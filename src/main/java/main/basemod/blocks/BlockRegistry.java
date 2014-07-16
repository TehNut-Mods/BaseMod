package main.basemod.blocks;

public class BlockRegistry {

	private static void registerBlockSet1() {
		//I use multiple sections here to sort things. It's just my system, you don't have to. Just delete "registerBlockSet2" and "registerAllBlocks" then make this public. Make sure to change the call in the main class.
	}

	private static void registerBlockSet2() {

	}

	public static void registerAllBlocks() {
		registerBlockSet1();
		registerBlockSet2();
	}

}
