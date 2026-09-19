package net.js.structurebypass;

import com.mojang.serialization.MapCodec;
import java.util.Optional;
import net.minecraft.world.level.ChunkPos;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.structure.Structure;
import net.minecraft.world.level.levelgen.structure.StructurePiece;
import net.minecraft.world.level.levelgen.structure.StructureType;
import net.minecraft.world.level.levelgen.structure.pieces.StructurePiecesBuilder;
import net.minecraft.world.level.levelgen.structure.structures.DesertPyramidStructure;

public final class VoidDesertPyramidStructure extends DesertPyramidStructure {
    public static final MapCodec<VoidDesertPyramidStructure> CODEC =
            simpleCodec(VoidDesertPyramidStructure::new);
    public static final StructureType<VoidDesertPyramidStructure> TYPE = () -> CODEC;

    public VoidDesertPyramidStructure(StructureSettings settings) {
        super(settings);
    }

    @Override
    public Optional<GenerationStub> findGenerationPoint(GenerationContext context) {
        return onTopOfChunkCenter(context, Heightmap.Types.WORLD_SURFACE_WG, pieces -> {
            ChunkPos chunkPos = context.chunkPos();
            StructurePiece piece = new VoidDesertPyramidPiece(
                    context.random(), chunkPos.getMinBlockX(), chunkPos.getMinBlockZ());
            pieces.addPiece(piece);
        });
    }

    @Override
    public StructureType<?> type() {
        return TYPE;
    }
}
