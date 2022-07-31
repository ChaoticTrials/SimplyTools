package de.melanx.simplytools.data;

import de.melanx.morevanillalib.data.ModTags;
import de.melanx.simplytools.items.BaseTool;
import net.minecraft.data.DataGenerator;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.base.decoration.DecoratedBlock;
import org.moddingx.libx.base.decoration.DecorationContext;
import org.moddingx.libx.base.decoration.DecorationType;
import org.moddingx.libx.datagen.provider.CommonTagsProviderBase;
import org.moddingx.libx.mod.ModX;

@Datagen
public class ToolTags extends CommonTagsProviderBase {

    public ToolTags(ModX mod, DataGenerator generator, ExistingFileHelper fileHelper) {
        super(mod, generator, fileHelper);
    }

    @Override
    public void setup() {
        // NO-OP
    }

    @Override
    public void defaultItemTags(Item item) {
        if (item instanceof BaseTool tool) {
            switch (tool.getTier()) {
                case WOODEN -> this.item(ModTags.Items.WOOD_TOOLS).add(item);
                case STONE -> this.item(ModTags.Items.STONE_TOOLS).add(item);
                case IRON -> this.item(ModTags.Items.IRON_TOOLS).add(item);
                case GOLDEN -> this.item(ModTags.Items.GOLD_TOOLS).add(item);
                case DIAMOND -> this.item(ModTags.Items.DIAMOND_TOOLS).add(item);
                case NETHERITE -> this.item(ModTags.Items.NETHERITE_TOOLS).add(item);

                case BONE -> this.item(ModTags.Items.BONE_TOOLS).add(item);
                case COAL -> this.item(ModTags.Items.COAL_TOOLS).add(item);
                case COPPER -> this.item(ModTags.Items.COPPER_TOOLS).add(item);
                case EMERALD -> this.item(ModTags.Items.EMERALD_TOOLS).add(item);
                case ENDER -> this.item(ModTags.Items.ENDER_TOOLS).add(item);
                case FIERY -> this.item(ModTags.Items.FIERY_TOOLS).add(item);
                case GLOWSTONE -> this.item(ModTags.Items.GLOWSTONE_TOOLS).add(item);
                case LAPIS -> this.item(ModTags.Items.LAPIS_TOOLS).add(item);
                case NETHER -> this.item(ModTags.Items.NETHER_TOOLS).add(item);
                case OBSIDIAN -> this.item(ModTags.Items.OBSIDIAN_TOOLS).add(item);
                case PAPER -> this.item(ModTags.Items.PAPER_TOOLS).add(item);
                case PRISMARINE -> this.item(ModTags.Items.PRISMARINE_TOOLS).add(item);
                case QUARTZ -> this.item(ModTags.Items.QUARTZ_TOOLS).add(item);
                case REDSTONE -> this.item(ModTags.Items.REDSTONE_TOOLS).add(item);
                case SLIME -> this.item(ModTags.Items.SLIME_TOOLS).add(item);
            }
        }
    }

    @Override
    public void defaultBlockTags(Block block) {
        if (block instanceof DecoratedBlock decoBlock) {
            TagKey<Block> tagKey = null;
            if (decoBlock.getContext() == DecorationContext.STONE) {
                tagKey = BlockTags.MINEABLE_WITH_PICKAXE;
            } else if (decoBlock.getContext() == DecorationContext.PLANKS) {
                tagKey = BlockTags.MINEABLE_WITH_AXE;
            }

            if (tagKey != null) {
                for (DecorationType<?> type : decoBlock.getContext().types()) {
                    if (decoBlock.get(type) instanceof Block subBlock) {
                        this.block(tagKey).add(subBlock);
                    }
                }
            }
        }
    }
}
