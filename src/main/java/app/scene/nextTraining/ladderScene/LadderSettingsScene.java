package app.scene.nextTraining.ladderScene;

import app.controller.LadderTrainingController;
import app.data.BackgroundSettings;
import app.data.ladder.SetRepLadderSettings;
import app.data.timer.CountdownTimer;
import app.scene.nextTraining.NextTrainingScene;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class LadderSettingsScene extends Application {

    BackgroundSettings backgroundSettings = new BackgroundSettings();
    SetRepLadderSettings setRepLadderSettings = new SetRepLadderSettings();
    NextTrainingScene nextTrainingScene = new NextTrainingScene();
    LadderTrainingScene ladderTrainingScene = new LadderTrainingScene();;
    LadderTrainingController ladderTrainingController = new LadderTrainingController();

    public static Label timeSettingsLabel;
    public static Label repSettingsLabel;
    public static int defaultTime = 60;
    public static int intervalTime = 5;
    public static int defaultReps = 1;
    public static int intervalRep = 1;

    @Override
    public void start(Stage primaryStage) {
        AnchorPane anchorPane = new AnchorPane();
            anchorPane.setBackground(backgroundSettings.defaultBackground());

        GridPane gridPane = new GridPane();
            gridPane.setPrefWidth(BackgroundSettings.width);
            gridPane.setPrefHeight(BackgroundSettings.height - 25);
            gridPane.setAlignment(Pos.CENTER);
        HBox backToMenuHBox = new HBox();
            backToMenuHBox.setPrefWidth(BackgroundSettings.width);
            backToMenuHBox.setPrefHeight(BackgroundSettings.height);
            backToMenuHBox.setAlignment(Pos.BOTTOM_CENTER);
        HBox startButtonHBox = new HBox();
            startButtonHBox.setPrefWidth(BackgroundSettings.width);
            startButtonHBox.setPrefHeight(100);
            startButtonHBox.setAlignment(Pos.TOP_CENTER);

        anchorPane.getChildren().add(0, backToMenuHBox);
        anchorPane.getChildren().add(1, gridPane);
        anchorPane.getChildren().add(2, startButtonHBox);

        HBox timeButtonsHBox = new HBox();
            timeButtonsHBox.setPrefWidth(300);
            timeButtonsHBox.setPrefHeight(35);
        HBox repButtonsHBox = new HBox();
            repButtonsHBox.setPrefWidth(300);
            repButtonsHBox.setPrefHeight(35);

        Button startTrainingButton = new Button("START");
            startTrainingButton.setPrefWidth(400);
            startTrainingButton.setPrefHeight(75);
        Button backToMenuSettings = new Button("Back to menu");
            backToMenuSettings.setPrefWidth(250);
            backToMenuSettings.setPrefHeight(25);
        timeSettingsLabel = new Label(defaultTime + " seconds break");
            timeSettingsLabel.setPrefWidth(300);
            timeSettingsLabel.setPrefHeight(30);
            timeSettingsLabel.setStyle("-fx-background-color: white;-fx-alignment: center;-fx-font-size: 12");
        repSettingsLabel = new Label(defaultReps + " rep step");
            repSettingsLabel.setPrefWidth(300);
            repSettingsLabel.setPrefHeight(30);
            repSettingsLabel.setStyle("-fx-background-color: white;-fx-alignment: center;-fx-font-size: 12");
        Button plusTime = new Button("+");
            plusTime.setPrefWidth(150);
            plusTime.setPrefHeight(35);
        Button minusTime = new Button("-");
            minusTime.setPrefWidth(150);
            minusTime.setPrefHeight(35);
        Button plusRep = new Button("+");
            plusRep.setPrefWidth(150);
            plusRep.setPrefHeight(35);
        Button minusRep = new Button("-");
            minusRep.setPrefWidth(150);
            minusRep.setPrefHeight(35);

        startButtonHBox.getChildren().add(startTrainingButton);
        backToMenuHBox.getChildren().add(backToMenuSettings);
        timeButtonsHBox.getChildren().addAll(plusTime, minusTime);
        repButtonsHBox.getChildren().addAll(plusRep, minusRep);

        gridPane.add(timeSettingsLabel, 10, 20);
        gridPane.add(repSettingsLabel, 30, 20);
        gridPane.add(timeButtonsHBox, 10, 30);
        gridPane.add(repButtonsHBox, 30, 30);

        Scene sceneSettingTraining = new Scene(anchorPane, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(sceneSettingTraining);

        backToMenuSettings.setOnAction(event -> nextTrainingScene.start(primaryStage));
        plusTime.setOnAction(event -> CountdownTimer.plusIntervalTimeToDefaultTime());
        minusTime.setOnAction(event -> CountdownTimer.minusIntervalTimeFromDefaultTime());
        plusRep.setOnAction(event -> setRepLadderSettings.plusIntervalRepToDefaultReps());
        minusRep.setOnAction(event -> setRepLadderSettings.minusIntervalRepFromDefaultReps());
        startTrainingButton.setOnAction(event -> {
            ladderTrainingScene.start(primaryStage);
            ladderTrainingController.startLadderTraining();
        });
    }
}
