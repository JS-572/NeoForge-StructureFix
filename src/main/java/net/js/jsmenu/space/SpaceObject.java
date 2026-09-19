package net.js.jsmenu.space;

import net.js.jsmenu.space.star.Star;
import net.js.jsmenu.space.star.StarClass;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.Level;

/**
 * Base model for anything the space UI can display and select.
 * Type-specific classes can extend this later with extra fields.
 */
public abstract class SpaceObject {
    private final String id;
    private final String displayName;
    private final SpaceObjectType type;
    private final double mapX;
    private final double mapY;
    private final String description;
    private final ResourceKey<Level> spaceDimension;
    private final ResourceKey<Level> lifeDimension;

    protected SpaceObject(
            String id,
            String displayName,
            SpaceObjectType type,
            double mapX,
            double mapY,
            String description,
            ResourceKey<Level> spaceDimension,
            ResourceKey<Level> lifeDimension
    ) {
        this.id = id;
        this.displayName = displayName;
        this.type = type;
        this.mapX = mapX;
        this.mapY = mapY;
        this.description = description;
        this.spaceDimension = spaceDimension;
        this.lifeDimension = lifeDimension;
    }

    public String getId() {
        return id;
    }

    public String getDisplayName() {
        return displayName;
    }

    public SpaceObjectType getType() {
        return type;
    }

    public double getMapX() {
        return mapX;
    }

    public double getMapY() {
        return mapY;
    }

    public String getDescription() {
        return description;
    }

    public ResourceKey<Level> getSpaceDimension() {
        return spaceDimension;
    }

    public ResourceKey<Level> getLifeDimension() {
        return lifeDimension;
    }

    public boolean hasSpaceDimension() {
        return spaceDimension != null;
    }

    public boolean hasLifeDimension() {
        return lifeDimension != null;
    }

    public boolean canLand() {
        return switch (type) {
            case PLANET, MOON, ASTEROID, COMET -> hasSpaceDimension();
            default -> false;
        };
    }

    public boolean hasLifeVariant() {
        return hasLifeDimension();
    }

    public boolean canHarvestLava() {
        return type == SpaceObjectType.STAR;
    }

    public StarClass getStarClass() {
        if (this instanceof Star star) {
            return star.getStarClass();
        }
        return null;
    }
}
