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

public class FlarewoodSaplingBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<FlarewoodSaplingBlock> CODEC = simpleCodec(FlarewoodSaplingBlock::new);

    public FlarewoodSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<FlarewoodSaplingBlock> codec() {
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
            level.setBlock(pos.above(i), StarBlocks.FLAREWOOD_LOG.get().defaultBlockState(), 3);
        }

        // Leaves (basic cube)
        BlockPos top = pos.above(5);

        for (int x = -2; x <= 2; x++) {
            for (int y = -2; y <= 2; y++) {
                for (int z = -2; z <= 2; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) < 4) {
                        level.setBlock(top.offset(x, y, z),
                                StarBlocks.FLAREWOOD_LEAVES.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}
