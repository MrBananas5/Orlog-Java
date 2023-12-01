package com.example.orlog.Game;

import com.example.orlog.Realms.Midgard;

import javafx.scene.Group;


import java.util.Random;



public class Dice {
    private Side[] sides;
    private Side active;
    private final Random rand;
    private final DiceVal type;
    private final DiceVal[] symbs;
    private boolean chosen;
    private String tint;
    private int x;
    private int y;

    public Dice(Midgard realm, DiceVal type,DiceVal[] sides, int sx, int sy) {
        this.sides = new Side[]{null,null,null,null,null,null};
        tint = realm.getTint();
        for (int n = 0;n<6;n++){
            this.sides[n] = new Side(realm.getPath(),type,DiceVal.getBorder(n,type),sides[n],sx,sy,tint);
            this.sides[n].setClick(this);
        }
        rand = new Random();
        symbs = sides;
        this.type = type;
    }
    public void print(){
        System.out.print("{");
        for (Side side: sides){
            System.out.print(side.getString() +",");
        }
        System.out.println("}");
    }

    public DiceVal getType() {return type;}
    public DiceVal[] getSymbs(){return symbs;}
    public void roll() {
        active = sides[rand.nextInt(6)];
    }

    public void display(Group root, int x, int y) {
        this.x = x;
        this.y = y;
        active.load(x,y,root.getChildren());
    }
    public void hide(Group root){
        if (active != null) {
            active.delete(root.getChildren());
            active.set(96,0,0,tint);
        }
    }

    public void toggleChosen() {
        chosen = !chosen;
    if (chosen){active.highlight();
    }else{active.dim();}
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public String getActive(){
        return active.getString();
    }

    public void setX(int i) {x= i;
    }
    public void setY(int i) {y= i;
    }

    public boolean getChosen() {
        return chosen;
    }

    public void setChosen(boolean b) {chosen = b;}

    public DiceVal getSymb() {
        if (this.active != null) {
            return active.getSymb();
        }
        return null;
    }

    public DiceVal getBorder() {
        return active.getBorder();
    }

    public void dim() {
        if (this.active != null) {
        active.untint();
        active.dim();
    }}

    public void miniDisplay(Group root,int s, int x, int y) {
        active.set(s,x,y,null);
        active.untint();
        active.load(x,y,root.getChildren());
    }

    public void mistDice() {
        for (int n = 0; n < sides.length; n++){sides[n] = sides[n].mist(this);}
    }
}
