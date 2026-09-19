package net.js.jsmenu.client;

import net.js.jsmenu.item.ModItems;
import net.minecraft.world.item.Items;
import net.minecraft.client.Minecraft;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.level.block.Blocks;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.neoforge.common.NeoForge;
import java.util.*;

public class DynamicHeldLightHandler {

    private final Set<BlockPos> lightPositions = new HashSet<>();
    private static final int LIGHT_RADIUS = 8;

    public static void register() {
        NeoForge.EVENT_BUS.register(new DynamicHeldLightHandler());
    }

    @SubscribeEvent
    public void onClientTick(ClientTickEvent.Post event) {
        Minecraft mc = Minecraft.getInstance();
        if (mc.player == null || mc.level == null) return;

        boolean holdingLight =
                mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(ModItems.SCANDIUM_PICKAXE.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(ModItems.SCANDIUM_SWORD.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(ModItems.SCANDIUM_SHOVEL.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(ModItems.SCANDIUM_AXE.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(ModItems.SCANDIUM_HOE.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(ModItems.SCANDIUM_SWORD.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(ModItems.SCANDIUM_PICKAXE.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(ModItems.SCANDIUM_SHOVEL.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(ModItems.SCANDIUM_AXE.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(ModItems.SCANDIUM_HOE.get()) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.TORCH) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(Items.TORCH) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.SOUL_TORCH) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(Items.SOUL_TORCH) ||
                        mc.player.getItemBySlot(EquipmentSlot.MAINHAND).is(Items.REDSTONE_TORCH) ||
                        mc.player.getItemBySlot(EquipmentSlot.OFFHAND).is(Items.REDSTONE_TORCH);

        BlockPos playerPos = mc.player.blockPosition();

        if (holdingLight) {
            // Generate sphere of light positions around the player
            Set<BlockPos> newLightPositions = new HashSet<>();
            BlockPos.MutableBlockPos mutable = new BlockPos.MutableBlockPos();

            for (int x = -LIGHT_RADIUS; x <= LIGHT_RADIUS; x++) {
                for (int y = -LIGHT_RADIUS; y <= LIGHT_RADIUS; y++) {
                    for (int z = -LIGHT_RADIUS; z <= LIGHT_RADIUS; z++) {
                        // Check if within sphere radius
                        if (x * x + y * y + z * z <= LIGHT_RADIUS * LIGHT_RADIUS) {
                            mutable.set(playerPos.getX() + x, playerPos.getY() + y, playerPos.getZ() + z);
                            BlockPos pos = mutable.immutable();

                            // Only place light in air blocks
                            if (mc.level.getBlockState(pos).isAir()) {
                                newLightPositions.add(pos);

                                // If this position didn't have a light before, place one
                                if (!lightPositions.contains(pos)) {
                                    mc.level.setBlock(pos, Blocks.LIGHT.defaultBlockState(), 3);
                                }
                            }
                        }
                    }
                }
            }

            // Remove light blocks that are no longer in the sphere
            for (BlockPos pos : lightPositions) {
                if (!newLightPositions.contains(pos)) {
                    mc.level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
                }
            }

            lightPositions.clear();
            lightPositions.addAll(newLightPositions);

        } else if (!lightPositions.isEmpty()) {
            // Remove all light blocks when not holding light
            for (BlockPos pos : lightPositions) {
                mc.level.setBlock(pos, Blocks.AIR.defaultBlockState(), 3);
            }
            lightPositions.clear();
        }
    }
}
