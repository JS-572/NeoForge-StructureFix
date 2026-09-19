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

public abstract class GreenLavaFluid extends BaseFlowingFluid {
    public static final Properties PROPERTIES = new Properties(() -> ModFluidTypes.GREEN_LAVA_TYPE.get(), () -> ModFluids.GREEN_LAVA.get(), () -> ModFluids.FLOWING_GREEN_LAVA.get()).explosionResistance(1000000000000000000000000000000000f)
            .tickRate(3).levelDecreasePerBlock(2).bucket(() -> ModItems.GREEN_LAVA_BUCKET.get()).block(() -> (LiquidBlock) ModBlocks.GREEN_LAVA.get());

    private GreenLavaFluid() {
        super(PROPERTIES);
    }

    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.ASH;
    }

    public static class Source extends GreenLavaFluid {
        public int getAmount(FluidState state) {
            return 8;
        }
        public boolean isSource(FluidState state) {
            return true;
        }
    }
    public static class Flowing extends GreenLavaFluid {
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
