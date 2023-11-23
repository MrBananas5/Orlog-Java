package com.example.orlog.Game;

import com.example.orlog.Realms.Midgard;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

import java.util.Random;

import static com.example.orlog.Game.DiceVal.getBorder;

public class Dice {
    private final Side[] sides;
    private Side active;
    private Random rand;
    private DiceVal type;
    private DiceVal[] symbs;
    private boolean chosen;

    private int x;
    private int y;

    public Dice(Midgard realm, DiceVal type,DiceVal[] sides, int sx, int sy) {
        this.sides = new Side[]{null,null,null,null,null,null};
        for (int n = 0;n<6;n++){
            this.sides[n] = new Side(realm.getPath(),type,DiceVal.getBorder(n,type),sides[n],sx,sy,realm.getTint());
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
        }
    }

    public void toggleChosen() {chosen = !chosen;}

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
        return active.getSymb();
    }

    public DiceVal getBorder() {
        return active.getBorder();
    }
}
