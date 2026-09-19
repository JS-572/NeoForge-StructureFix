package net.js.jsmenu;

import net.js.jsmenu.client.DynamicHeldLightHandler;
import net.js.jsmenu.client.HeldLightSphereHandler;
import net.js.jsmenu.client.ModFluidRenderers;
import net.js.jsmenu.client.space.SpaceScreenController;
import net.neoforged.bus.api.IEventBus;

/**
 * Client-side registration helper. Call JSMenuClient.init(modBus) from your main mod constructor
 * passing the IEventBus you receive there.
 */
public class JSMenuClient {
    public static void init(IEventBus modBus) {
        modBus.addListener(ModFluidRenderers::onClientSetup);
        DynamicHeldLightHandler.register();
        HeldLightSphereHandler.register();
        SpaceScreenController.init(modBus);
    }
}
