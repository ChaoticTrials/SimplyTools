package de.melanx.simplytools;

import com.mojang.serialization.MapCodec;
import de.melanx.simplytools.util.VanillaCondition;
import net.neoforged.neoforge.common.conditions.ICondition;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "CONDITION_CODECS")
public class ModConditionCodecs {

    public static final MapCodec<? extends ICondition> vanillaCondition = VanillaCondition.CODEC;
}
