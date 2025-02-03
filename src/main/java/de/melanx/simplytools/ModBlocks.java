package de.melanx.simplytools;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockBehaviour;
import org.moddingx.libx.annotation.registration.RegisterClass;
import org.moddingx.libx.base.decoration.DecoratedBlock;
import org.moddingx.libx.base.decoration.DecorationContext;

@RegisterClass(registry = "BLOCK")
public class ModBlocks {

    public static final DecoratedBlock cleanEndStone = new DecoratedBlock(SimplyTools.getInstance(), DecorationContext.STONE, BlockBehaviour.Properties.ofFullCopy(Blocks.END_STONE).strength(4.0f, 11.0f));
}
