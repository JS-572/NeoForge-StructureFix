package net.js.jsmenu.space.asteroid;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class Asteroid extends SpaceObject {
    public Asteroid(String id,
                    String displayName,
                    double mapX,
                    double mapY,
                    String description,
                    ResourceKey<Level> spaceDimension,
                    ResourceKey<Level> lifeDimension) {
        super(
                id,
                displayName,
                SpaceObjectType.ASTEROID,
                mapX,
                mapY,
                description,
                spaceDimension,
                lifeDimension);
    }
}
