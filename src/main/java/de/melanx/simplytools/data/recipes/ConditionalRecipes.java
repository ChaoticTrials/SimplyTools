package de.melanx.simplytools.data.recipes;

import de.melanx.simplytools.ModBlocks;
import de.melanx.simplytools.ModItems;
import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.util.VanillaCondition;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.neoforged.neoforge.common.Tags;
import net.neoforged.neoforge.common.conditions.ICondition;
import net.neoforged.neoforge.common.conditions.ModLoadedCondition;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class ConditionalRecipes extends RecipeProviderBase implements CraftingExtension {

    public ConditionalRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        this.createHammer(ModItems.boneHammer, Ingredient.of(Tags.Items.BONES));
        this.createHammer(ModItems.coalHammer, Ingredient.of(Items.COAL));
        this.createHammer(ModItems.copperHammer, Ingredient.of(Tags.Items.INGOTS_COPPER));
        this.createHammer(ModItems.emeraldHammer, Ingredient.of(Tags.Items.GEMS_EMERALD));
        this.createHammer(ModItems.enderHammer, Ingredient.of(ModBlocks.cleanEndStone));
        this.createHammer(ModItems.fieryHammer, Ingredient.of(Items.MAGMA_CREAM));
        this.createHammer(ModItems.glowstoneHammer, Ingredient.of(Items.GLOWSTONE));
        this.createHammer(ModItems.lapisHammer, Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS));
        this.createHammer(ModItems.netherHammer, Ingredient.of(Items.NETHER_BRICKS));
        this.createHammer(ModItems.obsidianHammer, Ingredient.of(Tags.Items.OBSIDIANS));
        this.createHammer(ModItems.paperHammer, Ingredient.of(ModItems.paperBundle));
        this.createHammer(ModItems.prismarineHammer, Ingredient.of(Tags.Items.GEMS_PRISMARINE));
        this.createHammer(ModItems.quartzHammer, Ingredient.of(Items.QUARTZ_BLOCK));
        this.createHammer(ModItems.redstoneHammer, Ingredient.of(Tags.Items.STORAGE_BLOCKS_REDSTONE));
        this.createHammer(ModItems.slimeHammer, Ingredient.of(Tags.Items.SLIME_BALLS));

        this.createExcavator(ModItems.boneExcavator, Ingredient.of(Tags.Items.BONES));
        this.createExcavator(ModItems.coalExcavator, Ingredient.of(Items.COAL));
        this.createExcavator(ModItems.copperExcavator, Ingredient.of(Tags.Items.INGOTS_COPPER));
        this.createExcavator(ModItems.emeraldExcavator, Ingredient.of(Tags.Items.GEMS_EMERALD));
        this.createExcavator(ModItems.enderExcavator, Ingredient.of(ModBlocks.cleanEndStone));
        this.createExcavator(ModItems.fieryExcavator, Ingredient.of(Items.MAGMA_CREAM));
        this.createExcavator(ModItems.glowstoneExcavator, Ingredient.of(Items.GLOWSTONE));
        this.createExcavator(ModItems.lapisExcavator, Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS));
        this.createExcavator(ModItems.netherExcavator, Ingredient.of(Items.NETHER_BRICKS));
        this.createExcavator(ModItems.obsidianExcavator, Ingredient.of(Tags.Items.OBSIDIANS));
        this.createExcavator(ModItems.paperExcavator, Ingredient.of(ModItems.paperBundle));
        this.createExcavator(ModItems.prismarineExcavator, Ingredient.of(Tags.Items.GEMS_PRISMARINE));
        this.createExcavator(ModItems.quartzExcavator, Ingredient.of(Items.QUARTZ_BLOCK));
        this.createExcavator(ModItems.redstoneExcavator, Ingredient.of(Tags.Items.STORAGE_BLOCKS_REDSTONE));
        this.createExcavator(ModItems.slimeExcavator, Ingredient.of(Tags.Items.SLIME_BALLS));
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(
                new ModLoadedCondition(CompatHelper.MOREVANILLATOOLS),
                new VanillaCondition()
        );
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.MOREVANILLATOOLS + "/" + BuiltInRegistries.ITEM.getKey(item).getPath());
    }

    private void createHammer(Item result, Ingredient material) {
        BaseTool tool = (BaseTool) result;
        this.shaped(this.output(tool.getHead()), RecipeCategory.TOOLS, tool.getHead(),
                "mm ",
                "mmm",
                " mm",
                'm', material);
        this.shaped(this.output(result), RecipeCategory.TOOLS, result,
                "  h",
                " s ",
                "s  ",
                'h', tool.getHead(),
                's', Tags.Items.RODS_WOODEN);
    }

    private void createExcavator(Item result, Ingredient material) {
        BaseTool tool = (BaseTool) result;
        this.shaped(this.output(tool.getHead()), RecipeCategory.TOOLS, tool.getHead(),
                "mmm",
                "mmm",
                " m ",
                'm', material);
        this.shaped(this.output(result), RecipeCategory.TOOLS, result,
                "  h",
                " s ",
                "s  ",
                'h', tool.getHead(),
                's', Tags.Items.RODS_WOODEN);
    }
}
