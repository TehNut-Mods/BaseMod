package main.basemod.blocks;

/*
 * General ore that drops and item instead of itself when broken.
 */

import main.basemod.items.ItemRegistry;
import net.minecraft.block.material.Material;
import net.minecraft.item.Item;

import java.util.Random;

public class BlockOreQuisqueLapis extends BlockBase {

	public BlockOreQuisqueLapis() {
		super("quisque.lapis.ore", Material.rock, "quisqueLapis_ore", soundTypeStone, 3F);
	}

	// Drops the item you return here when broken.
	@Override
	public Item getItemDropped(int int1, Random random, int int2) {
		return ItemRegistry.quisqueLapis;
	}

	// Drops the amount of items you get here.
	@Override
	public int quantityDropped(Random random) {
		return this == this ? 4 + random.nextInt(5) : 1;
	}
}
