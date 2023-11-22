package com.example.orlog.Menu;

import com.example.orlog.Buttons.Rec;
import com.example.orlog.Game.DiceBuilder;
import com.example.orlog.Game.DicePack;
import com.example.orlog.Game.DiceVal;
import com.example.orlog.Realms.Midgard;
import javafx.scene.Group;

import java.util.ArrayList;

import static com.example.orlog.Game.Playnum.*;
import static com.example.orlog.Menu.MenuController.menucontroller;

public class DiceMenu extends Menu{

    private DiceBuilder[] builders;
    public DiceMenu(String name) {
        super(name);
    }

    public ArrayList<Rec> getItems(){
        return items;
    }
    public void setItems(DiceBuilder[] items){
        builders = items;
        for (DiceBuilder dice: items){
            this.items.add(dice);
            addP2(dice);
        }
    }
    public void setDice(DicePack pack, Midgard realm){
        DiceVal[] vals = new DiceVal[]{null,null,null,null,null};
        for (int i = 0;i <5;i++){vals[i] = builders[i].getType();}
        pack.setDice(PLAYER1, realm,vals);
        pack.setDice(PLAYER2, realm,vals);
    }
    private void addP2(DiceBuilder dice){
        DiceBuilder p2Dice = dice.copy();
        p2Dice.setPlayer2();
        items.add(p2Dice);
    }

    public void set(Group group){
        group.getChildren().clear();
        load(group);
        menucontroller.setMenu(this);
    }
}
