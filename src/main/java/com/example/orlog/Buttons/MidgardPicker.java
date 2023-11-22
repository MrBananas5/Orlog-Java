package com.example.orlog.Buttons;

import com.example.orlog.Menu.PowerMenu;
import com.example.orlog.Realms.Midgard;
import javafx.scene.Group;

public class MidgardPicker extends GamePicker {

    public MidgardPicker(PowerMenu menu, Group group, String name, String tint,int n,int x, int y) {
        super(new Midgard(name,"Midgard/",tint), menu, group, name, "Mid_"+n, x, y);
    }
}
