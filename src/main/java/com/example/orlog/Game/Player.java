package com.example.orlog.Game;
import com.example.orlog.Powers.Power;

import java.util.ArrayList;
import java.util.Random;
public class Player {
    private int favour; private int health;

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

    public void setFavour(int favour) {
        this.favour = favour;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
        System.out.println(this.health);
    }

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
    public boolean incHealth(int n){
        if( (health + n) > 0){
            health +=n;
            return true;
        }return false;}
    public boolean incFavour(int n){
        if( (favour + n) > 0){
            favour +=n;
            return true;
        }return false;}
    public int getPN(){return (-2*player.getNumber())+1;}
}
