package com.example.orlog.Buttons;

import com.example.orlog.Menu.PowerMenu;
import com.example.orlog.Realms.Midgard;
import javafx.scene.Group;
import javafx.scene.paint.Color;

public class RealmPicker extends GamePicker{
    public RealmPicker(Midgard pack, PowerMenu menu, Group group, int x, int y) {
        super(pack, menu, group, pack.getSName()+"_Front", pack.getSName()+"_Back", x, y);
    }
    public void tint(String col){
        tintImg(bg, Color.web(col));
    }
}
