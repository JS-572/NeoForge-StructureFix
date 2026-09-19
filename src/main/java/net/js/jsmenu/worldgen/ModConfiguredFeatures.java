package net.js.jsmenu.worldgen;

import net.js.jsmenu.JSMenu;
import net.js.jsmenu.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.data.worldgen.features.FeatureUtils;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.levelgen.feature.ConfiguredFeature;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.configurations.FeatureConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.OreConfiguration;
import net.minecraft.world.level.levelgen.feature.configurations.SimpleBlockConfiguration;
import net.minecraft.world.level.levelgen.feature.stateproviders.BlockStateProvider;
import net.minecraft.world.level.levelgen.structure.templatesystem.BlockMatchTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.RuleTest;
import net.minecraft.world.level.levelgen.structure.templatesystem.TagMatchTest;

import java.util.List;

public class ModConfiguredFeatures {
    public static final ResourceKey<ConfiguredFeature<?, ?>> HYDROGEN_ORE_KEY = registerKey("hydrogen_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LITHIUM_ORE_KEY = registerKey("lithium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BERYLLIUM_ORE_KEY = registerKey("beryllium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BORON_ORE_KEY = registerKey("boron_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CARBON_ORE_KEY = registerKey("carbon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NITROGEN_ORE_KEY = registerKey("nitrogen_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OXYGEN_ORE_KEY = registerKey("oxygen_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLUORINE_ORE_KEY = registerKey("fluorine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NEON_ORE_KEY = registerKey("neon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SODIUM_ORE_KEY = registerKey("sodium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MAGNESIUM_ORE_KEY = registerKey("magnesium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ALUMINUM_ORE_KEY = registerKey("aluminum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILICON_ORE_KEY = registerKey("silicon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PHOSPHORUS_ORE_KEY = registerKey("phosphorus_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SULFUR_ORE_KEY = registerKey("sulfur_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHLORINE_ORE_KEY = registerKey("chlorine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARGON_ORE_KEY = registerKey("argon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POTASSIUM_ORE_KEY = registerKey("potassium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALCIUM_ORE_KEY = registerKey("calcium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SCANDIUM_ORE_KEY = registerKey("scandium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TITANIUM_ORE_KEY = registerKey("titanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> VANADIUM_ORE_KEY = registerKey("vanadium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CHROMIUM_ORE_KEY = registerKey("chromium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MANGANESE_ORE_KEY = registerKey("manganese_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COBALT_ORE_KEY = registerKey("cobalt_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NICKEL_ORE_KEY = registerKey("nickel_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZINC_ORE_KEY = registerKey("zinc_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GALLIUM_ORE_KEY = registerKey("gallium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GERMANIUM_ORE_KEY = registerKey("germanium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ARSENIC_ORE_KEY = registerKey("arsenic_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SELENIUM_ORE_KEY = registerKey("selenium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> KRYPTON_ORE_KEY = registerKey("krypton_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUBIDIUM_ORE_KEY = registerKey("rubidium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> STRONTIUM_ORE_KEY = registerKey("strontium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YTTRIUM_ORE_KEY = registerKey("yttrium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ZIRCONIUM_ORE_KEY = registerKey("zirconium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIOBIUM_ORE_KEY = registerKey("niobium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOLYBDENUM_ORE_KEY = registerKey("molybdenum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TECHNETIUM_ORE_KEY = registerKey("technetium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUTHENIUM_ORE_KEY = registerKey("ruthenium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RHODIUM_ORE_KEY = registerKey("rhodium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PALLADIUM_ORE_KEY = registerKey("palladium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SILVER_ORE_KEY = registerKey("silver_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CADMIUM_ORE_KEY = registerKey("cadmium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> INDIUM_ORE_KEY = registerKey("indium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TIN_ORE_KEY = registerKey("tin_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ANTIMONY_ORE_KEY = registerKey("antimony_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TELLURIUM_ORE_KEY = registerKey("tellurium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IODINE_ORE_KEY = registerKey("iodine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> XENON_ORE_KEY = registerKey("xenon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CAESIUM_ORE_KEY = registerKey("caesium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BARIUM_ORE_KEY = registerKey("barium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LANTHANUM_ORE_KEY = registerKey("lanthanum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CERIUM_ORE_KEY = registerKey("cerium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PRASEODYMIUM_ORE_KEY = registerKey("praseodymium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NEODYMIUM_ORE_KEY = registerKey("neodymium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PROMETHIUM_ORE_KEY = registerKey("promethium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SAMARIUM_ORE_KEY = registerKey("samarium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EUROPIUM_ORE_KEY = registerKey("europium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> GADOLINIUM_ORE_KEY = registerKey("gadolinium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TERBIUM_ORE_KEY = registerKey("terbium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DYSPROSIUM_ORE_KEY = registerKey("dysprosium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HOLMIUM_ORE_KEY = registerKey("holmium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ERBIUM_ORE_KEY = registerKey("erbium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> THULIUM_ORE_KEY = registerKey("thulium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> YTTERBIUM_ORE_KEY = registerKey("ytterbium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LUTETIUM_ORE_KEY = registerKey("lutetium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HAFNIUM_ORE_KEY = registerKey("hafnium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TANTALUM_ORE_KEY = registerKey("tantalum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TUNGSTEN_ORE_KEY = registerKey("tungsten_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RHENIUM_ORE_KEY = registerKey("rhenium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OSMIUM_ORE_KEY = registerKey("osmium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> IRIDIUM_ORE_KEY = registerKey("iridium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLATINUM_ORE_KEY = registerKey("platinum_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> THALLIUM_ORE_KEY = registerKey("thallium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LEAD_ORE_KEY = registerKey("lead_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BISMUTH_ORE_KEY = registerKey("bismuth_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> POLONIUM_ORE_KEY = registerKey("polonium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ASTATINE_ORE_KEY = registerKey("astatine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RADON_ORE_KEY = registerKey("radon_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FRANCIUM_ORE_KEY = registerKey("francium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RADIUM_ORE_KEY = registerKey("radium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ACTINIUM_ORE_KEY = registerKey("actinium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> THORIUM_ORE_KEY = registerKey("thorium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PROTACTINIUM_ORE_KEY = registerKey("protactinium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> URANIUM_ORE_KEY = registerKey("uranium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NEPTUNIUM_ORE_KEY = registerKey("neptunium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> PLUTONIUM_ORE_KEY = registerKey("plutonium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> AMERICIUM_ORE_KEY = registerKey("americium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CURIUM_ORE_KEY = registerKey("curium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BERKELIUM_ORE_KEY = registerKey("berkelium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> CALIFORNIUM_ORE_KEY = registerKey("californium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> EINSTEINIUM_ORE_KEY = registerKey("einsteinium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FERMIUM_ORE_KEY = registerKey("fermium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MENDELEVIUM_ORE_KEY = registerKey("mendelevium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NOBELIUM_ORE_KEY = registerKey("nobelium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LAWRENCIUM_ORE_KEY = registerKey("lawrencium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> RUTHERFORDIUM_ORE_KEY = registerKey("rutherfordium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DUBNIUM_ORE_KEY = registerKey("dubnium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> SEABORGIUM_ORE_KEY = registerKey("seaborgium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> BOHRIUM_ORE_KEY = registerKey("bohrium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> HASSIUM_ORE_KEY = registerKey("hassium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MEITNERIUM_ORE_KEY = registerKey("meitnerium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> DARMSTADTIUM_ORE_KEY = registerKey("darmstadtium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> ROENTGENIUM_ORE_KEY = registerKey("roentgenium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> COPERNICIUM_ORE_KEY = registerKey("copernicium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> NIHONIUM_ORE_KEY = registerKey("nihonium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> FLEROVIUM_ORE_KEY = registerKey("flerovium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOSCOVIUM_ORE_KEY = registerKey("moscovium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> LIVERMORIUM_ORE_KEY = registerKey("livermorium_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> TENNESSINE_ORE_KEY = registerKey("tennessine_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> OGANESSON_ORE_KEY = registerKey("oganesson_ore");
    public static final ResourceKey<ConfiguredFeature<?, ?>> MOON_CRATERS_KEY = registerKey("moon_craters");

    public static void bootstrap(BootstrapContext<ConfiguredFeature<?, ?>> context) {

        RuleTest stoneReplaceables = new TagMatchTest(BlockTags.STONE_ORE_REPLACEABLES);
        RuleTest deepslateReplaceables = new TagMatchTest(BlockTags.DEEPSLATE_ORE_REPLACEABLES);
        RuleTest netherrackReplaceables = new BlockMatchTest(Blocks.NETHERRACK);
        RuleTest endReplaceables = new BlockMatchTest(Blocks.END_STONE);

        RuleTest graniteReplaceables = new BlockMatchTest(Blocks.GRANITE);
        RuleTest dioriteReplaceables = new BlockMatchTest(Blocks.DIORITE);
        RuleTest andesiteReplaceables = new BlockMatchTest(Blocks.ANDESITE);
        RuleTest tuffReplaceables = new BlockMatchTest(Blocks.TUFF);

        RuleTest oakleavesReplaceables = new BlockMatchTest(Blocks.OAK_LEAVES);
        RuleTest spruceleavesReplaceables = new BlockMatchTest(Blocks.SPRUCE_LEAVES);
        RuleTest birchleavesReplaceables = new BlockMatchTest(Blocks.BIRCH_LEAVES);
        RuleTest acacialeavesReplaceables = new BlockMatchTest(Blocks.ACACIA_LEAVES);
        RuleTest jungleleavesReplaceables = new BlockMatchTest(Blocks.JUNGLE_LEAVES);
        RuleTest darkoakleavesReplaceables = new BlockMatchTest(Blocks.DARK_OAK_LEAVES);
        RuleTest mangroveleavesReplaceables = new BlockMatchTest(Blocks.MANGROVE_LEAVES);
        RuleTest cherryleavesReplaceables = new BlockMatchTest(Blocks.CHERRY_LEAVES);

        List<OreConfiguration.TargetBlockState> overworldOres = List.of(
        OreConfiguration.target(stoneReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(oakleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(spruceleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(birchleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(jungleleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(acacialeavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(darkoakleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(mangroveleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(cherryleavesReplaceables, ModBlocks.HYDROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.LITHIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.BERYLLIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.BORON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.CARBON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.NITROGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.OXYGEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.FLUORINE_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.NEON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.SODIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.MAGNESIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.ALUMINUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.SILICON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.PHOSPHORUS_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.SULFUR_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.CHLORINE_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.ARGON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.POTASSIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.CALCIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.SCANDIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.TITANIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.VANADIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.CHROMIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.MANGANESE_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.COBALT_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.NICKEL_ORE.get().defaultBlockState()),
        OreConfiguration.target(graniteReplaceables, ModBlocks.ZINC_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.GALLIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.GERMANIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.ARSENIC_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.SELENIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.KRYPTON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.RUBIDIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.STRONTIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.YTTRIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.ZIRCONIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.NIOBIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.MOLYBDENUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.TECHNETIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.RUTHENIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.RHODIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.PALLADIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.SILVER_ORE.get().defaultBlockState()),
        OreConfiguration.target(dioriteReplaceables, ModBlocks.CADMIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.INDIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.TIN_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.ANTIMONY_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.TELLURIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.IODINE_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.XENON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.CAESIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.BARIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.HAFNIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.TANTALUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.TUNGSTEN_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.RHENIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.OSMIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.IRIDIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(andesiteReplaceables, ModBlocks.PLATINUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.THALLIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.LEAD_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.BISMUTH_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.POLONIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.ASTATINE_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.RADON_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.FRANCIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.RADIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.RUTHERFORDIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.DUBNIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.SEABORGIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.BOHRIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.HASSIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.MEITNERIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.DARMSTADTIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.ROENTGENIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(tuffReplaceables, ModBlocks.COPERNICIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.NIHONIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.FLEROVIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.MOSCOVIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(deepslateReplaceables, ModBlocks.LIVERMORIUM_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.TENNESSINE_ORE.get().defaultBlockState()),
        OreConfiguration.target(stoneReplaceables, ModBlocks.OGANESSON_ORE.get().defaultBlockState()));

        register(context, HYDROGEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 12));
        register(context, LITHIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, BERYLLIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, BORON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, CARBON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, NITROGEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, OXYGEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, FLUORINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, NEON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, SODIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, MAGNESIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 7));
        register(context, ALUMINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 7));
        register(context, SILICON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, PHOSPHORUS_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 3));
        register(context, SULFUR_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 7));
        register(context, CHLORINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, ARGON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, POTASSIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, CALCIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 11));
        register(context, SCANDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, TITANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, VANADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, CHROMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, MANGANESE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 7));
        register(context, COBALT_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, NICKEL_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, ZINC_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 12));
        register(context, GALLIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 9));
        register(context, GERMANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, ARSENIC_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, SELENIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 1));
        register(context, KRYPTON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, RUBIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, STRONTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, YTTRIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, ZIRCONIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, NIOBIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, MOLYBDENUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, TECHNETIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, RUTHENIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, RHODIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 3));
        register(context, PALLADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, SILVER_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, CADMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, INDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, TIN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, ANTIMONY_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 9));
        register(context, TELLURIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, IODINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, XENON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 9));
        register(context, CAESIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, BARIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, LANTHANUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.LANTHANUM_ORE.get().defaultBlockState(), 5));
        register(context, CERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.CERIUM_ORE.get().defaultBlockState(), 8));
        register(context, PRASEODYMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.PRASEODYMIUM_ORE.get().defaultBlockState(), 4));
        register(context, NEODYMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.NEODYMIUM_ORE.get().defaultBlockState(), 4));
        register(context, PROMETHIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.PROMETHIUM_ORE.get().defaultBlockState(), 5));
        register(context, SAMARIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.SAMARIUM_ORE.get().defaultBlockState(), 2));
        register(context, EUROPIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.EUROPIUM_ORE.get().defaultBlockState(), 5));
        register(context, GADOLINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.GADOLINIUM_ORE.get().defaultBlockState(), 7));
        register(context, TERBIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.TERBIUM_ORE.get().defaultBlockState(), 5));
        register(context, DYSPROSIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.DYSPROSIUM_ORE.get().defaultBlockState(), 2));
        register(context, HOLMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.HOLMIUM_ORE.get().defaultBlockState(), 5));
        register(context, ERBIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.ERBIUM_ORE.get().defaultBlockState(), 3));
        register(context, THULIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.THULIUM_ORE.get().defaultBlockState(), 4));
        register(context, YTTERBIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.YTTERBIUM_ORE.get().defaultBlockState(), 5));
        register(context, LUTETIUM_ORE_KEY, Feature.ORE, new OreConfiguration(netherrackReplaceables, ModBlocks.LUTETIUM_ORE.get().defaultBlockState(), 8));
        register(context, HAFNIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 9));
        register(context, TANTALUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, TUNGSTEN_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 11));
        register(context, RHENIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, OSMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, IRIDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, PLATINUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 12));
        register(context, THALLIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, LEAD_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, BISMUTH_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, POLONIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, ASTATINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 6));
        register(context, RADON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 7));
        register(context, FRANCIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 3));
        register(context, RADIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, ACTINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.ACTINIUM_ORE.get().defaultBlockState(), 4));
        register(context, THORIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.THORIUM_ORE.get().defaultBlockState(), 5));
        register(context, PROTACTINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.PROTACTINIUM_ORE.get().defaultBlockState(), 4));
        register(context, URANIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.URANIUM_ORE.get().defaultBlockState(), 6));
        register(context, NEPTUNIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.NEPTUNIUM_ORE.get().defaultBlockState(), 3));
        register(context, PLUTONIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.PLUTONIUM_ORE.get().defaultBlockState(), 5));
        register(context, AMERICIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.AMERICIUM_ORE.get().defaultBlockState(), 2));
        register(context, CURIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.CURIUM_ORE.get().defaultBlockState(), 4));
        register(context, BERKELIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.BERKELIUM_ORE.get().defaultBlockState(), 5));
        register(context, CALIFORNIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.CALIFORNIUM_ORE.get().defaultBlockState(), 1));
        register(context, EINSTEINIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.EINSTEINIUM_ORE.get().defaultBlockState(), 3));
        register(context, FERMIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.FERMIUM_ORE.get().defaultBlockState(), 4));
        register(context, MENDELEVIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.MENDELEVIUM_ORE.get().defaultBlockState(), 2));
        register(context, NOBELIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.NOBELIUM_ORE.get().defaultBlockState(), 8));
        register(context, LAWRENCIUM_ORE_KEY, Feature.ORE, new OreConfiguration(endReplaceables, ModBlocks.LAWRENCIUM_ORE.get().defaultBlockState(), 2));
        register(context, RUTHERFORDIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 10));
        register(context, DUBNIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, SEABORGIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, BOHRIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 8));
        register(context, HASSIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 1));
        register(context, MEITNERIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, DARMSTADTIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, ROENTGENIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 1));
        register(context, COPERNICIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, NIHONIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 1));
        register(context, FLEROVIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 1));
        register(context, MOSCOVIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 2));
        register(context, LIVERMORIUM_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 4));
        register(context, TENNESSINE_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 5));
        register(context, OGANESSON_ORE_KEY, Feature.ORE, new OreConfiguration(overworldOres, 3));

        register(context, MOON_CRATERS_KEY, Feature.RANDOM_PATCH,
                FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                        new SimpleBlockConfiguration(BlockStateProvider.simple(Blocks.CAVE_AIR.defaultBlockState())),
                        List.of(Blocks.END_STONE)));

        FlowerSpawnData.FLOWERS.forEach(definition ->
                register(context, definition.configuredKey(), Feature.RANDOM_PATCH,
                        FeatureUtils.simplePatchConfiguration(Feature.SIMPLE_BLOCK,
                                new SimpleBlockConfiguration(BlockStateProvider.simple(definition.block().get().defaultBlockState())),
                                List.of(Blocks.GRASS_BLOCK))));
    }


    public static ResourceKey<ConfiguredFeature<?, ?>> registerKey(String name) {
        return ResourceKey.create(Registries.CONFIGURED_FEATURE, ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, name));
    }

    private static <FC extends FeatureConfiguration, F extends Feature<FC>> void register(BootstrapContext<ConfiguredFeature<?, ?>> context,
                                                                                          ResourceKey<ConfiguredFeature<?, ?>> key, F feature, FC configuration) {
        context.register(key, new ConfiguredFeature<>(feature, configuration));
    }

}
