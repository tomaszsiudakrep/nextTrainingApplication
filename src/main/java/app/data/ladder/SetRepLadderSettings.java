package app.data.ladder;

import app.scene.nextTraining.ladderScene.LadderSettingsScene;

public class SetRepLadderSettings {

    public void plusIntervalRepToDefaultReps() {
        LadderSettingsScene.defaultReps += LadderSettingsScene.intervalRep;
        if (LadderSettingsScene.defaultReps == 1) LadderSettingsScene.repSettingsLabel.setText(LadderSettingsScene.defaultReps + " rep step");
        else LadderSettingsScene.repSettingsLabel.setText(LadderSettingsScene.defaultReps + " reps step");
    }

    public void minusIntervalRepFromDefaultReps() {
        LadderSettingsScene.defaultReps -= LadderSettingsScene.intervalRep;
        if (LadderSettingsScene.defaultReps == 0) LadderSettingsScene.defaultReps = 1;
        if (LadderSettingsScene.defaultReps == 1) LadderSettingsScene.repSettingsLabel.setText(LadderSettingsScene.defaultReps + " rep step");
        else LadderSettingsScene.repSettingsLabel.setText(LadderSettingsScene.defaultReps + " reps step");
    }
}
