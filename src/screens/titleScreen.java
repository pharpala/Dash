package src.screens;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;

import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;

public class titleScreen {
    public static void createAndSet(Stage primaryStage) {
        Pane root = new Pane();

		URL imageBackgroundURL = titleScreen.class.getResource("images/titleScreenBackground.png");
        Image imgBackground = new Image(imageBackgroundURL.toExternalForm());
        ImageView ivBackground = new ImageView(imgBackground);
        root.getChildren().add(ivBackground);

        Scene sceneTitle = new Scene(root, 
                                     imgBackground.getWidth(),
                                     imgBackground.getHeight());
        
        Button btnPlay = new Button();
        btnPlay.setPrefSize(300,80);
        btnPlay.setText("PLAY");
        btnPlay.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR,40));
		btnPlay.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
		btnPlay.setEffect(new DropShadow());
		btnPlay.setOnMouseEntered(e -> btnPlay.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
		btnPlay.setOnMouseExited(e -> btnPlay.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
		btnPlay.setOnAction(e -> characterSelectScreen.createAndSet(primaryStage, ""));

        Button btnControls = new Button();
		btnControls.setPrefSize(300,80);
		btnControls.setText("CONTROLS");
		btnControls.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR,40));
		btnControls.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
		btnControls.setEffect(new DropShadow());
		btnControls.setOnMouseEntered(e -> btnControls.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));		
		btnControls.setOnMouseExited(e -> btnControls.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
		btnControls.setOnAction(e -> {
			Alert alrtControls = new Alert(AlertType.INFORMATION);
			alrtControls.setHeaderText(null);
			alrtControls.setContentText("A - MOVE LEFT\nD - MOVE RIGHT");
			alrtControls.setTitle("Controls");
			alrtControls.getButtonTypes().clear();
			alrtControls.getButtonTypes().add(ButtonType.OK);
			alrtControls.showAndWait();
		});

		Button btnHighScore = new Button();
		btnHighScore.setPrefSize(300,80);
		btnHighScore.setText("HIGH SCORE");
		btnHighScore.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR,40));
		btnHighScore.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
		btnHighScore.setEffect(new DropShadow());
		btnHighScore.setOnMouseEntered(e -> btnHighScore.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
		btnHighScore.setOnMouseExited(e -> btnHighScore.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
		btnHighScore.setOnAction(e -> {
			int highScore = getHighScore();
			ArrayList<String> highScoreHolders = getHighScoreHolder(highScore);

			Alert alrtHighScore = new Alert(AlertType.INFORMATION);
			alrtHighScore.setHeaderText(null);
			if(highScore == -1) {
				alrtHighScore.setContentText("There are currently no high scores!\nBe the first one to set a highscore by clicking PLAY!");
			}
			else {
				alrtHighScore.setContentText("HIGHSCORE: " + highScore + "\nHELD BY: " + String.join(", ", highScoreHolders));
			}
			alrtHighScore.setTitle("High Score");
			alrtHighScore.getButtonTypes().clear();
			alrtHighScore.getButtonTypes().add(ButtonType.OK);
			alrtHighScore.showAndWait();
		});

        VBox vButtons = new VBox();
		vButtons.setSpacing(20);
		vButtons.getChildren().addAll(btnPlay, btnControls, btnHighScore);
		vButtons.setLayoutX(238);
		vButtons.setLayoutY(290);
        root.getChildren().add(vButtons);

        primaryStage.setScene(sceneTitle);
        primaryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			public void handle(WindowEvent e) {
				Alert alrtConfirm = new Alert(AlertType.CONFIRMATION);
				alrtConfirm.setContentText("Are you sure you want to exit?");
				alrtConfirm.setTitle("Exit");
				alrtConfirm.setHeaderText(null);
				alrtConfirm.getButtonTypes().clear();
				alrtConfirm.getButtonTypes().addAll(ButtonType.YES, ButtonType.NO);

				Optional<ButtonType> result = alrtConfirm.showAndWait();
				if(result.get() == ButtonType.NO) {
					e.consume();
				}
			}
		});
		primaryStage.centerOnScreen();
		primaryStage.setResizable(false);
		primaryStage.setTitle("Dash");
		primaryStage.show();
    }

	private static int getHighScore() {
		int highScore = Integer.MIN_VALUE;

		File scoresFile = new File("./scores.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(scoresFile));
			if(br.readLine() == null) {
				br.close();
				return -1;
			}
			else {
				br.close();
				BufferedReader br2 = new BufferedReader(new FileReader(scoresFile));
				int sepPos = 0;
				int curScore = 0;
				String curLine = null;
				while((curLine = br2.readLine()) != null) {
					sepPos = curLine.indexOf("=");
					curScore = Integer.parseInt(curLine.substring(sepPos+1));
					if(curScore > highScore) {
						highScore = curScore;
					}
				}
				br2.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
		return highScore;
	}

	private static ArrayList<String> getHighScoreHolder(int highScore) {
		ArrayList<String> highScoreHolders = new ArrayList<>();
		
		if(highScore == -1) {
			return highScoreHolders;
		}
		
		File scoresFile = new File("./scores.txt");
		BufferedReader br;
		try {
			br = new BufferedReader(new FileReader(scoresFile));
			String curLine = null;
			int sepPos = 0;
			int score = 0;
			while((curLine = br.readLine()) != null) {
				sepPos = curLine.indexOf("=");
				score = Integer.parseInt(curLine.substring(sepPos+1));
				if(score == highScore) {
					highScoreHolders.add(curLine.substring(0,sepPos));
				}
			}
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return highScoreHolders;
	}
}
