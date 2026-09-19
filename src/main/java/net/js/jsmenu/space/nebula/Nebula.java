package net.js.jsmenu.space.nebula;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;

public class Nebula extends SpaceObject {

    public Nebula(
            String id,
            String displayName,
            double mapX,
            double mapY,
            String description
    ) {
        super(
                id,
                displayName,
                SpaceObjectType.NEBULA,
                mapX,
                mapY,
                description,
                null,
                null
        );
    }
}

