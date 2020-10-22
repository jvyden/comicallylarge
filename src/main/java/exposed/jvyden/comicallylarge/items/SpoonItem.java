package exposed.jvyden.comicallylarge.items;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class SpoonItem extends Item {
    public SpoonItem(String name) {
        this.setRegistryName(name);
        this.setTranslationKey(name);
        this.setCreativeTab(CreativeTabs.TOOLS);
        this.setMaxStackSize(1);
    }
}
