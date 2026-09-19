package net.js.jsmenu.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SolarAshBlock extends Block {
    public SolarAshBlock(Properties properties) {
        super(properties);
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && !entity.fireImmune()) {
            entity.setRemainingFireTicks(Math.max(entity.getRemainingFireTicks(), 40));
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (!level.isClientSide && !entity.fireImmune() && entity.tickCount % 20 == 0) {
            entity.igniteForSeconds(2.0F);
            entity.hurt(level.damageSources().hotFloor(), 1.0F);
        }
        super.entityInside(state, level, pos, entity);
    }
}
