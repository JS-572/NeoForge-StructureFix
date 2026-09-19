package net.js.jsmenu.block.custom;

import net.js.jsmenu.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.network.chat.Component;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.ItemInteractionResult;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;

public class CarbonCompressorBlock extends Block {

    public CarbonCompressorBlock(Properties properties) {
        super(properties);
    }

    @Override
    public ItemInteractionResult useItemOn(ItemStack stack, BlockState state, Level level, BlockPos pos, Player player, InteractionHand hand, BlockHitResult hit) {
        if (!level.isClientSide && stack.is(ModItems.CARBON.get())) {
            // remove 1 carbon
            stack.shrink(1);

            // drop diamond item at block position
            popResource(level, pos, new ItemStack(Items.DIAMOND));

            // feedback to player
            player.sendSystemMessage(Component.literal("Carbon used! Diamond dropped!"));

            return ItemInteractionResult.SUCCESS;
        }
        return ItemInteractionResult.SUCCESS;
    }
}