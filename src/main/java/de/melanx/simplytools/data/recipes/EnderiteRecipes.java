package de.melanx.simplytools.data.recipes;

import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.util.VanillaCondition;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
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
//        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.netheriteHammer, Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ModItems.enderiteHammer);
//        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ((BaseTool) ModItems.netheriteHammer).getHead(), Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ((BaseTool) ModItems.enderiteHammer).getHead());
//        this.shaped(this.output(ModItems.enderiteHammer), RecipeCategory.TOOLS, ModItems.enderiteHammer, "  h", " s ", "s  ", 'h', ((BaseTool) ModItems.enderiteHammer).getHead(), 's', Tags.Items.RODS_WOODEN);

//        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ModItems.netheriteExcavator, Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ModItems.enderiteExcavator);
//        this.smithing(RecipeCategory.TOOLS, Items.NETHERITE_UPGRADE_SMITHING_TEMPLATE, ((BaseTool) ModItems.netheriteExcavator).getHead(), Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ((BaseTool) ModItems.enderiteExcavator).getHead());
//        this.shaped(this.output(ModItems.enderiteExcavator), RecipeCategory.TOOLS, ModItems.enderiteExcavator, "  h", " s ", "s  ", 'h', ((BaseTool) ModItems.enderiteExcavator).getHead(), 's', Tags.Items.RODS_WOODEN);
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
