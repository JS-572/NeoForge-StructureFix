package net.js.jsmenu.space.black_hole;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;

public class BlackHole extends SpaceObject {

    public BlackHole(
            String id,
            String displayName,
            double mapX,
            double mapY,
            String description
    ) {
        super(
                id,
                displayName,
                SpaceObjectType.BLACK_HOLE,
                mapX,
                mapY,
                description,
                null,
                null
        );
    }
}

