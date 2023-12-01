package com.example.orlog.Game;

import com.example.orlog.Buttons.ImageButton;
import com.example.orlog.Menu.MenuController;
import javafx.scene.image.Image;



public class DiceBuilder extends ImageButton {
    protected int n = 0;
    protected int p = 0;

    protected String realm;
    protected int x;protected int y;
    public DiceBuilder(String realm, int x, int y) {
        super(realm+"/", "Gold_Front","Basic_Back", x, y, 96, 96, MenuController.tintCol);
        bg.setOnMouseClicked(mouseEvent -> onClick());
        this.realm = realm;
        this.x = x;this.y = y;
    }
    public boolean sameSide(int p){return p==this.p;}
    private void setImg(){
        bg.setImage(new Image(getBack()+".png"));
        fg.setImage(new Image(getFront()+".png"));
    }
    protected void onClick(){
        n = (n+1)%5;
        setImg();
        tint(MenuController.tintCol);
    }
    public void setPlayer2(){p = 1;}
    private String getBack(){
        return absPath +realm+"/"+  new String[]{"Basic", "Frigg", "Vidar", "Loki", "Odin"}[n] + "_Back";
    }
    private String getFront(){
        return absPath+realm+"/"+new String[]{"Gold", "Frigg","Vidar","Loki","Gold"}[n]+"_Front";
    }
    public DiceVal getType(){
        return new DiceVal[]{DiceVal.BASIC,DiceVal.FRIGG,DiceVal.VIDAR,DiceVal.LOKI,DiceVal.ODIN}[n];
    }
    public DiceBuilder copy(){return new DiceBuilder(realm,900-x-125,y);}
    public void setN(int n){this.n = (n%5);setImg();}
}
