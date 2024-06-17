package de.melanx.simplytools;

import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.data.BlockLoot;
import de.melanx.simplytools.data.BlockStates;
import de.melanx.simplytools.data.ItemModels;
import de.melanx.simplytools.data.ToolTags;
import de.melanx.simplytools.data.recipes.ConditionalRecipes;
import de.melanx.simplytools.data.recipes.EnderiteRecipes;
import de.melanx.simplytools.data.recipes.Recipes;
import de.melanx.simplytools.data.recipes.SimplestCopperGearRecipes;
import de.melanx.simplytools.util.ClientEventHandler;
import de.melanx.simplytools.util.VanillaCondition;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("simplytools")
public final class SimplyTools extends ModXRegistration {

    public static Logger LOGGER = LoggerFactory.getLogger(SimplyTools.class);
    private static SimplyTools instance;

    public SimplyTools() {
        instance = this;

        CraftingHelper.register(VanillaCondition.SERIALIZER);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        if (FMLEnvironment.dist == Dist.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        }

        DatagenSystem.create(this, system -> {
            system.addDataProvider(BlockLoot::new);
            system.addDataProvider(BlockStates::new);
            system.addDataProvider(ItemModels::new);
            system.addDataProvider(ToolTags::new);
            system.addDataProvider(Recipes::new);
            system.addDataProvider(ConditionalRecipes::new);
            system.addDataProvider(SimplestCopperGearRecipes::new);
            system.addDataProvider(EnderiteRecipes::new);
        });

        CompatHelper.loadTiers();
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {
        // NO-OP
    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        // NO-OP
    }

    public static SimplyTools getInstance() {
        return instance;
    }
}
