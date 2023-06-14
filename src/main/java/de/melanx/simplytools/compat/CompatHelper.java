package de.melanx.simplytools.compat;

import de.melanx.MoreVanillaTools.items.ToolMaterials;
import de.melanx.simplytools.SimplyTools;
import de.melanx.simplytools.config.ModConfig;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.items.DummyItem;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.ModList;
import net.minecraftforge.registries.ForgeRegistries;
import net.onvoid.copperized.common.CopperizedTiers;

import javax.annotation.Nonnull;
import java.util.*;

public class CompatHelper {

    public static String COPPERIZED = "copperized";
    public static String ENDERITE = "lolenderite";
    public static String MOREVANILLATOOLS = "morevanillatools";
    private static final Map<String, Tier> LOADED_TIERS = new HashMap<>();

    public static void loadTiers() {
        RegisterTiersEvent event = new RegisterTiersEvent();
        MinecraftForge.EVENT_BUS.post(event);
        event.getTiersByModid().forEach((modid, map) -> {
            if (ModList.get().isLoaded(modid)) {
                LOADED_TIERS.putAll(map);
            }
        });

        if (ModList.get().isLoaded(COPPERIZED)) {
            SimplyTools.LOGGER.info(COPPERIZED + " is loaded.");
            LOADED_TIERS.put("copper", CopperizedTiers.COPPER);
        }

        if (ModList.get().isLoaded(ENDERITE)) {
            SimplyTools.LOGGER.info(ENDERITE + " is loaded.");
//            LOADED_TIERS.put("enderite", ToolMaterialInit.ENDERITE); todo enderite
        }

        if (ModList.get().isLoaded(MOREVANILLATOOLS)) {
            SimplyTools.LOGGER.info(MOREVANILLATOOLS + " is loaded.");
            LOADED_TIERS.put("bone", ToolMaterials.BONE);
            LOADED_TIERS.put("coal", ToolMaterials.COAL);
            LOADED_TIERS.put("copper", ToolMaterials.COPPER);
            LOADED_TIERS.put("emerald", ToolMaterials.EMERALD);
            LOADED_TIERS.put("ender", ToolMaterials.ENDER);
            LOADED_TIERS.put("fiery", ToolMaterials.FIERY);
            LOADED_TIERS.put("glowstone", ToolMaterials.GLOWSTONE);
            LOADED_TIERS.put("lapis", ToolMaterials.LAPIS);
            LOADED_TIERS.put("nether", ToolMaterials.NETHER);
            LOADED_TIERS.put("obsidian", ToolMaterials.OBSIDIAN);
            LOADED_TIERS.put("paper", ToolMaterials.PAPER);
            LOADED_TIERS.put("prismarine", ToolMaterials.PRISMARINE);
            LOADED_TIERS.put("quartz", ToolMaterials.QUARTZ);
            LOADED_TIERS.put("redstone", ToolMaterials.REDSTONE);
            LOADED_TIERS.put("slime", ToolMaterials.SLIME);
        }
    }

    public static Item makeItem(String modid, float attackDamageModifier, float attackSpeedModifier, String tier, TagKey<Block> mineable, Item.Properties properties) {
        return CompatHelper.makeItem(List.of(modid), attackDamageModifier, attackSpeedModifier, tier, mineable, properties);
    }

    public static Item makeItem(List<String> modids, float attackDamageModifier, float attackSpeedModifier, String tier, TagKey<Block> mineable, Item.Properties properties) {
        if (LOADED_TIERS.containsKey(tier)) {
            return new BaseTool(attackDamageModifier, attackSpeedModifier, CompatHelper.createTier(CompatHelper.getTierFor(tier)), mineable, properties);
        }

        return new DummyItem(modids);
    }

    public static Tier getTierFor(String material) {
        return LOADED_TIERS.getOrDefault(material.toLowerCase(Locale.ROOT), DummyItem.DUMMY_TIER);
    }

    public static int getDurabilityFor(String tier) {
        return CompatHelper.getTierFor(tier).getUses();
    }

    public static Ingredient getIngredientByIds(ResourceLocation... ids) {
        Set<Ingredient> ingredients = new HashSet<>();
        for (ResourceLocation id : ids) {
            if (id.getNamespace().startsWith("#")) {
                TagKey<Item> tag = TagKey.create(Registries.ITEM, new ResourceLocation(id.getNamespace().replace("#", ""), id.getPath()));
                ingredients.add(Ingredient.of(tag));
            } else {
                Item item = ForgeRegistries.ITEMS.getValue(id);
                if (item == null) {
                    SimplyTools.LOGGER.info("Item doesn't exist: " + id);
                }
                ingredients.add(Ingredient.of(item));
            }
        }

        return ingredients.isEmpty() ? Ingredient.EMPTY : Ingredient.merge(ingredients);
    }

    public static boolean isLoaded(String modid) {
        return ModList.get().isLoaded(modid);
    }

    /**
     * @param base The {@link Tier} the material is made of
     * @return The tier used for the self-made AIOT
     */
    public static Tier createTier(Tier base) {
        return new Tier() {

            @Override
            public int getUses() {
                return (int) (base.getUses() * ModConfig.durabilityModifier);
            }

            @Override
            public float getSpeed() {
                return base.getSpeed();
            }

            @Override
            public float getAttackDamageBonus() {
                return base.getAttackDamageBonus();
            }

            @Override
            public int getLevel() {
                return base.getLevel();
            }

            @Override
            public int getEnchantmentValue() {
                return base.getEnchantmentValue();
            }

            @Nonnull
            @Override
            public Ingredient getRepairIngredient() {
                return base.getRepairIngredient();
            }
        };
    }

    public record LoadedTier(String name, Tier tier) {

    }
}
