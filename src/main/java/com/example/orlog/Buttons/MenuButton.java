package com.example.orlog.Buttons;

import com.example.orlog.Menu.Menu;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.input.MouseEvent;

public class MenuButton extends ImageButton {
    public MenuButton(Menu menu, Group group, String path, String foreground, String background, int x, int y, int sx, int sy) {
        super(path, foreground, background, x, y, sx, sy);
        bg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                menu.set(group);
            }
        });
        fg.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                menu.set(group);
            }
        });
    }
}
