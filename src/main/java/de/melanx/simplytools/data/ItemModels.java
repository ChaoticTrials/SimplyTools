package de.melanx.simplytools.data;

import de.melanx.simplytools.items.BaseTool;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import org.moddingx.libx.datagen.DatagenContext;
import org.moddingx.libx.datagen.provider.model.ItemModelProviderBase;

public class ItemModels extends ItemModelProviderBase {

    public ItemModels(DatagenContext context) {
        super(context);
    }

    @Override
    protected void setup() {
        // NO-OP
    }

    @Override
    protected void defaultItem(ResourceLocation id, Item item) {
        if (item instanceof BaseTool) {
            this.withExistingParent(id.getPath(), HANDHELD).texture("layer0", ResourceLocation.fromNamespaceAndPath(id.getNamespace(), "item/" + id.getPath()));
        } else {
            super.defaultItem(id, item);
        }
    }
}
