package de.melanx.simplytools.util;

import de.melanx.simplytools.ModEnchantments;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.HitResult;
import net.minecraft.world.phys.Vec3;

import java.util.*;

public class BlockBreaker {

    private static final Set<UUID> CURRENTLY_MINING = new HashSet<>();

    public static void mine(Level level, ServerPlayer player, BlockPos originPos, int radius, BreakValidator breakValidator) {
        CURRENTLY_MINING.add(player.getGameProfile().getId());
        ItemStack tool = player.getMainHandItem();
        List<BlockPos> breakBlocks = BlockBreaker.getBreakBlocks(level, player, radius, EnchantmentHelper.getEnchantmentLevel(ModEnchantments.powerOfTheDepth, player), originPos);
        for (BlockPos pos : breakBlocks) {
            boolean canBreak = breakValidator.canBreak(level.getBlockState(pos), level, pos);
            if (canBreak && tool.isDamageableItem() && tool.getMaxDamage() - tool.getDamageValue() <= 0 && !player.isCreative()) {
                break;
            } else if (!canBreak) {
                continue;
            }

            player.gameMode.destroyBlock(pos);
        }
        CURRENTLY_MINING.remove(player.getGameProfile().getId());
    }

    public static boolean canMine(Player player) {
        return !CURRENTLY_MINING.contains(player.getGameProfile().getId());
    }

    protected static List<BlockPos> getBreakBlocks(Level level, Player player, int radius, int depth, BlockPos originPosition) {
        List<BlockPos> potentialBrokenBlocks = new ArrayList<>();

        Vec3 eyePosition = player.getEyePosition();
        Vec3 rotation = player.getViewVector(1);
        //noinspection ConstantConditions
        double reach = Math.max(player.getEntityReach(), player.getBlockReach());
        Vec3 combined = eyePosition.add(rotation.x * reach, rotation.y * reach, rotation.z * reach);

        BlockHitResult rayTraceResult = level.clip(new ClipContext(eyePosition, combined, ClipContext.Block.COLLIDER, ClipContext.Fluid.NONE, player));

        if (rayTraceResult.getType() == HitResult.Type.BLOCK) {
            Direction side = rayTraceResult.getDirection();

            boolean doX = side.getStepX() == 0;
            boolean doY = side.getStepY() == 0;
            boolean doZ = side.getStepZ() == 0;

            BlockPos begin = new BlockPos(doX ? -radius : 0, doY ? -radius : 0, doZ ? -radius : 0);
            BlockPos end = new BlockPos(doX ? radius : depth * -side.getStepX(), doY ? radius : depth * -side.getStepY(), doZ ? radius : depth * -side.getStepZ());

            BlockPos.betweenClosedStream(originPosition.offset(begin), originPosition.offset(end)).forEach(pos -> potentialBrokenBlocks.add(pos.immutable()));
        }

        return potentialBrokenBlocks;
    }

    public interface BreakValidator {

        boolean canBreak(BlockState state, Level level, BlockPos pos);
    }
}
