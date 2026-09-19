package net.js.structurebypass;

import com.mojang.serialization.MapCodec;
import java.util.Optional;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.WorldgenRandom;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentPieces;
import net.minecraft.world.level.levelgen.structure.structures.OceanMonumentStructure;

public final class VoidMonumentStructure extends OceanMonumentStructure {
    public static final MapCodec<VoidMonumentStructure> CODEC = simpleCodec(VoidMonumentStructure::new);
    public static final StructureType<VoidMonumentStructure> TYPE = () -> CODEC;

    public VoidMonumentStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG,
                pieces -> generatePieces(pieces, context));
    }

    private static void generatePieces(StructurePiecesBuilder pieces, GenerationContext context) {
        ChunkPos chunkPos = context.chunkPos();
        WorldgenRandom random = context.random();
        pieces.addPiece(new OceanMonumentPieces.MonumentBuilding(
                random, chunkPos.getMinBlockX() - 29, chunkPos.getMinBlockZ() - 29,
                net.minecraft.core.Direction.Plane.HORIZONTAL.getRandomDirection(random)));
    }

    @Override
    public StructureType<?> type() {
        return TYPE;
    }
}
