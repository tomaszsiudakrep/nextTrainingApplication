package app.data.timer;

import app.controller.CountdownTimerController;
import app.scene.nextTraining.ladderScene.LadderSettingsScene;
import app.scene.nextTraining.ladderScene.LadderTrainingScene;
import javafx.application.Platform;
import javafx.scene.control.Label;
import javax.swing.*;

public class CountdownTimer {

    CountdownTimerController countdownTimerController = new CountdownTimerController();

    public static Label timeLabel = new Label();
    public static int elapsedTime;
    public static int hours = 0;
    public static int minutes = 0;
    public static int seconds = 0;
    public static boolean started = false;
    public static String hours_string = String.format("%02d", hours);
    public static String minutes_string = String.format("%02d", minutes);
    public static String seconds_string = String.format("%02d", seconds);

    public static Timer timer = new Timer(1000, e -> Platform.runLater(() -> {
        elapsedTime -= 1000;
        hours = (elapsedTime / 3600000);
        minutes = (elapsedTime / 60000) % 60;
        seconds = (elapsedTime / 1000) % 60;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
        if (elapsedTime == 0) {
            stopTimer();
            started = false;
            elapsedTime = CountdownTimerController.elapsedTime();
            LadderTrainingScene.repsDoneButton.setDisable(false);
            timeLabel.setText("LET'S GO");
        }
    }));

    public CountdownTimer() {
        elapsedTime = CountdownTimerController.elapsedTime();
        timeLabel.setPrefWidth(150);
        timeLabel.setPrefHeight(30);
        timeLabel.setStyle("-fx-background-color: white; -fx-font-size: 30; -fx-text-fill: #6857a5;-fx-underline: false; -fx-text-alignment: center; -fx-alignment: center");
        timeLabel.setText("LET'S GO");
    }

    public static void start() {
        if (!started) {
            started = true;
            startTimer();
        } else {
            started = false;
            stopTimer();
        }
    }

    public static void reset() {
        stopTimer();
        started = false;
        seconds = 0;
        minutes = 0;
        hours = 0;
        seconds_string = String.format("%02d", seconds);
        minutes_string = String.format("%02d", minutes);
        hours_string = String.format("%02d", hours);
        timeLabel.setText(hours_string + ":" + minutes_string + ":" + seconds_string);
    }

    public static void startTimer() {
        timer.start();
    }

    public static void stopTimer() {
        timer.stop();
    }

    public static void plusIntervalTimeToDefaultTime() {
        LadderSettingsScene.defaultTime += LadderSettingsScene.intervalTime;
        LadderSettingsScene.timeSettingsLabel.setText(LadderSettingsScene.defaultTime + " seconds break");
    }

    public static void minusIntervalTimeFromDefaultTime() {
        LadderSettingsScene.defaultTime -= LadderSettingsScene.intervalTime;
        if (LadderSettingsScene.defaultTime == 0) LadderSettingsScene.defaultTime = 5;
        LadderSettingsScene.timeSettingsLabel.setText(LadderSettingsScene.defaultTime + " seconds break");
    }

}
