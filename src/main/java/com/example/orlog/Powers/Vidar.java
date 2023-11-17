package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;

public class Vidar extends DicePower{
    public Vidar(int x, int y, DicePack pack) {
        super("Vidar",x,y,pack);
    }
    public Vidar copy(DicePack pack) { return new Vidar(900 -64- x,y,pack);}
}
