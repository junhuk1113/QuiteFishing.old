package net.pmkjun.quitefishing.input;

import net.pmkjun.quitefishing.QuiteFishingClient;
import com.mojang.blaze3d.platform.InputConstants;
import net.minecraft.client.KeyMapping;
import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RegisterKeyMappingsEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.TickEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;

public class KeyMappings implements IKeyMappings {

    public static KeyMapping openSettingScreen = new KeyMapping(
            "key.dungeonhelper.open_dungeonhelper_settings",
            InputConstants.KEY_M,
            "key.dungeonhelper.category");

    @Override
    public void register() {
        MinecraftForge.EVENT_BUS.register(this);
        FMLJavaModLoadingContext.get().getModEventBus().addListener(KeyMappings::registerKeyBindings);
    }

    public static void registerKeyBindings(RegisterKeyMappingsEvent event) {
        event.register(openSettingScreen);
    }

    @SubscribeEvent
    public void onClientTick(TickEvent.ClientTickEvent event) {
        Minecraft mc = Minecraft.getInstance();
        QuiteFishingClient client = QuiteFishingClient.getInstance();

        if(event.phase == TickEvent.Phase.END) {
            while(openSettingScreen.consumeClick()) {
                //mc.setScreen(client.getSettingsScreen());
            }
        }
    }
}
