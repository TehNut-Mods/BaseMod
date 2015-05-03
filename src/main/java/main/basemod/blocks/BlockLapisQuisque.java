package main.basemod.blocks;

/*
 * General block that doesn't do anything.
 */

import net.minecraft.block.material.Material;

public class BlockLapisQuisque extends BlockBase {

    public BlockLapisQuisque() {
        super("quisque.lapis.block", Material.rock, "quisqueLapis_block", soundTypeStone, 1F);
    }
}
