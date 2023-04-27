package de.melanx.simplytools.data;

import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.loot.BlockLootProviderBase;

public class BlockLoot extends BlockLootProviderBase {

    public BlockLoot(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        // NO-OP
    }
}
