package net.js.jsmenu.block.custom.saplings.moon.Moon;

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

public class VacuumSaplingBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<VacuumSaplingBlock> CODEC = simpleCodec(VacuumSaplingBlock::new);

    public VacuumSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<VacuumSaplingBlock> codec() {
        return CODEC;
    }

    @Override
    protected boolean mayPlaceOn(BlockState state, BlockGetter level, BlockPos pos) {
        return state.is(ModBlocks.LUNAR_SOIL.get())
                || state.is(ModBlocks.LUNAR_GRASS.get());
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
            level.setBlock(pos.above(i), ModBlocks.VACUUM_LOG.get().defaultBlockState(), 3);
        }

        // Leaves (basic cube)
        BlockPos top = pos.above(7);

        for (int x = -4; x <= 4; x++) {
            for (int y = -2; y <= 2; y++) {
                for (int z = -4; z <= 4; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) < 4) {
                        level.setBlock(top.offset(x, y, z),
                                ModBlocks.VACUUM_LEAVES.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}
