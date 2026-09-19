package net.js.jsmenu.damage;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.damagesource.DamageType;
import net.minecraft.world.entity.Entity;

public class HeliumDamageTypes {

    public static final ResourceKey<DamageType> HELIUM_POP =
            ResourceKey.create(Registries.DAMAGE_TYPE,
                    ResourceLocation.fromNamespaceAndPath("jsmenu", "helium_pop"));

    public static DamageSource heliumPop(ServerLevel level) {
        return level.damageSources().source(HELIUM_POP);
    }

    public static DamageSource heliumPop(ServerLevel level, Entity attacker) {
        return level.damageSources().source(HELIUM_POP, attacker);
    }
}

