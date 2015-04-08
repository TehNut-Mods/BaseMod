package skeleton.gui;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;

public class CreativeTabBaseMod extends CreativeTabs {

	public CreativeTabBaseMod(String tabLabel) {
		super(tabLabel);
	}

	@Override
	public ItemStack getIconItemStack() {
		return new ItemStack(Blocks.command_block);
	}

	@Override
	public Item getTabIconItem() {
		return new Item();
	}
}
