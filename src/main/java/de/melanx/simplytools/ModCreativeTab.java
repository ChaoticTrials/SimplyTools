package de.melanx.simplytools;

import de.melanx.simplytools.config.ModConfig;
import de.melanx.simplytools.items.BaseTool;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import org.moddingx.libx.annotation.registration.RegisterClass;

@RegisterClass(registry = "CREATIVE_MODE_TAB")
public class ModCreativeTab {

    public static final CreativeModeTab simplytoolsTab = CreativeModeTab.builder()
            .title(Component.literal("Simply Tools"))
            .icon(() -> new ItemStack(ModItems.redstoneHammer))
            .displayItems((enabledFlags, output) -> {
                for (Item item : BuiltInRegistries.ITEM) {
                    if (SimplyTools.getInstance().modid.equals(BuiltInRegistries.ITEM.getKey(item).getNamespace())) {
                        if (!(item instanceof BaseTool tool) || (!tool.isVanilla() && ModConfig.vanillaOnly)) {
                            continue;
                        }

                        output.accept(new ItemStack(item));
                    }
                }
            })
            .build();
}
