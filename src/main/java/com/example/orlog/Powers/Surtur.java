package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Realms.Midgard;

public class Surtur extends Power{

    public Surtur(int x, int y, DicePack pack) {
        super("Surtur",8,x, y, pack);
    }
    public Surtur copy(DicePack pack) { return new Surtur(900 -64- x,y,pack);}

    @Override
    public void doIt(Player p, Midgard realm) {
        activated = true;
    }
}
