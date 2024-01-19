package src.screens;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.util.Duration;
import src.objects.Board;
import src.objects.Character;
import src.objects.Coin;
import src.objects.Train;

public class gameScreen {

	private static Timeline t2;
	private static int score = 0;

    public static void createAndSet(TextField tfName, int characterNum, Stage primaryStage) {
        Pane root = new Pane();

		URL imageBackgroundURL = gameScreen.class.getResource("images/gameBackground.png");
        Image imgGameBackground = new Image(imageBackgroundURL.toExternalForm());
        ImageView ivGameBackground = new ImageView(imgGameBackground);
        root.getChildren().add(ivGameBackground);

        Scene gameScene = new Scene(root,
                                    imgGameBackground.getWidth(),
                                    imgGameBackground.getHeight());
        
        Label lblScore = new Label();
		lblScore.setText("SCORE: 0");
		lblScore.setFont(Font.font("Arial", FontWeight.BOLD, FontPosture.REGULAR, 40));
        lblScore.setTextFill(Color.WHITE);
		lblScore.setLayoutX(20);
		lblScore.setLayoutY(20);                            

        Character player = new Character(characterNum);
        player.setX(imgGameBackground.getWidth()/2 - player.getWidth()/2);
		player.setY(imgGameBackground.getHeight()/2 - player.getHeight()/2);

        gameScene.setOnKeyPressed(e -> {
			if(player.isDead == false) {
				if(e.getEventType() == KeyEvent.KEY_PRESSED) {
					if(e.getCode() == KeyCode.A) {
						player.setX(player.getX() - 100);
						if(player.getX() <= 300) {
							player.setX(320);
						}
					}
					if(e.getCode() == KeyCode.D) {
						player.setX(player.getX() + 100);
						if(player.getX() + player.getWidth() >= 600) {
							player.setX(520);
						}
					}
				}
				player.getNode();
			}
		});

        KeyFrame kf = new KeyFrame(Duration.millis(200), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {

				// If the player is not dead call the move method
				if(player.isDead == false) {
					player.move();
				}
			}
		});


        Timeline t = new Timeline(kf);
		t.setCycleCount(Timeline.INDEFINITE);
		t.play();

        Random rnd = new Random();
		int cols = 0;

		Board board = new Board();
		Train train = new Train();
		Coin coin = new Coin();

		board.setY(-100);
		train.setY(-400);
		coin.setY(-200);

		cols = rnd.nextInt(3) + 1;
		if(cols == 1) {
			board.setX(300);
		} else if(cols == 2) {
			board.setX(400);
		} else {
			board.setX(500);
		}

		cols = rnd.nextInt(3) + 1;
		if(cols == 1) {
			train.setX(300);
		} else if(cols == 2) {
			train.setX(400);
		} else {
			train.setX(500);
		}

		cols = rnd.nextInt(3) + 1;
		if(cols == 1) {
			coin.setX(310);
		} else if(cols == 2) {
			coin.setX(410);
		} else {
			coin.setX(510);
		}

		score = 0;

		KeyFrame kf2 = new KeyFrame(Duration.millis(100), new EventHandler<ActionEvent>() {
			public void handle(ActionEvent e) {
				int cols = 0;
				
				if(player.isDead == false) {
					board.move();
					train.move();
					coin.move();

					player.getNode();
					train.getNode();
					board.getNode();
					coin.getNode();

					if(board.getY() >= 650) {
						cols = rnd.nextInt(3) + 1;
						if(cols == 1) {
							board.setX(300);
						} else if(cols == 2) {
							board.setX(400);
						} else {
							board.setX(500);
						}
						board.setY(-200);
					}

					if(train.getY() >= 650) {
						cols = rnd.nextInt(3) + 1;
						if(cols == 1) {
							train.setX(300);
						} else if(cols == 2) {
							train.setX(400);
						} else {
							train.setX(500);
						}
						train.setY(-600);
					}

					if(coin.getY() >= 650) {
						cols = rnd.nextInt(3) + 1;
						if(cols == 1) {
							coin.setX(310);
						} else if(cols == 2) {
							coin.setX(410);
						} else {
							coin.setX(510);
						}
						coin.setY(-250);
					}

					if(player.getNode().getBoundsInParent().intersects(board.getNode().getBoundsInParent()) ||
					   player.getNode().getBoundsInParent().intersects(train.getNode().getBoundsInParent())) {
							player.killEskimo();
							player.getNode();
					}

					if(coin.getNode().getBoundsInParent().intersects(train.getNode().getBoundsInParent()) || 
					   coin.getNode().getBoundsInParent().intersects(board.getNode().getBoundsInParent())) {
							cols = rnd.nextInt(3) + 1;
							if(cols == 1) {
								coin.setX(310);
							} else if(cols == 2) {
								coin.setX(410);
							} else {
								coin.setX(510);
							}
							coin.setY(-200);
					}

					if(board.getNode().getBoundsInParent().intersects(train.getNode().getBoundsInParent())) {
						cols = rnd.nextInt(3) + 1;
						if(cols == 1) {
							board.setX(300);
						} else if(cols == 2) {
							board.setX(430);
						} else {
							board.setX(540);
						}
						board.setY(-200);
					}

					if(player.getNode().getBoundsInParent().intersects(coin.getNode().getBoundsInParent())) {
						score++;

						if(score == 5 || score == 20 || score == 30 || score == 40) {
							t2.setRate(t2.getRate() + 1);
							t.setRate(t.getRate() + 0.4);
						}

						lblScore.setText("SCORE: " + score);

						cols = rnd.nextInt(3) + 1;
						if(cols == 1) {
							coin.setX(310);
						} else if(cols == 2) {
							coin.setX(410);
						} else {
							coin.setX(510);
						}
						coin.setY(-200);	
					}
				}
				else {
					t2.stop();
					t.stop();

					try {
						TimeUnit.SECONDS.sleep(2);
					} catch (InterruptedException e1) {
						e1.printStackTrace();
					}

					try {
						FileWriter writer = new FileWriter("./scores.txt", true);
						BufferedWriter bw = new BufferedWriter(writer);
						bw.write(tfName.getText() + "=" + score + "\n");
						bw.close();
					} catch(IOException err) {
						err.printStackTrace();
					}
					endScreen.createAndSet(primaryStage, score, tfName);
				}
			}
		});
		root.getChildren().addAll(board.getNode(), train.getNode(), coin.getNode(), player.getNode(), lblScore);

		t2 = new Timeline(kf2);
		t2.setCycleCount(Timeline.INDEFINITE);
		t2.play();

        primaryStage.setScene(gameScene);
        primaryStage.centerOnScreen();
    }
}
