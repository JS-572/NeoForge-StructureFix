package net.js.structurebypass;

import net.neoforged.fml.common.Mod;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.bus.api.IEventBus;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.level.levelgen.structure.StructureType;

@Mod("structurebypass")
public class StructureBypass {
    public static final DeferredRegister<StructureType<?>> STRUCTURE_TYPES =
            DeferredRegister.create(BuiltInRegistries.STRUCTURE_TYPE, "structurebypass");

    public static final DeferredHolder<StructureType<?>, StructureType<VoidDesertPyramidStructure>> VOID_DESERT_PYRAMID =
            STRUCTURE_TYPES.register("void_desert_pyramid", () -> VoidDesertPyramidStructure.TYPE);
    public static final DeferredHolder<StructureType<?>, StructureType<VoidMonumentStructure>> VOID_MONUMENT =
            STRUCTURE_TYPES.register("void_monument", () -> VoidMonumentStructure.TYPE);
    public static final DeferredHolder<StructureType<?>, StructureType<VoidNetherFossilStructure>> VOID_NETHER_FOSSIL =
            STRUCTURE_TYPES.register("void_nether_fossil", () -> VoidNetherFossilStructure.TYPE);

    public StructureBypass(IEventBus modEventBus) {
        STRUCTURE_TYPES.register(modEventBus);
    }
}
