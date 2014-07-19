package main.basemod.blocks;

import main.basemod.BaseMod;
import main.basemod.ModInformation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockLapisQuisque extends Block {

	public BlockLapisQuisque() {
		super(Material.rock);
		this.setCreativeTab(BaseMod.tabBaseMod);
		this.setHardness(1F);
		this.setStepSound(soundTypeStone);
		this.setBlockName(ModInformation.ID + ".quisque.lapis.block");
		this.setBlockTextureName(ModInformation.ID + ":quisqueLapis_block");
	}
}
