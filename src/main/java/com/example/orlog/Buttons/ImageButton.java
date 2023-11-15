package com.example.orlog.Buttons;


import javafx.scene.Node;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.util.List;

public class ImageButton extends Rec{
    protected ImageView fg;
    protected ImageView bg;
    protected static final String absPath = "C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/";
    public ImageButton(String path, String foreground, String background, int x, int y,int sx, int sy){
        this.fg = new ImageView(new Image(absPath +path +foreground+".png"));
        this.bg = new ImageView(new Image(absPath +path +background+".png"));
        set(new ImageView[]{fg,bg},x,y,sx,sy);
    }
    public ImageButton(String path, String background, int x, int y,int sx, int sy){
        this.bg = new ImageView(new Image(absPath +path +background+".png"));
        this.fg = null;
        set(new ImageView[]{bg},x,y,sx,sy);
    }
    private void set(ImageView[] imgs, int x, int y, int sx, int sy){
        for (ImageView v: imgs){
            v.setX(x);
            v.setY(y);
            v.setFitWidth(sx);
            v.setFitHeight(sy);
        }
    }
    public void load(List<Node> group){
        group.add(bg);
        if (fg !=null) {group.add(fg);}
    }
    public Node getNode(){return bg;}
}
