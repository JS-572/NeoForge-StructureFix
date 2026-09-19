package net.js.jsmenu.space.comet;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class Comet extends SpaceObject {
    public Comet(String id,
                 String displayName,
                 double mapX,
                 double mapY,
                 String description,
                 ResourceKey<Level> spaceDimension,
                 ResourceKey<Level> lifeDimension) {
        super(
                id,
                displayName,
                SpaceObjectType.COMET,
                mapX,
                mapY,
                description,
                spaceDimension,
                lifeDimension);
    }
}
