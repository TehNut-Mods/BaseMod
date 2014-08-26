package main.basemod.util;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiScreenBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;

public class GuiHelper {

	public static void doBookGui(EntityPlayer player, ItemStack itemStack, boolean par3) {
		Minecraft.getMinecraft().displayGuiScreen(new GuiScreenBook(player, itemStack, par3));
	}
}
