package net.js.jsmenu.item.custom.tools.transition_metals.scandium;

import net.js.jsmenu.util.ModTags;
import net.js.jsmenu.item.ModToolTiers;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.PickaxeItem;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.core.registries.BuiltInRegistries;

public class ScandiumPickaxe extends PickaxeItem {

    public ScandiumPickaxe() {
        super(ModToolTiers.SCANDIUM, new Item.Properties().attributes(PickaxeItem.createAttributes(ModToolTiers.SCANDIUM, 5, 2.8F)).stacksTo(1));
    }

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity user) {

        // Only server, and only on ores from your tag
        if (!level.isClientSide && state.is(ModTags.Blocks.TRANSITION_METAL_ORES)) {

            ItemStack smelted = getSmeltResult(state.getBlock());

            if (!smelted.isEmpty()) {

                // NeoForge-correct block deletion WITHOUT loot tables
                level.destroyBlock(pos, false);

                // Drop the smelted ingot
                Block.popResource(level, pos, smelted);

                // NeoForge durability
                stack.hurtAndBreak(1, user, EquipmentSlot.MAINHAND);

                return true; // prevent vanilla behavior
            }
        }

        return super.mineBlock(stack, level, state, pos, user);
    }

    /** Auto-smelt — converts X_ore → X_ingot based on registry name */
    private ItemStack getSmeltResult(Block block) {

        // Example: "scandium_ore"
        String path = BuiltInRegistries.BLOCK.getKey(block).getPath();

        // Only auto-smelt if ends in _ore
        if (!path.endsWith("_ore")) {
            return ItemStack.EMPTY;
        }

        // Convert "scandium_ore" -> "scandium_ingot"
        String ingotName = path.replace("_ore", "_ingot");

        // Correct 1.21 ResourceLocation creation
        ResourceLocation id = ResourceLocation.fromNamespaceAndPath("jsmenu", ingotName);

        // Look up the item
        Item ingot = BuiltInRegistries.ITEM.get(id);

        if (ingot == null) {
            return ItemStack.EMPTY;
        }

        return new ItemStack(ingot);
    }

}