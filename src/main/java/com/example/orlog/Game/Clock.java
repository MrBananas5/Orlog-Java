package com.example.orlog.Game;

import java.util.Timer;

public class Clock {
    private Timer timer;
     static Clock clock = new Clock();
     private Clock() {
         timer= new Timer();
     }
    public Timer getTimer() {return timer;}

}
