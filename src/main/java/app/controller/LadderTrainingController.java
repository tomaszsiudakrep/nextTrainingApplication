package app.controller;

import app.data.ladder.RepsToDo;
import app.data.timer.CountdownTimer;
import app.scene.nextTraining.ladderScene.LadderSettingsScene;
import app.scene.nextTraining.ladderScene.LadderTrainingScene;

import java.util.List;

public class LadderTrainingController {

    RepsToDo repsToDo = new RepsToDo();
    CountdownTimer countdownTimer = new CountdownTimer();

    public void startLadderTraining() {
        int reps = LadderSettingsScene.defaultReps;
        List<Integer> list = RepsToDo.listOfReps;
        repsToDo.nextStep(list, reps);
        repsToDo.changeTextInLabel(reps);
        int summaryReps = RepsToDo.summaryReps;
        repsToDo.changeTextInSummaryLabel(summaryReps);
    }

    public void repsDone() {
        LadderTrainingScene.repsDoneButton.setDisable(true);
        int reps = RepsToDo.repsToDo;
        repsToDo.addRepsToList(reps);
        repsToDo.summary(RepsToDo.listOfReps);
        int summaryReps = RepsToDo.summaryReps;
        repsToDo.changeTextInSummaryLabel(summaryReps);
        repsToDo.nextStep(RepsToDo.listOfReps, LadderSettingsScene.defaultReps);
        repsToDo.changeTextInLabel(RepsToDo.repsToDo);
        CountdownTimer.start();
    }

    public void endOfTraining() {
        repsToDo.endTraining();
        LadderTrainingScene.repsToDoStaticLabel.setText(RepsToDo.repsToDo -1 + "");
        LadderTrainingScene.repsToDoLabel.setText("DONE LVL");
        LadderTrainingScene.breakTimeLabel.setText("GOOD JOB !");
        LadderTrainingScene.repsDoneButton.setDisable(true);
        LadderTrainingScene.repsNotDoneButton.setDisable(true);
    }

    public void  repsNotDone() {

    }
}
