package net.js.jsmenu.space.planet;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

public class Planet extends SpaceObject {
    private final PlanetType planetType;
    private final PlanetRotation rotation;

    public Planet(
            String id,
            String displayName,
            double mapX,
            double mapY,
            String description,
            ResourceKey<Level> spaceDimension,
            ResourceKey<Level> lifeDimension,
            PlanetType planetType,
            PlanetRotation rotation
    ) {
        super(
                id,
                displayName,
                SpaceObjectType.PLANET,
                mapX,
                mapY,
                description,
                spaceDimension,
                lifeDimension
        );

        this.planetType = planetType;
        this.rotation = rotation;
    }

    public PlanetType getPlanetType() {
        return planetType;
    }

    public PlanetRotation getRotation() {
        return rotation;
    }
}
