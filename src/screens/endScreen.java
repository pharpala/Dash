package src.screens;

import java.net.URL;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

public class endScreen {
    public static void createAndSet(Stage primaryStage, int score, TextField tfName) {
        Pane root = new Pane();

        URL imageBackgroundURL = endScreen.class.getResource("images/endScreenBackground.png");
        Image imgBackground = new Image(imageBackgroundURL.toExternalForm());
        ImageView ivBackground = new ImageView(imgBackground);
        root.getChildren().add(ivBackground);

        Scene sceneEnd = new Scene(root, 
                                   imgBackground.getWidth(),
                                   imgBackground.getHeight());

        Label lblScore = new Label(String.valueOf(score));
        lblScore.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR, 50));
        lblScore.setTextFill(Color.BLACK);
        lblScore.setLayoutX(474);
        lblScore.setLayoutY(242);
        root.getChildren().add(lblScore);

        Button btnPlayAgain = new Button();
        btnPlayAgain.setPrefSize(300,80);
        btnPlayAgain.setLayoutX(45);
        btnPlayAgain.setLayoutY(445);
        btnPlayAgain.setText("PLAY AGAIN");
        btnPlayAgain.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR, 40));
        btnPlayAgain.setEffect(new DropShadow());
        btnPlayAgain.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
        btnPlayAgain.setOnMouseEntered(e -> btnPlayAgain.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
        btnPlayAgain.setOnMouseExited(e -> btnPlayAgain.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
        btnPlayAgain.setOnAction(e -> {
            characterSelectScreen.createAndSet(primaryStage, tfName.getText());
        });
        root.getChildren().add(btnPlayAgain);
        
        Button btnExit = new Button();
        btnExit.setPrefSize(300,80);
        btnExit.setLayoutX(380);
        btnExit.setLayoutY(445);
        btnExit.setText("EXIT");
        btnExit.setFont(Font.font("Britannic Bold", FontWeight.BOLD, FontPosture.REGULAR, 40));
        btnExit.setEffect(new DropShadow());
        btnExit.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;");
        btnExit.setOnMouseEntered(e -> btnExit.setStyle("-fx-background-color: lightblue; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
        btnExit.setOnMouseExited(e -> btnExit.setStyle("-fx-background-color: white; -fx-border-color: black; -fx-border-width: 3 3 3 3;"));
        btnExit.setOnAction(e -> System.exit(0));
        root.getChildren().add(btnExit);

        primaryStage.setScene(sceneEnd);
        primaryStage.centerOnScreen();
    }
}
