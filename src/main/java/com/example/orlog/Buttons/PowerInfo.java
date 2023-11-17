package com.example.orlog.Buttons;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class PowerInfo extends InfoButton {
    private final Label label;
    public PowerInfo(String name, String blessing, int cost,String desc, TextInfo tx, int x, int y) {
        super("Buttons/Statues/", name, name+ "'s " +blessing +"\nCOST: "+cost +"\n"+ desc, tx, x, y, 64, 128);
        label = new Label(name);
        label.setFont(Font.loadFont(absPath+ "norse.bold.otf", 56));
        label.setTextFill(Color.web("#000000"));
        label.setPrefSize(200,64);
        label.setLayoutY(y+16);
        label.setLayoutX(x+69);
        label.setOnMousePressed(mouseEvent -> onClick(tx,name+ "'s " +blessing +"\nCOST: "+cost +"\n"+ desc));

        fg = new ImageView(new Image(absPath+"Midgard/"+name+".png"));
        fg.setOnMousePressed(mouseEvent -> onClick(tx,name+ "'s " +blessing +"\nCOST: "+cost +"\n"+ desc));
        fg.setLayoutY(y+59);
        fg.setLayoutX(x+5);
        fg.setX(64);
        fg.setY(32);
    }
    public void load(List<Node> group){
        group.add(bg);
        group.add(label);
        group.add(fg);
    }
}