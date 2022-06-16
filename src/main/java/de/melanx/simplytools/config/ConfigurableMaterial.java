package de.melanx.simplytools.config;

import net.minecraft.world.item.Tier;

public record ConfigurableMaterial(float speed, float attackDamageBonus, int harvestLevel, int enchantmentValue) {

    public static ConfigurableMaterial of(Tier tier) {
        //noinspection deprecation
        return new ConfigurableMaterial(tier.getSpeed(), tier.getAttackDamageBonus(), tier.getLevel(), tier.getEnchantmentValue());
    }
}
