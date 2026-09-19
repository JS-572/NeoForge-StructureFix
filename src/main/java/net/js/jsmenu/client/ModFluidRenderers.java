package net.js.jsmenu.client;

import net.js.jsmenu.fluid.ModFluids;
import net.minecraft.client.renderer.ItemBlockRenderTypes;
import net.minecraft.client.renderer.RenderType;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;

public final class ModFluidRenderers {
    private ModFluidRenderers() {
    }

    public static void onClientSetup(FMLClientSetupEvent event) {
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BROMINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BROMINE.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.MERCURY.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_MERCURY.get(), RenderType.translucent());

        ItemBlockRenderTypes.setRenderLayer(ModFluids.RED_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_RED_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.LIGHT_YELLOW_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_LIGHT_YELLOW_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.YELLOW_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_YELLOW_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.GREEN_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_GREEN_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.LIGHT_BLUE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_LIGHT_BLUE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BLUE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BLUE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.PURPLE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PURPLE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.PINK_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_PINK_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.WHITE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_WHITE_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BROWN_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BROWN_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.BLACK_LAVA.get(), RenderType.translucent());
        ItemBlockRenderTypes.setRenderLayer(ModFluids.FLOWING_BLACK_LAVA.get(), RenderType.translucent());
    }
}
