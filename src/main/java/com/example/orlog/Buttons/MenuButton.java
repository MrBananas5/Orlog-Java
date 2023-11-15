package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

public class MenuButton extends ImageButton {
    public MenuButton(Menu menu, Group group, String path, String foreground, String background, int x, int y, int sx, int sy) {
        super(path, foreground, background, x, y, sx, sy);
        bg.setOnMouseClicked(mouseEvent -> menu.set(group));
        fg.setOnMouseClicked(mouseEvent -> menu.set(group));
    }
}
