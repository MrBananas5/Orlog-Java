package com.example.orlog.Realms;

import com.example.orlog.Game.Player;
import javafx.scene.Group;

import static com.example.orlog.Game.DiceVal.*;

public class Alfheim extends Midgard {


    public Alfheim() {
        super("Alfheim","FF0055","#000000");this.sname = "Alf";
    }
    //in Alfheim, everything resolves 'inverted' so 1 warrior = 1Thief, 1 Axe, 1 Shield, 1 bow
@Override
    public void resolve(Player p1, Player p2, Group root){
        int p1d = p1.getDice().size();
        int p2d = p2.getDice().size();
        p1.incDmg((p1d-p1.getSymbs(AXE))-(p2d-p2.getSymbs(WARRIOR)));//The number of dice that aren't AXE etc.
        p1.incDmg((p1d-p1.getSymbs(BOW))-(p2d-p2.getSymbs(SHIELD)));//The number of dice that aren't BOW etc.
        doFavor(p1,p2);
        doBorders(p1,p2);
        doPowers(p1);
        p2.incHealth(-p1.getDmg());
        endResolve(p1,root);

}
@Override
    protected void doFavor(Player p1, Player p2){
        int f = p2.stealFavour(p1.getDice().size()-p1.getSymbs(THIEF));
        p1.incFavour(f);
    }
}

