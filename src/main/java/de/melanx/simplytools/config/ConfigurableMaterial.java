package de.melanx.simplytools.config;

import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;

public record ConfigurableMaterial(float speed, float attackDamageBonus, TagKey<Block> incorrectBlockForDrops, int enchantmentValue) {

    public static ConfigurableMaterial of(Tier tier) {
        return new ConfigurableMaterial(tier.getSpeed(), tier.getAttackDamageBonus(), tier.getIncorrectBlocksForDrops(), tier.getEnchantmentValue());
    }
}
