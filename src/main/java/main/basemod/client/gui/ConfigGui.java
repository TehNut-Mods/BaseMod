package main.basemod.client.gui;

/*
 * Creates a config GUI for your mod. This requires an mcmod.info file with the correct modid. These are dummy sections that don't do anything.
 */

import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.IConfigElement;
import main.basemod.ModInformation;
import main.basemod.util.TextHelper;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigCategory;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.List;

import static main.basemod.ConfigHandler.*;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(parentScreen), ModInformation.ID, false, false, TextHelper.localize("gui." + ModInformation.ID + ".config.title"));
	}

	@SuppressWarnings("rawtypes")
	private static List<IConfigElement> getConfigElements(GuiScreen parent) {
		List<IConfigElement> list = new ArrayList<IConfigElement>();

		// adds sections declared in ConfigHandler. toLowerCase() is used because the configuration class automatically does this, so must we.
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(exampleSection.toLowerCase())));
		list.add(new ConfigElement<ConfigCategory>(config.getCategory(generation.toLowerCase())));

		return list;
	}
}