package platform;

import javafx.scene.image.Image;
import platform.base.Collectable;

public class Coin extends SpecialPlatform implements Collectable {
	public Coin(Image image, int fitWidth, int fitHeight, int translateX, int translateY) {
		super(image, fitWidth, fitHeight);
		setTranslateX(translateX);
		setTranslateY(translateY);
	}
	
	public void printCoordinate() {
		System.out.println("X = " + this.getTranslateX() + " Y = " +   this.getTranslateY());
	}
}