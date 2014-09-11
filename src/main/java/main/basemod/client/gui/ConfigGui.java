package main.basemod.client.gui;

//Creates a config GUI for your mod. This requires a working mcmod.info file to work. These are dummy sections that don't do anything.

import cpw.mods.fml.client.config.DummyConfigElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import main.basemod.ConfigHandler;
import main.basemod.ModInformation;
import net.minecraft.client.gui.GuiScreen;
import net.minecraftforge.common.config.ConfigElement;
import net.minecraftforge.common.config.Configuration;

import java.util.ArrayList;
import java.util.List;

public class ConfigGui extends GuiConfig {

	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(), ModInformation.ID, false, false, GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
	}

	private static List<IConfigElement> getConfigElements() {
		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyConfigElement.DummyCategoryElement("Example Section", "info.basemod.config.section.generation", ExampleSectionEntry.class));
		list.add(new DummyConfigElement.DummyCategoryElement("Generation", "info.basemod.config.section.example", GenerationEntry.class));
		return list;
	}

	@SuppressWarnings("unchecked")
	public static class ExampleSectionEntry extends GuiConfigEntries.CategoryEntry {
		public ExampleSectionEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
			super(owningScreen, owningEntryList, prop);
		}

		@Override
		protected GuiScreen buildChildScreen() {
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(ConfigHandler.config.getCategory(ConfigHandler.exampleSection))).getChildElements(),
					this.owningScreen.modID, Configuration.CATEGORY_GENERAL, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
					GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
		}
	}

	@SuppressWarnings("unchecked")
	public static class GenerationEntry extends GuiConfigEntries.CategoryEntry {
		public GenerationEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement prop) {
			super(owningScreen, owningEntryList, prop);
		}

		@Override
		protected GuiScreen buildChildScreen() {
			return new GuiConfig(this.owningScreen,
					(new ConfigElement(ConfigHandler.config.getCategory(ConfigHandler.generation))).getChildElements(),
					this.owningScreen.modID, Configuration.CATEGORY_GENERAL, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart,
					this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart,
					GuiConfig.getAbridgedConfigPath(ConfigHandler.config.toString()));
		}
	}
}