package de.melanx.simplytools;

import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.Material;
import org.moddingx.libx.annotation.registration.RegisterClass;
import org.moddingx.libx.base.decoration.DecoratedBlock;
import org.moddingx.libx.base.decoration.DecorationContext;

@RegisterClass(registry = "BLOCK_REGISTRY")
public class ModBlocks {

    public static final DecoratedBlock cleanEndStone = new DecoratedBlock(SimplyTools.getInstance(), DecorationContext.STONE, BlockBehaviour.Properties.of(Material.STONE).strength(4.0f, 11.0f));
}
