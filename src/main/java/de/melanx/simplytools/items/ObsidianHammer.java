package de.melanx.simplytools.items;

import de.melanx.simplytools.ToolMaterials;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;

import javax.annotation.Nonnull;

public class ObsidianHammer extends BaseTool {

    public ObsidianHammer(float attackDamageModifier, float attackSpeedModifier, Properties properties) {
        super(attackDamageModifier, attackSpeedModifier, ToolMaterials.OBSIDIAN, BlockTags.MINEABLE_WITH_PICKAXE, properties);
    }

    @Override
    public float getDestroySpeed(@Nonnull ItemStack stack, @Nonnull BlockState state) {
        if (state.getBlock() == Blocks.OBSIDIAN) {
            int efficiencyLevel = stack.getEnchantmentLevel(Enchantments.BLOCK_EFFICIENCY);
            return 5.0F * (efficiencyLevel / 3.5F + 1);
        } else {
            return super.getDestroySpeed(stack, state);
        }
    }
}
