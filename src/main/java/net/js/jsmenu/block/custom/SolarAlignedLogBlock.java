package net.js.jsmenu.block.custom;

import net.js.jsmenu.space.planet.PlanetRotation;
import net.minecraft.core.Direction;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import net.minecraft.world.level.block.state.properties.DirectionProperty;
import net.minecraft.world.level.block.state.StateDefinition;

public class SolarAlignedLogBlock extends RotatedPillarBlock {

    public static final DirectionProperty FACING =
            BlockStateProperties.HORIZONTAL_FACING;

    public SolarAlignedLogBlock(Properties properties) {
        super(properties);

        this.registerDefaultState(
                this.stateDefinition.any()
                        .setValue(AXIS, Direction.Axis.Y)
                        .setValue(FACING, Direction.EAST)
        );
    }

    @Override
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        Level level = context.getLevel();

        return defaultBlockState()
                .setValue(AXIS, context.getClickedFace().getAxis())
                .setValue(FACING, getSunriseDirection(level));
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<net.minecraft.world.level.block.Block, BlockState> builder) {
        builder.add(AXIS, FACING);
    }

    /**
     * Override this for planets with different rotation directions.
     */
    protected PlanetRotation getPlanetRotation(Level level) {
        return PlanetRotation.PROGRADE;
    }

    /**
     * Returns the direction of sunrise based on planetary rotation.
     */
    protected Direction getSunriseDirection(Level level) {
        return getPlanetRotation(level) == PlanetRotation.PROGRADE
                ? Direction.EAST
                : Direction.WEST;
    }

    /**
     * Returns the direction of sunset based on planetary rotation.
     */
    protected Direction getSunsetDirection(Level level) {
        return getPlanetRotation(level) == PlanetRotation.PROGRADE
                ? Direction.WEST
                : Direction.EAST;
    }
}