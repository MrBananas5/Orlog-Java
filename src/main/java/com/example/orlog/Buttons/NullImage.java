package com.example.orlog.Buttons;

import javafx.scene.image.Image;

public class NullImage extends ImageButton{
    public NullImage(String path, String background, int x, int y, int sx, int sy) {
        super(path, background, x, y, sx, sy,null);
        bg.setOnMouseEntered(mouseEvent -> {});
        bg.setOnMouseExited(mouseEvent -> {});
    }
    public NullImage(String path, String background, int x, int y, int sx, int sy,String type) {
        super(path, background, x, y, sx, sy,null,type);
        bg.setOnMouseEntered(mouseEvent -> {});
        bg.setOnMouseExited(mouseEvent -> {});
    }
    public void setImage(String s) {
        bg.setImage(new Image(absPath+s+".png"));
    }
}
