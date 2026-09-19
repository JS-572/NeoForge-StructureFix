package net.js.jsmenu.fluid.types;

import net.js.jsmenu.JSMenu;
import net.neoforged.neoforge.fluids.FluidType;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.NeoForgeRegistries;

public class ModFluidTypes {
    public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, JSMenu.MOD_ID);
    public static final DeferredHolder<FluidType, FluidType> BROMINE_TYPE = REGISTRY.register("bromine", () -> new BromineFluidType());
    public static final DeferredHolder<FluidType, FluidType> MERCURY_TYPE = REGISTRY.register("mercury", () -> new MercuryFluidType());

    public static final DeferredHolder<FluidType, FluidType> RED_LAVA_TYPE = REGISTRY.register("red_lava_type", () -> new RedLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> LIGHT_YELLOW_LAVA_TYPE = REGISTRY.register("light_yellow_lava_type", () -> new LightYellowLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> YELLOW_LAVA_TYPE = REGISTRY.register("yellow_lava_type", () -> new YellowLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> GREEN_LAVA_TYPE = REGISTRY.register("green_lava_type", () -> new GreenLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> LIGHT_BLUE_LAVA_TYPE = REGISTRY.register("light_blue_lava_type", () -> new LightBlueLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> BLUE_LAVA_TYPE = REGISTRY.register("blue_lava_type", () -> new BlueLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> PURPLE_LAVA_TYPE = REGISTRY.register("purple_lava_type", () -> new PurpleLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> PINK_LAVA_TYPE = REGISTRY.register("pink_lava_type", () -> new PinkLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> WHITE_LAVA_TYPE = REGISTRY.register("white_lava_type", () -> new WhiteLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> BROWN_LAVA_TYPE = REGISTRY.register("brown_lava_type", () -> new BrownLavaFluidType());
    public static final DeferredHolder<FluidType, FluidType> BLACK_LAVA_TYPE = REGISTRY.register("black_lava_type", () -> new BlackLavaFluidType());
}
