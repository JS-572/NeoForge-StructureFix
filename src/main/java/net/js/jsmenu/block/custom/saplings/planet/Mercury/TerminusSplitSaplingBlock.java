package net.js.jsmenu.block.custom.saplings.planet.Mercury;

import com.mojang.serialization.MapCodec;
import net.js.jsmenu.block.ModBlocks;
import net.js.jsmenu.block.custom.SolarAlignedLogBlock;
import net.js.jsmenu.space.planet.PlanetRotation;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.BushBlock;
import net.minecraft.world.level.block.BonemealableBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;

public class TerminusSplitSaplingBlock extends BushBlock implements BonemealableBlock {

    public static final MapCodec<TerminusSplitSaplingBlock> CODEC =
            simpleCodec(TerminusSplitSaplingBlock::new);

    public static final DirectionProperty FACING =
            BlockStateProperties.HORIZONTAL_FACING;

    public TerminusSplitSaplingBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(FACING, Direction.EAST)
        );
    }

    @Override
    public MapCodec<TerminusSplitSaplingBlock> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(FACING);
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return defaultBlockState()
                .setValue(FACING, getSunriseDirection(context.getLevel()));
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
        growTree(level, pos, state);
    }

    private void growTree(ServerLevel level, BlockPos pos, BlockState saplingState) {
        level.removeBlock(pos, false);

        BlockState logState = ModBlocks.TERMINUS_SPLIT_LOG.get()
                .defaultBlockState()
                .setValue(
                        SolarAlignedLogBlock.FACING,
                        saplingState.getValue(FACING)
                );

        for (int i = 0; i < 6; i++) {
            level.setBlock(pos.above(i), logState, 3);
        }

        BlockPos top = pos.above(3);

        for (int x = -3; x <= 3; x++) {
            for (int y = -3; y <= 3; y++) {
                for (int z = -3; z <= 3; z++) {
                    if (Math.abs(x) + Math.abs(y) + Math.abs(z) < 3) {
                        level.setBlock(
                                top.offset(x, y, z),
                                ModBlocks.TERMINUS_SPLIT_LEAVES.get().defaultBlockState(),
                                3
                        );
                    }
                }
            }
        }
    }

    protected PlanetRotation getPlanetRotation(Level level) {
        return PlanetRotation.PROGRADE;
    }

    protected Direction getSunriseDirection(Level level) {
        return getPlanetRotation(level) == PlanetRotation.PROGRADE
                ? Direction.EAST
                : Direction.WEST;
    }
}
