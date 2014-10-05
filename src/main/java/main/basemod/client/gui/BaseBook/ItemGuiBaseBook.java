package main.basemod.client.gui.BaseBook;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import main.basemod.ModInformation;
import main.basemod.util.TextHelper;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.ResourceLocation;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.GL11;

import java.util.ArrayList;
import java.util.List;

import static org.lwjgl.opengl.GL11.glColor4f;

@SideOnly(Side.CLIENT)
public class ItemGuiBaseBook extends GuiScreen {

	static ResourceLocation gui = new ResourceLocation(ModInformation.ID, "textures/guis/bookBase.png");

	private static final int BOOK_BTN_NEXT = 0;
	private static final int BOOK_BTN_PREV = 1;

	public static final int WIDTH = 175;
	public static final int HEIGHT = 228;

	public static List<BaseBookPage> pages = new ArrayList<BaseBookPage>();

	private GuiButton next;
	private GuiButton prev;

	private int pageIndex = 0;
	private int bookTotalPages = 11;

	public int bookXStart;

	public ItemGuiBaseBook() {

	}

	@Override
	@SuppressWarnings("all")
	public void initGui() {
		super.initGui();

		bookXStart = (width - WIDTH) / 2;

		buttonList.add(next = new GuiButtonPageChange(BOOK_BTN_NEXT, bookXStart + WIDTH - 26, 210, false));
		buttonList.add(prev = new GuiButtonPageChange(BOOK_BTN_PREV, bookXStart + 10, 210, true));

		updateButtons();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch (button.id) {
			case BOOK_BTN_NEXT:
				pageIndex++;
				break;
			case BOOK_BTN_PREV:
				--pageIndex;
				break;
		}
		updateButtons();
	}

	private void updateButtons() {
		this.next.visible = (this.pageIndex < this.bookTotalPages - 1);
		this.prev.visible = this.pageIndex > 0;
	}

	@Override
	public void drawScreen(int mouseX, int mouseY, float renderPartials) {
		drawBackground();
		drawForeground();

		super.drawScreen(mouseX, mouseY, renderPartials);
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean doesGuiPauseGame() {
		return true;
	}

	@Override
	protected void keyTyped(char character, int key) {
		if (key == Keyboard.KEY_ESCAPE) {
			mc.displayGuiScreen(null);
		}
	}

	protected void drawBackground() {
		mc.renderEngine.bindTexture(gui);
		drawTexturedModalRect(bookXStart, 5, 0, 0, WIDTH, HEIGHT);
	}

	public void drawForeground() {
		switch (pageIndex) {
			case 0:
				drawMainScreen();
				break;
			case 1:
				drawScreenTwo();
				break;
			case 2:
				drawScreenThree();
				break;
			case 3:
				drawScreenFour();
				break;
			case 4:
				drawScreenFive();
				break;
			case 5:
				drawScreenSix();
				break;
			case 6:
				drawScreenSeven();
				break;
			case 7:
				drawScreenEight();
				break;
			case 8:
				drawScreenNine();
				break;
			case 9:
				drawScreenTen();
				break;
			case 10:
				drawScreenEleven();
				break;
		}
	}

	protected void drawMainScreen() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.main"), bookXStart + 60, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.main"), bookXStart + 30, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenTwo() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.1"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.1"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenThree() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.2"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.2"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenFour() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.3"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.3"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenFive() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.4"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.4"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenSix() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.5"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.5"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenSeven() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.6"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.6"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenEight() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.7"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.7"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenNine() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.8"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.8"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenTen() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.9"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.9"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	private void drawScreenEleven() {
		fontRendererObj.drawString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.title.10"), bookXStart + 70, 20, 0x000000);

		boolean unicode = fontRendererObj.getUnicodeFlag();
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize("gui." + ModInformation.ID + ".basebook.content.10"), bookXStart + 20, 60, WIDTH - 40, 0x000000);
		fontRendererObj.drawString((pageIndex + 1) + "/" + (bookTotalPages), bookXStart + 82, 215, 0x000000);
		fontRendererObj.setUnicodeFlag(unicode);
	}

	public class GuiButtonPageChange extends GuiButton {

		private final boolean previous;

		public GuiButtonPageChange(int id, int x, int y, boolean previous) {
			super(id, x, y, 16, 16, "");
			this.previous = previous;
		}

		@Override
		public void drawButton(Minecraft mc, int mouseX, int mouseY) {
			if (visible) {
				boolean mouseOver = mouseX >= xPosition && mouseY >= yPosition && mouseX < xPosition + width && mouseY < yPosition + height;
				glColor4f(1, 1, 1, 1);
				mc.renderEngine.bindTexture(gui);
				int u = 175;
				int v = 0;

				if (mouseOver) {
					v += 17;
				}

				if (previous) {
					u += 17;
				}

				GL11.glPushMatrix();

				GL11.glDisable(GL11.GL_LIGHTING);
				GL11.glColor4f(1, 1, 1, 1);

				drawTexturedModalRect(xPosition, yPosition, u, v, width, height);

				GL11.glEnable(GL11.GL_LIGHTING);

				GL11.glPopMatrix();
			}
		}
	}
}