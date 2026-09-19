package net.js.jsmenu.client.space;

import net.js.jsmenu.network.SpaceTravelHandler;
import net.js.jsmenu.network.payload.HarvestLavaPayload;
import net.js.jsmenu.network.payload.RequestLandingPayload;
import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;
import net.js.jsmenu.space.SpaceObjects;
import net.js.jsmenu.space.star.Star;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiGraphics;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.components.EditBox;
import net.minecraft.client.gui.screens.Screen;
import net.minecraft.network.chat.Component;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.util.Mth;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;

public class SpaceScreen extends Screen {
    private static final int FRAME_COLOR = 0xFFDCC39A;
    private static final int PANEL_COLOR = 0xFFDDC39A;
    private static final int LIFE_FRAME_COLOR = 0xFFD5D7A8;
    private static final int LIFE_PANEL_COLOR = 0xFFD7DAAB;
    private static final int SEARCH_COLOR = 0xFFB1B1B1;
    private static final int SEARCH_ICON_BOX_COLOR = 0xFFF8F8F8;
    private static final int MAP_COLOR = 0xFF000000;
    private static final int MAP_BORDER_COLOR = 0xFF050505;
    private static final int LIFE_MAP_BORDER_COLOR = 0xFF283618;
    private static final int TEXT_COLOR = 0xFF2B2115;
    private static final int MUTED_TEXT_COLOR = 0xFF6C5A40;
    private static final int ENTRY_SELECTED_COLOR = 0x80F6E8D0;
    private static final int ENTRY_HOVER_COLOR = 0x30FFFFFF;
    private static final int BUTTON_COLOR = 0xFFE4CCA4;
    private static final int BUTTON_TEXT_COLOR = 0xFF5F4D33;
    private static final int ENTRY_HEIGHT = 16;
    private static final int ENTRY_GAP = 4;
    private static final int SIDEBAR_PADDING = 10;

    private final List<SpaceObject> allObjects = new ArrayList<>(SpaceObjects.getSpaceObjects());
    private final List<SpaceObject> filteredObjects = new ArrayList<>();
    private final SpaceScreenMode mode;

    private EditBox searchBox;
    private Button actionButton;
    private Button secondaryActionButton;
    private Button zoomInButton;
    private Button zoomOutButton;
    private Button harvestDecreaseButton;
    private Button harvestIncreaseButton;
    private Button harvestConfirmButton;
    private Button harvestCancelButton;
    private SpaceObject selectedObject;
    private int listScroll;
    private double zoom = 1.0D;
    private boolean harvestPromptOpen;
    private int harvestAmount = 1;
    private int maxHarvestAmount = 1;
    private double mapOffsetX = 0.0D;
    private double mapOffsetY = 0.0D;
    private double lastMouseX = 0.0D;
    private double lastMouseY = 0.0D;
    private boolean isDraggingMap = false;

    public SpaceScreen(SpaceScreenMode mode) {
        super(Component.translatable(mode == SpaceScreenMode.SPACE ? "screen.jsmenu.space.title" : "screen.jsmenu.space_of_life.title"));
        this.mode = mode;
        allObjects.sort(Comparator.comparing(SpaceObject::getDisplayName, String.CASE_INSENSITIVE_ORDER));
    }

    @Override
    protected void init() {
        super.init();
        Layout layout = layout();

        searchBox = new EditBox(font, layout.searchFieldX(), layout.searchFieldY(), layout.searchFieldWidth(), 18,
                Component.translatable("screen.jsmenu.space.search"));
        searchBox.setMaxLength(64);
        searchBox.setBordered(false);
        searchBox.setTextColor(TEXT_COLOR);
        searchBox.setTextColorUneditable(TEXT_COLOR);
        searchBox.setResponder(value -> refreshFilteredObjects());
        searchBox.setFocused(true);
        addRenderableWidget(searchBox);

        actionButton = addRenderableWidget(Button.builder(Component.empty(), button -> handleAction())
                .bounds(layout.sidebarLeft + 10, layout.sidebarBottom - 28, layout.sidebarWidth - 20, 20)
                .build());
        actionButton.visible = false;

        secondaryActionButton = addRenderableWidget(Button.builder(Component.empty(), button -> handleSecondaryAction())
                .bounds(layout.sidebarLeft + 10, layout.sidebarBottom - 52, layout.sidebarWidth - 20, 20)
                .build());
        secondaryActionButton.visible = false;

        zoomInButton = addRenderableWidget(Button.builder(Component.literal("+"), button -> zoom = Math.min(3.0D, zoom + 0.25D))
                .bounds(layout.mapRight - 35, layout.mapBottom - 59, 28, 28)
                .build());
        zoomInButton.visible = false;

        zoomOutButton = addRenderableWidget(Button.builder(Component.literal("-"), button -> zoom = Math.max(0.5D, zoom - 0.25D))
                .bounds(layout.mapRight - 35, layout.mapBottom - 31, 28, 28)
                .build());
        zoomOutButton.visible = false;

        harvestDecreaseButton = addRenderableWidget(Button.builder(Component.literal("-"), button -> {
            harvestAmount = Math.max(1, harvestAmount - 1);
            updateHarvestPromptButtons();
        }).bounds(width / 2 - 66, height / 2 + 8, 20, 20).build());
        harvestDecreaseButton.visible = false;

        harvestIncreaseButton = addRenderableWidget(Button.builder(Component.literal("+"), button -> {
            harvestAmount = Math.min(maxHarvestAmount, harvestAmount + 1);
            updateHarvestPromptButtons();
        }).bounds(width / 2 + 46, height / 2 + 8, 20, 20).build());
        harvestIncreaseButton.visible = false;

        harvestConfirmButton = addRenderableWidget(Button.builder(Component.translatable("screen.jsmenu.space.harvest_confirm"), button -> confirmHarvest())
                .bounds(width / 2 - 48, height / 2 + 36, 96, 20)
                .build());
        harvestConfirmButton.visible = false;

        harvestCancelButton = addRenderableWidget(Button.builder(Component.translatable("screen.jsmenu.space.cancel"), button -> closeHarvestPrompt())
                .bounds(width / 2 - 48, height / 2 + 60, 96, 20)
                .build());
        harvestCancelButton.visible = false;

        refreshFilteredObjects();
        closeHarvestPrompt();
    }

    private void refreshFilteredObjects() {
        String query = searchBox == null ? "" : searchBox.getValue().trim().toLowerCase(Locale.ROOT);
        filteredObjects.clear();

        for (SpaceObject object : allObjects) {
            if (query.isEmpty() || object.getDisplayName().toLowerCase(Locale.ROOT).contains(query)) {
                filteredObjects.add(object);
            }
        }

        if (filteredObjects.isEmpty()) {
            selectedObject = null;
            listScroll = 0;
        } else if (selectedObject == null || !filteredObjects.contains(selectedObject)) {
            // ArrayList doesn't have getFirst(), use get(0)
            selectedObject = filteredObjects.get(0);
            listScroll = 0;
        } else {
            clampScroll();
        }

        updateActionButton();
    }

    private void updateActionButton() {
        if (actionButton == null) {
            return;
        }

        if (selectedObject == null) {
            actionButton.visible = false;
            actionButton.active = false;
            if (secondaryActionButton != null) {
                secondaryActionButton.visible = false;
                secondaryActionButton.active = false;
            }
            return;
        }

        actionButton.visible = true;
        actionButton.active = canCurrentSelectionLand() || selectedObject.canHarvestLava();

        Component label = Component.translatable("screen.jsmenu.space.no_action");
        if (shouldShowLandAsPrimary()) {
            label = Component.translatable("screen.jsmenu.space.land");
        } else if (selectedObject.canHarvestLava()) {
            label = Component.translatable("screen.jsmenu.space.harvest_lava");
        }
        actionButton.setMessage(label);

        if (secondaryActionButton != null) {
            secondaryActionButton.visible = shouldShowSecondaryHarvestAction();
            secondaryActionButton.active = secondaryActionButton.visible;
            secondaryActionButton.setMessage(Component.translatable("screen.jsmenu.space.harvest_lava"));
        }
    }

    private void handleAction() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || selectedObject == null) {
            return;
        }

        if (shouldShowLandAsPrimary() && canCurrentSelectionLand()) {
            requestLanding(selectedObject);
            onClose();
            return;
        }

        if (selectedObject.canHarvestLava()) {
            openHarvestPrompt(minecraft);
            return;
        }

        if (canCurrentSelectionLand()) {
            requestLanding(selectedObject);
            onClose();
        }
    }

    private void handleSecondaryAction() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null || selectedObject == null || !shouldShowSecondaryHarvestAction()) {
            return;
        }

        openHarvestPrompt(minecraft);
    }

    private void requestLanding(SpaceObject object) {
        PacketDistributor.sendToServer(new RequestLandingPayload(object.getId(), mode == SpaceScreenMode.SPACE_OF_LIFE));
    }

    private void openHarvestPrompt(Minecraft minecraft) {
        HarvestOptions options = getHarvestOptions(minecraft);
        if (options.maxBuckets() <= 0) {
            minecraft.player.displayClientMessage(
                    Component.translatable("screen.jsmenu.space.no_harvest_materials").withStyle(ChatFormatting.RED),
                    false
            );
            return;
        }

        if (options.maxBuckets() == 1) {
            if (performHarvestSingleplayer(minecraft, 1, options)) {
                closeHarvestPrompt();
            }
            return;
        }

        maxHarvestAmount = options.maxBuckets();
        harvestAmount = 1;
        harvestPromptOpen = true;
        updateHarvestPromptButtons();
    }

    private void confirmHarvest() {
        Minecraft minecraft = Minecraft.getInstance();
        if (minecraft.player == null) {
            return;
        }

        HarvestOptions options = getHarvestOptions(minecraft);
        harvestAmount = Math.min(harvestAmount, options.maxBuckets());
        if (harvestAmount <= 0) {
            closeHarvestPrompt();
            return;
        }

        if (performHarvestSingleplayer(minecraft, harvestAmount, options)) {
            closeHarvestPrompt();
        }
    }

    private boolean performHarvestSingleplayer(Minecraft minecraft, int amount, HarvestOptions options) {
        if (minecraft.player == null || !(selectedObject instanceof Star)) {
            return false;
        }

        harvestAmount = Math.min(amount, options.maxBuckets());
        if (harvestAmount <= 0) {
            return false;
        }

        PacketDistributor.sendToServer(
                new HarvestLavaPayload(
                        selectedObject.getId(),
                        harvestAmount
                )
        );
        return true;
    }

    private HarvestOptions getHarvestOptions(Minecraft minecraft) {
        if (minecraft.player == null || !(selectedObject instanceof Star star)) {
            return new HarvestOptions(0, 0, null);
        }

        int buckets = countItem(minecraft.player.getInventory().items, Items.BUCKET);
        int ironIngots = countItem(minecraft.player.getInventory().items, Items.IRON_INGOT);
        int ironBuckets = ironIngots / 3;
        return new HarvestOptions(buckets, buckets + ironBuckets, star);
    }

    @Override
    public boolean mouseScrolled(double mouseX, double mouseY, double scrollX, double scrollY) {
        if (isMouseOverList(mouseX, mouseY) && filteredObjects.size() > getVisibleEntryCount()) {
            listScroll = Mth.clamp(listScroll - (int) Math.signum(scrollY), 0, getMaxScroll());
            return true;
        }

        if (isMouseOverMap(mouseX, mouseY)) {
            zoom = Mth.clamp(zoom + (scrollY > 0 ? 0.1D : -0.1D), 0.5D, 3.0D);
            return true;
        }

        return super.mouseScrolled(mouseX, mouseY, scrollX, scrollY);
    }

    @Override
    public boolean mouseClicked(double mouseX, double mouseY, int button) {
        if (harvestPromptOpen) {
            if (harvestDecreaseRect().contains(mouseX, mouseY)) {
                harvestAmount = Math.max(1, harvestAmount - 1);
                updateHarvestPromptButtons();
                return true;
            }
            if (harvestIncreaseRect().contains(mouseX, mouseY)) {
                harvestAmount = Math.min(maxHarvestAmount, harvestAmount + 1);
                updateHarvestPromptButtons();
                return true;
            }
            if (harvestConfirmRect().contains(mouseX, mouseY)) {
                confirmHarvest();
                return true;
            }
            if (harvestCancelRect().contains(mouseX, mouseY)) {
                closeHarvestPrompt();
                return true;
            }
            return super.mouseClicked(mouseX, mouseY, button);
        }

        if (actionButtonRect().contains(mouseX, mouseY) && selectedObject != null && (canCurrentSelectionLand() || selectedObject.canHarvestLava())) {
            handleAction();
            return true;
        }
        if (secondaryActionButtonRect().contains(mouseX, mouseY) && shouldShowSecondaryHarvestAction()) {
            handleSecondaryAction();
            return true;
        }
        if (zoomInRect().contains(mouseX, mouseY)) {
            zoom = Math.min(3.0D, zoom + 0.25D);
            return true;
        }
        if (zoomOutRect().contains(mouseX, mouseY)) {
            zoom = Math.max(0.5D, zoom - 0.25D);
            return true;
        }

        Layout layout = layout();

        if (isMouseOverList(mouseX, mouseY)) {
            int relativeY = (int) mouseY - layout.listTop();
            int index = listScroll + relativeY / (ENTRY_HEIGHT + ENTRY_GAP);
            if (index >= 0 && index < filteredObjects.size()) {
                selectedObject = filteredObjects.get(index);
                updateActionButton();
                return true;
            }
        }

        if (isMouseOverMap(mouseX, mouseY)) {
            SpaceObject clickedObject = findObjectAt(mouseX, mouseY);
            if (clickedObject != null) {
                selectedObject = clickedObject;
                updateActionButton();
                return true;
            }
            
            if (button == 1) {
                isDraggingMap = true;
                lastMouseX = mouseX;
                lastMouseY = mouseY;
                return true;
            }
        }

        return super.mouseClicked(mouseX, mouseY, button);
    }

    @Override
    public boolean mouseDragged(double mouseX, double mouseY, int button, double dragX, double dragY) {
        if (isDraggingMap && button == 1) {
            mapOffsetX += mouseX - lastMouseX;
            mapOffsetY += mouseY - lastMouseY;
            lastMouseX = mouseX;
            lastMouseY = mouseY;
            return true;
        }
        return super.mouseDragged(mouseX, mouseY, button, dragX, dragY);
    }

    @Override
    public boolean mouseReleased(double mouseX, double mouseY, int button) {
        if (isDraggingMap && button == 1) {
            isDraggingMap = false;
            return true;
        }
        return super.mouseReleased(mouseX, mouseY, button);
    }

    @Override
    public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTick) {
        Layout layout = layout();

        guiGraphics.fill(0, 0, width, height, mode == SpaceScreenMode.SPACE ? FRAME_COLOR : LIFE_FRAME_COLOR);
        
        // Render map first (behind everything)
        guiGraphics.fill(layout.mapLeft, layout.mapTop, layout.mapRight, layout.mapBottom, MAP_COLOR);
        renderMap(guiGraphics, layout, mouseX, mouseY);
        guiGraphics.renderOutline(layout.mapLeft, layout.mapTop, layout.mapWidth(), layout.mapHeight(), mode == SpaceScreenMode.SPACE ? MAP_BORDER_COLOR : LIFE_MAP_BORDER_COLOR);
        
        // Render GUI on top
        guiGraphics.fill(layout.sidebarLeft, layout.sidebarTop, layout.sidebarRight, layout.sidebarBottom, mode == SpaceScreenMode.SPACE ? PANEL_COLOR : LIFE_PANEL_COLOR);
        guiGraphics.fill(layout.sidebarLeft, layout.sidebarTop, layout.sidebarRight, layout.searchBottom(), SEARCH_COLOR);
        guiGraphics.fill(layout.searchIconLeft(), layout.sidebarTop, layout.sidebarRight, layout.searchBottom(), SEARCH_ICON_BOX_COLOR);
        renderSearchIcon(guiGraphics, layout.searchIconLeft(), layout.sidebarTop);

        renderSidebar(guiGraphics, layout, mouseX, mouseY);
        renderActionButton(guiGraphics);
        renderSecondaryActionButton(guiGraphics);
        renderZoomButtons(guiGraphics);
        
        if (harvestPromptOpen) {
            renderHarvestPrompt(guiGraphics);
        }

        super.render(guiGraphics, mouseX, mouseY, partialTick);
    }

    private void renderSidebar(GuiGraphics guiGraphics, Layout layout, int mouseX, int mouseY) {
        int listLeft = layout.sidebarLeft + SIDEBAR_PADDING;
        int listTop = layout.listTop();
        int listWidth = layout.sidebarWidth - SIDEBAR_PADDING * 2;
        int visibleEntries = getVisibleEntryCount();

        for (int localIndex = 0; localIndex < visibleEntries; localIndex++) {
            int objectIndex = listScroll + localIndex;
            if (objectIndex >= filteredObjects.size()) {
                break;
            }

            SpaceObject object = filteredObjects.get(objectIndex);
            int entryTop = listTop + localIndex * (ENTRY_HEIGHT + ENTRY_GAP);
            if (object == selectedObject) {
                guiGraphics.fill(listLeft, entryTop, listLeft + listWidth, entryTop + ENTRY_HEIGHT, ENTRY_SELECTED_COLOR);
            } else if (isMouseOverEntry(mouseX, mouseY, listLeft, listWidth, entryTop)) {
                guiGraphics.fill(listLeft, entryTop, listLeft + listWidth, entryTop + ENTRY_HEIGHT, ENTRY_HOVER_COLOR);
            }
            guiGraphics.drawString(font, object.getDisplayName(), listLeft + 4, entryTop + 4, TEXT_COLOR, false);
        }

        if (filteredObjects.isEmpty()) {
            guiGraphics.drawString(font, Component.translatable("screen.jsmenu.space.no_results"), listLeft, listTop, MUTED_TEXT_COLOR, false);
        }

        int infoLeft = layout.sidebarLeft + SIDEBAR_PADDING;
        int infoTop = layout.sidebarBottom - 118;
        int infoWidth = layout.sidebarWidth - SIDEBAR_PADDING * 2;

        if (selectedObject == null) {
            guiGraphics.drawString(font, Component.translatable("screen.jsmenu.space.no_selection"), infoLeft, infoTop, MUTED_TEXT_COLOR, false);
            return;
        }

        guiGraphics.drawString(font, Component.literal(selectedObject.getDisplayName()).withStyle(ChatFormatting.BOLD), infoLeft, infoTop, TEXT_COLOR, false);
        guiGraphics.drawString(font, Component.literal(formatType(selectedObject.getType())), infoLeft, infoTop + 14, MUTED_TEXT_COLOR, false);
        guiGraphics.drawString(font, Component.translatable(mode == SpaceScreenMode.SPACE ? "screen.jsmenu.space.mode_label" : "screen.jsmenu.space_of_life.mode_label"), infoLeft, infoTop + 24, MUTED_TEXT_COLOR, false);
        guiGraphics.drawWordWrap(font, Component.literal(selectedObject.getDescription()), infoLeft, infoTop + 40, infoWidth, TEXT_COLOR);
        guiGraphics.drawString(font, buildActionSummary(selectedObject), infoLeft, infoTop + 96, MUTED_TEXT_COLOR, false);
    }

    private void renderMap(GuiGraphics guiGraphics, Layout layout, int mouseX, int mouseY) {
        List<SpaceObject> mapObjects = filteredObjects.isEmpty() ? allObjects : filteredObjects;
        for (SpaceObject object : mapObjects) {
            int markerX = layout.mapCenterX() + (int) Math.round(object.getMapX() * zoom) + (int) mapOffsetX;
            int markerY = layout.mapCenterY() + (int) Math.round(object.getMapY() * zoom) + (int) mapOffsetY;
            int markerHalfSize = getMarkerHalfSize(object);

            if (isSun(object)) {
                guiGraphics.fill(markerX - markerHalfSize, markerY - markerHalfSize, markerX + markerHalfSize + 1, markerY + markerHalfSize + 1, 0xFFFFDE59);
                guiGraphics.fill(markerX - markerHalfSize + 6, markerY - markerHalfSize + 6, markerX + markerHalfSize - 5, markerY + markerHalfSize - 5, 0xFFF4F4F4);
            } else if (isEarth(object)) {
                guiGraphics.fill(markerX - markerHalfSize, markerY - markerHalfSize, markerX + markerHalfSize + 1, markerY + markerHalfSize + 1, 0xFF2C5FB5);
                guiGraphics.fill(markerX - markerHalfSize + 2, markerY - markerHalfSize + 4, markerX - markerHalfSize + 7, markerY + 1, 0xFF63C26A);
                guiGraphics.fill(markerX + 1, markerY - markerHalfSize + 2, markerX + markerHalfSize - 2, markerY + 3, 0xFF6DCD73);
                guiGraphics.fill(markerX - 4, markerY + 2, markerX + 2, markerY + markerHalfSize - 2, 0xFF58B85F);
                guiGraphics.fill(markerX + 4, markerY + 4, markerX + markerHalfSize - 3, markerY + markerHalfSize - 5, 0xFF77D27B);
            } else if (isMoon(object)) {
                guiGraphics.fill(markerX - markerHalfSize, markerY - markerHalfSize, markerX + markerHalfSize + 1, markerY + markerHalfSize + 1, 0xFF808080);
            } else if (isMercury(object)) {
                guiGraphics.fill(markerX - markerHalfSize, markerY - markerHalfSize, markerX + markerHalfSize + 2, markerY + markerHalfSize + 1, 0xFF808080);
            } else {
                int color = object == selectedObject ? 0xFFFFE08A : 0xFFE3D3B2;
                guiGraphics.fill(markerX - 2, markerY - 2, markerX + 3, markerY + 3, color);
            }

            if (object == selectedObject || isMouseOverMarker(object, mouseX, mouseY, layout)) {
                guiGraphics.drawString(font, object.getDisplayName(), markerX + markerHalfSize + 6, markerY - 4, 0xFFF6E9CE, false);
            }
        }
    }

    private Component buildActionSummary(SpaceObject object) {
        if (mode == SpaceScreenMode.SPACE_OF_LIFE && canObjectLand(object) && object.canHarvestLava()) {
            return Component.translatable("screen.jsmenu.space.action_summary.land_and_harvest");
        }
        if (object.canHarvestLava() && !shouldShowLandAsPrimaryFor(object)) {
            return Component.translatable("screen.jsmenu.space.action_summary.harvest");
        }
        if (canObjectLand(object)) {
            return Component.translatable("screen.jsmenu.space.action_summary.land");
        }
        return Component.translatable("screen.jsmenu.space.action_summary.none");
    }

    private String formatType(SpaceObjectType type) {
        return switch (type) {
            case STAR -> "Star";
            case PLANET -> "Planet";
            case MOON -> "Moon";
            case ASTEROID -> "Asteroid";
            case COMET -> "Comet";
            case GALAXY -> "Galaxy";
            case NEBULA -> "Nebula";
            case QUASAR -> "Quasar";
            case BLACK_HOLE -> "Black Hole";
        };
    }

    private boolean isMouseOverList(double mouseX, double mouseY) {
        Layout layout = layout();
        int left = layout.sidebarLeft + SIDEBAR_PADDING;
        int top = layout.listTop();
        int right = layout.sidebarRight - SIDEBAR_PADDING;
        int bottom = top + getVisibleEntryCount() * (ENTRY_HEIGHT + ENTRY_GAP);
        return mouseX >= left && mouseX <= right && mouseY >= top && mouseY <= bottom;
    }

    private boolean isMouseOverMap(double mouseX, double mouseY) {
        Layout layout = layout();
        return mouseX >= layout.mapLeft && mouseX <= layout.mapRight && mouseY >= layout.mapTop && mouseY <= layout.mapBottom;
    }

    private boolean isMouseOverEntry(int mouseX, int mouseY, int x, int width, int entryTop) {
        return mouseX >= x && mouseX <= x + width && mouseY >= entryTop && mouseY <= entryTop + ENTRY_HEIGHT;
    }

    private SpaceObject findObjectAt(double mouseX, double mouseY) {
        Layout layout = layout();
        for (SpaceObject object : allObjects) {
            if (isMouseOverMarker(object, mouseX, mouseY, layout)) {
                return object;
            }
        }
        return null;
    }

    private boolean isMouseOverMarker(SpaceObject object, double mouseX, double mouseY, Layout layout) {
        int markerX = layout.mapCenterX() + (int) Math.round(object.getMapX() * zoom) + (int) mapOffsetX;
        int markerY = layout.mapCenterY() + (int) Math.round(object.getMapY() * zoom) + (int) mapOffsetY;
        int markerHalfSize = getMarkerHalfSize(object);
        
        // Check if marker is within map bounds
        if (markerX < layout.mapLeft || markerX > layout.mapRight || markerY < layout.mapTop || markerY > layout.mapBottom) {
            return false;
        }
        
        return mouseX >= markerX - markerHalfSize && mouseX <= markerX + markerHalfSize
                && mouseY >= markerY - markerHalfSize && mouseY <= markerY + markerHalfSize;
    }

    private int getMarkerHalfSize(SpaceObject object) {
        if (isSun(object)) {
            return Math.max(18, (int) Math.round(28 * zoom));
        }
        if (isEarth(object)) {
            return Math.max(8, (int) Math.round(12 * zoom));
        }
        if (isMoon(object)) {
            return Math.max(2, (int) Math.round(3 * zoom));
        }
        if (isMercury(object)) {
            return Math.max(3, (int) Math.round(4 * zoom));
        }
        return 4;
    }

    private boolean isSun(SpaceObject object) {
        return "sun".equals(object.getId());
    }

    private boolean isEarth(SpaceObject object) {
        return "earth".equals(object.getId());
    }

    private boolean isMoon(SpaceObject object) {
        return "moon".equals(object.getId());
    }

    private boolean isMercury(SpaceObject object) {
        return "mercury".equals(object.getId());
    }

    private int getVisibleEntryCount() {
        return Math.max(1, (layout().sidebarHeight() - 170) / (ENTRY_HEIGHT + ENTRY_GAP));
    }

    private int getMaxScroll() {
        return Math.max(0, filteredObjects.size() - getVisibleEntryCount());
    }

    private void clampScroll() {
        listScroll = Mth.clamp(listScroll, 0, getMaxScroll());
    }

    private void renderSearchIcon(GuiGraphics guiGraphics, int left, int top) {
        int circleLeft = left + 9;
        int circleTop = top + 8;
        int iconColor = 0xFFB4B4B4;

        guiGraphics.renderOutline(circleLeft, circleTop, 10, 10, iconColor);
        guiGraphics.fill(circleLeft + 8, circleTop + 8, circleLeft + 15, circleTop + 10, iconColor);
        guiGraphics.fill(circleLeft + 10, circleTop + 8, circleLeft + 12, circleTop + 15, iconColor);
    }

    private void renderActionButton(GuiGraphics guiGraphics) {
        if (selectedObject == null || harvestPromptOpen) {
            return;
        }

        Component label = Component.translatable("screen.jsmenu.space.no_action");
        boolean active = canCurrentSelectionLand() || selectedObject.canHarvestLava();
        if (shouldShowLandAsPrimary()) {
            label = Component.translatable("screen.jsmenu.space.land");
        } else if (selectedObject.canHarvestLava()) {
            label = Component.translatable("screen.jsmenu.space.harvest_lava");
        }
        drawFlatButton(guiGraphics, actionButtonRect(), label, active);
    }

    private void renderSecondaryActionButton(GuiGraphics guiGraphics) {
        if (selectedObject == null || harvestPromptOpen || !shouldShowSecondaryHarvestAction()) {
            return;
        }

        drawFlatButton(guiGraphics, secondaryActionButtonRect(), Component.translatable("screen.jsmenu.space.harvest_lava"), true);
    }

    private void renderZoomButtons(GuiGraphics guiGraphics) {
        drawFlatButton(guiGraphics, zoomInRect(), Component.literal("+"), true);
        drawFlatButton(guiGraphics, zoomOutRect(), Component.literal("-"), true);
    }

    private void drawFlatButton(GuiGraphics guiGraphics, Rect rect, Component label, boolean active) {
        int fill = active ? BUTTON_COLOR : 0xFFD2C3A7;
        int textColor = active ? BUTTON_TEXT_COLOR : 0xFF8A7A62;
        guiGraphics.fill(rect.left, rect.top, rect.right, rect.bottom, fill);
        guiGraphics.renderOutline(rect.left, rect.top, rect.width(), rect.height(), 0xFF4C3D28);
        int textX = rect.left + (rect.width() - font.width(label)) / 2;
        int textY = rect.top + (rect.height() - 8) / 2;
        guiGraphics.drawString(font, label, textX, textY, textColor, false);
    }

    @Override
    public boolean isPauseScreen() {
        return true;
    }

    private Layout layout() {
        int topBarHeight = Math.max(54, height / 8);
        int sidebarWidth = Math.max(146, width / 6);
        int sidebarLeft = 0;
        int sidebarTop = topBarHeight;
        int sidebarBottom = height - 16;
        int sidebarRight = sidebarLeft + sidebarWidth;
        int mapLeft = sidebarRight + 2;
        int mapTop = sidebarTop;
        int mapRight = width - 18;
        int mapBottom = height - 18;
        return new Layout(topBarHeight, sidebarLeft, sidebarTop, sidebarRight, sidebarBottom, sidebarWidth, mapLeft, mapTop, mapRight, mapBottom);
    }

    private void renderHarvestPrompt(GuiGraphics guiGraphics) {
        int modalLeft = width / 2 - 90;
        int modalTop = height / 2 - 40;
        int modalWidth = 180;
        int modalHeight = 106;

        guiGraphics.fill(modalLeft, modalTop, modalLeft + modalWidth, modalTop + modalHeight, 0xF0E5D0AD);
        guiGraphics.renderOutline(modalLeft, modalTop, modalWidth, modalHeight, 0xFF69593B);
        guiGraphics.drawString(font, Component.translatable("screen.jsmenu.space.harvest_prompt"), modalLeft + 14, modalTop + 12, TEXT_COLOR, false);
        guiGraphics.drawString(font, Component.literal(Integer.toString(harvestAmount)), modalLeft + 84, modalTop + 15, TEXT_COLOR, false);
        guiGraphics.drawString(font, Component.translatable("screen.jsmenu.space.harvest_max", maxHarvestAmount), modalLeft + 14, modalTop + 34, MUTED_TEXT_COLOR, false);
        drawFlatButton(guiGraphics, harvestDecreaseRect(), Component.literal("-"), harvestAmount > 1);
        drawFlatButton(guiGraphics, harvestIncreaseRect(), Component.literal("+"), harvestAmount < maxHarvestAmount);
        drawFlatButton(guiGraphics, harvestConfirmRect(), Component.translatable("screen.jsmenu.space.harvest_confirm"), true);
        drawFlatButton(guiGraphics, harvestCancelRect(), Component.translatable("screen.jsmenu.space.cancel"), true);
    }

    private void updateHarvestPromptButtons() {
        boolean visible = harvestPromptOpen;
        harvestDecreaseButton.visible = visible;
        harvestIncreaseButton.visible = visible;
        harvestConfirmButton.visible = visible;
        harvestCancelButton.visible = visible;

        harvestDecreaseButton.active = visible && harvestAmount > 1;
        harvestIncreaseButton.active = visible && harvestAmount < maxHarvestAmount;
        harvestConfirmButton.active = visible && harvestAmount >= 1;
    }

    private void closeHarvestPrompt() {
        harvestPromptOpen = false;
        maxHarvestAmount = 1;
        harvestAmount = 1;
        updateHarvestPromptButtons();
    }

    private int countItem(List<ItemStack> stacks, Item item) {
        int total = 0;
        for (ItemStack stack : stacks) {
            if (stack.is(item)) {
                total += stack.getCount();
            }
        }
        return total;
    }

    private boolean removeItems(ServerPlayer player, Item item, int amount) {
        if (amount <= 0) {
            return true;
        }

        int remaining = amount;
        for (ItemStack stack : player.getInventory().items) {
            if (!stack.is(item)) {
                continue;
            }

            int taken = Math.min(remaining, stack.getCount());
            stack.shrink(taken);
            remaining -= taken;
            if (remaining <= 0) {
                return true;
            }
        }
        return false;
    }

    private void addItems(ServerPlayer player, ItemStack stack) {
        ItemStack remaining = stack.copy();
        while (!remaining.isEmpty()) {
            ItemStack singleStack = remaining.split(Math.min(remaining.getMaxStackSize(), remaining.getCount()));
            if (!player.getInventory().add(singleStack)) {
                player.drop(singleStack, false);
            }
        }
        player.inventoryMenu.broadcastChanges();
    }

    private record HarvestOptions(int bucketCount, int maxBuckets, Star star) {
    }

    private boolean canCurrentSelectionLand() {
        return selectedObject != null && canObjectLand(selectedObject);
    }

    private boolean canObjectLand(SpaceObject object) {
        if (object == null || getTargetDimensionKey(object) == null) {
            return false;
        }

        if (!SpaceTravelHandler.isLandingImplemented(object, mode == SpaceScreenMode.SPACE_OF_LIFE)) {
            return false;
        }

        if (mode == SpaceScreenMode.SPACE_OF_LIFE) {
            return true;
        }

        return object.canLand();
    }

    private boolean shouldShowLandAsPrimary() {
        return shouldShowLandAsPrimaryFor(selectedObject);
    }

    private boolean shouldShowLandAsPrimaryFor(SpaceObject object) {
        if (object == null) {
            return false;
        }

        if (mode == SpaceScreenMode.SPACE_OF_LIFE && object.getType() == SpaceObjectType.STAR && canObjectLand(object)) {
            return true;
        }

        return canObjectLand(object) && !object.canHarvestLava();
    }

    private boolean shouldShowSecondaryHarvestAction() {
        return mode == SpaceScreenMode.SPACE_OF_LIFE
                && selectedObject != null
                && selectedObject.getType() == SpaceObjectType.STAR
                && selectedObject.canHarvestLava()
                && canObjectLand(selectedObject);
    }

    private net.minecraft.resources.ResourceKey<Level> getTargetDimensionKey(SpaceObject object) {
        if (object == null) {
            return null;
        }
        return mode == SpaceScreenMode.SPACE_OF_LIFE ? object.getLifeDimension() : object.getSpaceDimension();
    }

    private Rect actionButtonRect() {
        Layout layout = layout();
        return new Rect(layout.sidebarLeft + 10, layout.sidebarBottom - 28, layout.sidebarLeft + layout.sidebarWidth - 10, layout.sidebarBottom - 8);
    }

    private Rect secondaryActionButtonRect() {
        Layout layout = layout();
        return new Rect(layout.sidebarLeft + 10, layout.sidebarBottom - 52, layout.sidebarLeft + layout.sidebarWidth - 10, layout.sidebarBottom - 32);
    }

    private Rect zoomInRect() {
        Layout layout = layout();
        return new Rect(layout.mapRight - 35, layout.mapBottom - 59, layout.mapRight - 7, layout.mapBottom - 31);
    }

    private Rect zoomOutRect() {
        Layout layout = layout();
        return new Rect(layout.mapRight - 35, layout.mapBottom - 31, layout.mapRight - 7, layout.mapBottom - 3);
    }

    private Rect harvestDecreaseRect() {
        return new Rect(width / 2 - 66, height / 2 + 8, width / 2 - 46, height / 2 + 28);
    }

    private Rect harvestIncreaseRect() {
        return new Rect(width / 2 + 46, height / 2 + 8, width / 2 + 66, height / 2 + 28);
    }

    private Rect harvestConfirmRect() {
        return new Rect(width / 2 - 48, height / 2 + 36, width / 2 + 48, height / 2 + 56);
    }

    private Rect harvestCancelRect() {
        return new Rect(width / 2 - 48, height / 2 + 60, width / 2 + 48, height / 2 + 80);
    }

    private record Layout(
            int topBarHeight,
            int sidebarLeft,
            int sidebarTop,
            int sidebarRight,
            int sidebarBottom,
            int sidebarWidth,
            int mapLeft,
            int mapTop,
            int mapRight,
            int mapBottom
    ) {
        int searchFieldX() {
            return sidebarLeft + 8;
        }

        int searchFieldY() {
            return sidebarTop + 9;
        }

        int searchFieldWidth() {
            return sidebarWidth - 50;
        }

        int searchIconLeft() {
            return sidebarRight - 40;
        }

        int searchBottom() {
            return sidebarTop + 34;
        }

        int listTop() {
            return sidebarTop + 44;
        }

        int sidebarHeight() {
            return sidebarBottom - sidebarTop;
        }

        int mapWidth() {
            return mapRight - mapLeft;
        }

        int mapHeight() {
            return mapBottom - mapTop;
        }

        int mapCenterX() {
            return mapLeft + mapWidth() / 2;
        }

        int mapCenterY() {
            return mapTop + mapHeight() / 2;
        }
    }

    private record Rect(int left, int top, int right, int bottom) {
        boolean contains(double x, double y) {
            return x >= left && x <= right && y >= top && y <= bottom;
        }

        int width() {
            return right - left;
        }

        int height() {
            return bottom - top;
        }
    }
}
