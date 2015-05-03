package main.basemod.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import main.basemod.BaseMod;
import main.basemod.ConfigHandler;
import main.basemod.ModInformation;
import net.minecraftforge.fml.client.event.ConfigChangedEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EventHandler {

    @SubscribeEvent
    public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
        if (eventArgs.modID.equals(ModInformation.ID)) {
            ConfigHandler.syncConfig();
            BaseMod.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
        }
    }
}
