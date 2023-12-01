package com.example.orlog.Game;

import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

public class MistSide extends Side{
    public MistSide(String path, DiceVal back, DiceVal border, DiceVal symb, int sx, int sy, String tintCol) {
        super(path, back, border, symb, sx, sy, tintCol);
    }
    public void tint(String col) {
        backTintImg(fg,Color.web(col));
    }
}
