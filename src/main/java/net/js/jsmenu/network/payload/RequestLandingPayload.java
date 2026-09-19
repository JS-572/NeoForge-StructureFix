package net.js.jsmenu.network.payload;

import net.js.jsmenu.JSMenu;
import net.minecraft.network.RegistryFriendlyByteBuf;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.resources.ResourceLocation;

public record RequestLandingPayload(String objectId, boolean lifeMode) implements CustomPacketPayload {
    public static final Type<RequestLandingPayload> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "request_landing"));
    public static final StreamCodec<RegistryFriendlyByteBuf, RequestLandingPayload> STREAM_CODEC = CustomPacketPayload.codec(
            RequestLandingPayload::write,
            RequestLandingPayload::new
    );

    public RequestLandingPayload(RegistryFriendlyByteBuf buffer) {
        this(buffer.readUtf(), buffer.readBoolean());
    }

    private void write(RegistryFriendlyByteBuf buffer) {
        buffer.writeUtf(objectId);
        buffer.writeBoolean(lifeMode);
    }

    @Override
    public Type<RequestLandingPayload> type() {
        return TYPE;
    }
}
