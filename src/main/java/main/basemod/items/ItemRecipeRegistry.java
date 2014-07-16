package main.basemod.items;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class ItemRecipeRegistry {

	//Self explanatory. Continue these how you wish. EG: registerCustomRecipes
	private static void registerShapedRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod), new Object[]{"X  ", " X ", "  X", 'X', "powderBlaze"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Items.blaze_rod), new Object[]{"  X", " X ", "X  ", 'X', "powderBlaze"}));
	}

	private static void registerShaplessRecipes() {

	}

	public static void registerItemRecipes() {
		registerShapedRecipes();
		registerShaplessRecipes();
	}

}
