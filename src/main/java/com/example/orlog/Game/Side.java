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
    protected final ImageView mg;
    private final String tintCol;
    public Side(String path, DiceVal back, DiceVal border, DiceVal symb, int sx, int sy, String tintCol ) {
        super(path, symb.name(), back.name()+"_Back", 0, 0, sx, sy,tintCol);
        this.back = back;
        this.symb = symb;
        this.tintCol = tintCol;
        this.border = border;
        mg = get(absPath +path +border.name()+"_Front.png");
        set(new ImageView[]{bg, fg, mg}, 0, 0, 96, 96, tintCol);
    }

    public String getString() { return ("(" +back.name() + ","+symb.name()+ ","+border.name()+")");
    }


    public void tint(String col) {
        tintImg(fg,Color.web(col));
    }

    public void setClick(Dice d){
        this.fg.setOnMouseClicked(mouseEvent -> d.toggleChosen());
        this.bg.setOnMouseClicked(mouseEvent -> d.toggleChosen());
        this.mg.setOnMouseClicked(mouseEvent ->  d.toggleChosen());
    }
    public void load(int x, int y, List<Node> group) {
        group.add(bg);
        group.add(mg);
        group.add(fg);
        this.fg.setX(x);
        this.fg.setY(y);
        this.bg.setY(y);
        this.bg.setX(x);;
        this.mg.setY(y);
        this.mg.setX(x);;

    }
    public void set(int s, int x, int y,String tint){
        super.set(new ImageView[]{mg,fg,bg},x,y,s,s,tint);
        if (tint == null){nulled();}
    }

    @Override
    public void delete(List<Node> group) {
        super.delete(group);
        group.remove(mg);
    }
    public DiceVal getSymb(){return symb;}


    public DiceVal getBorder() {return border;}

    public void nulled(){
        fg.setOnMouseEntered(mouseEvent -> {});
        mg.setOnMouseEntered(mouseEvent -> {});
        bg.setOnMouseEntered(mouseEvent -> {});
    }
    public void dim() {
        bg.setOnMouseExited(mouseEvent -> untint());
        fg.setOnMouseExited(mouseEvent -> untint());
        mg.setOnMouseExited(mouseEvent -> untint());
    }

    public void highlight() {
        fg.setOnMouseExited(mouseEvent -> {});
        mg.setOnMouseExited(mouseEvent -> {});
        bg.setOnMouseExited(mouseEvent -> {});

    }

    public MistSide mist(Dice d) {
        MistSide m = new MistSide("Niflheim/",back,border,symb, (int) fg.getFitWidth(),(int) fg.getFitHeight(),tintCol);
        m.setClick(d);
        return m;
    }
}
