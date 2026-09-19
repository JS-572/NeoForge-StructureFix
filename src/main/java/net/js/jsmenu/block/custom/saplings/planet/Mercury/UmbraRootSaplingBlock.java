package net.js.jsmenu.block.custom.saplings.planet.Mercury;

import com.mojang.serialization.MapCodec;
import net.js.jsmenu.block.ModBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.state.BlockState;

public class UmbraRootSaplingBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<UmbraRootSaplingBlock> CODEC = simpleCodec(UmbraRootSaplingBlock::new);

    public UmbraRootSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<UmbraRootSaplingBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ModBlocks.SOLAR_CRUST.get())
                || state.is(ModBlocks.SCORCHED_REGOLITH.get());
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
        for (int i = 0; i < 6; i++) {
            level.setBlock(pos.above(i), ModBlocks.UMBRA_ROOT_LOG.get().defaultBlockState(), 3);
        }

        // Leaves (basic cube)
        BlockPos top = pos.above(6);

        for (int x = -1; x <= 1; x++) {
            for (int y = -4; y <= 4; y++) {
                for (int z = -3; z <= 3; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) < 3) {
                        level.setBlock(top.offset(x, y, z),
                                ModBlocks.UMBRA_ROOT_LEAVES.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}
