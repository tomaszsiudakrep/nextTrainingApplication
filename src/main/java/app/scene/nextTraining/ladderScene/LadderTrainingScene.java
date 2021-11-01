package app.scene.nextTraining.ladderScene;

import app.controller.CountdownTimerController;
import app.controller.LadderTrainingController;
import app.data.BackButton;
import app.data.BackgroundSettings;
import app.data.ladder.RepsToDo;
import app.data.timer.CountdownTimer;
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
    CountdownTimerController countdownTimerController = new CountdownTimerController();
    LadderSettingsScene ladderSettingsScene;
    LadderTrainingController ladderTrainingController = new LadderTrainingController();
    BackButton backButton;
    RepsToDo repsToDo = new RepsToDo();

    public static CountdownTimer countdownTimer;
    public static Label repsToDoStaticLabel;
    public static Label summaryRepsStaticLabel;
    public static Button repsDoneButton;
    public static Button repsNotDoneButton;
    public static Label breakTimeLabel;
    public static Label repsToDoLabel;

    @Override
    public void start(Stage primaryStage) {
        backButton = new BackButton();
        countdownTimer = new CountdownTimer();
        ladderSettingsScene = new LadderSettingsScene();

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

        repsToDoLabel = new Label("TO DO");
            repsToDoLabel.setPrefHeight(30);
            repsToDoLabel.setPrefWidth(150);
            repsToDoLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        Label summaryRepsLabel = new Label("SUMMARY");
            summaryRepsLabel.setPrefHeight(30);
            summaryRepsLabel.setPrefWidth(150);
            summaryRepsLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        breakTimeLabel = new Label("BREAK TIME");
            breakTimeLabel.setPrefHeight(30);
            breakTimeLabel.setPrefWidth(150);
            breakTimeLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        repsToDoStaticLabel = new Label();
            repsToDoStaticLabel.setPrefHeight(30);
            repsToDoStaticLabel.setPrefWidth(150);
            repsToDoStaticLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        CountdownTimer.timeLabel.setStyle("-fx-background-color: white; -fx-alignment: center");
        summaryRepsStaticLabel = new Label();
            summaryRepsStaticLabel.setPrefHeight(30);
            summaryRepsStaticLabel.setPrefWidth(150);
            summaryRepsStaticLabel.setStyle("-fx-font-size: 15;-fx-background-color: white;-fx-alignment: center");
        Button endTrainingButton = new Button("END TRAINING");
            endTrainingButton.setPrefHeight(50);
            endTrainingButton.setPrefWidth(300);
        repsDoneButton = new Button("REPS DONE");
            repsDoneButton.setPrefHeight(50);
            repsDoneButton.setPrefWidth(150);
        repsNotDoneButton = new Button("REPS NOT DONE \nAND GO DOWN");
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
        gridPane.add(CountdownTimer.timeLabel, 20, 20);
        gridPane.add(summaryRepsStaticLabel, 30, 20);

        Scene ladderTrainingScene = new Scene(anchorPane, BackgroundSettings.width, BackgroundSettings.height, Color.BLACK);
        primaryStage.setScene(ladderTrainingScene);

        backToLadderSettingsButton.setOnAction(event -> {
            countdownTimerController.resetTimer();
            repsToDo.clear();
            ladderSettingsScene.start(primaryStage);
        });
        repsDoneButton.setOnAction(event -> ladderTrainingController.repsDone());
        endTrainingButton.setOnAction(event -> ladderTrainingController.endOfTraining());
    }
}
