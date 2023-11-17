package com.example.orlog.Game;


import com.example.orlog.Powers.Power;

import java.util.ArrayList;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class DicePack {
    private int maxPower;
    private ArrayList<ArrayList<Power>> powers;
    private int startHealth;
    private int startEnergy;
    private ArrayList<ArrayList<Dice>> dice;
    public DicePack(){
        start();
    }
    private void start(){
        maxPower =7;
        startHealth = 15;
        startEnergy = 0;
        dice = new ArrayList<>();
        powers = new ArrayList<>();
        for (int i = 0;i<2;i++){
            powers.add(new ArrayList<>());
            dice.add(new ArrayList<>());
        }
    }
    private void removePower(Power power, int p){
        power.getChild().delete(menucontroller.getGroup().getChildren());
        menucontroller.getPowerMenu().remove(power.getChild());
        powers.get(p).remove(power);
        for (Power pow : powers.get(p)){
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
    public int powerSize(int p){return powers.get(p).size();
    }
    public int powerIndex(int p, Power power){return powers.get(p).indexOf(power);
    }
    public void addPower(Power power, int p) {
        if (powers.get(p).contains(power)){
            removePower(power,p);
        }
        else if (powers.get(p).size() < maxPower ){
            powers.get(p).add(power);
            menucontroller.getPowerMenu().add(power.getChild());
            power.getChild().load(menucontroller.getGroup().getChildren());
        }
    }

}
