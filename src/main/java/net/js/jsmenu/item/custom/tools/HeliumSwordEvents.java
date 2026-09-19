package net.js.jsmenu.item.custom.tools;

import net.js.jsmenu.JSMenu;
import net.js.jsmenu.damage.HeliumDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.LivingEntity;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.event.entity.living.LivingFallEvent;

@EventBusSubscriber(modid = JSMenu.MOD_ID)
public final class HeliumSwordEvents {
    private HeliumSwordEvents() {
    }

    @SubscribeEvent
    public static void onLivingFall(LivingFallEvent event) {
        LivingEntity target = event.getEntity();
        if (target.level().isClientSide || !(target.level() instanceof ServerLevel serverLevel)) {
            return;
        }

        CompoundTag persistentData = target.getPersistentData();
        if (!persistentData.getBoolean(HeliumSwordItem.HELIUM_SWORD_POP_TAG)) {
            return;
        }

        persistentData.remove(HeliumSwordItem.HELIUM_SWORD_POP_TAG);

        Entity attacker = null;
        if (persistentData.hasUUID(HeliumSwordItem.HELIUM_SWORD_ATTACKER_TAG)) {
            attacker = serverLevel.getEntity(persistentData.getUUID(HeliumSwordItem.HELIUM_SWORD_ATTACKER_TAG));
            persistentData.remove(HeliumSwordItem.HELIUM_SWORD_ATTACKER_TAG);
        }

        float damage = Math.max(0.0F, (event.getDistance() - 3.0F) * event.getDamageMultiplier());
        if (damage <= 0.0F) {
            return;
        }

        event.setCanceled(true);
        if (attacker != null) {
            target.hurt(HeliumDamageTypes.heliumPop(serverLevel, attacker), damage);
            return;
        }

        target.hurt(HeliumDamageTypes.heliumPop(serverLevel), damage);
    }
}
