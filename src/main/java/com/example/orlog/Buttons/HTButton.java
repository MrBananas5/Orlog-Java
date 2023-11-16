package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

public class HTButton extends MenuButton{

    public HTButton(Menu menu, Group group,  String foreground, int x, int y) {
        super(menu, group, "Buttons/", foreground,"HT_BACK", x, y, 225, 125);
    }
}
