package exposed.jvyden.comicallylarge;

import exposed.jvyden.comicallylarge.items.SpoonItem;
import net.minecraft.item.Item;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ItemHandler {
    static Item spoonItem;

    public static void init() {
        spoonItem = new SpoonItem("spoon");
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(spoonItem);
    }
}
