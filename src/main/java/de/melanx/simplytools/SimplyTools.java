package de.melanx.simplytools;

import de.melanx.simplytools.compat.CompatHelper;
import de.melanx.simplytools.util.ClientEventHandler;
import de.melanx.simplytools.util.VanillaCondition;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.common.crafting.CraftingHelper;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.loading.FMLEnvironment;
import org.moddingx.libx.mod.ModXRegistration;
import org.moddingx.libx.registration.RegistrationBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Nonnull;

@Mod("simplytools")
public final class SimplyTools extends ModXRegistration {

    public static Logger LOGGER = LoggerFactory.getLogger(SimplyTools.class);
    private static SimplyTools instance;

    public SimplyTools() {
        super(new CreativeModeTab("simplytools") {

            @Nonnull
            @Override
            public ItemStack makeIcon() {
                return new ItemStack(ModItems.redstoneHammer);
            }
        });
        instance = this;

        CraftingHelper.register(VanillaCondition.SERIALIZER);
        MinecraftForge.EVENT_BUS.register(new EventHandler());
        if (FMLEnvironment.dist == Dist.CLIENT) {
            MinecraftForge.EVENT_BUS.register(new ClientEventHandler());
        }

        CompatHelper.loadTiers();
    }

    @Override
    protected void setup(FMLCommonSetupEvent event) {

    }

    @Override
    protected void clientSetup(FMLClientSetupEvent event) {

    }

    @Override
    protected void initRegistration(RegistrationBuilder builder) {
        builder.enableRegistryTracking();
    }

    public static SimplyTools getInstance() {
        return instance;
    }

    @Nonnull
    public static CreativeModeTab getTab() {
        //noinspection ConstantConditions
        return instance.tab;
    }
}
