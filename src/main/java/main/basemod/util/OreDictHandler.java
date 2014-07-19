package main.basemod.util;

import main.basemod.blocks.BlockRegistry;
import main.basemod.items.ItemRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.OreDictionary;

public class OreDictHandler {

	//Oredict entries
	public static String powderBlaze = "powderBlaze";
	public static String quisqueLapis = "dustQuisqueLapis";
	public static String quisqueLapis_ore = "oreLapisQuisque";

	public static void registerOreDict() {
		OreDictionary.registerOre(powderBlaze, new ItemStack(Items.blaze_powder, 1, 0));
		OreDictionary.registerOre(quisqueLapis, new ItemStack(ItemRegistry.quisqueLapis));

		OreDictionary.registerOre(quisqueLapis_ore, new ItemStack(BlockRegistry.quisqueLapisOre));
	}
}