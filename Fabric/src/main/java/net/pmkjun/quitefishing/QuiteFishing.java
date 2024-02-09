package net.pmkjun.quitefishing;

import net.pmkjun.quitefishing.input.KeyMappings;
import com.mojang.logging.LogUtils;
import net.fabricmc.api.ModInitializer;
import org.slf4j.Logger;

public class QuiteFishing implements ModInitializer {

    public static final String MODID = "quitefishing";
    public static final Logger LOGGER = LogUtils.getLogger();

    public QuiteFishingClient client;

    @Override
    public void onInitialize() {
        KeyMappings keyMappings = new KeyMappings();

        client = new QuiteFishingClient(keyMappings);
        client.init();

        keyMappings.register();
    }
}
