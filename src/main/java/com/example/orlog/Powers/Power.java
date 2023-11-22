package com.example.orlog.Powers;

import com.example.orlog.Buttons.ImageButton;
import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Game.Playnum;
import com.example.orlog.Menu.MenuController;
public class Power extends ImageButton  {
    final private String name;



    protected int x;
    protected int y;
    public ImageButton getChild() {
        return child;
    }

    private ImageButton child;
    private Playnum p;


    public Power(String name, int x, int y, DicePack pack) {
        super("Buttons/Statues/",name,x,y,64,128,MenuController.tintCol);
        p = Playnum.PLAYER1 ;
        this.x = x;
        this.y = y;
        this.name = name;
        bg.setOnMouseClicked(mouseEvent -> addto(pack,p));
    }//10+(300/pack.getSize(p)*pack.powerIndex(p,this)+((900-84)*p)
    //10+(pack.powerIndex(p,this)*(((2*p)-1)*-74))+((900-84)*p))
    public ImageButton getPower(String path,int x, int y,Player p,String tintCol){
        ImageButton toRet = new ImageButton(path,name,x,y,64,32,tintCol);
        toRet.getNode().setOnMouseClicked(mouseEvent -> activate(p));
        return toRet;
    }
    private void activate(Player p){System.out.println("boom!");}
    public void rePos(DicePack pack){

        child.setX((p.getNumber()*836) +((2*p.getNumber())-1)*- (10+(440/pack.powerSize(p)*pack.powerIndex(p,this))));
    }
    public void setPlayer2(){p = Playnum.PLAYER2;}
    public void addto(DicePack pack, Playnum p){
        if (child == null){
            child = new ImageButton("Buttons/Statues/",name,10,750-138,64,128,MenuController.tintCol);}
        pack.addPower(this,p);

    }
    public String getName(){return name;}

    public Power copy(DicePack dicePack) {
    return null;}
}
