package ui;

import java.io.Serializable;

public class ViewDimension implements Serializable {

	// X, Y, Width, Height 를 포함
	public int X;
	public int Y;
	public int WIDTH;
	public int HEIGHT;

	public ViewDimension(){}

	public ViewDimension(int width, int height) {
		WIDTH = width;
		HEIGHT = height;
	}

	public ViewDimension(int x, int y, int width, int height) {
		X = x;
		Y = y;
		WIDTH = width;
		HEIGHT = height;
	}

	private ViewDimension getNewWindowPosition(int xPositionOfCenter, int yPositionOfCenter) {
		ViewDimension vd = new ViewDimension();
		vd.X = xPositionOfCenter - (WIDTH/2);
		vd.Y = yPositionOfCenter - (HEIGHT/2);
		vd.WIDTH = WIDTH;
		vd.HEIGHT = HEIGHT;
		return vd;
	}

	// 화면의 센터로 위치
	public void alignCenter(ViewDimension parentDimension) {
		ViewDimension vd = getNewWindowPosition(parentDimension.WIDTH / 2, parentDimension.HEIGHT / 2);
		X = vd.X;
		Y = vd.Y;
		WIDTH = vd.WIDTH;
		HEIGHT = vd.HEIGHT;
	}

	public void moveByPercent(ViewDimension parentDimension, int percentInX, int percentInY) {
		int onePercentForX = parentDimension.WIDTH / 100;
		int onePercentForY = parentDimension.HEIGHT / 100;

		X += percentInX * onePercentForX;
		Y -= percentInY * onePercentForY;
	}

	public void toLeft(ViewDimension parentDimension, int offset) {
		X = offset;
	}

	public void toRight(ViewDimension parentDimension, int offset) {
		X = parentDimension.WIDTH - WIDTH - offset;
	}

	public void toBottom(ViewDimension parentDimension, int offset) {
		Y = parentDimension.HEIGHT - HEIGHT - offset;
	}

	public void toTop(ViewDimension parentDimension, int offset) {
		Y = offset;
	}

	public void scale(float scale) {
		WIDTH *= scale;
		HEIGHT *= scale;
	}
}
