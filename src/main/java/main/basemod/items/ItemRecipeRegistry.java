package main.basemod.items;

/*
 * General place to do all your item related recipe things'n'stuff.
 */

import main.basemod.blocks.BlockRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry {

	// Self explanatory. Continue these how you wish. EG: registerSmeltingRecipes
	private static void registerShapedRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod), new Object[]{"X  ", " X ", "  X", 'X', "powderBlaze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod), new Object[]{"  X", " X ", "X  ", 'X', "powderBlaze"}));
	}

	private static void registerShaplessRecipes() {
		GameRegistry.addShapelessRecipe(new ItemStack(BlockRegistry.quisqueLapisBlock), new ItemStack(ItemRegistry.quisqueLapis, 9));
	}

	public static void registerItemRecipes() {
		registerShapedRecipes();
		registerShaplessRecipes();
	}
}
