package de.melanx.simplytools;

import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.config.ConfigurableMaterial;
import de.melanx.simplytools.config.ModConfig;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.Tiers;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import org.moddingx.libx.util.lazy.LazyValue;

import javax.annotation.Nonnull;
import java.util.function.Supplier;

public enum ToolMaterials implements Tier {

    WOODEN(ModConfig.ToolValues.wood, Tiers.WOOD.getUses(), () -> Ingredient.of(ItemTags.PLANKS)),
    STONE(ModConfig.ToolValues.stone, Tiers.STONE.getUses(), () -> Ingredient.of(Tags.Items.COBBLESTONE)),
    IRON(ModConfig.ToolValues.iron, Tiers.IRON.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_IRON)),
    GOLDEN(ModConfig.ToolValues.gold, Tiers.GOLD.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_GOLD)),
    DIAMOND(ModConfig.ToolValues.diamond, Tiers.DIAMOND.getUses(), () -> Ingredient.of(Tags.Items.GEMS_DIAMOND)),
    NETHERITE(ModConfig.ToolValues.netherite, Tiers.NETHERITE.getUses(), () -> Ingredient.of(Tags.Items.INGOTS_NETHERITE)),

    BONE("bone", () -> Ingredient.of(Tags.Items.BONES)),
    COAL("coal", () -> Ingredient.of(Items.COAL)),
    COPPER("copper", () -> Ingredient.of(Tags.Items.INGOTS_COPPER)),
    EMERALD("emerald", () -> Ingredient.of(Tags.Items.GEMS_EMERALD)),
    ENDER("ender", () -> Ingredient.of(Tags.Items.ENDER_PEARLS)),
    FIERY("fiery", () -> Ingredient.of(Items.MAGMA_BLOCK)),
    GLOWSTONE("glowstone", () -> Ingredient.of(Tags.Items.DUSTS_GLOWSTONE)),
    LAPIS("lapis", () -> Ingredient.of(Tags.Items.GEMS_LAPIS)),
    NETHER("nether", () -> Ingredient.of(Items.NETHER_BRICKS)),
    OBSIDIAN("obsidian", () -> Ingredient.of(Tags.Items.OBSIDIAN)),
    PAPER("paper", () -> Ingredient.of(Items.PAPER)),
    PRISMARINE("prismarine", () -> Ingredient.of(Tags.Items.DUSTS_PRISMARINE)),
    QUARTZ("quartz", () -> Ingredient.of(Tags.Items.GEMS_QUARTZ)),
    REDSTONE("redstone", () -> Ingredient.of(Tags.Items.DUSTS_REDSTONE)),
    SLIME("slime", () -> Ingredient.of(Tags.Items.SLIMEBALLS));

    private final ConfigurableMaterial material;
    private final int durability;
    private final LazyValue<Ingredient> repairIngredient;

    ToolMaterials(String material, Supplier<Ingredient> repairIngredient) {
        int baseDurability = CompatHelper.getDurabilityFor(material);
        this.material = ConfigurableMaterial.of(CompatHelper.getTierFor(material));
        this.durability = (int) (baseDurability * ModConfig.durabilityModifier);
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    ToolMaterials(ConfigurableMaterial material, int baseDurability, Supplier<Ingredient> repairIngredient) {
        this.material = material;
        this.durability = (int) (baseDurability * ModConfig.durabilityModifier);
        this.repairIngredient = new LazyValue<>(repairIngredient);
    }

    @Override
    public int getUses() {
        return this.durability;
    }

    @Override
    public float getSpeed() {
        return this.material.speed();
    }

    @Override
    public float getAttackDamageBonus() {
        return this.material.attackDamageBonus();
    }

    @Override
    public int getLevel() {
        return this.material.harvestLevel();
    }

    @Override
    public int getEnchantmentValue() {
        return this.material.enchantmentValue();
    }

    @Nonnull
    @Override
    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
