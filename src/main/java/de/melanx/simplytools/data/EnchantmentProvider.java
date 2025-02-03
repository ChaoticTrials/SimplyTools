package de.melanx.simplytools.data;

import de.melanx.simplytools.SimplyTools;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.entity.EquipmentSlotGroup;
import net.minecraft.world.item.enchantment.Enchantment;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.EnchantmentProviderBase;

public class EnchantmentProvider extends EnchantmentProviderBase {

    public static final ResourceKey<Enchantment> POWER_OF_THE_DEPTH = ResourceKey.create(Registries.ENCHANTMENT, SimplyTools.getInstance().resource("power_of_the_depth"));

    public final Holder<Enchantment> powerOfTheDepth = this.enchantment(Component.translatable("enchantment.simplytools.power_of_the_depth"))
            .supportedItems(ToolTags.TOOLS_RANGED)
            .slot(EquipmentSlotGroup.MAINHAND)
            .minCost(15, 9)
            .maxCost(20, 9)
            .maxLevel(3)
            .build();

    public EnchantmentProvider(DatagenContext ctx) {
        super(ctx);
    }
}
