package main.basemod.blocks;

import main.basemod.BaseMod;
import main.basemod.ModInformation;
import main.basemod.items.ItemRegistry;
import net.minecraft.block.BlockOre;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOreQuisqueLapis extends BlockOre {

	public BlockOreQuisqueLapis() {
		this.setCreativeTab(BaseMod.tabBaseMod);
		this.setBlockName(ModInformation.ID + ".quisque.lapis.ore");
		this.setBlockTextureName(ModInformation.ID + ":quisqueLapis_ore");
		this.setHardness(3F);
	}

	@Override
	public Item getItemDropped(int int1, Random random, int int2) {
		return ItemRegistry.quisqueLapis;
	}

	@Override
	public int quantityDropped(Random random) {
		return this == this ? 4 + random.nextInt(5) : 1;
	}
}
