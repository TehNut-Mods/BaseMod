package main.basemod;

// Creation and usage of the config. Most if it is self explanatory.

import java.io.File;

import net.minecraftforge.common.config.Configuration;

public class ConfigHandler
{
    public static Configuration config;

    // sections to add to the config
    public static String exampleSection = "Example Section";
    public static String generation = "Generation";

    // options in the config
    public static boolean exampleOption;
    public static boolean enableGeneration;

    public static void init(File file)
    {
        config = new Configuration(file);

        syncConfig();
    }

    public static void syncConfig()
    {
        // Example category comment.
        config.addCustomCategoryComment(exampleSection, "Example section comment");
        config.addCustomCategoryComment(generation, "This section contains all settings regarding ore generation.");

        exampleOption = config.get(exampleSection, "exampleOption", true, "Description of option goes here.").getBoolean(exampleOption);
        enableGeneration = config.get(generation, "enableGeneration", true, "Enable Lapis Quisque generation").getBoolean(enableGeneration);

        config.save();
    }
}
