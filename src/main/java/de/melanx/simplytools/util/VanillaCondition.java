package de.melanx.simplytools.util;

import com.mojang.serialization.MapCodec;
import de.melanx.simplytools.config.ModConfig;
import net.neoforged.neoforge.common.conditions.ICondition;

import javax.annotation.Nonnull;

public class VanillaCondition implements ICondition {

    public static final VanillaCondition INSTANCE = new VanillaCondition();

    public static MapCodec<VanillaCondition> CODEC = MapCodec.unit(INSTANCE).stable();

    @Override
    public boolean test(@Nonnull IContext context) {
        return !ModConfig.vanillaOnly;
    }

    @Nonnull
    @Override
    public MapCodec<? extends ICondition> codec() {
        return CODEC;
    }
}
