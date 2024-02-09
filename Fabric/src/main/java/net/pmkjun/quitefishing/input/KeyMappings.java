package net.pmkjun.quitefishing.input;

import net.fabricmc.fabric.api.client.event.lifecycle.v1.ClientTickEvents;
import net.fabricmc.fabric.api.client.keybinding.v1.KeyBindingHelper;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.option.KeyBinding;
import net.pmkjun.quitefishing.QuiteFishingClient;

public class KeyMappings implements IKeyMappings {
        public static KeyBinding openSettingScreen = new KeyBinding("fishhelper.key.open_settings", 74, "fishhelper.key.category");

    public void register() {
        MinecraftClient mc = MinecraftClient.getInstance();
        QuiteFishingClient client = QuiteFishingClient.getInstance();
        //register(openSettingScreen, () -> mc.setScreen((Screen)new ConfigScreen(mc.currentScreen)));
    }

    private void register(KeyBinding keyMapping, KeyBehavior behavior) {
        keyMapping = KeyBindingHelper.registerKeyBinding(keyMapping);
        KeyBinding finalKeyMapping = keyMapping;
        ClientTickEvents.END_CLIENT_TICK.register(m -> {
            while (finalKeyMapping.wasPressed())
                behavior.action();
        });
    }

    static interface KeyBehavior {
        void action();
    }
}