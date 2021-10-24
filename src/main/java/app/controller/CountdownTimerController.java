package app.controller;

import app.data.timer.CountdownTimerData;

public class CountdownTimerController {

    CountdownTimerData countdownTimerData = new CountdownTimerData();

    public int elapsedTime() {
        int time = countdownTimerData.downloadElapsedTime();
        return countdownTimerData.convertTime(time);
    }
}
