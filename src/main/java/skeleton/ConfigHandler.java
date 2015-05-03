package skeleton;

import net.minecraftforge.common.config.Configuration;

import java.io.File;

public class ConfigHandler {

    public static Configuration config;

    public static boolean enableLogging;

    public static void init(File file) {
        config = new Configuration(file);
        syncConfig();
    }

    public static void syncConfig() {

        enableLogging = config.get(Configuration.CATEGORY_GENERAL, "enableLogging", true, "Enables console logging for extra information.").getBoolean();

        config.save();
    }
}
