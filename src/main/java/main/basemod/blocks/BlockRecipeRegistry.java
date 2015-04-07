package main.basemod.blocks;

/*
 * General place to do all your block related recipe things'n'stuff.
 */

import net.minecraft.init.Blocks;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.oredict.ShapedOreRecipe;

public class BlockRecipeRegistry {

	//Self explanatory. Continue these how you wish. EG: registerPulverizerRecipes
	private static void registerShapedRecipes() {
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(Blocks.gold_ore), new Object[]{"XXX", "X X", "XXX", 'X', "ingotGold"}));
		GameRegistry.addRecipe(new ShapedOreRecipe(new ItemStack(BlockRegistry.quisqueLapisBlock), new Object[]{"XXX", "XXX", "XXX", 'X', "dustQuisqueLapis"}));
	}

	private static void registerShapelessRecipes() {

	}

	public static void registerBlockRecipes() {
		registerShapedRecipes();
		registerShapelessRecipes();
	}
}
