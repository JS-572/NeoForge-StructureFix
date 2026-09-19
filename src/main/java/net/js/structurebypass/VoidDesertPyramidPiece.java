package net.js.structurebypass;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.levelgen.structure.structures.DesertPyramidPiece;
import net.minecraft.util.RandomSource;

public final class VoidDesertPyramidPiece extends DesertPyramidPiece {
    public VoidDesertPyramidPiece(RandomSource random, int x, int z) {
        super(random, x, z);
    }

    @Override
    protected boolean updateHeightPositionToLowestGroundHeight(LevelAccessor level, int height) {
        if (this.getBoundingBox().minY() != 64) {
            this.move(0, 64 - this.getBoundingBox().minY(), 0);
        }
        return true;
    }
}
