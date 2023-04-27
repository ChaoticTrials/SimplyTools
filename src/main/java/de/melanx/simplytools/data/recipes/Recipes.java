package de.melanx.simplytools.data.recipes;

import de.melanx.simplytools.ModBlocks;
import de.melanx.simplytools.ModItems;
import de.melanx.simplytools.SimplyTools;
import de.melanx.simplytools.items.BaseTool;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.SimpleCookingRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.*;
import org.moddingx.libx.datagen.provider.recipe.crafting.CompressionExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

public class Recipes extends RecipeProviderBase implements CraftingExtension, CompressionExtension, DefaultExtension, SmeltingExtension, SmithingExtension, StoneCuttingExtension {

    public Recipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.compress(Items.PAPER, ModItems.paperBundle);
        this.blasting(Tags.Items.END_STONES, ModBlocks.cleanEndStone, 0.1f, 200);

        this.createHammer(ModItems.woodenHammer, Ingredient.of(ItemTags.PLANKS));
        this.createHammer(ModItems.stoneHammer, Ingredient.of(Tags.Items.COBBLESTONE));
        this.createHammer(ModItems.ironHammer, Ingredient.of(Tags.Items.INGOTS_IRON));
        this.createHammer(ModItems.goldenHammer, Ingredient.of(Tags.Items.INGOTS_GOLD));
        this.createHammer(ModItems.diamondHammer, Ingredient.of(Tags.Items.GEMS_DIAMOND));
        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.diamondHammer, Ingredient.of(Tags.Items.INGOTS_NETHERITE), ModItems.netheriteHammer);
        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ((BaseTool) ModItems.diamondHammer).getHead(), Ingredient.of(Tags.Items.INGOTS_NETHERITE), ((BaseTool) ModItems.netheriteHammer).getHead());
        this.shaped(RecipeCategory.TOOLS, ModItems.netheriteHammer, "  h", " s ", "s  ", 'h', ((BaseTool) ModItems.netheriteHammer).getHead(), 's', Tags.Items.RODS_WOODEN);

        this.createExcavator(ModItems.woodenExcavator, Ingredient.of(ItemTags.PLANKS));
        this.createExcavator(ModItems.stoneExcavator, Ingredient.of(Tags.Items.COBBLESTONE));
        this.createExcavator(ModItems.ironExcavator, Ingredient.of(Tags.Items.INGOTS_IRON));
        this.createExcavator(ModItems.goldenExcavator, Ingredient.of(Tags.Items.INGOTS_GOLD));
        this.createExcavator(ModItems.diamondExcavator, Ingredient.of(Tags.Items.GEMS_DIAMOND));
        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.diamondExcavator, Ingredient.of(Tags.Items.INGOTS_NETHERITE), ModItems.netheriteExcavator);
        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ((BaseTool) ModItems.diamondExcavator).getHead(), Ingredient.of(Tags.Items.INGOTS_NETHERITE), ((BaseTool) ModItems.netheriteExcavator).getHead());
        this.shaped(RecipeCategory.TOOLS, ModItems.netheriteExcavator, "  h", " s ", "s  ", 'h', ((BaseTool) ModItems.netheriteExcavator).getHead(), 's', Tags.Items.RODS_WOODEN);

        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModItems.ironHammer, ModItems.ironExcavator), RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 200)
                .unlockedBy("has_item0", has(ModItems.ironHammer))
                .unlockedBy("has_item1", has(ModItems.ironExcavator))
                .save(this.consumer(), SimplyTools.getInstance().resource("iron_nugget_from_smelting"));
        SimpleCookingRecipeBuilder
                .smelting(Ingredient.of(ModItems.goldenHammer, ModItems.goldenExcavator), RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1f, 200)
                .unlockedBy("has_item0", has(ModItems.goldenHammer))
                .unlockedBy("has_item1", has(ModItems.goldenExcavator))
                .save(this.consumer(), SimplyTools.getInstance().resource("gold_nugget_from_smelting"));
        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModItems.ironHammer, ModItems.ironExcavator), RecipeCategory.MISC, Items.IRON_NUGGET, 0.1f, 100)
                .unlockedBy("has_item0", has(ModItems.ironHammer))
                .unlockedBy("has_item1", has(ModItems.ironExcavator))
                .save(this.consumer(), SimplyTools.getInstance().resource("iron_nugget_from_blasting"));
        SimpleCookingRecipeBuilder
                .blasting(Ingredient.of(ModItems.goldenHammer, ModItems.goldenExcavator), RecipeCategory.MISC, Items.GOLD_NUGGET, 0.1f, 100)
                .unlockedBy("has_item0", has(ModItems.goldenHammer))
                .unlockedBy("has_item1", has(ModItems.goldenExcavator))
                .save(this.consumer(), SimplyTools.getInstance().resource("gold_nugget_from_blasting"));
    }

    protected void createHammer(Item result, Ingredient material) {
        BaseTool tool = (BaseTool) result;
        this.shaped(RecipeCategory.TOOLS, tool.getHead(),
                "mm ",
                "mmm",
                " mm",
                'm', material);
        this.shaped(RecipeCategory.TOOLS, result,
                "  h",
                " s ",
                "s  ",
                'h', tool.getHead(),
                's', Tags.Items.RODS_WOODEN);
    }

    protected void createExcavator(Item result, Ingredient material) {
        BaseTool tool = (BaseTool) result;
        this.shaped(RecipeCategory.TOOLS, tool.getHead(),
                "mmm",
                "mmm",
                " m ",
                'm', material);
        this.shaped(RecipeCategory.TOOLS, result,
                "  h",
                " s ",
                "s  ",
                'h', tool.getHead(),
                's', Tags.Items.RODS_WOODEN);
    }
}
