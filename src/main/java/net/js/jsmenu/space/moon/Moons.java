package net.js.jsmenu.space.moon;

import net.js.jsmenu.space.SpaceDimensions;

import java.util.List;
import java.util.Optional;

public class Moons {
    public static final Moon MOON = new Moon("moon", "Moon",455.0D, 50.0D, "Our only moon and our most well-known. The Moon! Earth's natural satellite maintains the ocean tides and keeps the Earth's axial tilt steady.", SpaceDimensions.MOON, SpaceDimensions.MOON_LIFE);

    private static final List<Moon> MOONS = List.of(MOON);

    private Moons() {
    }

    public static List<Moon> getMoons() {
        return MOONS;
    }

    public static Optional<Moon> getMoon(String id) {
        return MOONS.stream()
                .filter(moon -> moon.getId().equals(id))
                .findFirst();
    }
}
