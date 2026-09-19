package net.js.jsmenu.item.custom.tools.transition_metals.scandium;

import net.js.jsmenu.item.ModToolTiers;
import net.minecraft.world.item.HoeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.tags.BlockTags;

public class ScandiumHoe extends HoeItem {

    public ScandiumHoe() {
        super(ModToolTiers.SCANDIUM, new Item.Properties().attributes(HoeItem.createAttributes(ModToolTiers.SCANDIUM, -3, 3.0F)).stacksTo(1));
    }

    // Allow hoe to till normally; also speed up on leaves/sculk (to match your requested behavior)
    @Override
    public float getDestroySpeed(ItemStack stack, BlockState state) {
        if (state.is(BlockTags.LEAVES)) {
            return super.getDestroySpeed(stack, state) * 1.5F;
        }
        return super.getDestroySpeed(stack, state);
    }
}
