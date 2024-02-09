package net.pmkjun.quitefishing;

import com.mojang.logging.LogUtils;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.pmkjun.quitefishing.QuiteFishingClient;
import net.pmkjun.quitefishing.input.KeyMappings;
import org.slf4j.Logger;

@Mod(QuiteFishing.MODID)
public class QuiteFishing {
    public static final String MODID = "quitefishing";
    public static final Logger LOGGER = LogUtils.getLogger();

    public QuiteFishingClient client;

    public QuiteFishing(){
        IEventBus eventBus = FMLJavaModLoadingContext.get().getModEventBus();

        KeyMappings keyMapping = new KeyMappings();
        keyMapping.register();

        client = new QuiteFishingClient(keyMapping);
        client.init();
    }
}
