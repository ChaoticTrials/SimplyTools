package de.melanx.simplytools.items;

import de.melanx.simplytools.ToolMaterials;
import de.melanx.simplytools.compat.LibCompat;
import net.minecraft.core.Holder;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.*;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import org.moddingx.libx.registration.Registerable;
import org.moddingx.libx.registration.RegistrationContext;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class BaseTool extends DiggerItem implements Registerable {

    private final boolean isVanilla;
    private final Item head;
    private final TagKey<Block> mineable;

    public BaseTool(float attackDamageModifier, float attackSpeedModifier, Tier tier, TagKey<Block> mineable, Properties properties) {
        super(tier, mineable, properties.attributes(DiggerItem.createAttributes(tier, attackDamageModifier, attackSpeedModifier)));
        this.isVanilla = tier == ToolMaterials.WOODEN
                || tier == ToolMaterials.STONE
                || tier == ToolMaterials.IRON
                || tier == ToolMaterials.GOLDEN
                || tier == ToolMaterials.DIAMOND
                || tier == ToolMaterials.NETHERITE;
        this.head = new Item(new Item.Properties());
        this.mineable = mineable;
    }

    @Override
    public int getBurnTime(@Nonnull ItemStack itemStack, @Nullable RecipeType<?> recipeType) {
        return this.getTier() == ToolMaterials.WOODEN ? 400 : 0;
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        return super.getDestroySpeed(stack, state) * 0.9f;
    }

    @Override
    public void registerAdditional(RegistrationContext ctx, EntryCollector builder) {
        builder.registerNamed(Registries.ITEM, "head", this.head);
    }

    public Item getHead() {
        return this.head;
    }

    public TagKey<Block> getMineable() {
        return this.mineable;
    }

    @Override
    public int getEnchantmentLevel(@Nonnull ItemStack stack, Holder<Enchantment> enchantment) {
        if (enchantment.is(Enchantments.KNOCKBACK) && stack.getItem() instanceof BaseTool item && item.getTier() == ToolMaterials.SLIME) {
            return 3;
        }

        return super.getEnchantmentLevel(stack, enchantment);
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable TooltipContext context, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag isAdvanced) {
        if (LibCompat.isMoreVanillaLibLoaded()) {
            LibCompat.editHoverText(this, stack, context, tooltip, isAdvanced);
        }

        super.appendHoverText(stack, context, tooltip, isAdvanced);
    }

    public boolean isVanilla() {
        return this.isVanilla;
    }

    public ToolMaterials getModdedMaterial() {
        return this.getTier() instanceof ToolMaterials material ? material : null;
    }
}
