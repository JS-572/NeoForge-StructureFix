package net.js.jsmenu.space.moon;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class Moon extends SpaceObject {
    public Moon(String id, String displayName, double mapX, double mapY, String description, ResourceKey<Level> spaceDimension, ResourceKey<Level> lifeDimension) {
        super(id, displayName, SpaceObjectType.MOON, mapX, mapY, description, spaceDimension, lifeDimension);
    }
}
