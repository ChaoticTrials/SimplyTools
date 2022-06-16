package de.melanx.simplytools.util;

import com.google.gson.JsonObject;
import de.melanx.simplytools.SimplyTools;
import de.melanx.simplytools.config.ModConfig;
import net.minecraft.resources.ResourceLocation;
import net.minecraftforge.common.crafting.conditions.ICondition;
import net.minecraftforge.common.crafting.conditions.IConditionSerializer;

public class VanillaCondition implements ICondition {

    public static final ResourceLocation KEY = new ResourceLocation(SimplyTools.getInstance().modid, "vanilla_plus");

    @Override
    public ResourceLocation getID() {
        return KEY;
    }

    @Override
    public boolean test(IContext context) {
        return !ModConfig.vanillaOnly;
    }

    public static final IConditionSerializer<VanillaCondition> SERIALIZER = new IConditionSerializer<>() {
        @Override
        public void write(JsonObject json, VanillaCondition value) {
            // nothing
        }

        @Override
        public VanillaCondition read(JsonObject json) {
            return new VanillaCondition();
        }

        @Override
        public ResourceLocation getID() {
            return KEY;
        }
    };
}
