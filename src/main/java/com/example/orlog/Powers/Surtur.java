package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;

public class Surtur extends Power{

    public Surtur(int x, int y, DicePack pack) {
        super("Surtur",x, y, pack);
    }
    public Surtur copy(DicePack pack) { return new Surtur(900 -64- x,y,pack);}
}
