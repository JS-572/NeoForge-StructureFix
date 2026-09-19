package net.js.jsmenu.network;

import net.js.jsmenu.JSMenu;
import net.js.jsmenu.network.payload.RequestLandingPayload;
import net.js.jsmenu.network.payload.HarvestLavaPayload;
import net.minecraft.server.level.ServerPlayer;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.network.event.RegisterPayloadHandlersEvent;
import net.neoforged.neoforge.network.handling.IPayloadContext;

@EventBusSubscriber(modid = JSMenu.MOD_ID, bus = EventBusSubscriber.Bus.MOD)
public final class SpaceNetwork {
    private static final String PROTOCOL_VERSION = "1";

    private SpaceNetwork() {
    }

    @SubscribeEvent
    public static void registerPayloads(RegisterPayloadHandlersEvent event) {
        event.registrar(PROTOCOL_VERSION)
                .playToServer(RequestLandingPayload.TYPE, RequestLandingPayload.STREAM_CODEC, SpaceNetwork::handleLandingRequest)
                .playToServer(HarvestLavaPayload.TYPE, HarvestLavaPayload.STREAM_CODEC, SpaceNetwork::handleHarvestLava);
    }

    private static void handleLandingRequest(RequestLandingPayload payload, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player) {
            SpaceTravelHandler.requestLanding(player, payload.objectId(), payload.lifeMode());
        }
    }

    private static void handleHarvestLava(HarvestLavaPayload payload, IPayloadContext context) {
        if (context.player() instanceof ServerPlayer player) {
            SpaceHarvestLava.harvestLava(player, payload.starId(), payload.amount());
        }
    }

    public static void handleHarvestPacket(ServerPlayer player, HarvestLavaPayload payload) {

        SpaceHarvestLava.harvestLava(
                player,
                payload.starId(),
                payload.amount()
        );
    }
}
