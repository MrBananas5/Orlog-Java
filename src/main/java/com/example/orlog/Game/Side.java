package com.example.orlog.Game;

import com.example.orlog.Buttons.ImageButton;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.List;

public class Side extends ImageButton {
    private final DiceVal back;
    private final DiceVal symb;
    private final DiceVal border;
    private final ImageView mg;
    private final String tintCol;
    public Side(String path, DiceVal back, DiceVal border, DiceVal symb, int sx, int sy, String tintCol ) {
        super(path, symb.name(), back.name()+"_Back", 0, 0, sx, sy,tintCol);
        this.back = back;
        this.symb = symb;
        this.border = border;
        this.tintCol = tintCol;
        mg = get(absPath +path +border.name()+"_Front.png");
    }

    public String getString() { return ("(" +back.name() + ","+symb.name()+ ","+border.name()+")");
    }
    public void setClick(Dice d){
        this.fg.setOnMouseClicked(mouseEvent ->  d.toggleChosen());
        this.bg.setOnMouseClicked(mouseEvent ->  d.toggleChosen());
    }
    public void load(int x, int y, List<Node> group) {
        super.load(group);
        set(new ImageView[]{bg, mg, fg}, x, y, 96, 96, tintCol);
        group.add(mg);
    }
    public void tint(String col){
        tintImg(fg, Color.web(col));
    }
    @Override
    public void delete(List<Node> group) {
        super.delete(group);
        group.remove(mg);
    }
    public DiceVal getSymb(){return symb;}

    public DiceVal getBorder() {return border;}

}
