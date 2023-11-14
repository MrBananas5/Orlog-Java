package com.example.orlog.Buttons;

import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class ImageButton extends Rec{
    protected ImageView fg;
    protected ImageView bg;
    public ImageButton(String path, String foreground, String background, int x, int y,int sx, int sy){
        String absPath = "C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/";
        this.fg = new ImageView(new Image(absPath +path +foreground+".png"));
        this.bg = new ImageView(new Image(absPath +path +background+".png"));
        for (ImageView v: new ImageView[]{fg, bg}){
            v.setX(x);
            v.setY(y);
            v.setFitWidth(sx);
            v.setFitHeight(sy);
        }
    }
    public void load(List<Node> group){
        group.add(bg);
        group.add(fg);
    }
    public Node getNode(){return bg;}
}
