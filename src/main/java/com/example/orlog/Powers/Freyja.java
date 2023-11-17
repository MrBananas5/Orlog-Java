package com.example.orlog.Powers;


import com.example.orlog.Game.DicePack;


public class Freyja extends Power{

    public Freyja(int x, int y, DicePack pack) {
        super("Freyja",x, y, pack);
    }
    public Freyja copy(DicePack pack) { return new Freyja(900 -64- x,y,pack);
    }
}
