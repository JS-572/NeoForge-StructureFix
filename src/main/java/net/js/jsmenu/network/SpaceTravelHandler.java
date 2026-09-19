package net.js.jsmenu.network;

import net.js.jsmenu.space.SpaceDimensions;
import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjects;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.Level;

public final class SpaceTravelHandler {
    private SpaceTravelHandler() {
    }

    public static void requestLanding(ServerPlayer player, String objectId, boolean lifeMode) {
        SpaceObjects.getSpaceObject(objectId).ifPresentOrElse(
                object -> landPlayer(player, object, lifeMode),
                () -> player.sendSystemMessage(Component.translatable("screen.jsmenu.space.land_pending", objectId))
        );
    }

    private static void landPlayer(ServerPlayer player, SpaceObject object, boolean lifeMode) {
        if (!isLandingImplemented(object, lifeMode)) {
            player.sendSystemMessage(Component.translatable("screen.jsmenu.space.land_pending", object.getDisplayName()));
            return;
        }

        ResourceKey<Level> targetKey = lifeMode ? object.getLifeDimension() : object.getSpaceDimension();
        if (targetKey == null) {
            player.sendSystemMessage(Component.translatable("screen.jsmenu.space.land_pending", object.getDisplayName()));
            return;
        }

        ServerLevel targetLevel = player.server.getLevel(targetKey);
        if (targetLevel == null) {
            player.sendSystemMessage(Component.translatable("message.jsmenu.space_dimension_missing"));
            return;
        }

        BlockPos spawnPos = targetLevel.getSharedSpawnPos();
        player.teleportTo(
                targetLevel,
                spawnPos.getX() + 0.5D,
                spawnPos.getY() + 1.0D,
                spawnPos.getZ() + 0.5D,
                player.getYRot(),
                player.getXRot()
        );
        player.fallDistance = 0.0F;
    }

    public static boolean isLandingImplemented(SpaceObject object, boolean lifeMode) {
        if (object == null) {
            return false;
        }

        ResourceKey<Level> targetKey = lifeMode ? object.getLifeDimension() : object.getSpaceDimension();
        if (targetKey == null) {
            return false;
        }

        // Landing is considered implemented for any space object that has a target dimension
        // (previously Mercury was explicitly excluded here, which prevented landing on Mercury)
        return true;
    }
}
