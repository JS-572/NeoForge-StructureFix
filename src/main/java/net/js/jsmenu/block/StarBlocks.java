package net.js.jsmenu.block;

import net.js.jsmenu.JSMenu;
import net.js.jsmenu.block.custom.saplings.star.Sun.CoronaBloomSaplingBlock;
import net.js.jsmenu.block.custom.saplings.star.Sun.FlarewoodSaplingBlock;
import net.js.jsmenu.block.custom.IgnitedSolarAshBlock;
import net.js.jsmenu.block.custom.SolarAshBlock;
import net.js.jsmenu.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.*;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockSetType;
import net.minecraft.world.level.block.state.properties.WoodType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredBlock;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class StarBlocks {
    public static final DeferredRegister.Blocks BLOCKS =
            DeferredRegister.createBlocks(JSMenu.MOD_ID);

    public static final DeferredBlock<Block> SOLAR_ASH = registerBlock("solar_ash", () -> new SolarAshBlock(BlockBehaviour.Properties.of().strength(0.7f).sound(SoundType.SAND).randomTicks()));
    public static final DeferredBlock<Block> IGNITED_SOLAR_ASH = registerBlock("ignited_solar_ash", () -> new IgnitedSolarAshBlock(BlockBehaviour.Properties.of().strength(0.8f).sound(SoundType.SAND).lightLevel(state -> 12).randomTicks(), SOLAR_ASH.get()));
    public static final DeferredBlock<Block> SOLAR_STONE = registerBlock("solar_stone", () -> new Block(BlockBehaviour.Properties.of().strength(2.5f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> CORESTONE = registerBlock("corestone", () -> new Block(BlockBehaviour.Properties.of().strength(4.5f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> SOLARITE_ORE = registerBlock("solarite_ore", () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BLAZESTONE_ORE = registerBlock("blazestone_ore", () -> new Block(BlockBehaviour.Properties.of().strength(3.3f).requiresCorrectToolForDrops().lightLevel(state -> 7).sound(SoundType.STONE)));
    public static final DeferredBlock<Block> RADIANT_CRYSTAL_ORE = registerBlock("radiant_crystal_ore", () -> new Block(BlockBehaviour.Properties.of().strength(3.6f).requiresCorrectToolForDrops().lightLevel(state -> 10).sound(SoundType.AMETHYST)));
    public static final DeferredBlock<Block> CORE_FRAGMENT_ORE = registerBlock("core_fragment_ore", () -> new Block(BlockBehaviour.Properties.of().strength(5.0f).requiresCorrectToolForDrops().sound(SoundType.DEEPSLATE)));
    public static final DeferredBlock<Block> SOLARITE_BLOCK = registerBlock("solarite_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> BLAZESTONE_BLOCK = registerBlock("blazestone_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.3f).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(state -> 7)));
    public static final DeferredBlock<Block> RADIANT_CRYSTAL_BLOCK = registerBlock("radiant_crystal_block", () -> new Block(BlockBehaviour.Properties.of().strength(3.6f).requiresCorrectToolForDrops().sound(SoundType.STONE).lightLevel(state -> 10)));
    public static final DeferredBlock<Block> CORE_FRAGMENT_BLOCK = registerBlock("core_fragment_block", () -> new Block(BlockBehaviour.Properties.of().strength(5.0f).requiresCorrectToolForDrops().sound(SoundType.STONE)));
    public static final DeferredBlock<Block> FLAREWOOD_LOG = registerBlock("flarewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> FLAREWOOD_WOOD = registerBlock("flarewood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FLAREWOOD_LOG = registerBlock("stripped_flarewood_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_FLAREWOOD_WOOD = registerBlock("stripped_flarewood_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> FLAREWOOD_PLANKS = registerBlock("flarewood_planks", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> FLAREWOOD_LEAVES = registerBlock("flarewood_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().lightLevel(state -> 5).isValidSpawn((state, level, pos, entityType) -> false).isSuffocating(StarBlocks::never).isViewBlocking(StarBlocks::never)));
    public static final DeferredBlock<Block> FLAREWOOD_SAPLING = registerBlock("flarewood_sapling", () -> new FlarewoodSaplingBlock(BlockBehaviour.Properties.of().noCollission().instabreak().randomTicks().sound(SoundType.GRASS).lightLevel(state -> 4)));
    public static final DeferredBlock<Block> CORONA_BLOOM_LOG = registerBlock("corona_bloom_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CORONA_BLOOM_WOOD = registerBlock("corona_bloom_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CORONA_BLOOM_LOG = registerBlock("stripped_corona_bloom_log", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> STRIPPED_CORONA_BLOOM_WOOD = registerBlock("stripped_corona_bloom_wood", () -> new RotatedPillarBlock(BlockBehaviour.Properties.of().strength(2.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CORONA_BLOOM_PLANKS = registerBlock("corona_bloom_planks", () -> new Block(BlockBehaviour.Properties.of().strength(2.0f, 3.0f).sound(SoundType.WOOD)));
    public static final DeferredBlock<Block> CORONA_BLOOM_LEAVES = registerBlock("corona_bloom_leaves", () -> new LeavesBlock(BlockBehaviour.Properties.of().strength(0.2f).randomTicks().sound(SoundType.AZALEA_LEAVES).noOcclusion().lightLevel(state -> 5).isValidSpawn((state, level, pos, entityType) -> false).isSuffocating(StarBlocks::never).isViewBlocking(StarBlocks::never)));
    public static final DeferredBlock<Block> CORONA_BLOOM_SAPLING = registerBlock("corona_bloom_sapling", () -> new CoronaBloomSaplingBlock(BlockBehaviour.Properties.of().noCollission().instabreak().randomTicks().sound(SoundType.GRASS).lightLevel(state -> 4)));
    public static final DeferredBlock<StairBlock> FLAREWOOD_STAIRS = registerBlock("flarewood_stairs", () -> new StairBlock(StarBlocks.FLAREWOOD_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> FLAREWOOD_SLAB = registerBlock("flarewood_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<PressurePlateBlock> FLAREWOOD_PRESSURE_PLATE = registerBlock("flarewood_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<ButtonBlock> FLAREWOOD_BUTTON = registerBlock("flarewood_button", () -> new ButtonBlock(BlockSetType.CHERRY, 20, BlockBehaviour.Properties.of().strength(2f).noCollission()));
    public static final DeferredBlock<FenceBlock> FLAREWOOD_FENCE = registerBlock("flarewood_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> FLAREWOOD_FENCE_GATE = registerBlock("flarewood_fence_gate", () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<DoorBlock> FLAREWOOD_DOOR = registerBlock("flarewood_door", () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<TrapDoorBlock> FLAREWOOD_TRAPDOOR = registerBlock("flarewood_trapdoor", () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));
    public static final DeferredBlock<StairBlock> CORONA_BLOOM_STAIRS = registerBlock("corona_bloom_stairs", () -> new StairBlock(StarBlocks.CORONA_BLOOM_PLANKS.get().defaultBlockState(), BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<SlabBlock> CORONA_BLOOM_SLAB = registerBlock("corona_bloom_slab", () -> new SlabBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<PressurePlateBlock> CORONA_BLOOM_PRESSURE_PLATE = registerBlock("corona_bloom_pressure_plate", () -> new PressurePlateBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<ButtonBlock> CORONA_BLOOM_BUTTON = registerBlock("corona_bloom_button", () -> new ButtonBlock(BlockSetType.CHERRY, 20, BlockBehaviour.Properties.of().strength(2f).noCollission()));
    public static final DeferredBlock<FenceBlock> CORONA_BLOOM_FENCE = registerBlock("corona_bloom_fence", () -> new FenceBlock(BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<FenceGateBlock> CORONA_BLOOM_FENCE_GATE = registerBlock("corona_bloom_fence_gate", () -> new FenceGateBlock(WoodType.CHERRY, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<DoorBlock> CORONA_BLOOM_DOOR = registerBlock("corona_bloom_door", () -> new DoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of().strength(2f)));
    public static final DeferredBlock<TrapDoorBlock> CORONA_BLOOM_TRAPDOOR = registerBlock("corona_bloom_trapdoor", () -> new TrapDoorBlock(BlockSetType.CHERRY, BlockBehaviour.Properties.of().strength(2f).noOcclusion()));

    private static <T extends Block> DeferredBlock<T> registerBlock(String name, Supplier<T> block) {
        DeferredBlock<T> toReturn = BLOCKS.register(name, block);
        registerBlockItem(name, toReturn);
        return toReturn;
    }
    private static <T extends Block> void registerBlockItem(String name, DeferredBlock<T> block) {
        ModItems.ITEMS.register(name, () -> new BlockItem(block.get(), new Item.Properties().fireResistant()));
    }

    private static boolean never(BlockState state, BlockGetter level, BlockPos pos) {
        return false;
    }
    public static void register(IEventBus eventBus) {
        BLOCKS.register(eventBus);
    }
}
