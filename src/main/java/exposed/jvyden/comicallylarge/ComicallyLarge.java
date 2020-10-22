package exposed.jvyden.comicallylarge;

import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.Mod;
import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

@Mod(
        modid = ComicallyLarge.MOD_ID,
        name = ComicallyLarge.MOD_NAME,
        version = ComicallyLarge.VERSION
)
public class ComicallyLarge {

    public static final String MOD_ID = BuildInfo.MAVEN_NAME;
    public static final String MOD_NAME = "The Comically Large Spoon";
    public static final String VERSION = BuildInfo.VERSION;

    public static Logger logger;

    @Mod.Instance(MOD_ID)
    public static ComicallyLarge INSTANCE;

    @Mod.EventHandler
    public void preinit(FMLPreInitializationEvent event) {
        logger = event.getModLog();

        ItemHandler.init();
        logger.log(Level.INFO, "Dawg, can I get some ice cream?");
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        logger.log(Level.INFO, "Only a spoonful!");
    }

    @Mod.EventHandler
    public void postinit(FMLPostInitializationEvent event) {
        logger.log(Level.INFO, "As we can see, King Bach has presented a rather large spoon to his friend. " +
                "The humor stems from the fact that King Bach would like to eat some ice cream but his friend resorts at" +
                " him, saying he can only have a spoonful and nothing more. Bach then suddenly changes his expression " +
                "and body language that he is in possession of a spoon. And not just any spoon, it is a massive " +
                "stainless steel spoon. This is funny because you would never expect someone to be in possession of a " +
                "massive spoon to eat ice cream with. It is completely unorthodox and uncalled for. " +
                "This is why the video is on the 2012 epic vine compilation on YouTube.");
    }
}
