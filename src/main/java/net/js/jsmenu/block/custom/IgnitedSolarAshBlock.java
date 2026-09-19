package net.js.jsmenu.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class IgnitedSolarAshBlock extends SolarAshBlock {
    private final Block spreadTarget;

    public IgnitedSolarAshBlock(Properties properties, Block spreadTarget) {
        super(properties);
        this.spreadTarget = spreadTarget;
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        BlockPos spreadPos = pos.offset(random.nextInt(3) - 1, 0, random.nextInt(3) - 1);
        if (!level.isLoaded(spreadPos) || spreadPos.equals(pos)) {
            return;
        }

        if (level.getBlockState(spreadPos).is(spreadTarget) && level.isEmptyBlock(spreadPos.above()) && random.nextInt(6) == 0) {
            level.setBlockAndUpdate(spreadPos, defaultBlockState());
        }
    }
}
