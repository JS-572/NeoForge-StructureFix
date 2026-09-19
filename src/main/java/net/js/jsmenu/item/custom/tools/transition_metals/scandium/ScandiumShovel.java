package net.js.jsmenu.item.custom.tools.transition_metals.scandium;

import net.js.jsmenu.item.ModToolTiers;
import net.js.jsmenu.util.ModTags;
import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ShovelItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;

public class ScandiumShovel extends ShovelItem {

    public ScandiumShovel() {
        super(ModToolTiers.SCANDIUM, new Item.Properties().attributes(ShovelItem.createAttributes(ModToolTiers.SCANDIUM, 3, 3.0F)).stacksTo(1));
    }
    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity user) {

        // Only apply special mining if block is in your tag
        if (!level.isClientSide && state.is(ModTags.Blocks.SHOVEL_MINEABLES)) {
            stack.hurtAndBreak(1, user, EquipmentSlot.MAINHAND);
            return true;
        }

        return super.mineBlock(stack, level, state, pos, user);
    }
}
