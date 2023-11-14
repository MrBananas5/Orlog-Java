package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

public class MinButton extends MenuButton {

    public MinButton(Menu menu, Group group, String foreground, int x, int y) {
        super(menu, group, "Buttons/", foreground, "Symb_Back", x, y, 125, 125);
    }
}