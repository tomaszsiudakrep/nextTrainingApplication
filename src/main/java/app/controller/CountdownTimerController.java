package app.controller;

import app.data.timer.CountdownTimer;
import app.data.timer.CountdownTimerData;
import app.scene.nextTraining.ladderScene.LadderSettingsScene;

public class CountdownTimerController {

    CountdownTimerData countdownTimerData = new CountdownTimerData();

    public static int elapsedTime() {
        int time = CountdownTimerData.downloadElapsedTime();
        return CountdownTimerData.convertTime(time);
    }

    public void resetTimer() {
        LadderSettingsScene.defaultTime = 60;
        CountdownTimer.reset();
    }
}
