package net.js.jsmenu.item.custom;

import net.js.jsmenu.block.ModBlocks;
import net.js.jsmenu.block.StarBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.util.RandomSource;

import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

import static java.util.Map.entry;

public class OreTurnerItem extends Item {
    public static final List<Supplier<? extends Block>> STONE_ORES = List.of(
            () -> Blocks.COAL_ORE,
            () -> Blocks.COPPER_ORE,
            () -> Blocks.IRON_ORE,
            () -> Blocks.GOLD_ORE,
            () -> Blocks.LAPIS_ORE,
            () -> Blocks.REDSTONE_ORE,
            () -> Blocks.EMERALD_ORE,
            () -> Blocks.DIAMOND_ORE,
            ModBlocks.HYDROGEN_ORE,
            ModBlocks.LITHIUM_ORE,
            ModBlocks.BERYLLIUM_ORE,
            ModBlocks.BORON_ORE,
            ModBlocks.CARBON_ORE,
            ModBlocks.NITROGEN_ORE,
            ModBlocks.OXYGEN_ORE,
            ModBlocks.FLUORINE_ORE,
            ModBlocks.NEON_ORE,
            ModBlocks.SODIUM_ORE,
            ModBlocks.MAGNESIUM_ORE,
            ModBlocks.SILICON_ORE,
            ModBlocks.PHOSPHORUS_ORE,
            ModBlocks.SULFUR_ORE,
            ModBlocks.CHLORINE_ORE,
            ModBlocks.ARGON_ORE,
            ModBlocks.POTASSIUM_ORE,
            ModBlocks.CALCIUM_ORE,
            ModBlocks.GERMANIUM_ORE,
            ModBlocks.ARSENIC_ORE,
            ModBlocks.SELENIUM_ORE,
            ModBlocks.KRYPTON_ORE,
            ModBlocks.RUBIDIUM_ORE,
            ModBlocks.STRONTIUM_ORE,
            ModBlocks.ANTIMONY_ORE,
            ModBlocks.TELLURIUM_ORE,
            ModBlocks.IODINE_ORE,
            ModBlocks.XENON_ORE,
            ModBlocks.CAESIUM_ORE,
            ModBlocks.BARIUM_ORE,
            ModBlocks.POLONIUM_ORE,
            ModBlocks.ASTATINE_ORE,
            ModBlocks.RADON_ORE,
            ModBlocks.FRANCIUM_ORE,
            ModBlocks.RADIUM_ORE,
            ModBlocks.TENNESSINE_ORE,
            ModBlocks.OGANESSON_ORE
    );

    public static final List<Supplier<? extends Block>> DEEPSLATE_ORES = List.of(
            () -> Blocks.DEEPSLATE_COAL_ORE,
            () -> Blocks.DEEPSLATE_COPPER_ORE,
            () -> Blocks.DEEPSLATE_IRON_ORE,
            () -> Blocks.DEEPSLATE_GOLD_ORE,
            () -> Blocks.DEEPSLATE_LAPIS_ORE,
            () -> Blocks.DEEPSLATE_REDSTONE_ORE,
            () -> Blocks.DEEPSLATE_EMERALD_ORE,
            () -> Blocks.DEEPSLATE_DIAMOND_ORE,
            ModBlocks.ALUMINUM_ORE,
            ModBlocks.GALLIUM_ORE,
            ModBlocks.INDIUM_ORE,
            ModBlocks.TIN_ORE,
            ModBlocks.THALLIUM_ORE,
            ModBlocks.LEAD_ORE,
            ModBlocks.BISMUTH_ORE,
            ModBlocks.NIHONIUM_ORE,
            ModBlocks.FLEROVIUM_ORE,
            ModBlocks.MOSCOVIUM_ORE,
            ModBlocks.LIVERMORIUM_ORE
    );

    public static final List<Supplier<? extends Block>> NETHER_ORES = List.of(
            () -> Blocks.NETHER_QUARTZ_ORE,
            () -> Blocks.NETHER_GOLD_ORE,
            () -> Blocks.ANCIENT_DEBRIS,
            ModBlocks.LANTHANUM_ORE,
            ModBlocks.CERIUM_ORE,
            ModBlocks.PRASEODYMIUM_ORE,
            ModBlocks.NEODYMIUM_ORE,
            ModBlocks.PROMETHIUM_ORE,
            ModBlocks.SAMARIUM_ORE,
            ModBlocks.EUROPIUM_ORE,
            ModBlocks.GADOLINIUM_ORE,
            ModBlocks.TERBIUM_ORE,
            ModBlocks.DYSPROSIUM_ORE,
            ModBlocks.HOLMIUM_ORE,
            ModBlocks.ERBIUM_ORE,
            ModBlocks.THULIUM_ORE,
            ModBlocks.YTTERBIUM_ORE,
            ModBlocks.LUTETIUM_ORE
    );

    private static final List<Supplier<? extends Block>> END_ORES = List.of(
            ModBlocks.ACTINIUM_ORE,
            ModBlocks.THORIUM_ORE,
            ModBlocks.PROTACTINIUM_ORE,
            ModBlocks.URANIUM_ORE,
            ModBlocks.NEPTUNIUM_ORE,
            ModBlocks.PLUTONIUM_ORE,
            ModBlocks.AMERICIUM_ORE,
            ModBlocks.CURIUM_ORE,
            ModBlocks.BERKELIUM_ORE,
            ModBlocks.CALIFORNIUM_ORE,
            ModBlocks.EINSTEINIUM_ORE,
            ModBlocks.FERMIUM_ORE,
            ModBlocks.MENDELEVIUM_ORE,
            ModBlocks.NOBELIUM_ORE,
            ModBlocks.LAWRENCIUM_ORE
    );

    public static final List<Supplier<? extends Block>> GRANITE_ORES = List.of(
            ModBlocks.SCANDIUM_ORE,
            ModBlocks.TITANIUM_ORE,
            ModBlocks.VANADIUM_ORE,
            ModBlocks.CHROMIUM_ORE,
            ModBlocks.MANGANESE_ORE,
            ModBlocks.COBALT_ORE,
            ModBlocks.NICKEL_ORE,
            ModBlocks.ZINC_ORE
    );

    public static final List<Supplier<? extends Block>> DIORITE_ORES = List.of(
            ModBlocks.YTTRIUM_ORE,
            ModBlocks.ZIRCONIUM_ORE,
            ModBlocks.NIOBIUM_ORE,
            ModBlocks.MOLYBDENUM_ORE,
            ModBlocks.TECHNETIUM_ORE,
            ModBlocks.RUTHENIUM_ORE,
            ModBlocks.RHODIUM_ORE,
            ModBlocks.PALLADIUM_ORE,
            ModBlocks.SILVER_ORE,
            ModBlocks.CADMIUM_ORE
    );

    public static final List<Supplier<? extends Block>> ANDESITE_ORES = List.of(
            ModBlocks.HAFNIUM_ORE,
            ModBlocks.TANTALUM_ORE,
            ModBlocks.TUNGSTEN_ORE,
            ModBlocks.RHENIUM_ORE,
            ModBlocks.OSMIUM_ORE,
            ModBlocks.IRIDIUM_ORE,
            ModBlocks.PLATINUM_ORE
    );

    public static final List<Supplier<? extends Block>> TUFF_ORES = List.of(
            ModBlocks.RUTHERFORDIUM_ORE,
            ModBlocks.DUBNIUM_ORE,
            ModBlocks.SEABORGIUM_ORE,
            ModBlocks.BOHRIUM_ORE,
            ModBlocks.HASSIUM_ORE,
            ModBlocks.MEITNERIUM_ORE,
            ModBlocks.DARMSTADTIUM_ORE,
            ModBlocks.ROENTGENIUM_ORE,
            ModBlocks.COPERNICIUM_ORE
    );

    public static final List<Supplier<? extends Block>> SUN_ORES = List.of(
            StarBlocks.BLAZESTONE_ORE,
            StarBlocks.RADIANT_CRYSTAL_ORE,
            StarBlocks.SOLARITE_ORE
    );

    public static final List<Supplier<? extends Block>> SUN_DEEPSLATE_ORES = List.of(
            StarBlocks.CORE_FRAGMENT_ORE
    );

    public static final List<Supplier<? extends Block>> MOON_ORES = List.of(
            ModBlocks.CRISRA_ORE,
            ModBlocks.GRADIENT_ORE,
            ModBlocks.LUNAR_ORE
    );

    public static final List<Supplier<? extends Block>> MOON_DEEPSLATE_ORES = List.of(
            ModBlocks.BRAGSTONE_ORE
    );

    public static final Map<Block, Block> ORE_TURNER_MAP = Map.ofEntries(
            entry(Blocks.COAL_ORE, Blocks.COAL_BLOCK),
            entry(Blocks.COPPER_ORE, Blocks.COPPER_BLOCK),
            entry(Blocks.IRON_ORE, Blocks.IRON_BLOCK),
            entry(Blocks.GOLD_ORE, Blocks.GOLD_BLOCK),
            entry(Blocks.LAPIS_ORE, Blocks.LAPIS_BLOCK),
            entry(Blocks.REDSTONE_ORE, Blocks.REDSTONE_BLOCK),
            entry(Blocks.EMERALD_ORE, Blocks.EMERALD_BLOCK),
            entry(Blocks.DIAMOND_ORE, Blocks.DIAMOND_BLOCK),
            entry(Blocks.DEEPSLATE_COAL_ORE, Blocks.COAL_BLOCK),
            entry(Blocks.DEEPSLATE_COPPER_ORE, Blocks.COPPER_BLOCK),
            entry(Blocks.DEEPSLATE_IRON_ORE, Blocks.IRON_BLOCK),
            entry(Blocks.DEEPSLATE_GOLD_ORE, Blocks.GOLD_BLOCK),
            entry(Blocks.DEEPSLATE_LAPIS_ORE, Blocks.LAPIS_BLOCK),
            entry(Blocks.DEEPSLATE_REDSTONE_ORE, Blocks.REDSTONE_BLOCK),
            entry(Blocks.DEEPSLATE_EMERALD_ORE, Blocks.EMERALD_BLOCK),
            entry(Blocks.DEEPSLATE_DIAMOND_ORE, Blocks.DIAMOND_BLOCK),
            entry(Blocks.NETHER_QUARTZ_ORE, Blocks.QUARTZ_BLOCK),
            entry(Blocks.NETHER_GOLD_ORE, Blocks.GOLD_BLOCK),
            entry(Blocks.ANCIENT_DEBRIS, Blocks.NETHERITE_BLOCK),
            entry(ModBlocks.HYDROGEN_ORE.get(), ModBlocks.HYDROGEN_BLOCK.get()),
            entry(ModBlocks.LITHIUM_ORE.get(), ModBlocks.LITHIUM_BLOCK.get()),
            entry(ModBlocks.BERYLLIUM_ORE.get(), ModBlocks.BERYLLIUM_BLOCK.get()),
            entry(ModBlocks.BORON_ORE.get(), ModBlocks.BORON_BLOCK.get()),
            entry(ModBlocks.CARBON_ORE.get(), ModBlocks.CARBON_BLOCK.get()),
            entry(ModBlocks.NITROGEN_ORE.get(), ModBlocks.NITROGEN_BLOCK.get()),
            entry(ModBlocks.OXYGEN_ORE.get(), ModBlocks.OXYGEN_BLOCK.get()),
            entry(ModBlocks.FLUORINE_ORE.get(), ModBlocks.FLUORINE_BLOCK.get()),
            entry(ModBlocks.NEON_ORE.get(), ModBlocks.NEON_BLOCK.get()),
            entry(ModBlocks.SODIUM_ORE.get(), ModBlocks.SODIUM_BLOCK.get()),
            entry(ModBlocks.MAGNESIUM_ORE.get(), ModBlocks.MAGNESIUM_BLOCK.get()),
            entry(ModBlocks.ALUMINUM_ORE.get(), ModBlocks.ALUMINUM_BLOCK.get()),
            entry(ModBlocks.SILICON_ORE.get(), ModBlocks.SILICON_BLOCK.get()),
            entry(ModBlocks.PHOSPHORUS_ORE.get(), ModBlocks.PHOSPHORUS_BLOCK.get()),
            entry(ModBlocks.SULFUR_ORE.get(), ModBlocks.SULFUR_BLOCK.get()),
            entry(ModBlocks.CHLORINE_ORE.get(), ModBlocks.CHLORINE_BLOCK.get()),
            entry(ModBlocks.ARGON_ORE.get(), ModBlocks.ARGON_BLOCK.get()),
            entry(ModBlocks.POTASSIUM_ORE.get(), ModBlocks.POTASSIUM_BLOCK.get()),
            entry(ModBlocks.CALCIUM_ORE.get(), ModBlocks.CALCIUM_BLOCK.get()),
            entry(ModBlocks.SCANDIUM_ORE.get(), ModBlocks.SCANDIUM_BLOCK.get()),
            entry(ModBlocks.TITANIUM_ORE.get(), ModBlocks.TITANIUM_BLOCK.get()),
            entry(ModBlocks.VANADIUM_ORE.get(), ModBlocks.VANADIUM_BLOCK.get()),
            entry(ModBlocks.CHROMIUM_ORE.get(), ModBlocks.CHROMIUM_BLOCK.get()),
            entry(ModBlocks.MANGANESE_ORE.get(), ModBlocks.MANGANESE_BLOCK.get()),
            entry(ModBlocks.COBALT_ORE.get(), ModBlocks.COBALT_BLOCK.get()),
            entry(ModBlocks.NICKEL_ORE.get(), ModBlocks.NICKEL_BLOCK.get()),
            entry(ModBlocks.ZINC_ORE.get(), ModBlocks.ZINC_BLOCK.get()),
            entry(ModBlocks.GALLIUM_ORE.get(), ModBlocks.GALLIUM_BLOCK.get()),
            entry(ModBlocks.GERMANIUM_ORE.get(), ModBlocks.GERMANIUM_BLOCK.get()),
            entry(ModBlocks.ARSENIC_ORE.get(), ModBlocks.ARSENIC_BLOCK.get()),
            entry(ModBlocks.SELENIUM_ORE.get(), ModBlocks.SELENIUM_BLOCK.get()),
            entry(ModBlocks.KRYPTON_ORE.get(), ModBlocks.KRYPTON_BLOCK.get()),
            entry(ModBlocks.RUBIDIUM_ORE.get(), ModBlocks.RUBIDIUM_BLOCK.get()),
            entry(ModBlocks.STRONTIUM_ORE.get(), ModBlocks.STRONTIUM_BLOCK.get()),
            entry(ModBlocks.YTTRIUM_ORE.get(), ModBlocks.YTTRIUM_BLOCK.get()),
            entry(ModBlocks.ZIRCONIUM_ORE.get(), ModBlocks.ZIRCONIUM_BLOCK.get()),
            entry(ModBlocks.NIOBIUM_ORE.get(), ModBlocks.NIOBIUM_BLOCK.get()),
            entry(ModBlocks.MOLYBDENUM_ORE.get(), ModBlocks.MOLYBDENUM_BLOCK.get()),
            entry(ModBlocks.TECHNETIUM_ORE.get(), ModBlocks.TECHNETIUM_BLOCK.get()),
            entry(ModBlocks.RUTHENIUM_ORE.get(), ModBlocks.RUTHENIUM_BLOCK.get()),
            entry(ModBlocks.RHODIUM_ORE.get(), ModBlocks.RHODIUM_BLOCK.get()),
            entry(ModBlocks.PALLADIUM_ORE.get(), ModBlocks.PALLADIUM_BLOCK.get()),
            entry(ModBlocks.SILVER_ORE.get(), ModBlocks.SILVER_BLOCK.get()),
            entry(ModBlocks.CADMIUM_ORE.get(), ModBlocks.CADMIUM_BLOCK.get()),
            entry(ModBlocks.INDIUM_ORE.get(), ModBlocks.INDIUM_BLOCK.get()),
            entry(ModBlocks.TIN_ORE.get(), ModBlocks.TIN_BLOCK.get()),
            entry(ModBlocks.ANTIMONY_ORE.get(), ModBlocks.ANTIMONY_BLOCK.get()),
            entry(ModBlocks.TELLURIUM_ORE.get(), ModBlocks.TELLURIUM_BLOCK.get()),
            entry(ModBlocks.IODINE_ORE.get(), ModBlocks.IODINE_BLOCK.get()),
            entry(ModBlocks.XENON_ORE.get(), ModBlocks.XENON_BLOCK.get()),
            entry(ModBlocks.CAESIUM_ORE.get(), ModBlocks.CAESIUM_BLOCK.get()),
            entry(ModBlocks.BARIUM_ORE.get(), ModBlocks.BARIUM_BLOCK.get()),
            entry(ModBlocks.LANTHANUM_ORE.get(), ModBlocks.LANTHANUM_BLOCK.get()),
            entry(ModBlocks.CERIUM_ORE.get(), ModBlocks.CERIUM_BLOCK.get()),
            entry(ModBlocks.PRASEODYMIUM_ORE.get(), ModBlocks.PRASEODYMIUM_BLOCK.get()),
            entry(ModBlocks.NEODYMIUM_ORE.get(), ModBlocks.NEODYMIUM_BLOCK.get()),
            entry(ModBlocks.PROMETHIUM_ORE.get(), ModBlocks.PROMETHIUM_BLOCK.get()),
            entry(ModBlocks.SAMARIUM_ORE.get(), ModBlocks.SAMARIUM_BLOCK.get()),
            entry(ModBlocks.EUROPIUM_ORE.get(), ModBlocks.EUROPIUM_BLOCK.get()),
            entry(ModBlocks.GADOLINIUM_ORE.get(), ModBlocks.GADOLINIUM_BLOCK.get()),
            entry(ModBlocks.TERBIUM_ORE.get(), ModBlocks.TERBIUM_BLOCK.get()),
            entry(ModBlocks.DYSPROSIUM_ORE.get(), ModBlocks.DYSPROSIUM_BLOCK.get()),
            entry(ModBlocks.HOLMIUM_ORE.get(), ModBlocks.HOLMIUM_BLOCK.get()),
            entry(ModBlocks.ERBIUM_ORE.get(), ModBlocks.ERBIUM_BLOCK.get()),
            entry(ModBlocks.THULIUM_ORE.get(), ModBlocks.THULIUM_BLOCK.get()),
            entry(ModBlocks.YTTERBIUM_ORE.get(), ModBlocks.YTTERBIUM_BLOCK.get()),
            entry(ModBlocks.LUTETIUM_ORE.get(), ModBlocks.LUTETIUM_BLOCK.get()),
            entry(ModBlocks.HAFNIUM_ORE.get(), ModBlocks.HAFNIUM_BLOCK.get()),
            entry(ModBlocks.TANTALUM_ORE.get(), ModBlocks.TANTALUM_BLOCK.get()),
            entry(ModBlocks.TUNGSTEN_ORE.get(), ModBlocks.TUNGSTEN_BLOCK.get()),
            entry(ModBlocks.RHENIUM_ORE.get(), ModBlocks.RHENIUM_BLOCK.get()),
            entry(ModBlocks.OSMIUM_ORE.get(), ModBlocks.OSMIUM_BLOCK.get()),
            entry(ModBlocks.IRIDIUM_ORE.get(), ModBlocks.IRIDIUM_BLOCK.get()),
            entry(ModBlocks.PLATINUM_ORE.get(), ModBlocks.PLATINUM_BLOCK.get()),
            entry(ModBlocks.THALLIUM_ORE.get(), ModBlocks.THALLIUM_BLOCK.get()),
            entry(ModBlocks.LEAD_ORE.get(), ModBlocks.LEAD_BLOCK.get()),
            entry(ModBlocks.BISMUTH_ORE.get(), ModBlocks.BISMUTH_BLOCK.get()),
            entry(ModBlocks.POLONIUM_ORE.get(), ModBlocks.POLONIUM_BLOCK.get()),
            entry(ModBlocks.ASTATINE_ORE.get(), ModBlocks.ASTATINE_BLOCK.get()),
            entry(ModBlocks.RADON_ORE.get(), ModBlocks.RADON_BLOCK.get()),
            entry(ModBlocks.FRANCIUM_ORE.get(), ModBlocks.FRANCIUM_BLOCK.get()),
            entry(ModBlocks.RADIUM_ORE.get(), ModBlocks.RADIUM_BLOCK.get()),
            entry(ModBlocks.ACTINIUM_ORE.get(), ModBlocks.ACTINIUM_BLOCK.get()),
            entry(ModBlocks.THORIUM_ORE.get(), ModBlocks.THORIUM_BLOCK.get()),
            entry(ModBlocks.PROTACTINIUM_ORE.get(), ModBlocks.PROTACTINIUM_BLOCK.get()),
            entry(ModBlocks.URANIUM_ORE.get(), ModBlocks.URANIUM_BLOCK.get()),
            entry(ModBlocks.NEPTUNIUM_ORE.get(), ModBlocks.NEPTUNIUM_BLOCK.get()),
            entry(ModBlocks.PLUTONIUM_ORE.get(), ModBlocks.PLUTONIUM_BLOCK.get()),
            entry(ModBlocks.AMERICIUM_ORE.get(), ModBlocks.AMERICIUM_BLOCK.get()),
            entry(ModBlocks.CURIUM_ORE.get(), ModBlocks.CURIUM_BLOCK.get()),
            entry(ModBlocks.BERKELIUM_ORE.get(), ModBlocks.BERKELIUM_BLOCK.get()),
            entry(ModBlocks.CALIFORNIUM_ORE.get(), ModBlocks.CALIFORNIUM_BLOCK.get()),
            entry(ModBlocks.EINSTEINIUM_ORE.get(), ModBlocks.EINSTEINIUM_BLOCK.get()),
            entry(ModBlocks.FERMIUM_ORE.get(), ModBlocks.FERMIUM_BLOCK.get()),
            entry(ModBlocks.MENDELEVIUM_ORE.get(), ModBlocks.MENDELEVIUM_BLOCK.get()),
            entry(ModBlocks.NOBELIUM_ORE.get(), ModBlocks.NOBELIUM_BLOCK.get()),
            entry(ModBlocks.LAWRENCIUM_ORE.get(), ModBlocks.LAWRENCIUM_BLOCK.get()),
            entry(ModBlocks.RUTHERFORDIUM_ORE.get(), ModBlocks.RUTHERFORDIUM_BLOCK.get()),
            entry(ModBlocks.DUBNIUM_ORE.get(), ModBlocks.DUBNIUM_BLOCK.get()),
            entry(ModBlocks.SEABORGIUM_ORE.get(), ModBlocks.SEABORGIUM_BLOCK.get()),
            entry(ModBlocks.BOHRIUM_ORE.get(), ModBlocks.BOHRIUM_BLOCK.get()),
            entry(ModBlocks.HASSIUM_ORE.get(), ModBlocks.HASSIUM_BLOCK.get()),
            entry(ModBlocks.MEITNERIUM_ORE.get(), ModBlocks.MEITNERIUM_BLOCK.get()),
            entry(ModBlocks.DARMSTADTIUM_ORE.get(), ModBlocks.DARMSTADTIUM_BLOCK.get()),
            entry(ModBlocks.ROENTGENIUM_ORE.get(), ModBlocks.ROENTGENIUM_BLOCK.get()),
            entry(ModBlocks.COPERNICIUM_ORE.get(), ModBlocks.COPERNICIUM_BLOCK.get()),
            entry(ModBlocks.NIHONIUM_ORE.get(), ModBlocks.NIHONIUM_BLOCK.get()),
            entry(ModBlocks.FLEROVIUM_ORE.get(), ModBlocks.FLEROVIUM_BLOCK.get()),
            entry(ModBlocks.MOSCOVIUM_ORE.get(), ModBlocks.MOSCOVIUM_BLOCK.get()),
            entry(ModBlocks.LIVERMORIUM_ORE.get(), ModBlocks.LIVERMORIUM_BLOCK.get()),
            entry(ModBlocks.TENNESSINE_ORE.get(), ModBlocks.TENNESSINE_BLOCK.get()),
            entry(ModBlocks.OGANESSON_ORE.get(), ModBlocks.OGANESSON_BLOCK.get()),
            entry(StarBlocks.BLAZESTONE_ORE.get(), StarBlocks.BLAZESTONE_BLOCK.get()),
            entry(StarBlocks.CORE_FRAGMENT_ORE.get(), StarBlocks.CORE_FRAGMENT_BLOCK.get()),
            entry(StarBlocks.SOLARITE_ORE.get(), StarBlocks.SOLARITE_BLOCK.get()),
            entry(StarBlocks.RADIANT_CRYSTAL_ORE.get(), StarBlocks.RADIANT_CRYSTAL_BLOCK.get()),
            entry(ModBlocks.CRISRA_ORE.get(), ModBlocks.CRISRA_BLOCK.get()),
            entry(ModBlocks.BRAGSTONE_ORE.get(), ModBlocks.BRAGSTONE_BLOCK.get()),
            entry(ModBlocks.LUNAR_ORE.get(), ModBlocks.LUNAR_BLOCK.get()),
            entry(ModBlocks.GRADIENT_ORE.get(), ModBlocks.GRADIENT_BLOCK.get())
    );

    public OreTurnerItem(Properties properties) {
        super(properties);
    }
    @Override
    public InteractionResult useOn(UseOnContext context) {
        Level level = context.getLevel();
        if (level.isClientSide()) return InteractionResult.SUCCESS;

        BlockPos pos = context.getClickedPos();
        Block clickedBlock = level.getBlockState(pos).getBlock();
        RandomSource random = level.getRandom();
        Block newBlock = null;

        if (ORE_TURNER_MAP.containsKey(clickedBlock)) {
            newBlock = ORE_TURNER_MAP.get(clickedBlock);
        }
        else if (clickedBlock == Blocks.STONE) {
            newBlock = STONE_ORES.get(random.nextInt(STONE_ORES.size())).get();
        } else if (clickedBlock == Blocks.DEEPSLATE) {
            newBlock = DEEPSLATE_ORES.get(random.nextInt(DEEPSLATE_ORES.size())).get();
        } else if (clickedBlock == Blocks.NETHERRACK) {
            newBlock = NETHER_ORES.get(random.nextInt(NETHER_ORES.size())).get();
        } else if (clickedBlock == Blocks.END_STONE) {
            newBlock = END_ORES.get(random.nextInt(END_ORES.size())).get();
        } else if (clickedBlock == Blocks.GRANITE) {
            newBlock = GRANITE_ORES.get(random.nextInt(GRANITE_ORES.size())).get();
        } else if (clickedBlock == Blocks.DIORITE) {
            newBlock = DIORITE_ORES.get(random.nextInt(DIORITE_ORES.size())).get();
        } else if (clickedBlock == Blocks.ANDESITE) {
            newBlock = ANDESITE_ORES.get(random.nextInt(ANDESITE_ORES.size())).get();
        } else if (clickedBlock == Blocks.TUFF) {
            newBlock = TUFF_ORES.get(random.nextInt(TUFF_ORES.size())).get();
        } else if (clickedBlock == StarBlocks.SOLAR_STONE.get()) {
            newBlock = SUN_ORES.get(random.nextInt(SUN_ORES.size())).get();
        } else if (clickedBlock == ModBlocks.LUNAR_STONE.get()) {
            newBlock = MOON_ORES.get(random.nextInt(MOON_ORES.size())).get();
        } else if (clickedBlock == StarBlocks.CORESTONE.get()) {
            newBlock = SUN_DEEPSLATE_ORES.get(random.nextInt(SUN_DEEPSLATE_ORES.size())).get();
        } else if (clickedBlock == ModBlocks.INNER_STONE.get()) {
            newBlock = MOON_DEEPSLATE_ORES.get(random.nextInt(MOON_DEEPSLATE_ORES.size())).get();
        }

        if (newBlock != null) {
            level.setBlockAndUpdate(pos, newBlock.defaultBlockState());

            context.getItemInHand().hurtAndBreak(0, (ServerLevel) level, context.getPlayer(),
                    item -> context.getPlayer().onEquippedItemBroken(item,
                            context.getHand() == InteractionHand.MAIN_HAND ? EquipmentSlot.MAINHAND : EquipmentSlot.OFFHAND));

            return InteractionResult.CONSUME;
        }

        return InteractionResult.PASS;
    }
}
