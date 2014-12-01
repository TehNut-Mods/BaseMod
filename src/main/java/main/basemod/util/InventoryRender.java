package main.basemod.util;

import main.basemod.ModInformation;
import net.minecraft.block.Block;
import net.minecraft.client.Minecraft;
import net.minecraft.client.resources.model.ModelResourceLocation;
import net.minecraft.item.Item;

public class InventoryRender {

	public static void inventoryBlockRender(Block block, String blockName) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), 0, new ModelResourceLocation(ModInformation.ID + ":" + blockName, "inventory"));
	}

	public static void inventoryBlockRender(Block block, int meta, String blockName) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(Item.getItemFromBlock(block), meta, new ModelResourceLocation(ModInformation.ID + ":" + blockName, "inventory"));
	}

	public static void inventoryItemRender(Item item, String itemName) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, 0, new ModelResourceLocation(ModInformation.ID + ":" + itemName, "inventory"));
	}

	public static void inventoryItemRender(Item item, int meta, String itemName) {

		Minecraft.getMinecraft().getRenderItem().getItemModelMesher().register(item, meta, new ModelResourceLocation(ModInformation.ID + ":" + itemName, "inventory"));
	}
}
