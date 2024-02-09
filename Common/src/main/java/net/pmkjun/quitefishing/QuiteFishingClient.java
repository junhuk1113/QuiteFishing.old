package net.pmkjun.quitefishing;

import net.pmkjun.quitefishing.input.IKeyMappings;
import net.minecraft.client.Minecraft;

public class QuiteFishingClient {

    private Minecraft mc;
    private static QuiteFishingClient instance;

    private IKeyMappings keyMappings;

    public QuiteFishingClient(IKeyMappings keyMappings) {
        instance = this;

        this.keyMappings = keyMappings;
    }

    public void init() {

    }

    public static QuiteFishingClient getInstance(){
        return instance;
    }
}