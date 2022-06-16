package de.melanx.simplytools.util;

import de.melanx.simplytools.SimplyTools;
import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;

public class ComponentUtil {

    public static MutableComponent getTooltip(String s, Object... replacements) {
        return Component.translatable("tooltip." + SimplyTools.getInstance().modid + "." + s, replacements);
    }
}
