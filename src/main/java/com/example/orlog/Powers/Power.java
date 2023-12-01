package com.example.orlog.Powers;

import com.example.orlog.Buttons.ImageButton;
import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.Player;
import com.example.orlog.Game.Playnum;
import com.example.orlog.Menu.MenuController;
import com.example.orlog.Realms.Midgard;

public class Power extends ImageButton  {
    final private String name;

    public boolean isActivated() {
        return activated;
    }

    protected boolean activated = false;
    private ImageButton power;
    protected int cost;

    protected int x;
    protected int y;
    public ImageButton getChild() {
        return child;
    }

    private ImageButton child;
    private Playnum p;
    private boolean active;


    public Power(String name, int cost, int x, int y, DicePack pack) {
        super("Buttons/Statues/",name,x,y,64,128,MenuController.tintCol);
        p = Playnum.PLAYER1 ;
        this.x = x;
        this.y = y;
        this.name = name;
        this.cost = cost;
        bg.setOnMouseClicked(mouseEvent -> addto(pack,p));
    }//10+(300/pack.getSize(p)*pack.powerIndex(p,this)+((900-84)*p)
    //10+(pack.powerIndex(p,this)*(((2*p)-1)*-74))+((900-84)*p))
    public ImageButton getPower(String path, int x, int y, String tintCol){
        power = new ImageButton(path,name,x,y,64,32,tintCol);
        power.getNode().setOnMouseClicked(mouseEvent -> activate());
        return power;
    }
    public void dim() {
        bg.setOnMouseExited(mouseEvent -> untint());
        fg.setOnMouseExited(mouseEvent -> untint());
    }

    public void highlight() {
        fg.setOnMouseExited(mouseEvent -> {});
        bg.setOnMouseExited(mouseEvent -> {});
    }
    private void activate(){
        active = !active;
    if (active){power.getNode().setOnMouseExited(mouseEvent -> {});}
    else{power.getNode().setOnMouseExited(mouseEvent -> power.untint());}
    }
    public void doIt(Player p, Midgard realm){}
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

    public boolean isActive() {return active;}
    public void setActive(boolean b){active=b;
    if (!active){power.untint();power.getNode().setOnMouseExited(mouseEvent -> power.untint());}}

    public int getCost() {return cost;}

}
