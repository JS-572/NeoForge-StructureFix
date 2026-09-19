package net.js.jsmenu.util;

import net.js.jsmenu.JSMenu;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
        public static final TagKey<Block> NEEDS_HELIUM_TOOL = createTag("needs_helium_tool");
        public static final TagKey<Block> INCORRECT_FOR_HELIUM_TOOL = createTag("incorrect_for_helium_tool");
        public static final TagKey<Block> NEEDS_SCANDIUM_TOOL = createTag("needs_scandium_tool");
        public static final TagKey<Block> INCORRECT_FOR_SCANDIUM_TOOL = createTag("incorrect_for_scandium_tool");
        public static final TagKey<Block> NEEDS_TITANIUM_TOOL = createTag("needs_titanium_tool");
        public static final TagKey<Block> INCORRECT_FOR_TITANIUM_TOOL = createTag("incorrect_for_titanium_tool");
        public static final TagKey<Block> NEEDS_VANADIUM_TOOL = createTag("needs_vanadium_tool");
        public static final TagKey<Block> INCORRECT_FOR_VANADIUM_TOOL = createTag("incorrect_for_vanadium_tool");
        public static final TagKey<Block> NEEDS_CHROMIUM_TOOL = createTag("needs_chromium_tool");
        public static final TagKey<Block> INCORRECT_FOR_CHROMIUM_TOOL = createTag("incorrect_for_chromium_tool");
        public static final TagKey<Block> NEEDS_MANGANESE_TOOL = createTag("needs_manganese_tool");
        public static final TagKey<Block> INCORRECT_FOR_MANGANESE_TOOL = createTag("incorrect_for_manganese_tool");
        public static final TagKey<Block> NEEDS_COBALT_TOOL = createTag("needs_cobalt_tool");
        public static final TagKey<Block> INCORRECT_FOR_COBALT_TOOL = createTag("incorrect_for_cobalt_tool");
        public static final TagKey<Block> NEEDS_NICKEL_TOOL = createTag("needs_nickel_tool");
        public static final TagKey<Block> INCORRECT_FOR_NICKEL_TOOL = createTag("incorrect_for_nickel_tool");
        public static final TagKey<Block> NEEDS_ZINC_TOOL = createTag("needs_zinc_tool");
        public static final TagKey<Block> INCORRECT_FOR_ZINC_TOOL = createTag("incorrect_for_zinc_tool");
        public static final TagKey<Block> NEEDS_YTTRIUM_TOOL = createTag("needs_yttrium_tool");
        public static final TagKey<Block> INCORRECT_FOR_YTTRIUM_TOOL = createTag("incorrect_for_yttrium_tool");
        public static final TagKey<Block> NEEDS_ZIRCONIUM_TOOL = createTag("needs_zirconium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ZIRCONIUM_TOOL = createTag("incorrect_for_zirconium_tool");
        public static final TagKey<Block> NEEDS_NIOBIUM_TOOL = createTag("needs_niobium_tool");
        public static final TagKey<Block> INCORRECT_FOR_NIOBIUM_TOOL = createTag("incorrect_for_niobium_tool");
        public static final TagKey<Block> NEEDS_MOLYBDENUM_TOOL = createTag("needs_molybdenum_tool");
        public static final TagKey<Block> INCORRECT_FOR_MOLYBDENUM_TOOL = createTag("incorrect_for_molybdenum_tool");
        public static final TagKey<Block> NEEDS_TECHNETIUM_TOOL = createTag("needs_technetium_tool");
        public static final TagKey<Block> INCORRECT_FOR_TECHNETIUM_TOOL = createTag("incorrect_for_technetium_tool");
        public static final TagKey<Block> NEEDS_RUTHENIUM_TOOL = createTag("needs_ruthenium_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUTHENIUM_TOOL = createTag("incorrect_for_ruthenium_tool");
        public static final TagKey<Block> NEEDS_RHODIUM_TOOL = createTag("needs_rhodium_tool");
        public static final TagKey<Block> INCORRECT_FOR_RHODIUM_TOOL = createTag("incorrect_for_rhodium_tool");
        public static final TagKey<Block> NEEDS_PALLADIUM_TOOL = createTag("needs_palladium_tool");
        public static final TagKey<Block> INCORRECT_FOR_PALLADIUM_TOOL = createTag("incorrect_for_palladium_tool");
        public static final TagKey<Block> NEEDS_SILVER_TOOL = createTag("needs_silver_tool");
        public static final TagKey<Block> INCORRECT_FOR_SILVER_TOOL = createTag("incorrect_for_silver_tool");
        public static final TagKey<Block> NEEDS_CADMIUM_TOOL = createTag("needs_cadmium_tool");
        public static final TagKey<Block> INCORRECT_FOR_CADMIUM_TOOL = createTag("incorrect_for_cadmium_tool");
        public static final TagKey<Block> NEEDS_HAFNIUM_TOOL = createTag("needs_hafnium_tool");
        public static final TagKey<Block> INCORRECT_FOR_HAFNIUM_TOOL = createTag("incorrect_for_hafnium_tool");
        public static final TagKey<Block> NEEDS_TANTALUM_TOOL = createTag("needs_tantalum_tool");
        public static final TagKey<Block> INCORRECT_FOR_TANTALUM_TOOL = createTag("incorrect_for_tantalum_tool");
        public static final TagKey<Block> NEEDS_TUNGSTEN_TOOL = createTag("needs_tungsten_tool");
        public static final TagKey<Block> INCORRECT_FOR_TUNGSTEN_TOOL = createTag("incorrect_for_tungsten_tool");
        public static final TagKey<Block> NEEDS_RHENIUM_TOOL = createTag("needs_rhenium_tool");
        public static final TagKey<Block> INCORRECT_FOR_RHENIUM_TOOL = createTag("incorrect_for_rhenium_tool");
        public static final TagKey<Block> NEEDS_OSMIUM_TOOL = createTag("needs_osmium_tool");
        public static final TagKey<Block> INCORRECT_FOR_OSMIUM_TOOL = createTag("incorrect_for_osmium_tool");
        public static final TagKey<Block> NEEDS_IRIDIUM_TOOL = createTag("needs_iridium_tool");
        public static final TagKey<Block> INCORRECT_FOR_IRIDIUM_TOOL = createTag("incorrect_for_iridium_tool");
        public static final TagKey<Block> NEEDS_PLATINUM_TOOL = createTag("needs_platinum_tool");
        public static final TagKey<Block> INCORRECT_FOR_PLATINUM_TOOL = createTag("incorrect_for_platinum_tool");
        public static final TagKey<Block> NEEDS_RUTHERFORDIUM_TOOL = createTag("needs_rutherfordium_tool");
        public static final TagKey<Block> INCORRECT_FOR_RUTHERFORDIUM_TOOL = createTag("incorrect_for_rutherfordium_tool");
        public static final TagKey<Block> NEEDS_DUBNIUM_TOOL = createTag("needs_dubnium_tool");
        public static final TagKey<Block> INCORRECT_FOR_DUBNIUM_TOOL = createTag("incorrect_for_dubnium_tool");
        public static final TagKey<Block> NEEDS_SEABORGIUM_TOOL = createTag("needs_seaborgium_tool");
        public static final TagKey<Block> INCORRECT_FOR_SEABORGIUM_TOOL = createTag("incorrect_for_seaborgium_tool");
        public static final TagKey<Block> NEEDS_BOHRIUM_TOOL = createTag("needs_bohrium_tool");
        public static final TagKey<Block> INCORRECT_FOR_BOHRIUM_TOOL = createTag("incorrect_for_bohrium_tool");
        public static final TagKey<Block> NEEDS_HASSIUM_TOOL = createTag("needs_hassium_tool");
        public static final TagKey<Block> INCORRECT_FOR_HASSIUM_TOOL = createTag("incorrect_for_hassium_tool");
        public static final TagKey<Block> NEEDS_MEITNERIUM_TOOL = createTag("needs_meitnerium_tool");
        public static final TagKey<Block> INCORRECT_FOR_MEITNERIUM_TOOL = createTag("incorrect_for_meitnerium_tool");
        public static final TagKey<Block> NEEDS_DARMSTADTIUM_TOOL = createTag("needs_darmstadtium_tool");
        public static final TagKey<Block> INCORRECT_FOR_DARMSTADTIUM_TOOL = createTag("incorrect_for_darmstadtium_tool");
        public static final TagKey<Block> NEEDS_ROENTGENIUM_TOOL = createTag("needs_roentgenium_tool");
        public static final TagKey<Block> INCORRECT_FOR_ROENTGENIUM_TOOL = createTag("incorrect_for_roentgenium_tool");
        public static final TagKey<Block> NEEDS_COPERNICIUM_TOOL = createTag("needs_copernicium_tool");
        public static final TagKey<Block> INCORRECT_FOR_COPERNICIUM_TOOL = createTag("incorrect_for_copernicium_tool");

        public static final TagKey<Block> TRANSITION_METAL_ORES = createTag("transition_metal_ores");
        public static final TagKey<Block> SHOVEL_MINEABLES = createTag("shovel_mineables");

        public static final TagKey<Block> ORES = createTag("ores");
        private static TagKey<Block> createTag(String name) {
            return BlockTags.create(ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> FIRE_RESISTANT = createTag("fire_resistant");
        private static TagKey<Item> createTag(String name) {
            return ItemTags.create(ResourceLocation.fromNamespaceAndPath(JSMenu.MOD_ID, name));
        }
    }
}
