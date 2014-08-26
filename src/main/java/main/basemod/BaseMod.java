package main.basemod;

//Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
//If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkRegistry;
import cpw.mods.fml.common.registry.GameRegistry;
import main.basemod.blocks.BlockRecipeRegistry;
import main.basemod.blocks.BlockRegistry;
import main.basemod.client.gui.CreativeTabBaseMod;
import main.basemod.client.gui.GuiHandler;
import main.basemod.items.ItemRecipeRegistry;
import main.basemod.items.ItemRegistry;
import main.basemod.proxies.CommonProxy;
import main.basemod.util.GenerationHandler;
import main.basemod.util.OreDictHandler;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.config.Configuration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, guiFactory = "main.basemod.client.gui.ConfigGuiFactory")
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
		logger.info("Begin Pre-initialization");

		config = new Configuration(event.getSuggestedConfigurationFile());
		ConfigHandler.init(config);

		ItemRegistry.registerAllItems();
		BlockRegistry.registerAllBlocks();

		OreDictHandler.registerOreDict();

		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());
		GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
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
