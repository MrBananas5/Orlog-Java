package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;

public class Thor extends Power{
    public Thor(int x, int y, DicePack pack) {
        super("Thor",x,y,pack);
    }
    public Thor copy(DicePack pack) { return new Thor(900 -64- x,y,pack);}
}
