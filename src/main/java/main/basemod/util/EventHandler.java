package main.basemod.util;

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
			BaseMod.logger.info(TextHelper.localize("info.basemod.console.config.refresh"));
		}
	}

}
