package com.example.orlog.Powers;


import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.DiceVal;

public class Loki extends DicePower{
    public Loki(int x, int y, DicePack pack) {
        super("Loki",x,y, DiceVal.LOKI,pack);
    }
    public Loki copy(DicePack pack) { return new Loki(900 -64- x,y,pack);}
}
