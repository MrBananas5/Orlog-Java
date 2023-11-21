package com.example.orlog.Buttons;

import com.example.orlog.Game.Player;
import com.example.orlog.Menu.Menu;
import javafx.scene.Group;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class PlayerButton extends MenuButton{
    private Player player;

    public PlayerButton(Player player,Menu menu, Group group, String path, String foreground, String background, int x, int y, int sx, int sy) {
        super(menu, group, path, foreground, background, x, y, sx, sy);
        this.player = player;
    }
    protected void onClick(Menu menu, Group group) {
        super.onClick(menu, group);
        menucontroller.setPlayer(player);
    }
}
