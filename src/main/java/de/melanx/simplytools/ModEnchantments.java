package de.melanx.simplytools;

import de.melanx.simplytools.enchantments.DepthPower;
import net.minecraft.world.item.enchantment.Enchantment;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "ENCHANTMENT")
public class ModEnchantments {

    public static final Enchantment powerOfTheDepth = new DepthPower();
}
