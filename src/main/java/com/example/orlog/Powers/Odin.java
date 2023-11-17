package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;

public class Odin extends DicePower{
    public Odin(int x, int y, DicePack pack) {
        super("Odin",x,y,pack);
    }
    public Odin copy(DicePack pack) { return new Odin(900 -64- x,y,pack);}
}
