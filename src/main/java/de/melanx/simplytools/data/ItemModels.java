package de.melanx.simplytools.data;

import de.melanx.simplytools.items.BaseTool;
import net.minecraft.data.DataGenerator;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.moddingx.libx.annotation.data.Datagen;
import org.moddingx.libx.datagen.provider.ItemModelProviderBase;
import org.moddingx.libx.mod.ModX;

@Datagen
public class ItemModels extends ItemModelProviderBase {

    public ItemModels(ModX mod, DataGenerator generator, ExistingFileHelper fileHelper) {
        super(mod, generator, fileHelper);
    }

    @Override
    protected void setup() {
        // NO-OP
    }

    @Override
    protected void defaultItem(ResourceLocation id, Item item) {
        if (item instanceof BaseTool) {
            this.withExistingParent(id.getPath(), HANDHELD).texture("layer0", new ResourceLocation(id.getNamespace(), "item/" + id.getPath()));
        } else {
            super.defaultItem(id, item);
        }
    }
}
