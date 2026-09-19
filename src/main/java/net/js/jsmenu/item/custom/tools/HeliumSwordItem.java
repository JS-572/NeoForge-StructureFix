package net.js.jsmenu.item.custom.tools;

import net.js.jsmenu.damage.HeliumDamageTypes;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Tier;

public class HeliumSwordItem extends SwordItem {
    public static final String HELIUM_SWORD_POP_TAG = "jsmenu.helium_sword_pop";
    public static final String HELIUM_SWORD_ATTACKER_TAG = "jsmenu.helium_sword_attacker";

    public HeliumSwordItem(Tier tier, int attackDamageModifier, float attackSpeedModifier, Item.Properties properties) {
        super(tier, properties);
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        if (!target.level().isClientSide) {
            target.addEffect(new MobEffectInstance(MobEffects.LEVITATION, 100, 3));
            CompoundTag persistentData = target.getPersistentData();
            persistentData.putBoolean(HELIUM_SWORD_POP_TAG, true);
            persistentData.putUUID(HELIUM_SWORD_ATTACKER_TAG, attacker.getUUID());
        }
        return super.hurtEnemy(stack, target, attacker);
    }

}
