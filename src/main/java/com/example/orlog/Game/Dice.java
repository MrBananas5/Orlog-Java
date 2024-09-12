package com.example.orlog.Game;

import com.example.orlog.Realms.Midgard;

import javafx.application.Platform;
import javafx.scene.Group;


import java.util.Random;
import java.util.TimerTask;

import static com.example.orlog.Game.Clock.clock;


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
    public void animate(Group root){
        int displays = rand.nextInt(1,10);
        int each = rand.nextInt(2500,3000)/displays;
        animateSide(displays, root,each);}
    private void animateSide(int n,Group root,long delay) {
        //display random sides
        //remove clickability for each side, then restore
        //then show real side
        if (n== 0){active.load(x,y,root.getChildren());}
        if (n > 0) {
            Side sideDisplay;
            sideDisplay = sides[rand.nextInt(6)];
            sideDisplay.noClick();
            sideDisplay.load(x,y,root.getChildren());

            Dice me = this;
            clock.getTimer().schedule(new TimerTask() {
                public void run() {
                    Platform.runLater(() ->
                    {
                        sideDisplay.prepareTint();
                        sideDisplay.delete(root.getChildren());
                        sideDisplay.setClick(me);
                        animateSide(n - 1,root,delay);
                    });
                }
            }, delay); //wait about 3 seconds for dramatic effect, then end turn
        }
    }
    public void display(Group root, int x, int y) {
        this.x = x;
        this.y = y;
        animate(root);
    }
    public void hide(Group root){
        if (active != null) {
            active.delete(root.getChildren());
            active.set(96,0,0,tint);
        }
    }
    public void noClick(){for (Side side: sides){side.noClick();}}
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
        if (this.active != null) {
            return active.getBorder();
        }
        return null;
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
