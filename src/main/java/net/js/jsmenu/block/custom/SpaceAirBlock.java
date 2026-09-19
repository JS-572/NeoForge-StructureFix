package net.js.jsmenu.block.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;

public class SpaceAirBlock extends Block {
    public SpaceAirBlock(Properties properties) {
        super(properties);
    }

    @Override
    protected void entityInside(BlockState state, Level level, BlockPos pos, Entity entity) {
        if (level.isClientSide) return;
        if (entity instanceof Player player) {
            boolean hasFullArmor = true;
            for (var stack : player.getInventory().armor) {
                if (stack.isEmpty()) {
                    hasFullArmor = false;
                    break;
                }
            }
            if (!hasFullArmor && !player.hasEffect(MobEffects.WATER_BREATHING)) {
                player.hurt(level.damageSources().generic(), 6.0F);
            }
        }
    }
}
