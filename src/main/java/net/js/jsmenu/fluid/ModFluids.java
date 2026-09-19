package net.js.jsmenu.fluid;

import net.js.jsmenu.JSMenu;
import net.js.jsmenu.fluid.types.*;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.Fluid;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModFluids {
    public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, JSMenu.MOD_ID);
    public static final DeferredHolder<Fluid, FlowingFluid> BROMINE = REGISTRY.register("bromine", () -> new BromineFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BROMINE = REGISTRY.register("flowing_bromine", () -> new BromineFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> MERCURY = REGISTRY.register("mercury", () -> new MercuryFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_MERCURY = REGISTRY.register("flowing_mercury", () -> new MercuryFluid.Flowing());

    public static final DeferredHolder<Fluid, FlowingFluid> RED_LAVA = REGISTRY.register("red_lava", () -> new RedLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_RED_LAVA = REGISTRY.register("flowing_red_lava", () -> new RedLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> LIGHT_YELLOW_LAVA = REGISTRY.register("light_yellow_lava", () -> new LightYellowLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIGHT_YELLOW_LAVA = REGISTRY.register("flowing_light_yellow_lava", () -> new LightYellowLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> YELLOW_LAVA = REGISTRY.register("yellow_lava", () -> new YellowLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_YELLOW_LAVA = REGISTRY.register("flowing_yellow_lava", () -> new YellowLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> GREEN_LAVA = REGISTRY.register("green_lava", () -> new GreenLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_GREEN_LAVA = REGISTRY.register("flowing_green_lava", () -> new GreenLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> LIGHT_BLUE_LAVA = REGISTRY.register("light_blue_lava", () -> new LightBlueLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_LIGHT_BLUE_LAVA = REGISTRY.register("flowing_light_blue_lava", () -> new LightBlueLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> BLUE_LAVA = REGISTRY.register("blue_lava", () -> new BlueLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BLUE_LAVA = REGISTRY.register("flowing_blue_lava", () -> new BlueLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> PURPLE_LAVA = REGISTRY.register("purple_lava", () -> new PurpleLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PURPLE_LAVA = REGISTRY.register("flowing_purple_lava", () -> new PurpleLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> PINK_LAVA = REGISTRY.register("pink_lava", () -> new PinkLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_PINK_LAVA = REGISTRY.register("flowing_pink_lava", () -> new PinkLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> WHITE_LAVA = REGISTRY.register("white_lava", () -> new WhiteLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_WHITE_LAVA = REGISTRY.register("flowing_white_lava", () -> new WhiteLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> BROWN_LAVA = REGISTRY.register("brown_lava", () -> new BrownLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BROWN_LAVA = REGISTRY.register("flowing_brown_lava", () -> new BrownLavaFluid.Flowing());
    public static final DeferredHolder<Fluid, FlowingFluid> BLACK_LAVA = REGISTRY.register("black_lava", () -> new BlackLavaFluid.Source());
    public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_BLACK_LAVA = REGISTRY.register("flowing_black_lava", () -> new BlackLavaFluid.Flowing());
}
