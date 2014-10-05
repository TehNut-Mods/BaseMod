package main.basemod.util;

/*
 * Class for most of your events to be registered in.
 * Remember that there are two different registries for Events. This one will not work for everything.
 */

import cpw.mods.fml.client.event.ConfigChangedEvent;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import main.basemod.BaseMod;
import main.basemod.ConfigHandler;
import main.basemod.ModInformation;

public class EventHandler {

	@SubscribeEvent
	public void onConfigChanged(ConfigChangedEvent.OnConfigChangedEvent eventArgs) {
		if (eventArgs.modID.equals(ModInformation.ID)) {
			ConfigHandler.syncConfig();
			BaseMod.logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.config.refresh"));
		}
	}
}
