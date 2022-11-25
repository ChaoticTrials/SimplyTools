package de.melanx.simplytools.items;

import de.melanx.simplytools.SimplyTools;
import de.melanx.simplytools.ToolMaterials;
import de.melanx.simplytools.compat.LibCompat;
import de.melanx.simplytools.config.ModConfig;
import net.minecraft.core.NonNullList;
import net.minecraft.core.Registry;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.registration.Registerable;
import org.moddingx.libx.registration.RegistrationContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BaseTool extends DiggerItem implements Registerable {

    private final boolean isVanilla;
    private final Item head;

    public BaseTool(float attackDamageModifier, float attackSpeedModifier, Tier tier, TagKey<Block> mineable, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, tier, mineable, properties);
        this.isVanilla = tier == ToolMaterials.WOODEN
                || tier == ToolMaterials.STONE
                || tier == ToolMaterials.IRON
                || tier == ToolMaterials.GOLDEN
                || tier == ToolMaterials.DIAMOND
                || tier == ToolMaterials.NETHERITE;
        this.head = new Item(new Item.Properties().tab(SimplyTools.getTab()));
    }

    @Override
    public int getBurnTime(ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.getTier() == ToolMaterials.WOODEN ? 400 : 0;
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        return super.getDestroySpeed(stack, state) * 0.9f;
    }

    @Override
    public void fillItemCategory(@Nonnull CreativeModeTab tab, @Nonnull NonNullList<ItemStack> items) {
        if (!this.isVanilla && ModConfig.vanillaOnly) {
            return;
        }

        super.fillItemCategory(tab, items);
    }

    @Override
    public void registerAdditional(RegistrationContext ctx, EntryCollector builder) {
        builder.registerNamed(Registry.ITEM_REGISTRY, "head", this.head);
    }

    public Item getHead() {
        return this.head;
    }

    @Override
    public void initTracking(RegistrationContext ctx, TrackingCollector builder) throws ReflectiveOperationException {
        builder.trackNamed(ForgeRegistries.ITEMS, "head", BaseTool.class.getDeclaredField("head"));
    }

    @Override
    public int getEnchantmentLevel(ItemStack stack, Enchantment enchantment) {
        if (enchantment == Enchantments.KNOCKBACK && stack.getItem() instanceof BaseTool item && item.getTier() == ToolMaterials.SLIME) {
            return 3;
        }

        return super.getEnchantmentLevel(stack, enchantment);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag isAdvanced) {
        if (LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.editHoverText(this, stack, level, tooltip, isAdvanced);
        }

        super.appendHoverText(stack, level, tooltip, isAdvanced);
    }
}
