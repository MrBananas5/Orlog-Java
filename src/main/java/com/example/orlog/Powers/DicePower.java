package com.example.orlog.Powers;


import com.example.orlog.Game.Dice;
import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.DiceVal;
import com.example.orlog.Game.Player;
import com.example.orlog.Realms.Midgard;

public class DicePower extends Power{
    DiceVal type;
    public DicePower(String name, int x, int y, DiceVal type, DicePack pack) {
        super(name,6,x,y,pack);
        this.type = type;
    }
    public void doIt(Player p , Midgard realm){
        for (Dice dice: p.getDice() ){
            if (dice.getType() == DiceVal.BASIC){
                p.getDice().set(p.getDice().indexOf(dice),new Dice(realm,type,dice.getSymbs(),96,96));
            }
        }
        p.incFavour(cost);
    }

}
