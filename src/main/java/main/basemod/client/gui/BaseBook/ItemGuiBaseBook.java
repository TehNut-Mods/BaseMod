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

import static org.lwjgl.opengl.GL11.glColor4f;

@SideOnly(Side.CLIENT)
public class ItemGuiBaseBook extends GuiScreen {

	static ResourceLocation gui = new ResourceLocation(ModInformation.ID, "textures/guis/bookBase.png");

	private static final int BOOK_BTN_NEXT = 0;
	private static final int BOOK_BTN_PREV = 1;

	private static final int WIDTH = 175;
	private static final int HEIGHT = 228;

	private GuiButton next;
	private GuiButton prev;

	private int pageIndex = 0;
	private int bookTotalPages = 11;

	private int bookXStart;

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
		return false;
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
				buildPage("gui." + ModInformation.ID + ".basebook.title.main", "gui." + ModInformation.ID + ".basebook.content.main", 1);
				break;
			case 1:
				buildPage("gui." + ModInformation.ID + ".basebook.title.1", "gui." + ModInformation.ID + ".basebook.content.1", 2);
				break;
			case 2:
				buildPage("gui." + ModInformation.ID + ".basebook.title.2", "gui." + ModInformation.ID + ".basebook.content.2", 3);
				break;
			case 3:
				buildPage("gui." + ModInformation.ID + ".basebook.title.3", "gui." + ModInformation.ID + ".basebook.content.3", 4);
				break;
			case 4:
				buildPage("gui." + ModInformation.ID + ".basebook.title.4", "gui." + ModInformation.ID + ".basebook.content.4", 5);
				break;
			case 5:
				buildPage("gui." + ModInformation.ID + ".basebook.title.5", "gui." + ModInformation.ID + ".basebook.content.5", 6);
				break;
			case 6:
				buildPage("gui." + ModInformation.ID + ".basebook.title.6", "gui." + ModInformation.ID + ".basebook.content.6", 7);
				break;
			case 7:
				buildPage("gui." + ModInformation.ID + ".basebook.title.7", "gui." + ModInformation.ID + ".basebook.content.7", 8);
				break;
			case 8:
				buildPage("gui." + ModInformation.ID + ".basebook.title.8", "gui." + ModInformation.ID + ".basebook.content.8", 9);
				break;
			case 9:
				buildPage("gui." + ModInformation.ID + ".basebook.title.9", "gui." + ModInformation.ID + ".basebook.content.9", 10);
				break;
			case 10:
				buildPage("gui." + ModInformation.ID + ".basebook.title.10", "gui." + ModInformation.ID + ".basebook.content.10", 11);
				break;
			default:
				buildPage("gui." + ModInformation.ID + ".basebook.title.default", "gui." + ModInformation.ID + ".basebook.content.default", 11);
				break;
		}
	}

	private void buildPage(String unlocTitle, String unlocBody, int page) {
		drawCenteredString(fontRendererObj, TextHelper.localize(unlocTitle), bookXStart + 85, 20, 0x666666);
		fontRendererObj.setUnicodeFlag(false);
		fontRendererObj.drawSplitString(TextHelper.localize(unlocBody), bookXStart + 20, 60, WIDTH - 40, 0x666666);
		drawCenteredString(fontRendererObj, page + " / " + bookTotalPages, bookXStart + 85, 215, 0x666666);
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