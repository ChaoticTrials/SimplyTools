package de.melanx.simplytools.data;

import de.melanx.simplytools.ModBlocks;
import de.melanx.simplytools.ModItems;
import de.melanx.simplytools.compat.ToolsCompat;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.util.VanillaCondition;
import net.minecraft.data.DataGenerator;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
import org.moddingx.libx.mod.ModX;

import java.util.List;

@Datagen
public class ConditionalRecipes extends RecipeProviderBase implements CraftingExtension {

    public ConditionalRecipes(ModX mod, DataGenerator generator) {
        super(mod, generator);
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
        this.createHammer(ModItems.obsidianHammer, Ingredient.of(Tags.Items.OBSIDIAN));
        this.createHammer(ModItems.paperHammer, Ingredient.of(ModItems.paperBundle));
        this.createHammer(ModItems.prismarineHammer, Ingredient.of(Tags.Items.DUSTS_PRISMARINE));
        this.createHammer(ModItems.quartzHammer, Ingredient.of(Tags.Items.STORAGE_BLOCKS_QUARTZ));
        this.createHammer(ModItems.redstoneHammer, Ingredient.of(Tags.Items.STORAGE_BLOCKS_REDSTONE));
        this.createHammer(ModItems.slimeHammer, Ingredient.of(Tags.Items.SLIMEBALLS));

        this.createExcavator(ModItems.boneExcavator, Ingredient.of(Tags.Items.BONES));
        this.createExcavator(ModItems.coalExcavator, Ingredient.of(Items.COAL));
        this.createExcavator(ModItems.copperExcavator, Ingredient.of(Tags.Items.INGOTS_COPPER));
        this.createExcavator(ModItems.emeraldExcavator, Ingredient.of(Tags.Items.GEMS_EMERALD));
        this.createExcavator(ModItems.enderExcavator, Ingredient.of(ModBlocks.cleanEndStone));
        this.createExcavator(ModItems.fieryExcavator, Ingredient.of(Items.MAGMA_CREAM));
        this.createExcavator(ModItems.glowstoneExcavator, Ingredient.of(Items.GLOWSTONE));
        this.createExcavator(ModItems.lapisExcavator, Ingredient.of(Tags.Items.STORAGE_BLOCKS_LAPIS));
        this.createExcavator(ModItems.netherExcavator, Ingredient.of(Items.NETHER_BRICKS));
        this.createExcavator(ModItems.obsidianExcavator, Ingredient.of(Tags.Items.OBSIDIAN));
        this.createExcavator(ModItems.paperExcavator, Ingredient.of(ModItems.paperBundle));
        this.createExcavator(ModItems.prismarineExcavator, Ingredient.of(Tags.Items.DUSTS_PRISMARINE));
        this.createExcavator(ModItems.quartzExcavator, Ingredient.of(Tags.Items.STORAGE_BLOCKS_QUARTZ));
        this.createExcavator(ModItems.redstoneExcavator, Ingredient.of(Tags.Items.STORAGE_BLOCKS_REDSTONE));
        this.createExcavator(ModItems.slimeExcavator, Ingredient.of(Tags.Items.SLIMEBALLS));
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(
                new ModLoadedCondition(ToolsCompat.MODID),
                new VanillaCondition()
        );
    }

    private void createHammer(Item result, Ingredient material) {
        BaseTool tool = (BaseTool) result;
        this.shaped(tool.getHead(),
                "mm ",
                "mmm",
                " mm",
                'm', material);
        this.shaped(result,
                "  h",
                " s ",
                "s  ",
                'h', tool.getHead(),
                's', Tags.Items.RODS_WOODEN);
    }

    private void createExcavator(Item result, Ingredient material) {
        BaseTool tool = (BaseTool) result;
        this.shaped(tool.getHead(),
                "mmm",
                "mmm",
                " m ",
                'm', material);
        this.shaped(result,
                "  h",
                " s ",
                "s  ",
                'h', tool.getHead(),
                's', Tags.Items.RODS_WOODEN);
    }
}
