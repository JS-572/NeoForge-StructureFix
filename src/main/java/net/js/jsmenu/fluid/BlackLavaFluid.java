package net.js.jsmenu.fluid;

import net.js.jsmenu.block.ModBlocks;
import net.js.jsmenu.fluid.types.ModFluidTypes;
import net.js.jsmenu.item.ModItems;
import net.minecraft.core.particles.ParticleOptions;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FluidState;
import net.neoforged.neoforge.fluids.BaseFlowingFluid;

public abstract class BlackLavaFluid extends BaseFlowingFluid {
    public static final Properties PROPERTIES = new Properties(() -> ModFluidTypes.BLACK_LAVA_TYPE.get(), () -> ModFluids.BLACK_LAVA.get(), () -> ModFluids.FLOWING_BLACK_LAVA.get()).explosionResistance(1000000000000000000000000000000000f)
            .tickRate(3).levelDecreasePerBlock(2).bucket(() -> ModItems.BLACK_LAVA_BUCKET.get()).block(() -> (LiquidBlock) ModBlocks.BLACK_LAVA.get());

    private BlackLavaFluid() {
        super(PROPERTIES);
    }

    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.ASH;
    }

    public static class Source extends BlackLavaFluid {
        public int getAmount(FluidState state) {
            return 8;
        }
        public boolean isSource(FluidState state) {
            return true;
        }
    }
    public static class Flowing extends BlackLavaFluid {
        protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
            super.createFluidStateDefinition(builder);
            builder.add(LEVEL);
        }

        public int getAmount(FluidState state) {
            return state.getValue(LEVEL);
        }

        public boolean isSource(FluidState state) {
            return false;
        }
    }
}
