package com.example.orlog.Buttons;


import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class DiceInfo extends InfoButton {
    public DiceInfo(String name, String text, TextInfo tx, int x, int y) {
        super("Midgard/", name, "Basic_Back", text, tx, x, y,96,96);
    }
    public DiceInfo(String name, String back, String text, TextInfo tx, int x, int y) {
        super("Midgard/", name, back, text, tx, x, y,96,96);
    }
}
