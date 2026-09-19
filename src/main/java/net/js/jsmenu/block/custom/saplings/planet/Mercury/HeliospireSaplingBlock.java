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

public class HeliospireSaplingBlock extends BushBlock implements BonemealableBlock {
    public static final MapCodec<HeliospireSaplingBlock> CODEC = simpleCodec(HeliospireSaplingBlock::new);

    public HeliospireSaplingBlock(Properties properties) {
        super(properties);
    }

    @Override
    public MapCodec<HeliospireSaplingBlock> codec() {
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
            level.setBlock(pos.above(i), ModBlocks.HELIOSPIRE_LOG.get().defaultBlockState(), 3);
        }

        // Leaves (basic cube)
        BlockPos top = pos.above(9);

        for (int x = -5; x <= 5; x++) {
            for (int y = -7; y <= 7; y++) {
                for (int z = -6; z <= 6; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) < 8) {
                        level.setBlock(top.offset(x, y, z),
                                ModBlocks.HELIOSPIRE_LEAVES.get().defaultBlockState(), 3);
                    }
                }
            }
        }
    }
}
