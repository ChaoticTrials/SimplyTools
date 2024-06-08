package de.melanx.simplytools.data.recipes;

import de.melanx.simplytools.ModItems;
import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.util.VanillaCondition;
import io.github.lieonlion.enderite.init.ItemsInit;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.SmithingExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;

import javax.annotation.Nonnull;
import java.util.List;

public class EnderiteRecipes extends RecipeProviderBase implements CraftingExtension, SmithingExtension {

    public EnderiteRecipes(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        Ingredient enderiteIngot = Ingredient.of(ItemsInit.ENDERITE_INGOT.get());
        Ingredient obsidianInfusedEnderiteIngot = Ingredient.of(ItemsInit.OBSIDIAN_INFUSED_ENDERITE_INGOT.get());

        this.createRecipesFor((BaseTool) ModItems.netheriteHammer, (BaseTool) ModItems.enderiteHammer, enderiteIngot);
        this.createRecipesFor((BaseTool) ModItems.enderiteHammer, (BaseTool) ModItems.obsidianInfusedEnderiteHammer, obsidianInfusedEnderiteIngot);
        this.createRecipesFor((BaseTool) ModItems.netheriteExcavator, (BaseTool) ModItems.enderiteExcavator, enderiteIngot);
        this.createRecipesFor((BaseTool) ModItems.enderiteExcavator, (BaseTool) ModItems.obsidianInfusedEnderiteExcavator, obsidianInfusedEnderiteIngot);
    }

    public void createRecipesFor(BaseTool base, BaseTool output, Ingredient ingredient) {
        this.smithing(RecipeCategory.TOOLS, ItemsInit.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), base, ingredient, output);
        this.smithing(RecipeCategory.TOOLS, ItemsInit.ENDERITE_UPGRADE_SMITHING_TEMPLATE.get(), base.getHead(), ingredient, output.getHead());
        this.shaped(this.output(output), RecipeCategory.TOOLS, output, "  h", " s ", "s  ", 'h', output.getHead(), 's', Tags.Items.RODS_WOODEN);
    }

    @Override
    protected List<ICondition> conditions() {
        return List.of(
                new ModLoadedCondition(CompatHelper.ENDERITE),
                new VanillaCondition()
        );
    }

    private ResourceLocation output(@Nonnull Item item) {
        //noinspection ConstantConditions
        return this.mod.resource(CompatHelper.ENDERITE + "/" + ForgeRegistries.ITEMS.getKey(item).getPath());
    }
}
