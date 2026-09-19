package net.js.jsmenu.space.star;

import net.js.jsmenu.space.SpaceDimensions;

import java.util.List;
import java.util.Optional;

public class Stars {
    public static final Star SUN = new Star("sun", "Sun", 0.0D, 0.0D, "Center of the solar system and the main source of heat and light.", null, SpaceDimensions.SUN, StarClass.G, StarType.MAIN_SEQUENCE);

    private static final List<Star> STARS = List.of(SUN);

    private Stars() {
    }

    public static List<Star> getStars() {
        return STARS;
    }

    public static Optional<Star> getStar(String id) {
        return STARS.stream()
                .filter(star -> star.getId().equals(id))
                .findFirst();
    }
}
