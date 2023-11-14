package com.example.orlog.Buttons;

import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class PowerInfo extends InfoButton {
    private Label label;
    public PowerInfo(String name, String blessing, int cost,String desc, TextInfo tx, int x, int y) {
        super("Buttons/Statues/", name, name+ "'s " +blessing +"\nCOST: "+cost +"\n"+ desc, tx, x, y, 64, 128);
        label = new Label(name);
        label.setFont(Font.loadFont("file:C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/norse.bold.otf", 56));
        label.setTextFill(Color.web("#000000"));
        label.setPrefSize(200,64);
        label.setLayoutY(y+32);
        label.setLayoutX(x+64);
        label.setOnMousePressed(new EventHandler<MouseEvent>() {
            public void handle(MouseEvent mouseEvent) {
                onClick(tx,name+ "'s " +blessing +"\nCOST: "+cost +"\n"+ desc);
            }
        });
    }
    public void load(List<Node> group){
        group.add(bg);
        group.add(label);
    }
}