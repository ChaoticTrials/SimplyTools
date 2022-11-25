package de.melanx.simplytools.items;

import de.melanx.simplytools.util.ComponentUtil;
import net.minecraft.ChatFormatting;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.fml.ModList;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.List;

public class DummyItem extends Item {

    public static final Tier DUMMY_TIER = new Tier() {
        @Override
        public int getUses() {
            return -1;
        }

        @Override
        public float getSpeed() {
            return -1;
        }

        @Override
        public float getAttackDamageBonus() {
            return -1;
        }

        @Override
        public int getLevel() {
            return -1;
        }

        @Override
        public int getEnchantmentValue() {
            return -1;
        }

        @Nonnull
        @Override
        public Ingredient getRepairIngredient() {
            return Ingredient.EMPTY;
        }
    };

    private final List<String> missingMods;

    public DummyItem(String modid) {
        this(List.of(modid));
    }

    public DummyItem(@Nonnull List<String> modid) {
        super(new Properties());
        this.missingMods = modid;
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        return 0.0F;
    }

    @Override
    public void appendHoverText(@Nonnull ItemStack stack, @Nullable Level level, @Nonnull List<Component> tooltip, @Nonnull TooltipFlag isAdvanced) {
        if (!this.missingMods.isEmpty()) {
            tooltip.add(ComponentUtil.getTooltip("compat.not_loaded_list").withStyle(ChatFormatting.RED));
            for (String modid : this.missingMods) {
                if (!ModList.get().isLoaded(modid)) {
                    tooltip.add(Component.literal("- " + modid).withStyle(ChatFormatting.RED));
                }
            }
        }

        super.appendHoverText(stack, level, tooltip, isAdvanced);
    }
}
