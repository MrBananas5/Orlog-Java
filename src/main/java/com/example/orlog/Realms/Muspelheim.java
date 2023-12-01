package com.example.orlog.Realms;

import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Powers.Power;
import com.example.orlog.Powers.Surtur;
import javafx.scene.Group;

public class Muspelheim extends Midgard {
    public Muspelheim(DicePack pack) {
        super("Muspelheim","#FFAA00","#FF0000",1); this.sname = "Muspel";
        power = new Surtur(99,452,pack);
    }

    @Override
    public void resolve(Player p1, Player p2, Group root) {
        super.resolve(p1, p2, root);
        for (Power power: p1.getPowers()){
            if (power.getName().equals("Surtur")){if (!power.isActivated()){p1.incHealth(-1);}}
        }
    }
}
