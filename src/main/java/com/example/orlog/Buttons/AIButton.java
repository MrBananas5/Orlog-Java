package com.example.orlog.Buttons;

import com.example.orlog.Game.Player;
import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

public class AIButton extends PlayerButton{

    public AIButton(Player player, Menu menu, Group group, String name, String pos, int x, int y) {
        super(player, menu, group, "Buttons/Players/", name, pos+"_Back", x, y, 225, 125);
    }
}
