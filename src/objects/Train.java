package src.objects;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Train {
	private double x,y;
	private double width,height;
	private Image imgTrain;
	private ImageView iview;

	// Constructors, both null and with parameters
	public Train() {
		x = 0;
		y = 0;
		
		URL imageTrainURL = getClass().getResource("images/train.png");
		imgTrain = new Image(imageTrainURL.toExternalForm());
		iview = new ImageView(imgTrain);
		iview.setX(x);
		iview.setY(y);
		
		width = imgTrain.getWidth();
		height = imgTrain.getHeight();
	}
	
	public Train(double xPos, double yPos) {
		x = xPos;
		y = yPos;
		
		URL imageTrainURL = getClass().getResource("images/train.png");
		imgTrain = new Image(imageTrainURL.toExternalForm());
		iview = new ImageView(imgTrain);
		iview.setX(x);
		iview.setY(y);
		
		width = imgTrain.getWidth();
		height = imgTrain.getHeight();
	}
	
	// Handle speed of train, increases each time level gets harder
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
		imgTrain = img;
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
		return imgTrain;
	}
	
	public ImageView getNode() {
		iview.setImage(imgTrain);
		iview.setX(x);
		iview.setY(y);
		return iview;
	}
}
