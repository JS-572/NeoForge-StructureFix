package net.js.jsmenu.block.custom.saplings.star.Sun;

import com.mojang.serialization.MapCodec;
import net.js.jsmenu.block.StarBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class CoronaBloomSaplingBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<CoronaBloomSaplingBlock> CODEC = simpleCodec(CoronaBloomSaplingBlock::new);

    public CoronaBloomSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<CoronaBloomSaplingBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(StarBlocks.SOLAR_ASH.get())
                || state.is(StarBlocks.IGNITED_SOLAR_ASH.get());
    }

    @Override
    public boolean isValidBonemealTarget(LevelReader levelReader, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public boolean isBonemealSuccess(Level level, RandomSource randomSource, BlockPos blockPos, BlockState blockState) {
        return true;
    }

    @Override
    public void performBonemeal(ServerLevel level, RandomSource random, BlockPos pos, BlockState state) {
        growTree(level, pos);
    }

    private void growTree(ServerLevel level, BlockPos pos) {
        level.removeBlock(pos, false);

        // Simple example tree:
        for (int i = 0; i < 5; i++) {
            level.setBlock(pos.above(i), StarBlocks.CORONA_BLOOM_LOG.get().defaultBlockState(), 3);
        }

        // Leaves (basic cube)
        BlockPos top = pos.above(5);

        for (int x = -1; x <= 1; x++) {
            for (int y = -5; y <= 5; y++) {
                for (int z = -3; z <= 3; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) < 5) {
                        level.setBlock(top.offset(x, y, z),
                                StarBlocks.CORONA_BLOOM_LEAVES.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}
