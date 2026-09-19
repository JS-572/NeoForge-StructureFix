package net.js.jsmenu.block.custom.fluid;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.LiquidBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.material.PushReaction;

import java.util.function.Supplier;

public class BaseLavaBlock extends LiquidBlock {
    private final float contactDamage;

    public BaseLavaBlock(Supplier<? extends FlowingFluid> fluidSupplier, float contactDamage) {
        super(fluidSupplier.get(), Properties.of()
                .mapColor(MapColor.WATER)
                .strength(1000000000000000000000000000f)
                .noCollission()
                .noLootTable()
                .liquid()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.EMPTY)
                .replaceable());
        this.contactDamage = contactDamage;
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (this.contactDamage > 0.0F) {
            entity.igniteForSeconds(15.0F);
            entity.hurt(level.damageSources().lava(), this.contactDamage);
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    public void randomTick(BlockState state, ServerLevel level, BlockPos pos, RandomSource random) {
        if (!level.dimension().location().toString().equals("jsmenu:space")) {
            super.randomTick(state, level, pos, random);
        }
    }

    @Override
    public void onPlace(BlockState state, Level level, BlockPos pos, BlockState oldState, boolean isMoving) {
        if (level.dimension().location().toString().equals("jsmenu:space")) {
            level.setBlock(pos, state, 3);
        } else {
            super.onPlace(state, level, pos, oldState, isMoving);
        }
    }

    @Override
    public void neighborChanged(BlockState state, Level level, BlockPos pos, Block block, BlockPos fromPos, boolean isMoving) {
        if (level.dimension().location().toString().equals("jsmenu:space")) {
            level.setBlock(pos, state, 3);
        } else {
            super.neighborChanged(state, level, pos, block, fromPos, isMoving);
        }
    }
}
