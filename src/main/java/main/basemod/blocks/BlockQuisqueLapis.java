package main.basemod.blocks;

/*
 * General block that doesn't do anything.
 */

import net.minecraft.block.material.Material;

public class BlockQuisqueLapis extends BlockBase {

	public BlockQuisqueLapis() {
		super("quisque.lapis.block", Material.rock, soundTypeStone, 1F);
	}
}
