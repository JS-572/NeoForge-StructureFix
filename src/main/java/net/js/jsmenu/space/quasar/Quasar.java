package net.js.jsmenu.space.quasar;

import net.js.jsmenu.space.SpaceObject;
import net.js.jsmenu.space.SpaceObjectType;

public class Quasar extends SpaceObject {

    public Quasar(
            String id,
            String displayName,
            double mapX,
            double mapY,
            String description
    ) {
        super(
                id,
                displayName,
                SpaceObjectType.QUASAR,
                mapX,
                mapY,
                description,
                null,
                null
        );
    }
}

