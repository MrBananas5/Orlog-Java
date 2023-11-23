package com.example.orlog.Powers;

import com.example.orlog.Game.*;
import com.example.orlog.Realms.Midgard;

import static com.example.orlog.Game.DiceVal.ODIN;

public class Odin extends Power{
    public Odin(int x, int y, DicePack pack) {
        super("Odin",8,x,y,pack);
    }
    public Odin copy(DicePack pack) { return new Odin(900 -64- x,y,pack);}
    public void doIt(Player p, Midgard realm){
        p.getDice().add(new Dice(realm,ODIN,new DiceVal[]{DiceVal.AXE, DiceVal.THIEF, DiceVal.BOW, DiceVal.THIEF, DiceVal.WARRIOR, DiceVal.SHIELD},96,96));
        }

}
