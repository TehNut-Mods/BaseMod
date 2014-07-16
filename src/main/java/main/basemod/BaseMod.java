package main.basemod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import main.basemod.blocks.BlockRecipeRegistry;
import main.basemod.blocks.BlockRegistry;
import main.basemod.gui.CreativeTabBaseMod;
import main.basemod.items.ItemRecipeRegistry;
import main.basemod.items.ItemRegistry;
import main.basemod.proxies.CommonProxy;
import main.basemod.util.OreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, guiFactory = "main.basemod.gui.ConfigGuiFactory")
public class BaseMod {

	@SidedProxy(clientSide = "main.basemod.proxies.ClientProxy", serverSide = "main.basemod.proxies.CommonProxy")
	public static CommonProxy proxy;

	public static CreativeTabs tabBaseMod = new CreativeTabBaseMod(ModInformation.ID + ".creativeTab");
	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static BaseMod instance;
	public static Configuration config;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigHandler.init(config);

		logger.info("Begin Pre-initialization");

		OreDictHandler.registerOreDict();

		ItemRegistry.registerAllItems();
		BlockRegistry.registerAllBlocks();
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info("Begin Initialization");

		ItemRecipeRegistry.registerItemRecipes();
		BlockRecipeRegistry.registerBlockRecipes();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info("Begin Post-initialization");
	}
}
