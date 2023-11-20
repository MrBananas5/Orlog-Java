package com.example.orlog.Buttons;

import javafx.scene.paint.Color;

public class RealmInfo extends InfoButton {

    public RealmInfo(String name, String text, TextInfo tx, int x, int y) {
        super("Buttons/Realms/", name+"_Front", name+"_Back", text, tx, x, y,200,125);
    }
    public void tint(String col){
        tintImg(bg, Color.web(col));
    }
}
