package main.basemod.items;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.basemod.BaseMod;
import main.basemod.ModInformation;
import main.basemod.util.TextHelper;
import net.minecraft.client.renderer.texture.IIconRegister;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.IIcon;
import net.minecraft.world.World;

import java.util.List;

public class ItemBaseBook extends ItemBase {

    public IIcon[] icon = new IIcon[500];

    public ItemBaseBook() {
        super("book");
        this.setHasSubtypes(true);
        this.setMaxStackSize(1);
    }

    @Override
    public String getUnlocalizedName(ItemStack itemstack) {
        String name = "";
        switch (itemstack.getItemDamage()) {
            case 0: {
                name = "base";
                break;
            }
            case 1: {
                name = "yolo";
                break;
            }
            default:
                name = "nothing";
                break;
        }
        return getUnlocalizedName() + "." + name;
    }

    @SideOnly(Side.CLIENT)
    public void registerIcons(IIconRegister ri) {
        this.icon[0] = ri.registerIcon(ModInformation.ID + ":baseBook_closed");
        this.icon[1] = ri.registerIcon(ModInformation.ID + ":baseBook_open");
    }

    @SideOnly(Side.CLIENT)
    public IIcon getIconFromDamage(int meta) {
        return this.icon[meta];
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    @SideOnly(Side.CLIENT)
    public void getSubItems(Item item, CreativeTabs par2CreativeTabs, List list) {
        for (int i = 0; i <= 1; i++) {
            list.add(new ItemStack(this, 1, i));
        }
    }

    @Override
    public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player) {
        switch (itemStack.getItemDamage()) {
            case 0: {
                player.openGui(BaseMod.instance, 0, world, (int) player.posX, (int) player.posY, (int) player.posZ);
                return itemStack;
            }
            case 1: {
                if (player.isSneaking() && !player.capabilities.isCreativeMode) {
                    player.swingItem();
                    player.setFire(3);
                } else if (!player.isSneaking() && !player.worldObj.isRemote) {
                    player.addChatMessage(new ChatComponentTranslation("info." + ModInformation.ID + ".chat.sneak"));
                }
            }
        }
        return itemStack;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void addInformation(ItemStack itemStack, EntityPlayer player, List list, boolean par4) {
        if (itemStack.getItemDamage() == 1) {
            list.add(TextHelper.RED + TextHelper.localize("info." + ModInformation.ID + ".tooltip.fire"));
        }
    }
}
