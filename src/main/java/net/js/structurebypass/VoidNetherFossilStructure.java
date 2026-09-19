package net.js.structurebypass;

import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import java.util.Optional;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilPieces;
import net.minecraft.world.level.levelgen.structure.structures.NetherFossilStructure;
import net.minecraft.world.level.levelgen.heightproviders.HeightProvider;

public final class VoidNetherFossilStructure extends NetherFossilStructure {
    public static final MapCodec<VoidNetherFossilStructure> CODEC = RecordCodecBuilder.mapCodec(instance ->
            instance.group(settingsCodec(instance), HeightProvider.CODEC.fieldOf("height").forGetter(structure -> structure.height))
                    .apply(instance, VoidNetherFossilStructure::new));
    public static final StructureType<VoidNetherFossilStructure> TYPE = () -> CODEC;

    public VoidNetherFossilStructure(StructureSettings settings, net.minecraft.world.level.levelgen.heightproviders.HeightProvider height) {
        super(settings, height);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        BlockPos position = new BlockPos(
                context.chunkPos().getMinBlockX() + 8, 64,
                context.chunkPos().getMinBlockZ() + 8);
        return Optional.of(new GenerationStub(position,
                pieces -> NetherFossilPieces.addPieces(
                        context.structureTemplateManager(), pieces, context.random(), position)));
    }

    @Override
    public StructureType<?> type() {
        return TYPE;
    }
}
