package skeleton.util;

import skeleton.ConfigHandler;
import skeleton.ModInformation;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class LogHelper {

    private static Logger logger = LogManager.getLogger(ModInformation.NAME);

    public static void info(Object info) {
        if (ConfigHandler.enableLogging)
            logger.info(info);
    }

    public static void error(Object error) {
        if (ConfigHandler.enableLogging)
            logger.error(error);
    }

    public static void debug(Object debug) {
        if (ConfigHandler.enableLogging)
            logger.debug(debug);
    }

    public static void fatal(Object fatal) {
        if (ConfigHandler.enableLogging)
            logger.fatal(fatal);
    }

    public static void warn(Object warn) {
        if (ConfigHandler.enableLogging)
            logger.warn(warn);
    }
}
