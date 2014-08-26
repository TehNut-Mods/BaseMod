package main.basemod.items;

//General place to register all items.

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;

public class ItemRegistry {

	//items
	public static Item quisqueLapis;
	public static Item baseBook;

	private static void registerItemSet1() {
		//I use multiple sections here to sort things. It's just my system, you don't have to. Just delete "registerItemSet2" and "registerAllItems" then make this public. Make sure to change the call in the main class.
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
