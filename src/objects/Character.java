package src.objects;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Character {
	private double x, y;
	private double width, height;
	private Image[] imgRun;
	private ImageView iview;
	private int index;
	public boolean isDead;

	public Character(int character) {
		x = 0;
		y = 0;
		index = 0;

		// Array of Object Image to display the characters run
		imgRun = new Image[2];

		if(character == 1) {
			URL charOneRun1URL = getClass().getResource("images/characterOne-run1.png");
			URL charOneRun2URL = getClass().getResource("images/characterOne-run2.png");
			imgRun[0] = new Image(charOneRun1URL.toExternalForm());
			imgRun[1] = new Image(charOneRun2URL.toExternalForm());
		}
		else if(character == 2) {
			URL charTwoRun1URL = getClass().getResource("images/characterTwo-run1.png");
			URL charTwoRun2URL = getClass().getResource("images/characterTwo-run2.png");
			imgRun[0] = new Image(charTwoRun1URL.toExternalForm());
			imgRun[1] = new Image(charTwoRun2URL.toExternalForm());
		}
		else if(character == 3) {
			URL charThreeRun1URL = getClass().getResource("images/characterThree-run1.png");
			URL charThreeRun2URL = getClass().getResource("images/characterThree-run2.png");
			imgRun[0] = new Image(charThreeRun1URL.toExternalForm());
			imgRun[1] = new Image(charThreeRun2URL.toExternalForm());
		}

		width = imgRun[index].getWidth();
		height = imgRun[index].getHeight();
		iview = new ImageView(imgRun[index]);
		iview.setX(x);
		iview.setY(y);
		isDead = false;
	}

	public void move() {
		if(index == imgRun.length) {
			index = 0;
		}
		iview.setImage(imgRun[index]);
		index++;
	}

	// Handle running into train or board
	public void killEskimo() {
		isDead = true;
		URL imageBloodSplatURL = getClass().getResource("images/bloodSplatter.png");
		imgRun[0] = new Image(imageBloodSplatURL.toExternalForm());
		iview.setImage(imgRun[0]);
	}

	// Setters
	public void setX(double xPos) {
		x = xPos;
	}

	public void setY(double yPos) {
		y = yPos;
	}

	public void setWidth(double w) {
		width = w;
	}

	public void setHeight(double h) {
		height = h;
	}

	public void setImages(Image[] img) {
		imgRun = img;
	}

	public void setIndex(int i) {
		index = i;
	}

	// Getters
	public double getX() {
		return x;
	}

	public double getY() {
		return y;
	}

	public double getWidth() {
		return width;
	}

	public double getHeight() {
		return height;
	}

	public Image getImage() {
		return imgRun[index];
	}

	public ImageView getNode() {
		if(isDead == false ) {
			if(index == imgRun.length) {
				index = 0;
			}
			iview.setImage(imgRun[index]);
			iview.setX(x);
			iview.setY(y);
		
			return iview;
		} else {
			URL imageBloodSplatURL = getClass().getResource("images/bloodSplatter.png");
			imgRun[0] = new Image(imageBloodSplatURL.toExternalForm());
			iview.setImage(imgRun[0]);
			return iview;
		}
	}
}
