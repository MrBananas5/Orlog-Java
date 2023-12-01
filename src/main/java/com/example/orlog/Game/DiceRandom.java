package com.example.orlog.Game;

import com.example.orlog.Buttons.Rec;
import com.example.orlog.Menu.MenuController;

import java.util.Random;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class DiceRandom extends  DiceMaster{

    public DiceRandom(String realm, int x, int y) {
        super(realm, "???", x, y);
    }
    public void onClick(){
        Random rand = new Random();
        for (Rec rec: menucontroller.getDiceMenu().getItems()){
            if (rec.sameSide(p)){rec.setN(rand.nextInt(0,5));}
        }
        tint(MenuController.tintCol);
    }
    public DiceRandom copy(){return new DiceRandom(realm, 900-x-125,y);}
}
