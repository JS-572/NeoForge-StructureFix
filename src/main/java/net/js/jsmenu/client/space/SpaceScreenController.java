package net.js.jsmenu.client.space;

import com.mojang.blaze3d.platform.InputConstants;
import net.js.jsmenu.JSMenu;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import org.lwjgl.glfw.GLFW;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.common.NeoForge;

public class SpaceScreenController {
    private static final String KEY_CATEGORY = "key.categories." + JSMenu.MOD_ID;
    private static final KeyMapping OPEN_SPACE_SCREEN = new KeyMapping(
            "key." + JSMenu.MOD_ID + ".open_space_screen",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_LEFT_BRACKET,
            KEY_CATEGORY
    );
    private static final KeyMapping OPEN_SPACE_OF_LIFE_SCREEN = new KeyMapping(
            "key." + JSMenu.MOD_ID + ".open_space_of_life_screen",
            InputConstants.Type.KEYSYM,
            GLFW.GLFW_KEY_RIGHT_BRACKET,
            KEY_CATEGORY
    );

    private SpaceScreenController() {
    }

    public static void init(IEventBus modBus) {
        modBus.addListener(SpaceScreenController::registerKeyMappings);
        NeoForge.EVENT_BUS.register(new SpaceScreenController.Events());
    }

    private static void registerKeyMappings(RegisterKeyMappingsEvent event) {
        event.register(OPEN_SPACE_SCREEN);
        event.register(OPEN_SPACE_OF_LIFE_SCREEN);
    }

    private static final class Events {
        @SubscribeEvent
        public void onClientTick(ClientTickEvent.Post event) {
            Minecraft minecraft = Minecraft.getInstance();
            if (minecraft.player == null) {
                return;
            }

            if (minecraft.screen == null) {
                while (OPEN_SPACE_SCREEN.consumeClick()) {
                    openSpaceScreen(minecraft, SpaceScreenMode.SPACE);
                }
                while (OPEN_SPACE_OF_LIFE_SCREEN.consumeClick()) {
                    openSpaceScreen(minecraft, SpaceScreenMode.SPACE_OF_LIFE);
                }
            }
        }

        private void openSpaceScreen(Minecraft minecraft, SpaceScreenMode mode) {
            minecraft.setScreen(new SpaceScreen(mode));
        }
    }
}
