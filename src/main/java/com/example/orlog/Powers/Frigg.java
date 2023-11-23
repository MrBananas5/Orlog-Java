package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.DiceVal;

public class Frigg extends DicePower{
    public Frigg(int x, int y, DicePack pack) {
        super("Frigg",x,y, DiceVal.FRIGG,pack);
    }
    public Frigg copy(DicePack pack) { return new Frigg(900 -64- x,y,pack);}
}
