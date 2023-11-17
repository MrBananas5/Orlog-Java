package com.example.orlog.Realms;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Powers.Heimdall;

public class Niflheim extends Midgard {

    public Niflheim(DicePack pack) {
        super("Niflheim");this.sname = "Nifl";
        power = new Heimdall(99,452,pack);
    }

}
