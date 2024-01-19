package src;

import javafx.application.Application;
import javafx.stage.Stage;

import src.screens.titleScreen;
 
public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }
    
    public void start(Stage primaryStage) {
        titleScreen.createAndSet(primaryStage);
    }
}
