package main.basemod.client.gui;

import main.basemod.BaseMod;
import main.basemod.client.gui.BaseBook.ItemGuiBaseBook;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {

	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		if (ID == 0) {
			BaseMod.logger.info("Open Gui");
			return new ItemGuiBaseBook();
		}
		return null;
	}
}
