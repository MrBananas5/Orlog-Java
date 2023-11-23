package com.example.orlog.Powers;


import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Realms.Midgard;


public class Freyja extends Power{

    public Freyja(int x, int y, DicePack pack) {
        super("Freyja",12,x, y, pack);
    }
    public Freyja copy(DicePack pack) { return new Freyja(900 -64- x,y,pack);
    }
    public void doIt(Player p, Midgard realm){
        p.incHealth(10);
    }
}
