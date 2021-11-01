package app;

import app.controller.ExitController;
import app.data.BackgroundSettings;
import app.scene.nextTraining.NextTrainingScene;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class Launcher extends Application {

    ExitController exitController = new ExitController();
    BackgroundSettings backgroundSettings = new BackgroundSettings();

    NextTrainingScene nextTrainingScene;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        nextTrainingScene = new NextTrainingScene();

        GridPane gridMenu = new GridPane();
            gridMenu.setAlignment(Pos.CENTER);
            gridMenu.setBackground(backgroundSettings.defaultBackground());

        Button newTrainingButton = new Button("Next training");
            newTrainingButton.setPrefWidth(150);
            newTrainingButton.setPrefHeight(50);
        Button addTrainingButton = new Button("Add training");
            addTrainingButton.setPrefWidth(150);
            addTrainingButton.setPrefHeight(50);
        Button bestResultButton = new Button("Best result");
            bestResultButton.setPrefWidth(150);
            bestResultButton.setPrefHeight(50);
        Button exitMenuButton = new Button("Exit");
            exitMenuButton.setPrefWidth(150);
            exitMenuButton.setPrefHeight(50);

        gridMenu.add(newTrainingButton, 10, 10);
        gridMenu.add(addTrainingButton, 20, 10);
        gridMenu.add(bestResultButton, 10, 20);
        gridMenu.add(exitMenuButton, 20, 20);

        Scene sceneMenu = new Scene(gridMenu, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(sceneMenu);
        primaryStage.setTitle("Next Training App");
        primaryStage.setResizable(false);
        primaryStage.show();

        exitMenuButton.setOnAction(actionEvent -> exitController.exit());
        newTrainingButton.setOnAction(event -> nextTrainingScene.start(primaryStage));

    }

}
