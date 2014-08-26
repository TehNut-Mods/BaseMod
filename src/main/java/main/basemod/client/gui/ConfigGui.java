package main.basemod.client.gui;

//Creates a config GUI for your mod. This requires a working mcmod.info file to work. These are dummy sections that don't do anything.

import cpw.mods.fml.client.config.DummyConfigElement.DummyCategoryElement;
import cpw.mods.fml.client.config.GuiConfig;
import cpw.mods.fml.client.config.GuiConfigEntries;
import cpw.mods.fml.client.config.IConfigElement;
import main.basemod.BaseMod;
import main.basemod.ConfigHandler;
import main.basemod.ModInformation;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.resources.I18n;
import net.minecraftforge.common.config.ConfigElement;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ConfigGui extends GuiConfig {

	private static Map<Class<? extends BaseModEntry>, String> sections = new HashMap<Class<? extends BaseModEntry>, String>();

	public ConfigGui(GuiScreen parentScreen) {
		super(parentScreen, getConfigElements(), "Forge", false, false, I18n.format("info.basemod.config.title"));
	}

	private static List<IConfigElement> getConfigElements() {
		sections.put(ExampleEntry.class, ConfigHandler.exampleSection);
		sections.put(GenerationEntry.class, ConfigHandler.generation);

		List<IConfigElement> list = new ArrayList<IConfigElement>();
		list.add(new DummyCategoryElement(sections.get(ExampleEntry.class), "info.basemod.config.section.example", ExampleEntry.class));
		list.add(new DummyCategoryElement(sections.get(GenerationEntry.class), "info.basemod.config.section.generation", GenerationEntry.class));


		return list;
	}

	private static class BaseModEntry extends GuiConfigEntries.CategoryEntry {

		public BaseModEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
			super(owningScreen, owningEntryList, configElement);
		}

		@Override
		protected GuiScreen buildChildScreen() {
			String category = sections.get(this.getClass());
			return new GuiConfig(this.owningScreen, (new ConfigElement(BaseMod.config.getCategory(category.toLowerCase()))).getChildElements(), ModInformation.ID, category, this.configElement.requiresWorldRestart() || this.owningScreen.allRequireWorldRestart, this.configElement.requiresMcRestart() || this.owningScreen.allRequireMcRestart, GuiConfig.getAbridgedConfigPath(BaseMod.config.getConfigFile().getAbsolutePath()));
		}
	}

	public static class ExampleEntry extends BaseModEntry {

		public ExampleEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
			super(owningScreen, owningEntryList, configElement);
		}
	}

	public static class GenerationEntry extends BaseModEntry {

		public GenerationEntry(GuiConfig owningScreen, GuiConfigEntries owningEntryList, IConfigElement configElement) {
			super(owningScreen, owningEntryList, configElement);
		}
	}
}