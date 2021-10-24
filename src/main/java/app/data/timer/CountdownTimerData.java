package app.data.timer;

import app.data.ladder.SetTimeLadderSettings;

public class CountdownTimerData {

    public int convertTime(int elapsedTime) {
        return elapsedTime * 1000 * 60;
    }

    public int downloadElapsedTime() {
        return SetTimeLadderSettings.defaultTime;
    }
}
