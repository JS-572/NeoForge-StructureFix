package net.js.jsmenu.space;

import net.js.jsmenu.JSMenu;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.Level;

public class SpaceDimensions {
    public static final ResourceKey<Level> SPACE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "space"));
    public static final ResourceKey<Level> SPACE_OF_LIFE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "space_of_life"));
    public static final ResourceKey<Level> SUN = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "sun"));
    public static final ResourceKey<Level> MOON = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "moon"));
    public static final ResourceKey<Level> MOON_LIFE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "moon_life"));
    public static final ResourceKey<Level> MERCURY = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "mercury"));
    public static final ResourceKey<Level> MERCURY_LIFE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "mercury_life"));
    public static final ResourceKey<Level> VENUS = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "venus"));
    public static final ResourceKey<Level> VENUS_LIFE = ResourceKey.create(Registries.DIMENSION, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "venus_life"));
    private SpaceDimensions() {
    }
}
