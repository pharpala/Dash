package src.objects;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Coin {
	private double x,y;
	private double width, height;
	private Image imgCoin;
	private ImageView iview;
	
	// Constructors, for both null and parameter calls
	public Coin() {
		x = 0;
		y = 0;
		
		URL imageCoinURL = getClass().getResource("images/coin.png");
		imgCoin = new Image(imageCoinURL.toExternalForm());
		iview = new ImageView(imgCoin);
		iview.setX(x);
		iview.setY(y);
		
		width = imgCoin.getWidth();
		height = imgCoin.getHeight();
	}
	
	public Coin(double xPos, double yPos) {
		x = xPos;
		y = yPos;
		
		URL imageCoinURL = getClass().getResource("images/coin.png");
		imgCoin = new Image(imageCoinURL.toExternalForm());
		iview = new ImageView(imgCoin);
		iview.setX(x);
		iview.setY(y);
		
		width = imgCoin.getWidth();
		height = imgCoin.getHeight();
	}

	// Speed the gameplay moves
	public void move() {
		y += 10;
		iview.setY(y);
	}
	
	// Setters
	public void setX(double xPos) {
		x = xPos;
		iview.setX(x);
	}
	
	public void setY(double yPos) {
		y = yPos;
		iview.setY(y);
	}
	
	public void setWidth(double w) {
		width = w;
	}
	
	public void setHeight(double h) {
		height = h;
	}
	
	public void setImage(Image img) {
		imgCoin = img;
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
		return imgCoin;
	}
	
	public ImageView getNode() {
		iview.setImage(imgCoin);
		iview.setX(x);
		iview.setY(y);
		return iview;
	}
}
