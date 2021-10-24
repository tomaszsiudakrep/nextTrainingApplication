package app.data;

import app.scene.nextTraining.ladderScene.LadderSettingsScene;

public class SetTimeLadderSettings {

    public static int defaultTime = 60;
    public int intervalTime = 5;

    public void plusIntervalTimeToDefaultTime() {
        defaultTime += intervalTime;
        LadderSettingsScene.timeSettingsLabel.setText(defaultTime + " seconds break");
    }

    public void minusIntervalTimeFromDefaultTime() {
        defaultTime -= intervalTime;
        if (defaultTime == 0) defaultTime = 5;
        LadderSettingsScene.timeSettingsLabel.setText(defaultTime + " seconds break");
    }
}
