package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;

public class Idun extends Power{
    public Idun(int x, int y, DicePack pack) {
        super("Idun", x, y, pack);
    }
    public Idun copy(DicePack pack) { return new Idun(900 -64- x,y,pack);}
}
