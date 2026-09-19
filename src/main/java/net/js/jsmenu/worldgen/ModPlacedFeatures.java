package net.js.jsmenu.worldgen;

import net.js.jsmenu.JSMenu;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.placement.PlacementUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.levelgen.VerticalAnchor;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.placement.*;

import java.util.List;

public class ModPlacedFeatures {
    public static final ResourceKey<PlacedFeature> HYDROGEN_ORE_PLACED_KEY = registerKey("hydrogen_ore_placed");
    public static final ResourceKey<PlacedFeature> LITHIUM_ORE_PLACED_KEY = registerKey("lithium_ore_placed");
    public static final ResourceKey<PlacedFeature> BERYLLIUM_ORE_PLACED_KEY = registerKey("beryllium_ore_placed");
    public static final ResourceKey<PlacedFeature> BORON_ORE_PLACED_KEY = registerKey("boron_ore_placed");
    public static final ResourceKey<PlacedFeature> CARBON_ORE_PLACED_KEY = registerKey("carbon_ore_placed");
    public static final ResourceKey<PlacedFeature> NITROGEN_ORE_PLACED_KEY = registerKey("nitrogen_ore_placed");
    public static final ResourceKey<PlacedFeature> OXYGEN_ORE_PLACED_KEY = registerKey("oxygen_ore_placed");
    public static final ResourceKey<PlacedFeature> FLUORINE_ORE_PLACED_KEY = registerKey("fluorine_ore_placed");
    public static final ResourceKey<PlacedFeature> NEON_ORE_PLACED_KEY = registerKey("neon_ore_placed");
    public static final ResourceKey<PlacedFeature> SODIUM_ORE_PLACED_KEY = registerKey("sodium_ore_placed");
    public static final ResourceKey<PlacedFeature> MAGNESIUM_ORE_PLACED_KEY = registerKey("magnesium_ore_placed");
    public static final ResourceKey<PlacedFeature> ALUMINUM_ORE_PLACED_KEY = registerKey("aluminum_ore_placed");
    public static final ResourceKey<PlacedFeature> SILICON_ORE_PLACED_KEY = registerKey("silicon_ore_placed");
    public static final ResourceKey<PlacedFeature> PHOSPHORUS_ORE_PLACED_KEY = registerKey("phosphorus_ore_placed");
    public static final ResourceKey<PlacedFeature> SULFUR_ORE_PLACED_KEY = registerKey("sulfur_ore_placed");
    public static final ResourceKey<PlacedFeature> CHLORINE_ORE_PLACED_KEY = registerKey("chlorine_ore_placed");
    public static final ResourceKey<PlacedFeature> ARGON_ORE_PLACED_KEY = registerKey("argon_ore_placed");
    public static final ResourceKey<PlacedFeature> POTASSIUM_ORE_PLACED_KEY = registerKey("potassium_ore_placed");
    public static final ResourceKey<PlacedFeature> CALCIUM_ORE_PLACED_KEY = registerKey("calcium_ore_placed");
    public static final ResourceKey<PlacedFeature> SCANDIUM_ORE_PLACED_KEY = registerKey("scandium_ore_placed");
    public static final ResourceKey<PlacedFeature> TITANIUM_ORE_PLACED_KEY = registerKey("titanium_ore_placed");
    public static final ResourceKey<PlacedFeature> VANADIUM_ORE_PLACED_KEY = registerKey("vanadium_ore_placed");
    public static final ResourceKey<PlacedFeature> CHROMIUM_ORE_PLACED_KEY = registerKey("chromium_ore_placed");
    public static final ResourceKey<PlacedFeature> MANGANESE_ORE_PLACED_KEY = registerKey("manganese_ore_placed");
    public static final ResourceKey<PlacedFeature> COBALT_ORE_PLACED_KEY = registerKey("cobalt_ore_placed");
    public static final ResourceKey<PlacedFeature> NICKEL_ORE_PLACED_KEY = registerKey("nickel_ore_placed");
    public static final ResourceKey<PlacedFeature> ZINC_ORE_PLACED_KEY = registerKey("zinc_ore_placed");
    public static final ResourceKey<PlacedFeature> GALLIUM_ORE_PLACED_KEY = registerKey("gallium_ore_placed");
    public static final ResourceKey<PlacedFeature> GERMANIUM_ORE_PLACED_KEY = registerKey("germanium_ore_placed");
    public static final ResourceKey<PlacedFeature> ARSENIC_ORE_PLACED_KEY = registerKey("arsenic_ore_placed");
    public static final ResourceKey<PlacedFeature> SELENIUM_ORE_PLACED_KEY = registerKey("selenium_ore_placed");
    public static final ResourceKey<PlacedFeature> KRYPTON_ORE_PLACED_KEY = registerKey("krypton_ore_placed");
    public static final ResourceKey<PlacedFeature> RUBIDIUM_ORE_PLACED_KEY = registerKey("rubidium_ore_placed");
    public static final ResourceKey<PlacedFeature> STRONTIUM_ORE_PLACED_KEY = registerKey("strontium_ore_placed");
    public static final ResourceKey<PlacedFeature> YTTRIUM_ORE_PLACED_KEY = registerKey("yttrium_ore_placed");
    public static final ResourceKey<PlacedFeature> ZIRCONIUM_ORE_PLACED_KEY = registerKey("zirconium_ore_placed");
    public static final ResourceKey<PlacedFeature> NIOBIUM_ORE_PLACED_KEY = registerKey("niobium_ore_placed");
    public static final ResourceKey<PlacedFeature> MOLYBDENUM_ORE_PLACED_KEY = registerKey("molybdenum_ore_placed");
    public static final ResourceKey<PlacedFeature> TECHNETIUM_ORE_PLACED_KEY = registerKey("technetium_ore_placed");
    public static final ResourceKey<PlacedFeature> RUTHENIUM_ORE_PLACED_KEY = registerKey("ruthenium_ore_placed");
    public static final ResourceKey<PlacedFeature> RHODIUM_ORE_PLACED_KEY = registerKey("rhodium_ore_placed");
    public static final ResourceKey<PlacedFeature> PALLADIUM_ORE_PLACED_KEY = registerKey("palladium_ore_placed");
    public static final ResourceKey<PlacedFeature> SILVER_ORE_PLACED_KEY = registerKey("silver_ore_placed");
    public static final ResourceKey<PlacedFeature> CADMIUM_ORE_PLACED_KEY = registerKey("cadmium_ore_placed");
    public static final ResourceKey<PlacedFeature> INDIUM_ORE_PLACED_KEY = registerKey("indium_ore_placed");
    public static final ResourceKey<PlacedFeature> TIN_ORE_PLACED_KEY = registerKey("tin_ore_placed");
    public static final ResourceKey<PlacedFeature> ANTIMONY_ORE_PLACED_KEY = registerKey("antimony_ore_placed");
    public static final ResourceKey<PlacedFeature> TELLURIUM_ORE_PLACED_KEY = registerKey("tellurium_ore_placed");
    public static final ResourceKey<PlacedFeature> IODINE_ORE_PLACED_KEY = registerKey("iodine_ore_placed");
    public static final ResourceKey<PlacedFeature> XENON_ORE_PLACED_KEY = registerKey("xenon_ore_placed");
    public static final ResourceKey<PlacedFeature> CAESIUM_ORE_PLACED_KEY = registerKey("caesium_ore_placed");
    public static final ResourceKey<PlacedFeature> BARIUM_ORE_PLACED_KEY = registerKey("barium_ore_placed");
    public static final ResourceKey<PlacedFeature> LANTHANUM_ORE_PLACED_KEY = registerKey("lanthanum_ore_placed");
    public static final ResourceKey<PlacedFeature> CERIUM_ORE_PLACED_KEY = registerKey("cerium_ore_placed");
    public static final ResourceKey<PlacedFeature> PRASEODYMIUM_ORE_PLACED_KEY = registerKey("praseodymium_ore_placed");
    public static final ResourceKey<PlacedFeature> NEODYMIUM_ORE_PLACED_KEY = registerKey("neodymium_ore_placed");
    public static final ResourceKey<PlacedFeature> PROMETHIUM_ORE_PLACED_KEY = registerKey("promethium_ore_placed");
    public static final ResourceKey<PlacedFeature> SAMARIUM_ORE_PLACED_KEY = registerKey("samarium_ore_placed");
    public static final ResourceKey<PlacedFeature> EUROPIUM_ORE_PLACED_KEY = registerKey("europium_ore_placed");
    public static final ResourceKey<PlacedFeature> GADOLINIUM_ORE_PLACED_KEY = registerKey("gadolinium_ore_placed");
    public static final ResourceKey<PlacedFeature> TERBIUM_ORE_PLACED_KEY = registerKey("terbium_ore_placed");
    public static final ResourceKey<PlacedFeature> DYSPROSIUM_ORE_PLACED_KEY = registerKey("dysprosium_ore_placed");
    public static final ResourceKey<PlacedFeature> HOLMIUM_ORE_PLACED_KEY = registerKey("holmium_ore_placed");
    public static final ResourceKey<PlacedFeature> ERBIUM_ORE_PLACED_KEY = registerKey("erbium_ore_placed");
    public static final ResourceKey<PlacedFeature> THULIUM_ORE_PLACED_KEY = registerKey("thulium_ore_placed");
    public static final ResourceKey<PlacedFeature> YTTERBIUM_ORE_PLACED_KEY = registerKey("ytterbium_ore_placed");
    public static final ResourceKey<PlacedFeature> LUTETIUM_ORE_PLACED_KEY = registerKey("lutetium_ore_placed");
    public static final ResourceKey<PlacedFeature> HAFNIUM_ORE_PLACED_KEY = registerKey("hafnium_ore_placed");
    public static final ResourceKey<PlacedFeature> TANTALUM_ORE_PLACED_KEY = registerKey("tantalum_ore_placed");
    public static final ResourceKey<PlacedFeature> TUNGSTEN_ORE_PLACED_KEY = registerKey("tungsten_ore_placed");
    public static final ResourceKey<PlacedFeature> RHENIUM_ORE_PLACED_KEY = registerKey("rhenium_ore_placed");
    public static final ResourceKey<PlacedFeature> OSMIUM_ORE_PLACED_KEY = registerKey("osmium_ore_placed");
    public static final ResourceKey<PlacedFeature> IRIDIUM_ORE_PLACED_KEY = registerKey("iridium_ore_placed");
    public static final ResourceKey<PlacedFeature> PLATINUM_ORE_PLACED_KEY = registerKey("platinum_ore_placed");
    public static final ResourceKey<PlacedFeature> THALLIUM_ORE_PLACED_KEY = registerKey("thallium_ore_placed");
    public static final ResourceKey<PlacedFeature> LEAD_ORE_PLACED_KEY = registerKey("lead_ore_placed");
    public static final ResourceKey<PlacedFeature> BISMUTH_ORE_PLACED_KEY = registerKey("bismuth_ore_placed");
    public static final ResourceKey<PlacedFeature> POLONIUM_ORE_PLACED_KEY = registerKey("polonium_ore_placed");
    public static final ResourceKey<PlacedFeature> ASTATINE_ORE_PLACED_KEY = registerKey("astatine_ore_placed");
    public static final ResourceKey<PlacedFeature> RADON_ORE_PLACED_KEY = registerKey("radon_ore_placed");
    public static final ResourceKey<PlacedFeature> FRANCIUM_ORE_PLACED_KEY = registerKey("francium_ore_placed");
    public static final ResourceKey<PlacedFeature> RADIUM_ORE_PLACED_KEY = registerKey("radium_ore_placed");
    public static final ResourceKey<PlacedFeature> ACTINIUM_ORE_PLACED_KEY = registerKey("actinium_ore_placed");
    public static final ResourceKey<PlacedFeature> THORIUM_ORE_PLACED_KEY = registerKey("thorium_ore_placed");
    public static final ResourceKey<PlacedFeature> PROTACTINIUM_ORE_PLACED_KEY = registerKey("protactinium_ore_placed");
    public static final ResourceKey<PlacedFeature> URANIUM_ORE_PLACED_KEY = registerKey("uranium_ore_placed");
    public static final ResourceKey<PlacedFeature> NEPTUNIUM_ORE_PLACED_KEY = registerKey("neptunium_ore_placed");
    public static final ResourceKey<PlacedFeature> PLUTONIUM_ORE_PLACED_KEY = registerKey("plutonium_ore_placed");
    public static final ResourceKey<PlacedFeature> AMERICIUM_ORE_PLACED_KEY = registerKey("americium_ore_placed");
    public static final ResourceKey<PlacedFeature> CURIUM_ORE_PLACED_KEY = registerKey("curium_ore_placed");
    public static final ResourceKey<PlacedFeature> BERKELIUM_ORE_PLACED_KEY = registerKey("berkelium_ore_placed");
    public static final ResourceKey<PlacedFeature> CALIFORNIUM_ORE_PLACED_KEY = registerKey("californium_ore_placed");
    public static final ResourceKey<PlacedFeature> EINSTEINIUM_ORE_PLACED_KEY = registerKey("einsteinium_ore_placed");
    public static final ResourceKey<PlacedFeature> FERMIUM_ORE_PLACED_KEY = registerKey("fermium_ore_placed");
    public static final ResourceKey<PlacedFeature> MENDELEVIUM_ORE_PLACED_KEY = registerKey("mendelevium_ore_placed");
    public static final ResourceKey<PlacedFeature> NOBELIUM_ORE_PLACED_KEY = registerKey("nobelium_ore_placed");
    public static final ResourceKey<PlacedFeature> LAWRENCIUM_ORE_PLACED_KEY = registerKey("lawrencium_ore_placed");
    public static final ResourceKey<PlacedFeature> RUTHERFORDIUM_ORE_PLACED_KEY = registerKey("rutherfordium_ore_placed");
    public static final ResourceKey<PlacedFeature> DUBNIUM_ORE_PLACED_KEY = registerKey("dubnium_ore_placed");
    public static final ResourceKey<PlacedFeature> SEABORGIUM_ORE_PLACED_KEY = registerKey("seaborgium_ore_placed");
    public static final ResourceKey<PlacedFeature> BOHRIUM_ORE_PLACED_KEY = registerKey("bohrium_ore_placed");
    public static final ResourceKey<PlacedFeature> HASSIUM_ORE_PLACED_KEY = registerKey("hassium_ore_placed");
    public static final ResourceKey<PlacedFeature> MEITNERIUM_ORE_PLACED_KEY = registerKey("meitnerium_ore_placed");
    public static final ResourceKey<PlacedFeature> DARMSTADTIUM_ORE_PLACED_KEY = registerKey("darmstadtium_ore_placed");
    public static final ResourceKey<PlacedFeature> ROENTGENIUM_ORE_PLACED_KEY = registerKey("roentgenium_ore_placed");
    public static final ResourceKey<PlacedFeature> COPERNICIUM_ORE_PLACED_KEY = registerKey("copernicium_ore_placed");
    public static final ResourceKey<PlacedFeature> NIHONIUM_ORE_PLACED_KEY = registerKey("nihonium_ore_placed");
    public static final ResourceKey<PlacedFeature> FLEROVIUM_ORE_PLACED_KEY = registerKey("flerovium_ore_placed");
    public static final ResourceKey<PlacedFeature> MOSCOVIUM_ORE_PLACED_KEY = registerKey("moscovium_ore_placed");
    public static final ResourceKey<PlacedFeature> LIVERMORIUM_ORE_PLACED_KEY = registerKey("livermorium_ore_placed");
    public static final ResourceKey<PlacedFeature> TENNESSINE_ORE_PLACED_KEY = registerKey("tennessine_ore_placed");
    public static final ResourceKey<PlacedFeature> OGANESSON_ORE_PLACED_KEY = registerKey("oganesson_ore_placed");
    public static final ResourceKey<PlacedFeature> MOON_CRATERS_PLACED_KEY = registerKey("moon_craters_placed");

    public static void bootstrap(BootstrapContext<PlacedFeature> context) {
        var configuredFeatures = context.lookup(Registries.CONFIGURED_FEATURE);

        register(context, HYDROGEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HYDROGEN_ORE_KEY), ModOrePlacement.commonOrePlacement(24, HeightRangePlacement.uniform(VerticalAnchor.absolute(22), VerticalAnchor.absolute(256))));
        register(context, LITHIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LITHIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(18, HeightRangePlacement.uniform(VerticalAnchor.absolute(15), VerticalAnchor.absolute(92))));
        register(context, BERYLLIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BERYLLIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(36), VerticalAnchor.absolute(97))));
        register(context, BORON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BORON_ORE_KEY), ModOrePlacement.commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(28), VerticalAnchor.absolute(68))));
        register(context, CARBON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CARBON_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(70), VerticalAnchor.absolute(256))));
        register(context, NITROGEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NITROGEN_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(48), VerticalAnchor.absolute(96))));
        register(context, OXYGEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OXYGEN_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(54), VerticalAnchor.absolute(83))));
        register(context, FLUORINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLUORINE_ORE_KEY), ModOrePlacement.commonOrePlacement(14, HeightRangePlacement.uniform(VerticalAnchor.absolute(33), VerticalAnchor.absolute(96))));
        register(context, NEON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NEON_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(18), VerticalAnchor.absolute(108))));
        register(context, SODIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SODIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(16), VerticalAnchor.absolute(45))));
        register(context, MAGNESIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MAGNESIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(24), VerticalAnchor.absolute(76))));
        register(context, ALUMINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ALUMINUM_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-24))));
        register(context, SILICON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILICON_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(27), VerticalAnchor.absolute(87))));
        register(context, PHOSPHORUS_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PHOSPHORUS_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(66), VerticalAnchor.absolute(87))));
        register(context, SULFUR_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SULFUR_ORE_KEY), ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(94), VerticalAnchor.absolute(163))));
        register(context, CHLORINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHLORINE_ORE_KEY), ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(64), VerticalAnchor.absolute(72))));
        register(context, ARGON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ARGON_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(39), VerticalAnchor.absolute(92))));
        register(context, POTASSIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.POTASSIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(36), VerticalAnchor.absolute(100))));
        register(context, CALCIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CALCIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(11, HeightRangePlacement.uniform(VerticalAnchor.absolute(28), VerticalAnchor.absolute(55))));
        register(context, SCANDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SCANDIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(45), VerticalAnchor.absolute(64))));
        register(context, TITANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TITANIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(88), VerticalAnchor.absolute(101))));
        register(context, VANADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.VANADIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(37), VerticalAnchor.absolute(79))));
        register(context, CHROMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CHROMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(25), VerticalAnchor.absolute(40))));
        register(context, MANGANESE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MANGANESE_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(60), VerticalAnchor.absolute(75))));
        register(context, COBALT_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COBALT_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(65), VerticalAnchor.absolute(136))));
        register(context, NICKEL_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NICKEL_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(27), VerticalAnchor.absolute(40))));
        register(context, ZINC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ZINC_ORE_KEY), ModOrePlacement.commonOrePlacement(22, HeightRangePlacement.uniform(VerticalAnchor.absolute(-8), VerticalAnchor.absolute(252))));
        register(context, GALLIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GALLIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.absolute(-42), VerticalAnchor.absolute(-16))));
        register(context, GERMANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GERMANIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(22), VerticalAnchor.absolute(47))));
        register(context, ARSENIC_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ARSENIC_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(66), VerticalAnchor.absolute(92))));
        register(context, SELENIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SELENIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(58), VerticalAnchor.absolute(77))));
        register(context, KRYPTON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.KRYPTON_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(94), VerticalAnchor.absolute(124))));
        register(context, RUBIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUBIDIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(11, HeightRangePlacement.uniform(VerticalAnchor.absolute(45), VerticalAnchor.absolute(66))));
        register(context, STRONTIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.STRONTIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-2), VerticalAnchor.absolute(16))));
        register(context, YTTRIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.YTTRIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(19), VerticalAnchor.absolute(46))));
        register(context, ZIRCONIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ZIRCONIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(52), VerticalAnchor.absolute(88))));
        register(context, NIOBIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NIOBIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(56), VerticalAnchor.absolute(95))));
        register(context, MOLYBDENUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOLYBDENUM_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(10), VerticalAnchor.absolute(49))));
        register(context, TECHNETIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TECHNETIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(27), VerticalAnchor.absolute(76))));
        register(context, RUTHENIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUTHENIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(45), VerticalAnchor.absolute(99))));
        register(context, RHODIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RHODIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(92), VerticalAnchor.absolute(118))));
        register(context, PALLADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PALLADIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(20), VerticalAnchor.absolute(40))));
        register(context, SILVER_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SILVER_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(65), VerticalAnchor.absolute(118))));
        register(context, CADMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CADMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(85), VerticalAnchor.absolute(106))));
        register(context, INDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.INDIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(11, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(8))));
        register(context, TIN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TIN_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-36), VerticalAnchor.absolute(-6))));
        register(context, ANTIMONY_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ANTIMONY_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(62), VerticalAnchor.absolute(93))));
        register(context, TELLURIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TELLURIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(27), VerticalAnchor.absolute(46))));
        register(context, IODINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.IODINE_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(41), VerticalAnchor.absolute(66))));
        register(context, XENON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.XENON_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(38), VerticalAnchor.absolute(69))));
        register(context, CAESIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CAESIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(16), VerticalAnchor.absolute(116))));
        register(context, BARIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BARIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(22), VerticalAnchor.absolute(52))));
        register(context, LANTHANUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LANTHANUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(46), VerticalAnchor.absolute(80))));
        register(context, CERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CERIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(24), VerticalAnchor.absolute(93))));
        register(context, PRASEODYMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PRASEODYMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(12), VerticalAnchor.absolute(38))));
        register(context, NEODYMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NEODYMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(49), VerticalAnchor.absolute(58))));
        register(context, PROMETHIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PROMETHIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(30), VerticalAnchor.absolute(41))));
        register(context, SAMARIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SAMARIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(14, HeightRangePlacement.uniform(VerticalAnchor.absolute(24), VerticalAnchor.absolute(72))));
        register(context, EUROPIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EUROPIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(34), VerticalAnchor.absolute(56))));
        register(context, GADOLINIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.GADOLINIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(73), VerticalAnchor.absolute(84))));
        register(context, TERBIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TERBIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(28), VerticalAnchor.absolute(46))));
        register(context, DYSPROSIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DYSPROSIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(15), VerticalAnchor.absolute(63))));
        register(context, HOLMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HOLMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(35), VerticalAnchor.absolute(72))));
        register(context, ERBIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ERBIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(11, HeightRangePlacement.uniform(VerticalAnchor.absolute(22), VerticalAnchor.absolute(24))));
        register(context, THULIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THULIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(53), VerticalAnchor.absolute(92))));
        register(context, YTTERBIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.YTTERBIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(82), VerticalAnchor.absolute(100))));
        register(context, LUTETIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LUTETIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(12, HeightRangePlacement.uniform(VerticalAnchor.absolute(42), VerticalAnchor.absolute(86))));
        register(context, HAFNIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HAFNIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(28), VerticalAnchor.absolute(69))));
        register(context, TANTALUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TANTALUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(67), VerticalAnchor.absolute(70))));
        register(context, TUNGSTEN_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TUNGSTEN_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(90), VerticalAnchor.absolute(96))));
        register(context, RHENIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RHENIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(77), VerticalAnchor.absolute(119))));
        register(context, OSMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OSMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(90), VerticalAnchor.absolute(101))));
        register(context, IRIDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.IRIDIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(28), VerticalAnchor.absolute(64))));
        register(context, PLATINUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLATINUM_ORE_KEY), ModOrePlacement.commonOrePlacement(19, HeightRangePlacement.uniform(VerticalAnchor.absolute(-12), VerticalAnchor.absolute(96))));
        register(context, THALLIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THALLIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-52), VerticalAnchor.absolute(-30))));
        register(context, LEAD_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LEAD_ORE_KEY), ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(-30), VerticalAnchor.absolute(-16))));
        register(context, BISMUTH_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BISMUTH_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-54), VerticalAnchor.absolute(-6))));
        register(context, POLONIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.POLONIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(46), VerticalAnchor.absolute(56))));
        register(context, ASTATINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ASTATINE_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(36), VerticalAnchor.absolute(71))));
        register(context, RADON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RADON_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(84), VerticalAnchor.absolute(90))));
        register(context, FRANCIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FRANCIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(88), VerticalAnchor.absolute(109))));
        register(context, RADIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RADIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(32), VerticalAnchor.absolute(44))));
        register(context, ACTINIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ACTINIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(13, HeightRangePlacement.uniform(VerticalAnchor.absolute(26), VerticalAnchor.absolute(88))));
        register(context, THORIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.THORIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(17), VerticalAnchor.absolute(24))));
        register(context, PROTACTINIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PROTACTINIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(27), VerticalAnchor.absolute(77))));
        register(context, URANIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.URANIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(16, HeightRangePlacement.uniform(VerticalAnchor.absolute(18), VerticalAnchor.absolute(43))));
        register(context, NEPTUNIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NEPTUNIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(22), VerticalAnchor.absolute(42))));
        register(context, PLUTONIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.PLUTONIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(34), VerticalAnchor.absolute(51))));
        register(context, AMERICIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.AMERICIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(16), VerticalAnchor.absolute(47))));
        register(context, CURIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CURIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(23), VerticalAnchor.absolute(40))));
        register(context, BERKELIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BERKELIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(25), VerticalAnchor.absolute(50))));
        register(context, CALIFORNIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.CALIFORNIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(14), VerticalAnchor.absolute(25))));
        register(context, EINSTEINIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.EINSTEINIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(16), VerticalAnchor.absolute(21))));
        register(context, FERMIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FERMIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(11, HeightRangePlacement.uniform(VerticalAnchor.absolute(43), VerticalAnchor.absolute(49))));
        register(context, MENDELEVIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MENDELEVIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(36), VerticalAnchor.absolute(48))));
        register(context, NOBELIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NOBELIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(11), VerticalAnchor.absolute(38))));
        register(context, LAWRENCIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LAWRENCIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(17), VerticalAnchor.absolute(48))));
        register(context, RUTHERFORDIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.RUTHERFORDIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-42), VerticalAnchor.absolute(-2))));
        register(context, DUBNIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DUBNIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(2, HeightRangePlacement.uniform(VerticalAnchor.absolute(-9), VerticalAnchor.absolute(-2))));
        register(context, SEABORGIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.SEABORGIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-39), VerticalAnchor.absolute(-12))));
        register(context, BOHRIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.BOHRIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(7, HeightRangePlacement.uniform(VerticalAnchor.absolute(-64), VerticalAnchor.absolute(-44))));
        register(context, HASSIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.HASSIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-49), VerticalAnchor.absolute(-19))));
        register(context, MEITNERIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MEITNERIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(8, HeightRangePlacement.uniform(VerticalAnchor.absolute(-22), VerticalAnchor.absolute(31))));
        register(context, DARMSTADTIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.DARMSTADTIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(11, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(-12))));
        register(context, ROENTGENIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.ROENTGENIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(4, HeightRangePlacement.uniform(VerticalAnchor.absolute(-50), VerticalAnchor.absolute(-32))));
        register(context, COPERNICIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.COPERNICIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(9, HeightRangePlacement.uniform(VerticalAnchor.absolute(-29), VerticalAnchor.absolute(-7))));
        register(context, NIHONIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.NIHONIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(-13))));
        register(context, FLEROVIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.FLEROVIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(6, HeightRangePlacement.uniform(VerticalAnchor.absolute(-16), VerticalAnchor.absolute(-9))));
        register(context, MOSCOVIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOSCOVIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(5, HeightRangePlacement.uniform(VerticalAnchor.absolute(-59), VerticalAnchor.absolute(-14))));
        register(context, LIVERMORIUM_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.LIVERMORIUM_ORE_KEY), ModOrePlacement.commonOrePlacement(10, HeightRangePlacement.uniform(VerticalAnchor.absolute(-56), VerticalAnchor.absolute(0))));
        register(context, TENNESSINE_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.TENNESSINE_ORE_KEY), ModOrePlacement.commonOrePlacement(3, HeightRangePlacement.uniform(VerticalAnchor.absolute(-1), VerticalAnchor.absolute(16))));
        register(context, OGANESSON_ORE_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.OGANESSON_ORE_KEY), ModOrePlacement.commonOrePlacement(15, HeightRangePlacement.uniform(VerticalAnchor.absolute(26), VerticalAnchor.absolute(38))));

        register(context, MOON_CRATERS_PLACED_KEY, configuredFeatures.getOrThrow(ModConfiguredFeatures.MOON_CRATERS_KEY),
                List.of(
                        CountPlacement.of(10),
                        InSquarePlacement.spread(),
                        PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                        BiomeFilter.biome()
                ));

        FlowerSpawnData.FLOWERS.forEach(definition ->
                register(context, definition.placedKey(), configuredFeatures.getOrThrow(definition.configuredKey()),
                        List.of(RarityFilter.onAverageOnceEvery(definition.rarity()),
                                InSquarePlacement.spread(),
                                PlacementUtils.HEIGHTMAP_WORLD_SURFACE,
                                HeightRangePlacement.uniform(VerticalAnchor.absolute(definition.minY()), VerticalAnchor.absolute(definition.maxY())),
                                BiomeFilter.biome())));
    }

    private static ResourceKey<PlacedFeature> registerKey(String name) {
        return ResourceKey.create(Registries.PLACED_FEATURE, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, name));
    }

    private static void register(BootstrapContext<PlacedFeature> context, ResourceKey<PlacedFeature> key, Holder<ConfiguredFeature<?, ?>> configuration,
                                 List<PlacementModifier> modifiers) {
        context.register(key, new PlacedFeature(configuration, List.copyOf(modifiers)));
    }
}
