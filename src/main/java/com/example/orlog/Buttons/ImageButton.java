package com.example.orlog.Buttons;


import com.example.orlog.Menu.MenuController;
import javafx.scene.CacheHint;
import javafx.scene.Node;
import javafx.scene.effect.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.List;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class ImageButton extends Rec{
    protected ImageView fg;
    protected ImageView bg;
    protected static final String absPath = "file:C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/";
    private ImageView get(String path){return new ImageView( new Image(path));}
    public ImageButton(String path, String foreground, String background, int x, int y,int sx, int sy){
        this.bg = get(absPath +path +background+".png");
        this.fg = get(absPath +path +foreground+".png");
        set(new ImageView[]{fg,bg},x,y,sx,sy,"#00FFFF");

    }
    public ImageButton(String path, String background, int x, int y,int sx, int sy){
        this.bg = get(absPath +path +background+".png");
        this.fg = null;
        set(new ImageView[]{bg},x,y,sx,sy, MenuController.tintCol);
    }
    private void readyTint(String col, ImageView img){
        img.setOnMouseEntered(mouseEvent -> tint(col));
        img.setOnMouseExited(mouseEvent -> untint());
    }
    public void untint(){
        bg.setEffect(null);
        if (fg !=null) {fg.setEffect(null);}
    }
    public void tint(String col){
        tintImg(bg,Color.web(col));
        if (fg !=null) {tintImg(fg,Color.web(col));}
    }

    protected void tintImg(ImageView img, Color col){

        ImageInput image = new ImageInput(img.getImage());
        image.setX(img.getX());image.setY(img.getY());

        ///ColorAdjust adjust = new ColorAdjust(col.getHue(),col.getSaturation(), col.getBrightness(), 0);

        ColorInput adjust = new ColorInput(img.getX(), img.getY(),img.getFitWidth(),img.getFitHeight(),col);
        Blend blush = new Blend(BlendMode.SRC_ATOP ,image,adjust);

        Blend blush2 = new Blend(BlendMode.MULTIPLY,blush,image);
        img.setEffect(blush2);
    }

    public ImageButton(String path,  int sx, int sy) {
        super();
    }

    protected void set(ImageView[] imgs, int x, int y, int sx, int sy,String col){
        for (ImageView v: imgs){
            v.setX(x);
            v.setY(y);
            v.setFitWidth(sx);
            v.setFitHeight(sy);
            readyTint(col,v);
        }
    }
    public void load(List<Node> group){
        group.add(bg);
        if (fg !=null) {group.add(fg);}
    }
    public Node getNode(){return bg;}

    public void delete(List<Node> group) {
        group.remove(bg);
        if (fg !=null) {group.remove(fg);}
    }
    public void setX(int x){
        bg.setX(x);
        if (fg !=null) {fg.setX(x);}
    }

}
