package main.basemod.client.gui.BaseBook;

public class BaseBookPage {

	private int startNDX = 0;
	private int endNDX = 12;
	private ItemGuiBaseBook parent;

	public BaseBookPage(ItemGuiBaseBook parent, int startIndex) {
		this.parent = parent;
		this.startNDX = startIndex;
	}
}
