package com.example.orlog.Game;


import com.example.orlog.Powers.Power;
import com.example.orlog.Realms.Midgard;
import java.util.ArrayList;

import static com.example.orlog.Game.DiceVal.*;
import static com.example.orlog.Menu.MenuController.menucontroller;

public class DicePack {
    private int maxPower;
    private ArrayList<ArrayList<Power>> powers;

    public int getStartHealth() {
        return startHealth;
    }

    public int getStartFavour() {
        return startEnergy;
    }
    public ArrayList<Dice> getDice(Playnum p){
        return dice.get(p.getNumber());
    }
    public ArrayList<Power> getPowers(Playnum p){
        return powers.get(p.getNumber());
    }

    private int startHealth;
    private int startEnergy;
    private ArrayList<ArrayList<Dice>> dice;
    public DicePack(){
        start();
    }
    private void start(){
        maxPower =7;
        startHealth = 15;
        startEnergy = 12;
        dice = new ArrayList<>();
        powers = new ArrayList<>();
        for (int i = 0;i<2;i++){
            powers.add(new ArrayList<>());
            dice.add(new ArrayList<>());

        }
    }
    private void removePower(Power power, Playnum p){
        power.getChild().delete(menucontroller.getGroup().getChildren());
        menucontroller.getPowerMenu().remove(power.getChild());
        powers.get(p.getNumber()).remove(power);
        rePos(p);
    }
    private void rePos(Playnum p){
        for (Power pow : powers.get(p.getNumber())){
            pow.rePos(this);
        }
    }
    public void clear(){
        for (int i = 0; i<2;i++){
            for (Power power:powers.get(i)){
                power.getChild().delete(menucontroller.getGroup().getChildren());
                menucontroller.getPowerMenu().remove(power.getChild());
            }
        }
        start();}
    public int powerSize(Playnum p){return powers.get(p.getNumber()).size();
    }
    public int powerIndex(Playnum p, Power power){return powers.get(p.getNumber()).indexOf(power);
    }
    public void addPower(Power power, Playnum p) {
        if (powers.get(p.getNumber()).contains(power)){
            removePower(power,p);
        }
        else if (powers.get(p.getNumber()).size() < maxPower ){
            powers.get(p.getNumber()).add(power);
            menucontroller.getPowerMenu().add(power.getChild());
            power.getChild().load(menucontroller.getGroup().getChildren());
            rePos(p);

        }
    }
    public void setDice(Playnum p,Midgard realm, DiceVal[] vals){
        DiceVal[] symbs = new DiceVal[]{AXE,WARRIOR,BOW,SHIELD,THIEF};

        for (int i = 0; i<5;i++){
            DiceVal[] sides = new DiceVal[]{null,null,null,null,null,null};
            for (int j =0; j<6;j++){sides[j] = symbs[(i+j)%5];}
            dice.get(p.getNumber()).add(new Dice(realm,vals[i],sides,96,96));}
    }
}
