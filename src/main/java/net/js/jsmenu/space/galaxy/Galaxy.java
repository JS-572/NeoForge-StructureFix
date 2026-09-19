package net.js.jsmenu.space.galaxy;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;

public class Galaxy extends SpaceObject {

    public Galaxy(
            String id,
            String displayName,
            double mapX,
            double mapY,
            String description
    ) {
        super(
                id,
                displayName,
                SpaceObjectType.GALAXY,
                mapX,
                mapY,
                description,
                null,
                null
        );
    }
}

