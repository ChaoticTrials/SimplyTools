package de.melanx.simplytools;

import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.items.DummyItem;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Tier;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.fml.ModList;
import org.moddingx.libx.annotation.registration.RegisterClass;
import org.moddingx.libx.base.ItemBase;

import java.util.List;

@RegisterClass(registry = "ITEM")
public class ModItems {

    // hammers
    public static final Item woodenHammer = new BaseTool(1.5f, -3.0f, ToolMaterials.WOODEN, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item stoneHammer = new BaseTool(2.5f, -3.0f, ToolMaterials.STONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item ironHammer = new BaseTool(3.5f, -3.0f, ToolMaterials.IRON, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item goldenHammer = new BaseTool(1.5f, -3.0f, ToolMaterials.GOLDEN, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item diamondHammer = new BaseTool(4.5f, -3.0f, ToolMaterials.DIAMOND, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item netheriteHammer = new BaseTool(5.5f, -3.0f, ToolMaterials.NETHERITE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties().fireResistant());

    public static final Item boneHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.BONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item coalHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.COAL, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item copperHammer = ModItems.makeItem(List.of(CompatHelper.SIMPLEST_COPPER_GEAR, CompatHelper.MOREVANILLATOOLS), 0, -3.0f, ToolMaterials.COPPER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item emeraldHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.EMERALD, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item enderHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.ENDER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item fieryHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.FIERY, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item glowstoneHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.GLOWSTONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item lapisHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.LAPIS, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item netherHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.NETHER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item obsidianHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.OBSIDIAN, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item paperHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.PAPER, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item prismarineHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.PRISMARINE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item quartzHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.QUARTZ, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item redstoneHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.REDSTONE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item slimeHammer = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.0f, ToolMaterials.SLIME, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());

    public static final Item enderiteHammer = ModItems.makeItem(CompatHelper.ENDERITE, 0, -3.0f, ToolMaterials.ENDERITE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());
    public static final Item obsidianInfusedEnderiteHammer = ModItems.makeItem(CompatHelper.ENDERITE, 0, -3.0f, ToolMaterials.OBSIDIAN_INFUSED_ENDERITE, BlockTags.MINEABLE_WITH_PICKAXE, new Item.Properties());

    // excavators
    public static final Item woodenExcavator = new BaseTool(2.0f, -3.2f, ToolMaterials.WOODEN, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item stoneExcavator = new BaseTool(3.0f, -3.2f, ToolMaterials.STONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item ironExcavator = new BaseTool(4.0f, -3.2f, ToolMaterials.IRON, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item goldenExcavator = new BaseTool(2.0f, -3.2f, ToolMaterials.GOLDEN, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item diamondExcavator = new BaseTool(5.0f, -3.2f, ToolMaterials.DIAMOND, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item netheriteExcavator = new BaseTool(6.0f, -3.2f, ToolMaterials.NETHERITE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties().fireResistant());

    public static final Item boneExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.BONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item coalExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.COAL, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item copperExcavator = ModItems.makeItem(List.of(CompatHelper.SIMPLEST_COPPER_GEAR, CompatHelper.MOREVANILLATOOLS), 0, -3.2f, ToolMaterials.COPPER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item emeraldExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.EMERALD, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item enderExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.ENDER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item fieryExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.FIERY, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item glowstoneExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.GLOWSTONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item lapisExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.LAPIS, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item netherExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.NETHER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item obsidianExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.4f, ToolMaterials.OBSIDIAN, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item paperExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.PAPER, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item prismarineExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.PRISMARINE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item quartzExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.QUARTZ, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item redstoneExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.REDSTONE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item slimeExcavator = ModItems.makeItem(CompatHelper.MOREVANILLATOOLS, 0, -3.2f, ToolMaterials.SLIME, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());

    public static final Item enderiteExcavator = ModItems.makeItem(CompatHelper.ENDERITE, 0, -3.2f, ToolMaterials.ENDERITE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    public static final Item obsidianInfusedEnderiteExcavator = ModItems.makeItem(CompatHelper.ENDERITE, 0, -3.2f, ToolMaterials.OBSIDIAN_INFUSED_ENDERITE, BlockTags.MINEABLE_WITH_SHOVEL, new Item.Properties());
    // additions
    public static final Item paperBundle = new ItemBase(SimplyTools.getInstance(), new Item.Properties());

    public static Item makeItem(String modid, float attackDamageModifier, float attackSpeedModifier, Tier tier, TagKey<Block> mineable, Item.Properties properties) {
        return ModItems.makeItem(List.of(modid), attackDamageModifier, attackSpeedModifier, tier, mineable, properties);
    }

    public static Item makeItem(List<String> modids, float attackDamageModifier, float attackSpeedModifier, Tier tier, TagKey<Block> mineable, Item.Properties properties) {
        for (String modid : modids) {
            if (ModList.get().isLoaded(modid)) {
                return new BaseTool(attackDamageModifier, attackSpeedModifier, tier, mineable, properties);
            }
        }

        return new DummyItem(modids);
    }
}
