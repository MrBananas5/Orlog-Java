package com.example.orlog.Realms;

import com.example.orlog.Game.Dice;
import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Powers.Heimdall;
import javafx.scene.Group;

import java.util.ArrayList;

public class Niflheim extends Midgard {

    public Niflheim(DicePack pack) {
        super("Niflheim","#00eeff","#000000",1);this.sname = "Nifl";
        power = new Heimdall(99,452,pack);
    }
    public void setUp(Player p1){
        System.out.println();
        for (Dice d: p1.getDice()){d.mistDice();}
    }
}
