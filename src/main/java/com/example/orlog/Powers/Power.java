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
    }//10+(300/pack.getSize(p)*pack.powerIndex(p,this)+((900-84)*p)
    //10+(pack.powerIndex(p,this)*(((2*p)-1)*-74))+((900-84)*p))
    public void rePos(DicePack pack){

        child.setX((p*836) +((2*p)-1)*- (10+(440/pack.powerSize(p)*pack.powerIndex(p,this))));
    }
    public void setPlayer2(){p = 1;}
    public void addto(DicePack pack, int p){
        if (child == null){
            child = new ImageButton("Buttons/Statues/",name,10,750-138,64,128);}
        pack.addPower(this,p);

    }
    public String getName(){return name;}

    public Power copy(DicePack dicePack) {
    return null;}
}
