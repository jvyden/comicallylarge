package exposed.jvyden.comicallylarge;

import exposed.jvyden.comicallylarge.entities.EntityIceCream;
import exposed.jvyden.comicallylarge.items.IceCreamItem;
import exposed.jvyden.comicallylarge.items.SpoonItem;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.client.renderer.entity.RenderSnowball;
import net.minecraft.entity.Entity;
import net.minecraft.item.Item;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.fml.client.registry.IRenderFactory;
import net.minecraftforge.fml.client.registry.RenderingRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.EntityRegistry;

import java.util.Objects;

@Mod.EventBusSubscriber(modid=ComicallyLarge.MOD_ID)
public class ItemHandler {
    public static Item spoonItem;
    public static Item iceCreamItem;

    private static final Minecraft mc = Minecraft.getMinecraft();

    public static void init() {
        spoonItem = new SpoonItem("spoon");
        iceCreamItem = new IceCreamItem("ice_cream");

        RenderingRegistry.registerEntityRenderingHandler(EntityIceCream.class, (IRenderFactory<Entity>) manager ->
                new RenderSnowball<>(manager, iceCreamItem, mc.getRenderItem()));

        EntityRegistry.registerModEntity(new ResourceLocation(ComicallyLarge.MOD_ID+":ice_cream"), EntityIceCream.class, "ice_cream", 0, ComicallyLarge.INSTANCE, 80, 1, true);

//        RenderingRegistry.registerEntityRenderingHandler(EntityIceCream.class, new RenderSnowball<>(mc.getRenderManager(), iceCreamItem, mc.getRenderItem()));
//                       this.entityRenderMap.put(EntitySnowball.class, new RenderSnowball  (this,                  Items.SNOWBALL, itemRendererIn));
    }

    @SubscribeEvent
    public static void registerItems(RegistryEvent.Register<Item> event) {
        event.getRegistry().registerAll(spoonItem, iceCreamItem);
    }

    @SubscribeEvent
    public static void registerRenders(ModelRegistryEvent event) {
        registerRender(spoonItem);
        registerRender(iceCreamItem);
    }

    private static void registerRender(Item item) {
        ModelLoader.setCustomModelResourceLocation(item, 0, new ModelResourceLocation(Objects.requireNonNull(item.getRegistryName()), "inventory"));
    }
}
