package de.melanx.simplytools;

import de.melanx.simplytools.items.BaseTool;
import de.melanx.simplytools.util.BlockBreaker;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.event.level.BlockEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void onBlockBreak(BlockEvent.BreakEvent event) {
        if (event.getPlayer() instanceof ServerPlayer player && player.getMainHandItem().getItem() instanceof BaseTool && BlockBreaker.canMine(player)) {
            BlockState state = player.level().getBlockState(event.getPos());
            if (player.isShiftKeyDown() || !player.getMainHandItem().isCorrectToolForDrops(state)) {
                return;
            }

            float originalDestroySpeed = state.getDestroySpeed(player.level(), event.getPos());
            BlockBreaker.mine(player.level(), player, event.getPos(), 1, (breakState, breakLevel, breakPos) -> {
                float destroySpeed = breakState.getDestroySpeed(breakLevel, breakPos);
                boolean isEffective = player.getMainHandItem().isCorrectToolForDrops(breakState);
                boolean verifyHardness = destroySpeed < originalDestroySpeed * 5 && destroySpeed > 0;
                return isEffective && verifyHardness;
            });
            event.setCanceled(true);
        }
    }
}
