package Controller;

import javafx.animation.AnimationTimer;

public abstract class Timer extends AnimationTimer {

    private long sleepNs = 0;

    long prevTime = 0;

    public Timer(long sleepMs) {
        this.sleepNs = sleepMs * 1_000_000;
    }

    @Override
    public void handle(long now) {

        if ((now - prevTime) < sleepNs) {
            return;
        }

        prevTime = now;

        doAction();
    }

    public abstract void doAction();
}