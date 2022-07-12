package de.melanx.simplytools;

import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.util.BlockBreaker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void onAnvilUpdate(AnvilUpdateEvent event) {
        if (event.getLeft().getItem() instanceof BaseTool) {
            ItemStack addition = event.getRight();
            ItemStack output = event.getLeft().copy();
            if (!output.getItem().isValidRepairItem(event.getLeft(), addition)) {
                return;
            }

            int damageReduction = Math.min(output.getDamageValue(), output.getMaxDamage() / 7);
            if (damageReduction <= 0) {
                event.setOutput(ItemStack.EMPTY);
                event.setCost(0);
                return;
            }

            for (int i = 0; damageReduction > 0 && i < event.getRight().getCount(); ++i) {
                int durability = output.getDamageValue() - damageReduction;
                output.setDamageValue(durability);

                damageReduction = Math.min(output.getDamageValue(), output.getMaxDamage() / 7);
            }

            event.setOutput(output);
        }
    }

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() instanceof ServerPlayer player && player.getMainHandItem().getItem() instanceof BaseTool && BlockBreaker.canMine(player)) {
            BlockState state = player.level.getBlockState(event.getPos());
            if (player.isShiftKeyDown() || !player.getMainHandItem().isCorrectToolForDrops(state)) {
                return;
            }

            float originalDestroySpeed = state.getDestroySpeed(player.level, event.getPos());
            BlockBreaker.mine(player.level, player, event.getPos(), 1, (breakState, breakLevel, breakPos) -> {
                float destroySpeed = breakState.getDestroySpeed(breakLevel, breakPos);
                boolean isEffective = player.getMainHandItem().isCorrectToolForDrops(breakState);
                boolean verifyHardness = destroySpeed < originalDestroySpeed * 5 && destroySpeed > 0;
                return isEffective && verifyHardness;
            });
        }
    }
}
