package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class PlayButton extends LTButton{
    public PlayButton(int x, int y) {
        super(null, null, "play", x, y);
    }
    @Override
    protected void onClick(Menu menu, Group group) {
        menucontroller.begin();
    }
}
