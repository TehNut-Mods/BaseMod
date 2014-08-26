package main.basemod.items;

import main.basemod.BaseMod;
import main.basemod.ModInformation;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;

public class ItemBaseBook extends Item {

	public ItemBaseBook() {
		this.setCreativeTab(BaseMod.tabBaseMod);
		this.setUnlocalizedName(ModInformation.ID + ".book.base");
		this.setTextureName(ModInformation.ID + ":baseBook_closed");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
		player.openGui(BaseMod.instance, 0, world, (int)player.posX, (int)player.posY, (int)player.posZ);
		return itemStack;
	}
}
