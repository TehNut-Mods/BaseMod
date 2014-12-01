package main.basemod;

/*
 * Check all the classes for (hopefully) detailed descriptions of what it does. There will also be tidbits of comments throughout the codebase.
 * If you wish to add a description to a class, or extend/change an existing one, submit a PR with your changes.
 */


import main.basemod.blocks.BlockRecipeRegistry;
import main.basemod.blocks.BlockRegistry;
import main.basemod.client.gui.CreativeTabBaseMod;
import main.basemod.client.gui.GuiHandler;
import main.basemod.items.ItemRecipeRegistry;
import main.basemod.items.ItemRegistry;
import main.basemod.proxies.CommonProxy;
import main.basemod.util.EventHandler;
import main.basemod.util.GenerationHandler;
import main.basemod.util.OreDictHandler;
import main.basemod.util.TextHelper;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.network.NetworkRegistry;
import net.minecraftforge.fml.common.registry.GameRegistry;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@Mod(modid = ModInformation.ID, name = ModInformation.NAME, version = ModInformation.VERSION, dependencies = ModInformation.DEPEND, guiFactory = ModInformation.GUIFACTORY)
public class BaseMod {

	@SidedProxy(clientSide = ModInformation.CLIENTPROXY, serverSide = ModInformation.COMMONPROXY)
	public static CommonProxy proxy;

	public static CreativeTabs tabBaseMod = new CreativeTabBaseMod(ModInformation.ID + ".creativeTab");
	public static Logger logger = LogManager.getLogger(ModInformation.NAME);

	@Mod.Instance
	public static BaseMod instance;

	@Mod.EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.preInit"));

		ConfigHandler.init(event.getSuggestedConfigurationFile());

		ItemRegistry.registerItems();
		BlockRegistry.registerBlocks();

		OreDictHandler.registerOreDict();
		FMLCommonHandler.instance().bus().register(new EventHandler());
		NetworkRegistry.INSTANCE.registerGuiHandler(instance, new GuiHandler());

		GameRegistry.registerWorldGenerator(new GenerationHandler(), 2);
	}

	@Mod.EventHandler
	public void init(FMLInitializationEvent event) {
		logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.init"));

		ItemRecipeRegistry.registerItemRecipes();
		BlockRecipeRegistry.registerBlockRecipes();

		BlockRegistry.registerInventoryRender();
		ItemRegistry.registerInventoryRender();
	}

	@Mod.EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		logger.info(TextHelper.localize("info." + ModInformation.ID + ".console.load.postInit"));
	}
}
