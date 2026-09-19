package net.js.structurebypass.mixin;

import net.minecraft.world.level.LevelHeightAccessor;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.levelgen.RandomState;
import net.minecraft.world.level.levelgen.FlatLevelSource;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(FlatLevelSource.class)
public abstract class FlatLevelSourceMixin {
    @Inject(method = "getBaseHeight", at = @At("RETURN"), cancellable = true)
    private void structureBypass$provideVoidPlacementHeight(
            int x,
            int z,
            Heightmap.Types type,
            LevelHeightAccessor level,
            RandomState random,
            CallbackInfoReturnable<Integer> callback) {
        if (callback.getReturnValue() <= level.getMinBuildHeight()
                && type == Heightmap.Types.WORLD_SURFACE_WG) {
            callback.setReturnValue(65);
        }
    }
}
