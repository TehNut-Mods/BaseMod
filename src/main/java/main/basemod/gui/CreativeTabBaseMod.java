package main.basemod.gui;

//Creates your creative tab.

import main.basemod.items.ItemRegistry;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabBaseMod extends CreativeTabs {

	public CreativeTabBaseMod(String tabLabel) {
		super(tabLabel);
	}

	//The tab icon is what you return here.
	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(ItemRegistry.quisqueLapis);
	}

	@Override
	public Item getTabIconItem() { return new Item();
	}
}
