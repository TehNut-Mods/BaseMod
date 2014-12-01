package main.basemod.items;

/*
 * Class to register your blocks in.
 * The order that you list them here is the order they are registered.
 * Keep that in mind if you like nicely organized creative tabs.
 */

import main.basemod.util.InventoryRender;
import net.minecraft.item.Item;
import net.minecraftforge.fml.common.registry.GameRegistry;

public class ItemRegistry {

	// Items
	public static Item quisqueLapis;
	public static Item baseBook;

	public static void registerItems() {
		quisqueLapis = new ItemQuisqueLapis();
		GameRegistry.registerItem(quisqueLapis, "ItemQuisqueLapis");

		baseBook = new ItemBaseBook();
		GameRegistry.registerItem(baseBook, "ItemBaseBook");
	}

	public static void registerInventoryRender() {
		InventoryRender.inventoryItemRender(baseBook, 0, "ItemBaseBook");
		InventoryRender.inventoryItemRender(baseBook, 1, "ItemBaseBook");
		InventoryRender.inventoryItemRender(quisqueLapis, "ItemQuisqueLapis");
	}
}
