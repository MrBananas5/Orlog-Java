package com.example.orlog.Menu;
import com.example.orlog.Buttons.Rec;
import javafx.scene.Group;


import java.util.ArrayList;
import java.util.Arrays;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class Menu {
    private final String name;
    protected final ArrayList<Rec> items;
    public Menu(String name){
        items = new ArrayList<>();
        this.name = name;
    }
    public void remove(Rec n){items.remove(n);}
    public void add(Rec n){
        items.add(n);
    }
    public void setItems(Rec[] items)   {
        this.items.clear();
        this.items.addAll(Arrays.asList(items));
    }
    public void set(Group group){
        menucontroller.setMenuTitle(name);
        menucontroller.getMenu().clear(group);
        load(group);
        menucontroller.setMenu(this);
    }
    public void load(Group group){
        for (Rec n: items){
            n.load(group.getChildren());
        }
    }
    public void clear(Group group){
        group.getChildren().clear();
    }

    public int getSize() {
        return items.size();
    }

    public void addAll(Rec[] items) {
        this.items.addAll(Arrays.asList(items));
    }

}
