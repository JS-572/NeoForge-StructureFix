package net.js.jsmenu.network.payload;

import net.js.jsmenu.JSMenu;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.ByteBufCodecs;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record HarvestLavaPayload(String starId, int amount) implements CustomPacketPayload {

    public static final Type<HarvestLavaPayload> TYPE =
            new Type<>(ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "harvest_lava"));

    public static final StreamCodec<RegistryFriendlyByteBuf, HarvestLavaPayload> STREAM_CODEC =
            StreamCodec.composite(
                    ByteBufCodecs.STRING_UTF8, HarvestLavaPayload::starId,
                    ByteBufCodecs.VAR_INT, HarvestLavaPayload::amount,
                    HarvestLavaPayload::new
            );

    @Override
    public Type<? extends CustomPacketPayload> type() {
        return TYPE;
    }
}
