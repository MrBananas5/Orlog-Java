package com.example.orlog.Buttons;

public class NullImage extends ImageButton{
    public NullImage(String path, String background, int x, int y, int sx, int sy) {
        super(path, background, x, y, sx, sy,null);
        bg.setOnMouseEntered(mouseEvent -> {});
    }
}
