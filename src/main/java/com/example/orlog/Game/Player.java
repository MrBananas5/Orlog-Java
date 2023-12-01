package com.example.orlog.Game;
import com.example.orlog.Powers.Power;

import java.util.ArrayList;
import java.util.Random;
public class Player {
    private int favour; private int health;private int dmg;

    private ArrayList<Dice> dice;  private ArrayList<Power> powers;
    private final Playnum player;
    public Player(Playnum p){
        player = p;
    }

    public Playnum getP(){return player;}
    public Playnum getNum(){return Playnum.getPlayer(new Random().nextInt(2));}

    public int getFavour() {
        return favour;
    }

    public void setFavour(int favour) {this.favour = favour;}

    public int getHealth() {
        return health;
    }


    public void setHealth(int health) {this.health = health;}

    public ArrayList<Dice> getDice() {
        return dice;
    }

    public void setDice(ArrayList<Dice> dice) {
        this.dice = dice;
    }

    public ArrayList<Power> getPowers() {
        return powers;
    }

    public void setPowers(ArrayList<Power> powers) {
        this.powers = powers;
    }

    public void incHealth(int n){
        if( (health + n) >= 0){
            health +=n;
        }
    }
    public void incFavour(int n){
        if( (favour + n) > 0){
            favour +=n;
            return;
        }favour = 0;
    }
    public int getPN(){return (-2*player.getNumber())+1;}

    public void incDmg(int d) {
        if (d<0 ){d = 0;}
        dmg += d;
    }
    public  int getBorders(DiceVal v){
        int n = 0;
        for (Dice d: dice) {if (d.getBorder()==v){n++;}}
        return n;
    }
    public int getSymbs(DiceVal v) {
        int n = 0;
        for (Dice d: dice) {if (d.getSymb()==v){n++;}}
        return n;
    }

    public int stealFavour(int val) {
        if (val > favour){val = favour;}
        favour = favour - val;
        return val;
    }

    public int getDmg() {
        return dmg;
    }

    public void setDmg(int n) { dmg = n;}
}
