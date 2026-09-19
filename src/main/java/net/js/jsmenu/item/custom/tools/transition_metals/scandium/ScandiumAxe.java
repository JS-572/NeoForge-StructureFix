package net.js.jsmenu.item.custom.tools.transition_metals.scandium;

import net.js.jsmenu.item.ModToolTiers;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.state.BlockState;

public class ScandiumAxe extends AxeItem {

    public ScandiumAxe() {
        super(ModToolTiers.SCANDIUM, new Item.Properties().stacksTo(1).attributes(AxeItem.createAttributes(ModToolTiers.SCANDIUM, 6, 3.0F)));
    }

    // AxeItem already handles stripping and proper axe interactions.
    // Ensure enchantments work: extending AxeItem preserves enchantability.
    // Keep default mineBlock behavior so drops happen normally; override for special behavior if needed.

    @Override
    public boolean mineBlock(ItemStack stack, Level level, BlockState state, BlockPos pos, LivingEntity entity) {
        // Use vanilla logic but still damage tool
        return super.mineBlock(stack, level, state, pos, entity);
    }
}
