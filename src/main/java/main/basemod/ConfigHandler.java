package main.basemod;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	//sections
	public static String exampleSection = "Example Section";
	public static String generation = "Generation";

	//options
	public static boolean exampleOption;
	public static boolean enableGeneration;

	public static void init(Configuration config) {
		config.load();

		exampleOption = config.get(exampleSection, "exampleOption", true, "Description of option goes here.").getBoolean(exampleOption);
		enableGeneration = config.get(generation, "enableGeneration", true, "Enable Lapis Quisque generation").getBoolean(enableGeneration);

		if(config.hasChanged()) {
			config.save();
		}
	}
}
