package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import com.example.orlog.Menu.MenuController;
import javafx.scene.Group;

public class MenuButton extends ImageButton {
    public MenuButton(Menu menu, Group group, String path, String foreground, String background, int x, int y, int sx, int sy) {
        super(path, foreground, background, x, y, sx, sy, MenuController.tintCol);
        bg.setOnMouseClicked(mouseEvent -> onClick(menu,group));
        fg.setOnMouseClicked(mouseEvent -> onClick(menu,group));
    }
    protected void onClick(Menu menu, Group group){
        menu.set(group);
    }

}
