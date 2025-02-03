package de.melanx.simplytools.config;

import net.minecraft.world.item.Tiers;
import org.moddingx.libx.annotation.config.RegisterConfig;
import org.moddingx.libx.config.Config;
import org.moddingx.libx.config.Group;
import org.moddingx.libx.config.validate.FloatRange;

@RegisterConfig
public class ModConfig {

    @Config("This is only relevant when MoreVanillaTools is installed")
    public static boolean vanillaOnly = false;

    @Config({"Multiplier to calculate the durability", "Single tool durability * this value = durability"})
    @FloatRange(min = 0, max = 10)
    public static float durabilityModifier = 1.5f;

    @Group
    public static class ToolValues {

        @Config
        public static ConfigurableMaterial wood = ConfigurableMaterial.of(Tiers.WOOD);

        @Config
        public static ConfigurableMaterial stone = ConfigurableMaterial.of(Tiers.STONE);

        @Config
        public static ConfigurableMaterial iron = ConfigurableMaterial.of(Tiers.IRON);

        @Config
        public static ConfigurableMaterial gold = ConfigurableMaterial.of(Tiers.GOLD);

        @Config
        public static ConfigurableMaterial diamond = ConfigurableMaterial.of(Tiers.DIAMOND);

        @Config
        public static ConfigurableMaterial netherite = ConfigurableMaterial.of(Tiers.NETHERITE);
    }
}
