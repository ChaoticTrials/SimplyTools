package de.melanx.simplytools;

import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.data.*;
import de.melanx.simplytools.data.recipes.ConditionalRecipes;
import de.melanx.simplytools.data.recipes.EnderiteRecipes;
import de.melanx.simplytools.data.recipes.Recipes;
import de.melanx.simplytools.data.recipes.SimplestCopperGearRecipes;
import de.melanx.simplytools.util.ClientEventHandler;
import net.neoforged.api.distmarker.Dist;
import net.neoforged.fml.common.Mod;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.neoforge.common.NeoForge;
import org.moddingx.libx.datagen.DatagenSystem;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@Mod("simplytools")
public final class SimplyTools extends ModXRegistration {

    public static Logger LOGGER = LoggerFactory.getLogger(SimplyTools.class);
    private static SimplyTools instance;

    public SimplyTools(Dist dist) {
        instance = this;

        NeoForge.EVENT_BUS.register(new EventHandler());
        if (dist == Dist.CLIENT) {
            NeoForge.EVENT_BUS.register(new ClientEventHandler());
        }

        DatagenSystem.create(this, system -> {
            system.addRegistryProvider(EnchantmentProvider::new);
            system.addRegistryProvider(BlockLoot::new);
            system.addDataProvider(BlockStates::new);
            system.addDataProvider(ItemModels::new);
            system.addDataProvider(ToolTags::new);
            system.addDataProvider(EnchantmentTagsProvider::new);
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
