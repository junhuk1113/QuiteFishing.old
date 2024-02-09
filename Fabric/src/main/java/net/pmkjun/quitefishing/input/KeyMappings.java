package net.pmkjun.quitefishing.input;

import net.pmkjun.quitefishing.QuiteFishingClient;
import com.mojang.blaze3d.platform.InputConstants;
import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;

public class KeyMappings implements IKeyMappings {

    public static KeyMapping openSettingScreen = new KeyMapping(
            "key.dungeonhelper.open_dungeonhelper_settings",
            InputConstants.KEY_M,
            "key.dungeonhelper.category");


    @Override
    public void register() {
        Minecraft mc = Minecraft.getInstance();
        QuiteFishingClient client = QuiteFishingClient.getInstance();

        //register(openSettingScreen, () -> mc.setScreen(client.getSettingsScreen()));
    }

    private void register(KeyMapping keyMapping, KeyBehavior behavior) {
        keyMapping = KeyBindingHelper.registerKeyBinding(keyMapping);

        KeyMapping finalKeyMapping = keyMapping;
        ClientTickEvents.END_CLIENT_TICK.register(m -> {
            while(finalKeyMapping.consumeClick()) {
                behavior.action();
            }
        });
    }

    interface KeyBehavior {
        void action();
    }
}
