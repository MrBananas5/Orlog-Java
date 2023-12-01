package com.example.orlog.Realms;

import com.example.orlog.Buttons.NullImage;
import com.example.orlog.Game.Dice;

import com.example.orlog.Game.Player;
import com.example.orlog.Game.Playnum;
import com.example.orlog.Powers.Power;
import javafx.scene.Group;
import javafx.scene.effect.Glow;


import java.util.ArrayList;
import java.util.Random;

import static com.example.orlog.Game.DiceVal.*;

public class Midgard {
    protected Power power = null;
    private final String name;
    protected String sname;
    private final String tint;
    private final String path;
    private final Random rand;
    private final String textCol;
    public Midgard(String name,String path,String tint){
        this.name = name;
        this.sname = name;
        this.path = path;
        this.tint = tint;
        this.textCol = "#000000";
        rand = new Random();
    }

    public Midgard(String name,String tint,String textCol,int n) {
        this.name = name;
        this.sname = name;
        this.path = name+"/";
        this.tint = tint;
        this.textCol = textCol;
        rand = new Random();
    }

    public Power getPower(){return power;}

    public String getName() {return name;}
    public String getSName() {return sname;}

    public String getIcon() {
        return this.path+"Icon.png";
    }

    public String getPath(){return this.path;}
    public String getTint() {
        return tint;
    }

    public void rollDice(ArrayList<Dice> pdice ){
        for (Dice dice: pdice) {
            dice.setX(-100);dice.setY(-100);}
        for (Dice dice: pdice) {
            if (!dice.getChosen()) {
                dice.roll();
            }}
    }
    private boolean inBounds(int tx, int ty,int x1, int y1, int x2, int y2){
        return ((x1<tx && tx < x2 )&&(y1<ty && ty<y2));
    }
    public void setUp(Player player){}
    private boolean overlap(int x1, int y1, int x2, int y2, int s){
        return( inBounds(x1,y1,x2,y2,x2+s,y2+s) ||
                inBounds(x1+s,y1,x2,y2,x2+s,y2+s) ||
                inBounds(x1,y1+s,x2,y2,x2+s,y2+s) ||
                inBounds(x1+s,y1+s,x2,y2,x2+s,y2+s)
                );
    }
    protected int[] dicePos(ArrayList<Dice> pdice, int y1, int y2){
        int rx;int ry;
        boolean valid;
        while (true) {
             valid = true;
            rx = rand.nextInt(0,900 - 96);
            ry = rand.nextInt(y1, y2-96);
            for (Dice d : pdice) {
                int dx=d.getX();int dy = d.getY();
                if (overlap(rx,ry,dx,dy,96)){valid = false;}
            }
            if (valid){return new int[]{rx,ry};

        }
    }}
    public void displayDice(Group root,ArrayList<Dice> pdice, int y1,int y2){
        for (Dice dice:pdice) {
            if (!dice.getChosen()) {
                int[] pos = dicePos(pdice, y1, y2);
                dice.display(root, pos[0], pos[1]);
            }
        }
    }
    public void hideDice(Group root,ArrayList<Dice> pdice, int x){
        int n = 0;
        for (Dice dice:pdice){
            dice.hide(root);
            if (dice.getChosen()){dice.miniDisplay(root,48, x+ (n++*49),(750-48)/2);}
        }
    }
    public void resolve(Player p1,Player p2,Group root){
        p1.incDmg((p1.getSymbs(AXE) - p2.getSymbs(WARRIOR)));
        p1.incDmg((p1.getSymbs(BOW)-p2.getSymbs(SHIELD)));
        int f = p2.stealFavour(p1.getSymbs(THIEF));
        p1.incFavour(f);
        p1.incDmg(p1.getBorders(VIDAR));
        p1.incHealth(p1.getBorders(FRIGG));
        p2.incFavour(-p1.getBorders(LOKI));
        p1.incFavour(p1.getBorders(GOLD));
        for (Power power: p1.getPowers()){
            if (power.isActive()){
                if (p1.getFavour()>= power.getCost()) {
                    power.doIt(p1, this);p1.incFavour(-power.getCost());}}
            power.setActive(false);
        }
        p2.incHealth(-p1.getDmg());
        for (Dice dice: p1.getDice()) {
            dice.setChosen(false);
            dice.dim();
            dice.hide(root);
        }
        p1.setDmg(0);

    }

    public void gameOver(Playnum p, Group root) {
        NullImage winB = new NullImage(path,"Lose_"+ p.name(),0,0,900,750);
        winB.getNode().setEffect(new Glow(10));

        winB.load(root.getChildren());
    }

    public String getTextCol() {return textCol;}
}
