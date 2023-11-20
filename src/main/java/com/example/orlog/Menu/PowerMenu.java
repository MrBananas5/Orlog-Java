package com.example.orlog.Menu;



import com.example.orlog.Powers.Power;
import com.example.orlog.Realms.Midgard;
import javafx.scene.Group;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class PowerMenu extends Menu{
    private Midgard pack;
    private Power p2Power;

    public PowerMenu(String name) {
        super(name);
    }

    public void setItems(Power[] items){
        for (Power power: items){
            this.items.add(power);
            addP2(power);
        }
    }
    public void set(Group group, Midgard pack){
        this.pack = pack;
        menucontroller.getMenu().clear(group);
        if (pack.getPower() != null){
            add(pack.getPower());
            p2Power = addP2(pack.getPower());
        }
        load(group);
        menucontroller.setMenu(this);}
    private Power addP2(Power power){
        Power p2ver =  power.copy(menucontroller.getDicePack());
        p2ver.setPlayer2();
        this.items.add(p2ver);
        return p2ver;
    }
    public void clear(Group group){
        group.getChildren().clear();
        menucontroller.getDicePack().clear();
        remove(pack.getPower());
        remove(p2Power);
        }

}
