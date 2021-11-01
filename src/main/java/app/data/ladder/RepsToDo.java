package app.data.ladder;

import app.scene.nextTraining.ladderScene.LadderSettingsScene;
import app.scene.nextTraining.ladderScene.LadderTrainingScene;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class RepsToDo {

    public static int repsToDo = 0;
    public static int summaryReps = 0;
    public static List<Integer> listOfReps;
    public boolean finishTraining;

    public RepsToDo() {
        listOfReps = new ArrayList<>();
        finishTraining = false;
    }

    public void addRepsToList(int reps) {
        listOfReps.add(reps);
    }

    public int nextStep(List<Integer> list, int reps) {
        if (list.size() == 0) repsToDo += reps;
        else repsToDo = list.get(list.size()-1) + reps;
        return repsToDo;
    }

    public void changeTextInLabel(int reps) {
        LadderTrainingScene.repsToDoStaticLabel.setText(reps + "");
    }

    public void changeTextInSummaryLabel(int reps) {
        LadderTrainingScene.summaryRepsStaticLabel.setText(reps + "");
    }

    public int summary(List<Integer> list) {
        return summaryReps = list.stream().reduce((summaryReps, element) -> summaryReps += element).get();
    }

    public void clear() {
        repsToDo = 0;
        finishTraining = false;
        listOfReps = new ArrayList<>();
        summaryReps = 0;
    }

    public void endTraining() {
        finishTraining = true;
    }

}
