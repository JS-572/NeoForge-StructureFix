package net.js.jsmenu.fluid.types;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.extensions.common.IClientFluidTypeExtensions;
import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.common.SoundActions;
import net.neoforged.neoforge.fluids.FluidType;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class WhiteLavaFluidType extends FluidType {
    public WhiteLavaFluidType() {
        super(Properties.create().fallDistanceModifier(0f).canExtinguish(false).supportsBoating(false).canHydrate(false).motionScale(0.0028D).canConvertToSource(true).sound(SoundActions.BUCKET_FILL, SoundEvents.BUCKET_FILL).temperature(2600)
                .sound(SoundActions.BUCKET_EMPTY, SoundEvents.BUCKET_EMPTY).sound(SoundActions.FLUID_VAPORIZE, SoundEvents.FIRE_EXTINGUISH));
    }
    @SubscribeEvent
    public static void registerFluidTypeExtensions(RegisterClientExtensionsEvent event) {
        event.registerFluidType(new IClientFluidTypeExtensions() {
            private static final ResourceLocation STILL_TEXTURE = ResourceLocation.parse("jsmenu:block/white_lava");
            private static final ResourceLocation FLOWING_TEXTURE = ResourceLocation.parse("jsmenu:block/white_lava");

            @Override
            public ResourceLocation getStillTexture () {
                return STILL_TEXTURE;
            }

            @Override
            public ResourceLocation getFlowingTexture () {
                return FLOWING_TEXTURE;
            }
        }, ModFluidTypes.WHITE_LAVA_TYPE.get());
    }
}
