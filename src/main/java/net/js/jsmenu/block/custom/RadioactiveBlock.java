package net.js.jsmenu.block.custom;

import net.js.jsmenu.damage.RadioactiveDamageTypes;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.entity.BlockEntity;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class RadioactiveBlock extends Block {
    // Dynamic fields to hold the specific damage type keys for whichever material this block is
    private final ResourceKey<DamageType> stepDamageKey;
    private final ResourceKey<DamageType> karmaDamageKey;
    private final ResourceKey<DamageType> miningDamageKey;

    // The updated constructor requires you to pass the three custom keys
    public RadioactiveBlock(Properties properties,
                            ResourceKey<DamageType> stepDamageKey,
                            ResourceKey<DamageType> karmaDamageKey,
                            ResourceKey<DamageType> miningDamageKey) {
        super(properties);
        this.stepDamageKey = stepDamageKey;
        this.karmaDamageKey = karmaDamageKey;
        this.miningDamageKey = miningDamageKey;
    }

    @Override
    public void stepOn(Level level, BlockPos pos, BlockState state, Entity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            LivingEntity lastAttacked = player.getLastHurtMob();
            int ticksSinceAttack = (int) (player.getCurrentItemAttackStrengthDelay() * (1.0F - player.getAttackStrengthScale(0.0F)));
            LivingEntity regularAttacker = player.getKillCredit();

            DamageSource finalSource;

            if (lastAttacked != null && ticksSinceAttack < 60 && regularAttacker == null) {
                // Scenario 4: Instant Karma
                finalSource = RadioactiveDamageTypes.getSource(level, this.karmaDamageKey, lastAttacked);
            } else if (regularAttacker != null) {
                // Scenario 2: Active Combat Step
                finalSource = RadioactiveDamageTypes.getSource(level, this.stepDamageKey, regularAttacker);
            } else {
                // Scenario 1: Accidental Step
                finalSource = RadioactiveDamageTypes.getSource(level, this.stepDamageKey, null);
            }

            RadioactiveDamageTypes.hurtWithoutKnockback(player, finalSource, 6.0F);
        }
        super.stepOn(level, pos, state, entity);
    }

    @Override
    public void playerDestroy(Level level, @NotNull Player player, @NotNull BlockPos pos, @NotNull BlockState state, BlockEntity blockEntity, @NotNull ItemStack tool) {
        if (!level.isClientSide) {
            // Scenario 3: Custom mining radiation damage (Replaces generic damage)
            DamageSource miningSource = RadioactiveDamageTypes.getSource(level, this.miningDamageKey, null);
            RadioactiveDamageTypes.hurtWithoutKnockback(player, miningSource, 3F);
        }
        super.playerDestroy(level, player, pos, state, blockEntity, tool);
    }

    @Override
    protected void entityInside(@NotNull BlockState state, Level level, @NotNull BlockPos pos, @NotNull Entity entity) {
        if (!level.isClientSide && entity instanceof Player player) {
            // Keeping this as step damage so standing inside the block gives the same tracking
            RadioactiveDamageTypes.hurtWithoutKnockback(player, RadioactiveDamageTypes.getSource(level, this.stepDamageKey, player.getKillCredit()), 6F);
        }
        super.entityInside(state, level, pos, entity);
    }

    @Override
    protected @NotNull VoxelShape getCollisionShape(@NotNull BlockState state, @NotNull BlockGetter level, @NotNull BlockPos pos, @NotNull CollisionContext context) {
        return Block.box(0.0D, 0.0D, 0.0D, 16.0D, 16.0D, 16.0D);
    }
}
