package com.example.orlog.Realms;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Powers.Idun;

public class Asgard extends Midgard {

    public Asgard(DicePack pack) {
        super("Asgard","#FFFF00");
        power = new Idun(99,452,pack);
    }

}
