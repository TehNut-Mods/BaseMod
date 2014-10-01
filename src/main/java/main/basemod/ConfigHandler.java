package main.basemod;

/*
 * Creation and usage of the config file.
 */

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

	public static Configuration config;

	// Sections to add to the config
	public static String exampleSection = "Example Section";
	public static String generation = "Generation";

	// Options in the config
	public static boolean exampleOption;
	public static boolean enableGeneration;

	public static void init(File file) {
		config = new Configuration(file);
		syncConfig();
	}

	public static void syncConfig() {
		config.addCustomCategoryComment(exampleSection, "Example section comment");
		config.addCustomCategoryComment(generation, "This section contains all settings regarding ore generation.");

		exampleOption = config.get(exampleSection, "exampleOption", true, "Description of option goes here.").getBoolean(exampleOption);
		enableGeneration = config.get(generation, "enableGeneration", true, "Enable Lapis Quisque generation").getBoolean(enableGeneration);

		config.save();
	}
}
