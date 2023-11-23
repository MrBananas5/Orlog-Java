package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;

public class Heimdall extends Power{
    public Heimdall(int x, int y, DicePack pack) {
        super("Heimdall",8,x,y,pack);
    }
    public Heimdall copy(DicePack pack) { return new Heimdall(900 - 64-x,y,pack);}
}
