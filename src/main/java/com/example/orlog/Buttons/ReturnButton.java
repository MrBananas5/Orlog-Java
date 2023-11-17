package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class ReturnButton extends MinButton{
    public ReturnButton(Group group, int x, int y) {
        super(null, group, "Symb_return", x, y);
    }
    protected void onClick(Menu menu, Group group){
        menucontroller.getOldMenu().set(group);
    }
}
