package de.melanx.simplytools.compat;

import de.melanx.MoreVanillaTools.items.ToolMaterials;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.items.DummyItem;
import de.melanx.simplytools.items.ObsidianHammer;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;

public class ToolsCompat {

    public static final String MODID = "morevanillatools";

    public static Item makeItem(float attackDamageModifier, float attackSpeedModifier, de.melanx.simplytools.ToolMaterials tier, TagKey<Block> mineable, Item.Properties properties) {
        if (ToolsCompat.isMoreVanillaToolsLoaded()) {
            if (tier == de.melanx.simplytools.ToolMaterials.OBSIDIAN && mineable == BlockTags.MINEABLE_WITH_PICKAXE) {
                return new ObsidianHammer(attackDamageModifier, attackSpeedModifier, properties);
            }

            return new BaseTool(attackDamageModifier, attackSpeedModifier, tier, mineable, properties);
        } else {
            return new DummyItem(MODID);
        }
    }

    public static Tier getTierFor(String tier) {
        if (!ToolsCompat.isMoreVanillaToolsLoaded()) {
            return DummyItem.DUMMY_TIER;
        }

        return switch (tier) {
            case "bone" -> ToolMaterials.BONE;
            case "coal" -> ToolMaterials.COAL;
            case "copper" -> ToolMaterials.COPPER;
            case "emerald" -> ToolMaterials.EMERALD;
            case "ender" -> ToolMaterials.ENDER;
            case "fiery" -> ToolMaterials.FIERY;
            case "glowstone" -> ToolMaterials.GLOWSTONE;
            case "lapis" -> ToolMaterials.LAPIS;
            case "nether" -> ToolMaterials.NETHER;
            case "obsidian" -> ToolMaterials.OBSIDIAN;
            case "paper" -> ToolMaterials.PAPER;
            case "prismarine" -> ToolMaterials.PRISMARINE;
            case "quartz" -> ToolMaterials.QUARTZ;
            case "redstone" -> ToolMaterials.REDSTONE;
            case "slime" -> ToolMaterials.SLIME;
            default -> DummyItem.DUMMY_TIER;
        };
    }

    public static int getDurabilityFor(String tier) {
        Tier compat = ToolsCompat.getTierFor(tier);

        return compat.getUses();
    }

    public static boolean isMoreVanillaToolsLoaded() {
        return ModList.get().isLoaded(MODID);
    }
}
