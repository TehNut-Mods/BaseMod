package main.basemod.client.gui.BaseBook;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import org.lwjgl.opengl.GL11;

// Terrabad code until I actually finish writing my book code.

@SideOnly(Side.CLIENT)
public class ItemGuiBaseBook extends GuiScreen {

    private TurnPageButton buttonNextPage;
    private TurnPageButton buttonPreviousPage;
    private int bookImageWidth = 192;
    private int bookImageHeight = 192;
    private final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");

    public ItemGuiBaseBook(EntityPlayer player, ItemStack stack, boolean par3) {

    }

    @SuppressWarnings("unchecked")
    @Override
    public void initGui() {

        this.buttonList.clear();

        int i = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.buttonList.add(this.buttonNextPage = new TurnPageButton(1, i + 120, b0 + 154, true));
        this.buttonList.add(this.buttonPreviousPage = new TurnPageButton(2, i + 38, b0 + 154, false));
    }

    @Override
    public void drawScreen(int par1, int par2, float par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(bookGuiTextures);
        int k = (this.width - this.bookImageWidth) / 2;
        byte b0 = 2;
        this.drawTexturedModalRect(k, b0, 0, 0, this.bookImageWidth, this.bookImageHeight);

        addPage("Test", "", "Hello tharasdffffffffffffffffffffff ffffff fff", 0);

        super.drawScreen(par1, par2, par3);
    }

    @SuppressWarnings("unchecked")
    @Override
    protected void actionPerformed(GuiButton button) {

    }

    public boolean doesGuiPauseGame () {
        return false;
    }

    public void addPage(String title, String resourcePath, String content, int page) {
        fontRendererObj.drawSplitString(title, this.width / 2 - 10, this.height / 2 - 105, 118, 0x000000);
        fontRendererObj.drawSplitString(content, this.width / 2 - 60, this.height / 2 - 90, 118, 0x000000);
    }
}
