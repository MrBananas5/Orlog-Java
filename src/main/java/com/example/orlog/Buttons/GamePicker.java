package com.example.orlog.Buttons;


import com.example.orlog.Menu.PowerMenu;
import com.example.orlog.Realms.GamePack;
import javafx.scene.Group;

public class GamePicker extends MenuButton{
    public GamePicker(GamePack pack, PowerMenu menu, Group group, String fname, String bname, int x, int y) {
        super(menu, group, "Buttons/Realms/", fname, bname, x, y, 200, 125);
        bg.setOnMouseClicked(mouseEvent -> menu.set(group,pack));
        fg.setOnMouseClicked(mouseEvent -> menu.set(group,pack));
    }

}
