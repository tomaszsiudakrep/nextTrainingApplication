import app.data.timer.CountdownTimerData;
import app.data.ladder.SetTimeLadderSettings;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TestSuiteCountdownTimer {

    CountdownTimerData countdownTimerData = new CountdownTimerData();

    @Test
    void test_convertTime() {
        //Given
        int time = 60;
        //When
        int result =  countdownTimerData.convertTime(time);
        //Then
        Assertions.assertEquals(3600000,result);
    }

    @Test
    void test_downloadElapsedTime() {
        //Given
        SetTimeLadderSettings.defaultTime = 100;
        //When
        int time = countdownTimerData.downloadElapsedTime();
        //Then
        Assertions.assertEquals(100, time);
    }

}
