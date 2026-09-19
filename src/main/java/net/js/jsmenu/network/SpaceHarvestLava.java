package net.js.jsmenu.network;

import net.js.jsmenu.network.payload.HarvestLavaPayload;
import net.js.jsmenu.space.LavaBucketHelper;
import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjects;
import net.js.jsmenu.space.star.Star;
import net.js.jsmenu.space.star.StarClass;
import net.minecraft.ChatFormatting;
import net.minecraft.client.Minecraft;
import net.minecraft.network.chat.Component;
import net.minecraft.server.MinecraftServer;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.neoforged.neoforge.network.PacketDistributor;

import java.util.List;

public final class SpaceHarvestLava {

    private SpaceHarvestLava() {}

    public static void handleHarvestLava(Minecraft minecraft, Star star, int amount, boolean isSingleplayer) {
        if (minecraft.player == null || star == null) return;

        HarvestOptions options = getHarvestOptions(minecraft, star);

        if (options.maxBuckets() <= 0) {
            minecraft.player.displayClientMessage(
                    Component.translatable("screen.jsmenu.space.no_harvest_materials")
                            .withStyle(ChatFormatting.RED),
                    false
            );
            return;
        }

        int harvestCount = Math.min(amount, options.maxBuckets());

        if (isSingleplayer) {
            performSingleplayerHarvest(minecraft, star, harvestCount, options);
        } else {
            performMultiplayerHarvest(minecraft, star, harvestCount, options);
        }
    }

    private static void performSingleplayerHarvest(
            Minecraft minecraft,
            Star star,
            int amount,
            HarvestOptions options
    ) {
        MinecraftServer server = minecraft.getSingleplayerServer();
        if (server == null) return;

        Item lavaBucketItem = LavaBucketHelper.getLavaBucketForStarClass(star.getStarClass());
        if (lavaBucketItem == null) {
            minecraft.player.displayClientMessage(
                    Component.translatable(
                            "screen.jsmenu.space.unsupported_star_class",
                            star.getStarClass().name()
                    ).withStyle(ChatFormatting.RED),
                    false
            );
            return;
        }

        server.execute(() -> {
            ServerPlayer serverPlayer =
                    server.getPlayerList().getPlayer(minecraft.player.getUUID());

            if (serverPlayer == null) return;

            int bucketsToUse = Math.min(amount, options.bucketCount());
            int ironBucketsToCraft = amount - bucketsToUse;

            if (!removeItems(serverPlayer, Items.BUCKET, bucketsToUse)) return;
            if (!removeItems(serverPlayer, Items.IRON_INGOT, ironBucketsToCraft * 3)) return;

            addItems(serverPlayer, new ItemStack(lavaBucketItem, amount));
        });
    }

    private static void performMultiplayerHarvest(Minecraft minecraft, Star star, int amount, HarvestOptions options) {
        PacketDistributor.sendToServer(
                new HarvestLavaPayload(star.getId(), amount)
        );
    }

    private static HarvestOptions getHarvestOptions(Minecraft minecraft, Star star) {
        if (minecraft.player == null) {
            return new HarvestOptions(0, 0);
        }

        int buckets = countItem(minecraft.player.getInventory().items, Items.BUCKET);
        int ironIngots = countItem(minecraft.player.getInventory().items, Items.IRON_INGOT);
        int ironBuckets = ironIngots / 3;

        return new HarvestOptions(buckets, buckets + ironBuckets);
    }

    private static int countItem(List<ItemStack> stacks, Item item) {
        int total = 0;
        for (ItemStack stack : stacks) {
            if (stack.is(item)) {
                total += stack.getCount();
            }
        }
        return total;
    }

    private static boolean removeItems(ServerPlayer player, Item item, int amount) {
        if (amount <= 0) return true;

        int remaining = amount;

        for (ItemStack stack : player.getInventory().items) {
            if (!stack.is(item)) continue;

            int taken = Math.min(remaining, stack.getCount());
            stack.shrink(taken);
            remaining -= taken;

            if (remaining <= 0) return true;
        }

        return false;
    }

    private static void addItems(ServerPlayer player, ItemStack stack) {
        ItemStack remaining = stack.copy();

        while (!remaining.isEmpty()) {
            ItemStack split = remaining.split(
                    Math.min(remaining.getMaxStackSize(), remaining.getCount())
            );

            if (!player.getInventory().add(split)) {
                player.drop(split, false);
            }
        }

        player.inventoryMenu.broadcastChanges();
    }
    private static ItemStack getLavaBucketForStarClass(SpaceObject object) {
        StarClass starClass = object.getStarClass();
        if (starClass == null) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(
                LavaBucketHelper.getLavaBucketForStarClass(starClass)
        );
    }

    public static void harvestLava(ServerPlayer player, String starId, int amount) {
        if (player == null) {
            return;
        }

        SpaceObject object = SpaceObjects.getSpaceObject(starId)
                .orElse(null);

        if (object == null || !object.canHarvestLava()) {
            return;
        }

        ItemStack reward = getLavaBucketForStarClass(object);
        if (reward == null || reward.isEmpty()) {
            return;
        }
        var inventory = player.getInventory();

        int availableBuckets = countItem(inventory.items, Items.BUCKET);
        int availableIron = countItem(inventory.items, Items.IRON_INGOT);

        int bucketsToUse = Math.min(amount, availableBuckets);

        int ironBucketsToCraft = amount - bucketsToUse;
        int totalIronRequired = ironBucketsToCraft * 3;

        if (availableIron < totalIronRequired) {
            return;
        }

        removeItems(player, Items.BUCKET, bucketsToUse);
        removeItems(player, Items.IRON_INGOT, totalIronRequired);
        reward.setCount(amount);
        if (!player.getInventory().add(reward.copy())) {
            player.drop(reward.copy(), false);
        }

        player.containerMenu.broadcastChanges();
    }

    private record HarvestOptions(int bucketCount, int maxBuckets) {}
}
