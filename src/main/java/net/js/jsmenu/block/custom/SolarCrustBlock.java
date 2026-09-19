package net.js.jsmenu.block.custom;

import com.mojang.serialization.MapCodec;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.util.StringRepresentable;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.EnumProperty;
import net.minecraft.core.BlockPos;

public class SolarCrustBlock extends Block {
    public static final MapCodec<SolarCrustBlock> CODEC = simpleCodec(SolarCrustBlock::new);
    public static final EnumProperty<Stage> STAGE = EnumProperty.create("stage", Stage.class);

    public SolarCrustBlock(BlockBehaviour.Properties properties) {
        super(properties.sound(SoundType.GRASS).randomTicks().lightLevel(state -> state.getValue(STAGE).isIgnited() ? 8 : 0));
        registerDefaultState(stateDefinition.any().setValue(STAGE, Stage.SOLAR_CRUST));
    }

    @Override
    protected MapCodec<? extends Block> codec() {
        return CODEC;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(STAGE);
    }

    @Override
    protected void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (random.nextInt(6) != 0) {
            return;
        }

        Stage nextStage = state.getValue(STAGE).next();
        if (nextStage == null) {
            level.setBlockAndUpdate(pos, net.js.jsmenu.block.ModBlocks.SCORCHED_REGOLITH.get().defaultBlockState());
            return;
        }

        level.setBlockAndUpdate(pos, state.setValue(STAGE, nextStage));
    }

    public enum Stage implements StringRepresentable {
        SOLAR_CRUST("solar_crust"),
        IGNITED_SOLAR_CRUST("ignited_solar_crust"),
        REGOLITH("regolith"),
        IGNITED_REGOLITH("ignited_regolith");

        private final String name;

        Stage(String name) {
            this.name = name;
        }

        public boolean isIgnited() {
            return this == IGNITED_SOLAR_CRUST || this == IGNITED_REGOLITH;
        }

        public Stage next() {
            return switch (this) {
                case SOLAR_CRUST -> IGNITED_SOLAR_CRUST;
                case IGNITED_SOLAR_CRUST -> REGOLITH;
                case REGOLITH -> IGNITED_REGOLITH;
                case IGNITED_REGOLITH -> null;
            };
        }

        @Override
        public String getSerializedName() {
            return name;
        }
    }
}
