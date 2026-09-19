package net.js.jsmenu.item.custom.tools.transition_metals.scandium;

import net.js.jsmenu.item.ModToolTiers;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.SwordItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;

public class ScandiumSword extends SwordItem {

    public ScandiumSword() {
        // big damage: adjust attackDamageModifier to taste (this will produce the strong damage you mentioned)
        super(
                ModToolTiers.SCANDIUM, new Item.Properties().attributes(SwordItem.createAttributes(ModToolTiers.SCANDIUM, 11, -2.4F)).stacksTo(1));
    }

    @Override
    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        // give the target glowing for 10 seconds (200 ticks)
        target.addEffect(new MobEffectInstance(MobEffects.GLOWING, 200, 0, false, true, true));
        // damage tool properly
        stack.hurtAndBreak(1, attacker, EquipmentSlot.MAINHAND);
        return super.hurtEnemy(stack, target, attacker);
    }
}
