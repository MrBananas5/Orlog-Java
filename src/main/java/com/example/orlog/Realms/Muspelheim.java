package com.example.orlog.Realms;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Powers.Surtur;

public class Muspelheim extends Midgard {
    public Muspelheim(DicePack pack) {
        super("Muspelheim"); this.sname = "Muspel";
        power = new Surtur(99,452,pack);
    }
}
