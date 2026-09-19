package net.js.jsmenu.worldgen;

import net.js.jsmenu.JSMenu;
import net.js.jsmenu.block.ModBlocks;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.biome.Biome;
import net.minecraft.world.level.biome.Biomes;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.PlacedFeature;
import net.neoforged.neoforge.common.world.BiomeModifier;

import java.util.List;
import java.util.function.Supplier;

public final class FlowerSpawnData {
    public static final List<Definition> FLOWERS = List.of(
            flower("mountain_daisy", ModBlocks.MOUNTAIN_DAISY, 14, 90, 256, Biomes.MEADOW, Biomes.JAGGED_PEAKS, Biomes.FROZEN_PEAKS, Biomes.STONY_PEAKS),
            flower("spring_morning", ModBlocks.SPRING_MORNING, 5, 60, 180, Biomes.PLAINS, Biomes.MEADOW, Biomes.SUNFLOWER_PLAINS),
            flower("tiger_bell", ModBlocks.TIGER_BELL, 8, 70, 190, Biomes.MEADOW, Biomes.FLOWER_FOREST, Biomes.FOREST),
            flower("starburst", ModBlocks.STARBURST, 7, 64, 180, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.FLOWER_FOREST),
            flower("rain_drop", ModBlocks.RAIN_DROP, 10, 58, 160, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.RIVER),
            flower("dew_crystal", ModBlocks.DEW_CRYSTAL, 12, 62, 170, Biomes.SWAMP, Biomes.RIVER, Biomes.MEADOW),
            flower("emperor", ModBlocks.EMPEROR, 14, 64, 170, Biomes.FLOWER_FOREST, Biomes.FOREST, Biomes.CHERRY_GROVE),
            flower("snow_lily", ModBlocks.SNOW_LILY, 16, 90, 220, Biomes.GROVE, Biomes.SNOWY_SLOPES, Biomes.SNOWY_TAIGA),
            flower("meadow_lily", ModBlocks.MEADOW_LILY, 6, 64, 180, Biomes.MEADOW, Biomes.PLAINS, Biomes.FLOWER_FOREST),
            flower("golden_rays", ModBlocks.GOLDEN_RAYS, 6, 64, 180, Biomes.SUNFLOWER_PLAINS, Biomes.PLAINS, Biomes.MEADOW),
            flower("lantern_bowl", ModBlocks.LANTERN_BOWL, 12, 64, 160, Biomes.FOREST, Biomes.DARK_FOREST, Biomes.FLOWER_FOREST),
            flower("sunset_tulip", ModBlocks.SUNSET_TULIP, 8, 64, 170, Biomes.PLAINS, Biomes.MEADOW, Biomes.FLOWER_FOREST),
            flower("iris_mantle", ModBlocks.IRIS_MANTLE, 10, 62, 170, Biomes.MEADOW, Biomes.RIVER, Biomes.SWAMP),
            flower("cala", ModBlocks.CALA, 14, 62, 170, Biomes.SWAMP, Biomes.MANGROVE_SWAMP, Biomes.RIVER),
            flower("rainbow_stars", ModBlocks.RAINBOW_STARS, 12, 64, 180, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.MEADOW),
            flower("fire_lily", ModBlocks.FIRE_LILY, 18, 64, 180, Biomes.SAVANNA, Biomes.SAVANNA_PLATEAU, Biomes.SPARSE_JUNGLE),
            flower("royal_rose", ModBlocks.ROYAL_ROSE, 18, 64, 170, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.FOREST),
            flower("wild_rose", ModBlocks.WILD_ROSE, 9, 64, 170, Biomes.PLAINS, Biomes.FOREST, Biomes.FLOWER_FOREST),
            flower("paradise_flower", ModBlocks.PARADISE_FLOWER, 20, 64, 180, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.BAMBOO_JUNGLE),
            flower("sugarplum", ModBlocks.SUGARPLUM, 12, 64, 160, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.FLOWER_FOREST),
            flower("sparkle", ModBlocks.SPARKLE, 8, 64, 180, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW, Biomes.FLOWER_FOREST),
            flower("evensong", ModBlocks.EVENSONG, 18, 62, 150, Biomes.DARK_FOREST, Biomes.SWAMP, Biomes.MANGROVE_SWAMP),
            flower("warm_welcome", ModBlocks.WARM_WELCOME, 10, 64, 170, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.FLOWER_FOREST),
            flower("wedding_bell", ModBlocks.WEDDING_BELL, 10, 64, 170, Biomes.MEADOW, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST),
            flower("bunny_ears", ModBlocks.BUNNY_EARS, 16, 64, 180, Biomes.SPARSE_JUNGLE, Biomes.JUNGLE, Biomes.MEADOW),
            flower("sunset_daisy", ModBlocks.SUNSET_DAISY, 7, 64, 180, Biomes.PLAINS, Biomes.SUNFLOWER_PLAINS, Biomes.MEADOW),
            flower("xmas_thistle", ModBlocks.XMAS_THISTLE, 14, 70, 180, Biomes.TAIGA, Biomes.SNOWY_TAIGA, Biomes.WINDSWEPT_HILLS),
            flower("ladys_gown", ModBlocks.LADYS_GOWN, 14, 64, 170, Biomes.CHERRY_GROVE, Biomes.FOREST, Biomes.BIRCH_FOREST),
            flower("frost_berry", ModBlocks.FROST_BERRY, 18, 90, 210, Biomes.GROVE, Biomes.SNOWY_TAIGA, Biomes.SNOWY_SLOPES),
            flower("spring_buttercup", ModBlocks.SPRING_BUTTERCUP, 4, 60, 180, Biomes.PLAINS, Biomes.MEADOW, Biomes.FLOWER_FOREST),
            flower("ladys_button", ModBlocks.LADYS_BUTTON, 8, 64, 180, Biomes.MEADOW, Biomes.PLAINS, Biomes.FLOWER_FOREST),
            flower("heart_bowl", ModBlocks.HEART_BOWL, 12, 64, 170, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST, Biomes.FOREST),
            flower("pink_grace", ModBlocks.PINK_GRACE, 12, 64, 170, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST),
            flower("mothers_rose", ModBlocks.MOTHERS_ROSE, 16, 64, 170, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.FOREST),
            flower("inner_peace", ModBlocks.INNER_PEACE, 12, 64, 180, Biomes.MEADOW, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST),
            flower("wishing_tulip", ModBlocks.WISHING_TULIP, 8, 64, 170, Biomes.PLAINS, Biomes.MEADOW, Biomes.FLOWER_FOREST),
            flower("orange_bell", ModBlocks.ORANGE_BELL, 10, 64, 170, Biomes.MEADOW, Biomes.FOREST, Biomes.FLOWER_FOREST),
            flower("dream_stars", ModBlocks.DREAM_STARS, 14, 64, 180, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.MEADOW),
            flower("aradia", ModBlocks.ARADIA, 18, 64, 170, Biomes.CHERRY_GROVE, Biomes.DARK_FOREST, Biomes.FLOWER_FOREST),
            flower("sempiternal", ModBlocks.SEMPITERNAL, 20, 70, 220, Biomes.MEADOW, Biomes.GROVE, Biomes.CHERRY_GROVE),
            flower("noon_dream", ModBlocks.NOON_DREAM, 14, 64, 180, Biomes.SAVANNA, Biomes.SUNFLOWER_PLAINS, Biomes.PLAINS),
            flower("prairie_heart", ModBlocks.PRAIRIE_HEART, 5, 64, 180, Biomes.PLAINS, Biomes.MEADOW, Biomes.SUNFLOWER_PLAINS),
            flower("aurora", ModBlocks.AURORA, 20, 90, 220, Biomes.GROVE, Biomes.SNOWY_SLOPES, Biomes.MEADOW),
            flower("friendship_rose", ModBlocks.FRIENDSHIP_ROSE, 12, 64, 170, Biomes.FOREST, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE),
            flower("xanas_charm", ModBlocks.XANAS_CHARM, 20, 62, 150, Biomes.DARK_FOREST, Biomes.SWAMP, Biomes.MANGROVE_SWAMP),
            flower("love_everlasting", ModBlocks.LOVE_EVERLASTING, 16, 64, 170, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST, Biomes.FOREST),
            flower("remembrance", ModBlocks.REMEMBRANCE, 18, 70, 200, Biomes.GROVE, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST),
            flower("icy_drop", ModBlocks.ICY_DROP, 16, 90, 220, Biomes.GROVE, Biomes.SNOWY_SLOPES, Biomes.FROZEN_RIVER),
            flower("winter_solace", ModBlocks.WINTER_SOLACE, 18, 90, 220, Biomes.SNOWY_TAIGA, Biomes.GROVE, Biomes.SNOWY_SLOPES),
            flower("poinsettia", ModBlocks.POINSETTIA, 24, 64, 180, Biomes.JUNGLE, Biomes.SPARSE_JUNGLE, Biomes.SAVANNA_PLATEAU),
            flower("edelweiss", ModBlocks.EDELWEISS, 24, 100, 240, Biomes.MEADOW, Biomes.GROVE, Biomes.SNOWY_SLOPES),
            flower("lavender_star", ModBlocks.LAVENDER_STAR, 8, 64, 180, Biomes.MEADOW, Biomes.PLAINS, Biomes.SAVANNA),
            flower("blue_lys", ModBlocks.BLUE_LYS, 12, 62, 170, Biomes.RIVER, Biomes.MEADOW, Biomes.SWAMP),
            flower("queens_guard", ModBlocks.QUEENS_GUARD, 18, 64, 170, Biomes.BIRCH_FOREST, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST),
            flower("winters_end", ModBlocks.WINTERS_END, 16, 90, 220, Biomes.GROVE, Biomes.SNOWY_TAIGA, Biomes.MEADOW),
            flower("new_years_wish", ModBlocks.NEW_YEARS_WISH, 18, 90, 220, Biomes.GROVE, Biomes.SNOWY_SLOPES, Biomes.FROZEN_RIVER),
            flower("skys_edge", ModBlocks.SKYS_EDGE, 20, 110, 240, Biomes.MEADOW, Biomes.GROVE, Biomes.SNOWY_SLOPES),
            flower("foys_treasure", ModBlocks.FOYS_TREASURE, 16, 64, 180, Biomes.SAVANNA_PLATEAU, Biomes.MEADOW, Biomes.WINDSWEPT_HILLS),
            flower("snappy_flower", ModBlocks.SNAPPY_FLOWER, 10, 64, 170, Biomes.FOREST, Biomes.BIRCH_FOREST, Biomes.MEADOW),
            flower("may_flower", ModBlocks.MAY_FLOWER, 6, 64, 170, Biomes.FOREST, Biomes.PLAINS, Biomes.MEADOW),
            flower("128petals", ModBlocks.OFEPETALS, 12, 64, 180, Biomes.FLOWER_FOREST, Biomes.MEADOW, Biomes.SUNFLOWER_PLAINS),
            flower("summer_fingers", ModBlocks.SUMMER_FINGERS, 9, 64, 180, Biomes.PLAINS, Biomes.SAVANNA, Biomes.MEADOW),
            flower("p_gameralum", ModBlocks.P_GAMERALUM, 18, 64, 180, Biomes.FLOWER_FOREST, Biomes.CHERRY_GROVE, Biomes.DARK_FOREST),
            flower("purple_tendrils", ModBlocks.PURPLE_TENDRILS, 18, 62, 150, Biomes.SWAMP, Biomes.DARK_FOREST, Biomes.MANGROVE_SWAMP),
            flower("moon_craver", ModBlocks.MOON_CRAVER, 22, 90, 220, Biomes.GROVE, Biomes.SNOWY_SLOPES, Biomes.DARK_FOREST),
            flower("appera_blossom", ModBlocks.APPERA_BLOSSOM, 16, 64, 170, Biomes.CHERRY_GROVE, Biomes.FLOWER_FOREST, Biomes.BIRCH_FOREST),
            flower("tulip_gameora", ModBlocks.TULIP_GAMEORA, 10, 64, 170, Biomes.PLAINS, Biomes.MEADOW, Biomes.FLOWER_FOREST),
            flower("spring_touch", ModBlocks.SPRING_TOUCH, 6, 64, 170, Biomes.PLAINS, Biomes.MEADOW, Biomes.BIRCH_FOREST),
            flower("all_hallows_eve", ModBlocks.ALL_HALLOWS_EVE, 24, 62, 150, Biomes.DARK_FOREST, Biomes.SWAMP, Biomes.MANGROVE_SWAMP)
    );

    private FlowerSpawnData() {
    }

    @SafeVarargs
    private static Definition flower(String name, Supplier<Block> block, int rarity, int minY, int maxY, ResourceKey<Biome>... biomes) {
        return new Definition(name, block, rarity, minY, maxY, List.of(biomes));
    }

    public record Definition(String name, Supplier<Block> block, int rarity, int minY, int maxY,
                             List<ResourceKey<Biome>> biomes) {
        public ResourceKey<ConfiguredFeature<?, ?>> configuredKey() {
            return ResourceKey.create(net.minecraft.core.registries.Registries.CONFIGURED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, name));
        }

        public ResourceKey<PlacedFeature> placedKey() {
            return ResourceKey.create(net.minecraft.core.registries.Registries.PLACED_FEATURE,
                    ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, name + "_placed"));
        }

        public ResourceKey<BiomeModifier> modifierKey() {
            return ResourceKey.create(net.neoforged.neoforge.registries.NeoForgeRegistries.Keys.BIOME_MODIFIERS,
                    ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, "add_" + name));
        }
    }
}
