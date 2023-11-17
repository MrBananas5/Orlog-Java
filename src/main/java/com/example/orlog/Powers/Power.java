package com.example.orlog.Powers;

import com.example.orlog.Buttons.ImageButton;
import com.example.orlog.Game.DicePack;

public class Power extends ImageButton  {
    final private String name;



    protected int x;
    protected int y;
    public ImageButton getChild() {
        return child;
    }

    private ImageButton child;
    private int p;


    public Power(String name, int x, int y, DicePack pack) {
        super("Buttons/Statues/",name,x,y,64,128);
        p =0 ;
        this.x = x;
        this.y = y;
        this.name = name;
        bg.setOnMouseClicked(mouseEvent -> addto(pack,p));
    }
    public void rePos(DicePack pack){
        child.setX(10+(pack.powerIndex(p,this)*(((2*p)-1)*-74))+((900-84)*p));
    }
    public void setPlayer2(){p = 1;}
    public void addto(DicePack pack, int p){
        if (child == null){
        child = new ImageButton("Buttons/Statues/",name,10+(pack.powerSize(p)*(((2*p)-1)*-74))+((900-84)*p),750-138,64,128);}
        else {
            child.setX(10+(pack.powerSize(p)*(((2*p)-1)*-74))+((900-84)*p));
        }
        pack.addPower(this,p);

    }
    public String getName(){return name;}

    public Power copy(DicePack dicePack) {
    return null;}
}
