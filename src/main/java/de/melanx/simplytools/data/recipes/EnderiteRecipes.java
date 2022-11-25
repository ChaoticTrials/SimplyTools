package de.melanx.simplytools.data.recipes;

import de.melanx.simplytools.ModItems;
import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.util.VanillaCondition;
import io.github.lieonlion.enderite.core.init.ItemInit;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraftforge.common.Tags;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.ModLoadedCondition;
import net.minecraftforge.registries.ForgeRegistries;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.recipe.RecipeProviderBase;
import org.moddingx.libx.datagen.provider.recipe.SmithingExtension;
import org.moddingx.libx.datagen.provider.recipe.crafting.CraftingExtension;
import org.moddingx.libx.mod.ModX;

import javax.annotation.Nonnull;
import java.util.List;

@Datagen
public class EnderiteRecipes extends RecipeProviderBase implements CraftingExtension, SmithingExtension {

    public EnderiteRecipes(ModX mod, DataGenerator generator) {
        super(mod, generator);
    }

    @Override
    protected void setup() {
        this.smithing(ModItems.netheriteHammer, Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ModItems.enderiteHammer);
        this.smithing(((BaseTool) ModItems.netheriteHammer).getHead(), Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ((BaseTool) ModItems.enderiteHammer).getHead());
        this.shaped(this.output(ModItems.enderiteHammer), ModItems.enderiteHammer, "  h", " s ", "s  ", 'h', ((BaseTool) ModItems.enderiteHammer).getHead(), 's', Tags.Items.RODS_WOODEN);

        this.smithing(ModItems.netheriteExcavator, Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ModItems.enderiteExcavator);
        this.smithing(((BaseTool) ModItems.netheriteExcavator).getHead(), Ingredient.of(ItemInit.ENDERITE_INGOT.get()), ((BaseTool) ModItems.enderiteExcavator).getHead());
        this.shaped(this.output(ModItems.enderiteExcavator), ModItems.enderiteExcavator, "  h", " s ", "s  ", 'h', ((BaseTool) ModItems.enderiteExcavator).getHead(), 's', Tags.Items.RODS_WOODEN);
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
