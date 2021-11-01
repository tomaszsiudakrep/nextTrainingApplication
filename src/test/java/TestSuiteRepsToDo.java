import app.data.ladder.RepsToDo;
import app.scene.nextTraining.ladderScene.LadderSettingsScene;
import app.scene.nextTraining.ladderScene.LadderTrainingScene;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class TestSuiteRepsToDo {

    RepsToDo repsToDo = new RepsToDo();

    @Test
    void test_addRepsToList() {
        //Given
        int reps = 2;
        List<Integer> list = new ArrayList<>();
        list.add(2);
        //When
        int next = repsToDo.nextStep(list, reps);
        //Then
        Assertions.assertEquals(4, next);
    }

    @Test
    void test_summary() {
        //Given
        List<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(4);
        list.add(6);
        list.add(0);
        //When
        int result = repsToDo.summary(list);
        //Then
        Assertions.assertEquals(12, result);
    }

    @Test
    void test_changeTextInLabel() {
        //Given
        int reps = 2;
        //When
        repsToDo.changeTextInLabel(reps);
        //Then
        Assertions.assertEquals("2", LadderTrainingScene.repsToDoStaticLabel.getText());
    }
}
