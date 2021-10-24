package app.scene.nextTraining.ladderScene;

import app.data.BackgroundSettings;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;


public class LadderTrainingScene extends Application {

    BackgroundSettings backgroundSettings = new BackgroundSettings();
    LadderSettingsScene ladderSettingsScene = new LadderSettingsScene();

    public static Label repsToDoStaticLabel;
    public static Label breakTimeStaticLabel;
    public static Label summaryRepsStaticLabel;

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setBackground(backgroundSettings.defaultBackground());

        HBox backToLadderSettingsButtonHBox = new HBox();
            backToLadderSettingsButtonHBox.setPrefWidth(BackgroundSettings.width);
            backToLadderSettingsButtonHBox.setPrefHeight(BackgroundSettings.height);
            backToLadderSettingsButtonHBox.setAlignment(Pos.BOTTOM_CENTER);
        VBox vBox = new VBox();
            vBox.setPrefWidth(BackgroundSettings.width);
            vBox.setPrefHeight(BackgroundSettings.height-30);
            vBox.setAlignment(Pos.CENTER);
        HBox doneOrNotDoneRepsHBox = new HBox();
            doneOrNotDoneRepsHBox.setPrefWidth(300);
            doneOrNotDoneRepsHBox.setPrefHeight(50);
            doneOrNotDoneRepsHBox.setAlignment(Pos.CENTER);
        GridPane gridPane = new GridPane();
            gridPane.setPrefWidth(BackgroundSettings.width);
            gridPane.setPrefHeight(60);
            gridPane.setAlignment(Pos.TOP_CENTER);

        anchorPane.getChildren().add(0, backToLadderSettingsButtonHBox);
        anchorPane.getChildren().add(1, vBox);
        anchorPane.getChildren().add(2, gridPane);

        Label repsToDoLabel = new Label("TO DO");
        repsToDoLabel.setPrefHeight(30);
        repsToDoLabel.setPrefWidth(150);
        repsToDoLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        Label summaryRepsLabel = new Label("SUMMARY");
        summaryRepsLabel.setPrefHeight(30);
        summaryRepsLabel.setPrefWidth(150);
        summaryRepsLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        Label breakTimeLabel = new Label("BREAK TIME");
        breakTimeLabel.setPrefHeight(30);
        breakTimeLabel.setPrefWidth(150);
        breakTimeLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        repsToDoStaticLabel = new Label();
        repsToDoStaticLabel.setPrefHeight(30);
        repsToDoStaticLabel.setPrefWidth(150);
        repsToDoStaticLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        breakTimeStaticLabel = new Label();
        breakTimeStaticLabel.setPrefHeight(30);
        breakTimeStaticLabel.setPrefWidth(150);
        breakTimeStaticLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        summaryRepsStaticLabel = new Label();
        summaryRepsStaticLabel.setPrefHeight(30);
        summaryRepsStaticLabel.setPrefWidth(150);
        summaryRepsStaticLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        Button endTrainingButton = new Button("END TRAINING");
        endTrainingButton.setPrefHeight(50);
        endTrainingButton.setPrefWidth(300);
        Button repsDoneButton = new Button("REPS DONE");
        repsDoneButton.setPrefHeight(50);
        repsDoneButton.setPrefWidth(150);
        Button repsNotDoneButton = new Button("REPS NOT DONE");
        repsNotDoneButton.setPrefHeight(50);
        repsNotDoneButton.setPrefWidth(150);
        Button backToLadderSettingsButton = new Button("Back");
        backToLadderSettingsButton.setPrefHeight(30);
        backToLadderSettingsButton.setPrefWidth(300);

        doneOrNotDoneRepsHBox.getChildren().addAll(repsDoneButton, repsNotDoneButton);
        vBox.getChildren().addAll(doneOrNotDoneRepsHBox, endTrainingButton);
        backToLadderSettingsButtonHBox.getChildren().add(backToLadderSettingsButton);

        gridPane.add(repsToDoLabel, 10, 10);
        gridPane.add(breakTimeLabel, 20, 10);
        gridPane.add(summaryRepsLabel, 30, 10);
        gridPane.add(repsToDoStaticLabel, 10, 20);
        gridPane.add(breakTimeStaticLabel, 20, 20);
        gridPane.add(summaryRepsStaticLabel, 30, 20);

        Scene ladderTrainingScene = new Scene(anchorPane, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(ladderTrainingScene);

        backToLadderSettingsButton.setOnAction(event -> ladderSettingsScene.start(primaryStage));
    }
}
