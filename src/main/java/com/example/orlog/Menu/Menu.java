package com.example.orlog.Menu;
import com.example.orlog.Buttons.Rec;
import javafx.scene.Group;
import javafx.scene.Node;
import java.util.ArrayList;
import java.util.Arrays;

public class Menu {
    private ArrayList<Rec> items;
    public Menu(){
        items = new ArrayList<>();
    }
    public void remove(Node n){
        items.remove(n);
    }
    public void add(Rec n){
        items.add(n);
    }
    public void setItems(Rec[] items){
        this.items.clear();
        this.items.addAll(Arrays.asList(items));
    }
    public void set(Group group){
        group.getChildren().clear();
        load(group);
    }
    public void load(Group group){
        for (Rec n: items){
            n.load(group.getChildren());
        }
    }
        }
