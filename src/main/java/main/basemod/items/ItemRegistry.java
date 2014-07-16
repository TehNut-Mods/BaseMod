package main.basemod.items;

public class ItemRegistry {

	private static void registerItemSet1() {
		//I use multiple sections here to sort things. It's just my system, you don't have to. Just delete "registerItemSet2" and "registerAllItems" then make this public. Make sure to change the call in the main class.
	}

	private static void registerItemSet2() {

	}

	public static void registerAllItems() {
		registerItemSet1();
		registerItemSet2();
	}
}
