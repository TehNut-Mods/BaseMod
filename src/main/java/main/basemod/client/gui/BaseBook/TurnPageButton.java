package main.basemod.client.gui.BaseBook;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.opengl.GL11;

public class TurnPageButton extends GuiButton {

    private final boolean field_146151_o;

    public TurnPageButton(int par1, int par2, int par3, boolean par4) {
        super(par1, par2, par3, 23, 13, "");
        this.field_146151_o = par4;
    }

    public void drawButton(Minecraft minecraft, int width, int height) {

        final ResourceLocation bookGuiTextures = new ResourceLocation("textures/gui/book.png");

        if (this.visible) {
            boolean flag = width >= this.xPosition && height >= this.yPosition && width < this.xPosition + this.width && height < this.yPosition + this.height;
            GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
            minecraft.getTextureManager().bindTexture(bookGuiTextures);
            int k = 0;
            int l = 192;

            if (flag) {
                k += 23;
            }

            if (!this.field_146151_o) {
                l += 13;
            }

            this.drawTexturedModalRect(this.xPosition, this.yPosition, k, l, 23, 13);
        }
    }
}
