package de.melanx.simplytools.enchantments;

import de.melanx.simplytools.items.BaseTool;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;

public class DepthPower extends Enchantment {

    public DepthPower() {
        super(Rarity.RARE, EnchantmentCategory.create("simplytools.ranged", item -> item instanceof BaseTool), new EquipmentSlot[]{EquipmentSlot.MAINHAND});
    }

    @Override
    public int getMinCost(int level) {
        return 15 + (level - 1) * 9;
    }

    @Override
    public int getMaxLevel() {
        return 3;
    }
}
