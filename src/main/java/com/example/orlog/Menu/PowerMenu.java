package com.example.orlog.Menu;

import com.example.orlog.Realms.GamePack;
import javafx.scene.Group;

public class PowerMenu extends Menu{
    private  GamePack pack;
    public void set(Group group, GamePack pack){
        this.pack = pack;
        System.out.println(pack.getName());
        group.getChildren().clear();
        load(group);
        if (pack.getPower() != null){System.out.println(pack.getPower());}
        }
}
