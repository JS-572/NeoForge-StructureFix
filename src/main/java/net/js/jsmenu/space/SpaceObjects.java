package net.js.jsmenu.space;

import net.js.jsmenu.space.moon.Moons;
import net.js.jsmenu.space.planet.Planets;
import net.js.jsmenu.space.star.Stars;

import java.util.List;
import java.util.Optional;

public class SpaceObjects {
    private static final List<SpaceObject> SPACE_OBJECTS = List.copyOf(buildSpaceObjects());

    private SpaceObjects() {
    }

    private static List<SpaceObject> buildSpaceObjects() {
        List<SpaceObject> objects = new java.util.ArrayList<>();
        objects.addAll(Stars.getStars());
        objects.addAll(Planets.getPlanets());
        objects.addAll(Moons.getMoons());
        return objects;
    }

    public static List<SpaceObject> getSpaceObjects() {
        return SPACE_OBJECTS;
    }

    public static Optional<SpaceObject> getSpaceObject(String id) {
        return SPACE_OBJECTS.stream()
                .filter(spaceObject -> spaceObject.getId().equals(id))
                .findFirst();
    }
}
