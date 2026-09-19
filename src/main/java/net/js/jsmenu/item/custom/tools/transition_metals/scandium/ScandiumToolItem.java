package net.js.jsmenu.item.custom.tools.transition_metals.scandium;

import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;

public abstract class ScandiumToolItem extends Item {
    public ScandiumToolItem(Properties properties) {
        super(properties);
    }

    /**
     * Shared behavior for all scandium tools:
     * - Small client-side particle trail (subtle)
     * - While selected, grant short Night Vision to the player so items "glow" in the dark
     */
    @Override
    public void inventoryTick(ItemStack stack, Level level, net.minecraft.world.entity.Entity entity, int slot, boolean selected) {
        super.inventoryTick(stack, level, entity, slot, selected);

        // Particles: client-side only, subtle (no big fat particles)
        if (level.isClientSide() && selected && entity != null) {
            double x = entity.getX() + (level.random.nextDouble() - 0.5) * 0.2;
            double y = entity.getY() + 1.0 + (level.random.nextDouble() - 0.5) * 0.1;
            double z = entity.getZ() + (level.random.nextDouble() - 0.5) * 0.2;
            // single small end rod particle per tick (very subtle)
            level.addParticle(ParticleTypes.END_ROD, x, y, z, 0.0, 0.01, 0.0);
        }

        // Night Vision trick: server-side add short potion effect so player can see in dark while holding
        if (!level.isClientSide() && selected && entity instanceof Player player) {
            // 20 ticks (1 second) refresh so it persists while holding
            player.addEffect(new net.minecraft.world.effect.MobEffectInstance(net.minecraft.world.effect.MobEffects.NIGHT_VISION, 20, 0, false, false, false));
        }
    }
    /**
     * Subclasses can override getDestroySpeed to tweak behavior for specific blocks (e.g. make hoes faster on leaves/sculk).
     */
}
