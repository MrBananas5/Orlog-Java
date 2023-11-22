package com.example.orlog.Game;

import com.example.orlog.Buttons.ImageButton;

public class Side extends ImageButton {
    private final DiceVal back;
    private final DiceVal symb;
    private final DiceVal border;

    public Side(String path, DiceVal back, DiceVal border, DiceVal symb, int x, int y, int sx, int sy, String tintCol ) {
        super(path, symb.name(), back.name()+"_Back", x, y, sx, sy,tintCol);
        this.back = back;
        this.symb = symb;
        this.border = border;
    }

    public String getString() { return ("(" +back.name() + ","+symb.name()+ ","+border.name()+")");
    }
}
