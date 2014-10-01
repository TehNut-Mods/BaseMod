package main.basemod.items;

/*
 * Class to register your blocks in.
 * The order that you list them here is the order they are registered.
 * Keep that in mind if you like nicely organized creative tabs.
 */

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegistry {

	//items
	public static Item quisqueLapis;
	public static Item baseBook;

	// I use multiple sections here to sort things. It's just my system, you don't have to.
	// Just delete "registerItemSet2" and "registerAllItems" then make this public. Make sure to change the call in the main class.

	private static void registerItemSet1() {
		quisqueLapis = new ItemLapisQuisque();
		GameRegistry.registerItem(quisqueLapis, "ItemLapisQuisque");

		baseBook = new ItemBaseBook();
		GameRegistry.registerItem(baseBook, "ItemBaseBook");
	}

	private static void registerItemSet2() {

	}

	public static void registerAllItems() {
		registerItemSet1();
		registerItemSet2();
	}
}
