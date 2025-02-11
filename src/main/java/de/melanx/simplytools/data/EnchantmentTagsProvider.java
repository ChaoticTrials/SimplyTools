package de.melanx.simplytools.data;

import net.minecraft.core.registries.Registries;
import net.minecraft.tags.EnchantmentTags;
import net.minecraft.world.item.enchantment.Enchantment;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.tags.TagProviderBase;

public class EnchantmentTagsProvider extends TagProviderBase<Enchantment> {

    public EnchantmentTagsProvider(DatagenContext ctx) {
        super(ctx, Registries.ENCHANTMENT);
    }

    @Override
    protected void setup() {
        this.tag(EnchantmentTags.NON_TREASURE).add(EnchantmentProvider.POWER_OF_THE_DEPTH);
    }
}
