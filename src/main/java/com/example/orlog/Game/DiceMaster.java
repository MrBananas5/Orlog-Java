package com.example.orlog.Game;

import com.example.orlog.Buttons.Rec;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

import static com.example.orlog.Menu.MenuController.menucontroller;

public class DiceMaster extends DiceBuilder{
    private final Label label;
    public DiceMaster(String realm, String text,int x, int y) {
        super(realm, x, y);
        label = new Label(text);
        label.setFont(Font.loadFont(absPath+ "norse.bold.otf", 56));
        label.setTextFill(Color.web("#000000"));
        label.setPrefSize(96,96);
        label.setLayoutY(y);
        label.setLayoutX(x+16);
        label.setOnMouseClicked(mouseEvent -> onClick());
    }
    public void load(List<Node> group){
        super.load(group);
        group.add(label);
    }
    protected void onClick(){
        super.onClick();
        for (Rec rec: menucontroller.getDiceMenu().getItems()){
            if (rec.sameSide(p)){rec.setN(n);}
        }
    }

    public DiceMaster copy(){return new DiceMaster(realm, label.getText(), 900-x-125,y);}
}
