package tools;

public abstract class ClickableRectangle {
	private int x;
	private int y;
	private int height;
	private int length;
	public ClickableRectangle(int x, int y,int length, int height) {
		super();
		this.x = x;
		this.y = y;
		this.height = height;
		this.length = length;
	}	
	public abstract void onClick();
}
