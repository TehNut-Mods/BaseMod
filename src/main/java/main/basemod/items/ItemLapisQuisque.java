package main.basemod.items;

//General item that does nothing.

import main.basemod.BaseMod;
import main.basemod.ModInformation;
import net.minecraft.item.Item;

public class ItemLapisQuisque extends Item {

	public ItemLapisQuisque() {
		this.setCreativeTab(BaseMod.tabBaseMod);
		this.setUnlocalizedName(ModInformation.ID + ".quisque.lapis");
		this.setTextureName(ModInformation.ID + ":quisqueLapis");
	}
}
