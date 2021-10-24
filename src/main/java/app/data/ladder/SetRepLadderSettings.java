package app.data.ladder;

import app.scene.nextTraining.ladderScene.LadderSettingsScene;

public class SetRepLadderSettings {

    public static int defaultReps = 1;
    public int intervalRep = 1;

    public void plusIntervalRepToDefaultReps() {
        defaultReps += intervalRep;
        if (defaultReps == 1) LadderSettingsScene.repSettingsLabel.setText(defaultReps + " rep step");
        else LadderSettingsScene.repSettingsLabel.setText(defaultReps + " reps step");
    }

    public void minusIntervalRepFromDefaultReps() {
        defaultReps -= intervalRep;
        if (defaultReps == 0) defaultReps = 1;
        if (defaultReps == 1) LadderSettingsScene.repSettingsLabel.setText(defaultReps + " rep step");
        else LadderSettingsScene.repSettingsLabel.setText(defaultReps + " reps step");
    }
}
