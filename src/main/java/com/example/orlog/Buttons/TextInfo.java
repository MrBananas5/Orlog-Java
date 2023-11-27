package com.example.orlog.Buttons;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class TextInfo extends Rec{
    final private String sampleText;
    private final Label label;
    public TextInfo(String sampleText,int x, int y,int sx, int sy,int sf){
        this.sampleText = sampleText;
        label = new Label(sampleText);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefSize(sx,sy);
        label.setWrapText(true);
        label.setFont(Font.loadFont("file:C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/norse.bold.otf", sf));
        label.setTextFill(Color.web("#000000"));
    }
    public void restore(){label.setText(sampleText);}
    public void setText(String s){
        label.setText(s);
    }
    public void load(List<Node> group){
        group.add(label);
    }
}
