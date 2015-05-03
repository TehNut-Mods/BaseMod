package main.basemod.items;

/*
* Base item class for getting standard things done with quickly.
* Extend this for pretty much every item you make.
*/

import main.basemod.BaseMod;
import main.basemod.ModInformation;
import net.minecraft.item.Item;

public class ItemBase extends Item {

    public ItemBase(String unlocName) {
        super();

        setUnlocalizedName(ModInformation.ID + "." + unlocName);
        setCreativeTab(BaseMod.tabBaseMod);
    }
}
