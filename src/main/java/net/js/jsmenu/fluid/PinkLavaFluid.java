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

public abstract class PinkLavaFluid extends BaseFlowingFluid {
    public static final Properties PROPERTIES = new Properties(() -> ModFluidTypes.PINK_LAVA_TYPE.get(), () -> ModFluids.PINK_LAVA.get(), () -> ModFluids.FLOWING_PINK_LAVA.get()).explosionResistance(1000000000000000000000000000000000f)
            .tickRate(3).levelDecreasePerBlock(2).bucket(() -> ModItems.PINK_LAVA_BUCKET.get()).block(() -> (LiquidBlock) ModBlocks.PINK_LAVA.get());

    private PinkLavaFluid() {
        super(PROPERTIES);
    }

    @Override
    public ParticleOptions getDripParticle() {
        return ParticleTypes.ASH;
    }

    public static class Source extends PinkLavaFluid {
        public int getAmount(FluidState state) {
            return 8;
        }
        public boolean isSource(FluidState state) {
            return true;
        }
    }
    public static class Flowing extends PinkLavaFluid {
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
