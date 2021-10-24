package app.scene.nextTraining;

import app.Launcher;
import app.data.BackgroundSettings;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class NextTrainingScene extends Application {

    Launcher launcher = new Launcher();
    BackgroundSettings backgroundSettings = new BackgroundSettings();

    @Override
    public void start(Stage primaryStage) {
        GridPane gridPane = new GridPane();
            gridPane.setAlignment(Pos.CENTER);
            gridPane.setBackground(backgroundSettings.defaultBackground());

        Button ladderButton = new Button("Ladder");
            ladderButton.setPrefWidth(100);
            ladderButton.setPrefHeight(50);
        Button selectTrainingPlan = new Button("Select plan");
            selectTrainingPlan.setPrefWidth(100);
            selectTrainingPlan.setPrefHeight(50);
        Button backToMenu = new Button("Back to menu");
            backToMenu.setPrefWidth(100);
            backToMenu.setPrefHeight(50);

        gridPane.add(ladderButton, 10, 10);
        gridPane.add(selectTrainingPlan, 10, 20);
        gridPane.add(backToMenu, 10, 30);

        Scene scene = new Scene(gridPane, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(scene);

        backToMenu.setOnAction(event -> {
            try {
                launcher.start(primaryStage);
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
