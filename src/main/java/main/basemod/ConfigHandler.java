package main.basemod;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler {

	//sections
	public static String exampleSection= "Example Section";

	//options
	public static boolean exampleOption;

	public static void init(Configuration config) {
		config.load();

		exampleOption = config.get(exampleSection, "exampleOption", true, "Description of option goes here.").getBoolean(exampleOption);

		if(config.hasChanged()) {
			config.save();
		}
	}
}
