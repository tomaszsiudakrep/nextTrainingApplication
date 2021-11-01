package app.data.timer;

import app.scene.nextTraining.ladderScene.LadderSettingsScene;

public class CountdownTimerData {

    public static int convertTime(int elapsedTime) {
        return elapsedTime * 1000;
    }

    public static int downloadElapsedTime() {
        return LadderSettingsScene.defaultTime;
    }
}
