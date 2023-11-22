package com.example.orlog.Game;

import com.example.orlog.Realms.Midgard;

public class Dice {
    private final Side[] sides;
    private Side active;

    public Dice(Midgard realm, DiceVal[][] sides, int sx, int sy) {
        this.sides = new Side[]{null,null,null,null,null,null};
        for (int n = 0;n<6;n++){
            this.sides[n] = new Side(realm.getPath(),sides[n][0],sides[n][1],sides[n][2],0,0,sx,sy,realm.getTint());
        }
    }
    public void print(){
        System.out.print("{");
        for (Side side: sides){
            System.out.print(side.getString() +",");
        }
        System.out.println("}");
    }
}
