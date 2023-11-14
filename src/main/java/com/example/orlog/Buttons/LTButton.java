package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

public class LTButton extends MenuButton{

    public LTButton(Menu menu, Group group,  String foreground, int x, int y) {
        super(menu, group, "Buttons/", foreground,"LT_BACK", x, y, 450, 125);
    }
}
