package src.objects;

import java.net.URL;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Board {
	private double x,y;
	private double width, height;
	private Image imgBoard;
	private ImageView iview;
	
	// Constructor for null and parameters calls
	public Board() {
		x = 0;
		y = 0;
		
		URL imageBoardURL = getClass().getResource("images/board.png");
		imgBoard = new Image(imageBoardURL.toExternalForm());
		iview = new ImageView(imgBoard);
		iview.setX(x);
		iview.setY(y);
		
		width = imgBoard.getWidth();
		height = imgBoard.getHeight();
		
	}
	
	public Board(double xPos, double yPos) {
		x = xPos;
		y = yPos;
		
		URL imageBoardURL = getClass().getResource("images/board.png");
		imgBoard = new Image(imageBoardURL.toExternalForm());
		iview = new ImageView(imgBoard);
		iview.setX(x);
		iview.setY(y);
		
		width = imgBoard.getWidth();
		height = imgBoard.getHeight();
	}
	
	// Speed of Gameplay
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
		imgBoard = img;
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
		return imgBoard;
	}
	
	public ImageView getNode() {
		iview.setImage(imgBoard);
		iview.setX(x);
		iview.setY(y);
		return iview;
	}
}
