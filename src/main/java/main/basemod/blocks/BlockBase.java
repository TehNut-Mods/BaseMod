package main.basemod.blocks;

/*
* Base block class for getting standard things done with quickly.
* Extend this for pretty much every block you make.
*/

import main.basemod.BaseMod;
import main.basemod.ModInformation;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class BlockBase extends Block {

	public BlockBase(String unlocName, Material material, SoundType soundType, float hardness) {
		super(material);

		setUnlocalizedName(ModInformation.ID + "." + unlocName);
		setCreativeTab(BaseMod.tabBaseMod);
		setStepSound(soundType);
		setHardness(hardness);
	}
}
