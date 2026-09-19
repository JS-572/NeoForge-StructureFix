package net.js.jsmenu.space.planet;

import net.js.jsmenu.space.SpaceDimensions;
import net.minecraft.world.level.Level;

import java.util.List;
import java.util.Optional;

public class Planets {
    public static final Planet MERCURY = new Planet("mercury", "Mercury", 174.0D, 0.0D, "Closest planet to the Sun. Smallest one we know yet has no moons since it's too close to the Sun.", SpaceDimensions.MERCURY, SpaceDimensions.MERCURY_LIFE, PlanetType.TERRESTRIAL, PlanetRotation.PROGRADE);
    public static final Planet EARTH = new Planet("earth", "Earth", 450.0D, 0.0D, "Home world with breathable air, liquid water, and familiar life.", Level.OVERWORLD, Level.OVERWORLD, PlanetType.TERRESTRIAL, PlanetRotation.PROGRADE);

    private static final List<Planet> PLANETS = List.of(MERCURY, EARTH);

    private Planets() {
    }

    public static List<Planet> getPlanets() {
        return PLANETS;
    }

    public static Optional<Planet> getPlanet(String id) {
        return PLANETS.stream()
                .filter(planet -> planet.getId().equals(id))
                .findFirst();
    }
}
