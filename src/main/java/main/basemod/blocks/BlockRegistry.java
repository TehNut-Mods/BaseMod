package main.basemod.blocks;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;

public class BlockRegistry {

	//blocks
	public static Block quisqueLapisBlock;
	public static Block quisqueLapisOre;

	private static void registerBlockSet1() {
		//I use multiple sections here to sort things. It's just my system, you don't have to. Just delete "registerBlockSet2" and "registerAllBlocks" then make this public. Make sure to change the call in the main class.
		quisqueLapisOre = new BlockOreQuisqueLapis();
		GameRegistry.registerBlock(quisqueLapisOre, "BlockOreQuisqueLapis");

		quisqueLapisBlock = new BlockLapisQuisque();
		GameRegistry.registerBlock(quisqueLapisBlock, "BlockQuisqueLapis");
	}

	private static void registerBlockSet2() {

	}

	public static void registerAllBlocks() {
		registerBlockSet1();
		registerBlockSet2();
	}

}
