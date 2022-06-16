package de.melanx.simplytools;

import de.melanx.simplytools.compat.ToolsCompat;
import de.melanx.simplytools.items.BaseTool;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.Item;
import org.moddingx.libx.annotation.registration.RegisterClass;
import org.moddingx.libx.base.ItemBase;

@RegisterClass(registry = "ITEM_REGISTRY")
public class ModItems {

    // hammers
    public static final Item woodenHammer = new BaseTool(1.5f, -3.0f, ToolMaterials.WOODEN, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item stoneHammer = new BaseTool(2.5f, -3.0f, ToolMaterials.STONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item ironHammer = new BaseTool(3.5f, -3.0f, ToolMaterials.IRON, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item goldenHammer = new BaseTool(1.5f, -3.0f, ToolMaterials.GOLDEN, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item diamondHammer = new BaseTool(4.5f, -3.0f, ToolMaterials.DIAMOND, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item netheriteHammer = new BaseTool(5.5f, -3.0f, ToolMaterials.NETHERITE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()).fireResistant());

    public static final Item boneHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.BONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item coalHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.COAL, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item emeraldHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.EMERALD, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item enderHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.ENDER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item fieryHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.FIERY, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item glowstoneHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.GLOWSTONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item lapisHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.LAPIS, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item netherHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.NETHER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item obsidianHammer = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.OBSIDIAN, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item paperHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.PAPER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item prismarineHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.PRISMARINE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item quartzHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.QUARTZ, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item redstoneHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.REDSTONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item slimeHammer = ToolsCompat.makeItem(0, -3.0f, ToolMaterials.SLIME, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().tab(SimplyTools.getTab()));

    // excavators
    public static final Item woodenExcavator = new BaseTool(2.0f, -3.2f, ToolMaterials.WOODEN, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item stoneExcavator = new BaseTool(3.0f, -3.2f, ToolMaterials.STONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item ironExcavator = new BaseTool(4.0f, -3.2f, ToolMaterials.IRON, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item goldenExcavator = new BaseTool(2.0f, -3.2f, ToolMaterials.GOLDEN, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item diamondExcavator = new BaseTool(5.0f, -3.2f, ToolMaterials.DIAMOND, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item netheriteExcavator = new BaseTool(6.0f, -3.2f, ToolMaterials.NETHERITE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()).fireResistant());

    public static final Item boneExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.BONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item coalExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.COAL, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item emeraldExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.EMERALD, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item enderExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.ENDER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item fieryExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.FIERY, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item glowstoneExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.GLOWSTONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item lapisExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.LAPIS, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item netherExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.NETHER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item obsidianExcavator = ToolsCompat.makeItem(0, -3.4f, ToolMaterials.OBSIDIAN, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item paperExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.PAPER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item prismarineExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.PRISMARINE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item quartzExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.QUARTZ, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item redstoneExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.REDSTONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));
    public static final Item slimeExcavator = ToolsCompat.makeItem(0, -3.2f, ToolMaterials.SLIME, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().tab(SimplyTools.getTab()));

    // additions
    public static final Item paperBundle = new ItemBase(SimplyTools.getInstance(), new Item.Properties());
}
