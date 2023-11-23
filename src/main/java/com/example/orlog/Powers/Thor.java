package com.example.orlog.Powers;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Realms.Midgard;

public class Thor extends Power{
    public Thor(int x, int y, DicePack pack) {
        super("Thor",12,x,y,pack);
    }
    public Thor copy(DicePack pack) { return new Thor(900 -64- x,y,pack);}
    public void doIt(Player p, Midgard realm){
        p.incDmg(8);
    }
}
