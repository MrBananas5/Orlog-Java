package com.example.orlog.Buttons;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;

import java.util.List;

public class TextInfo extends Rec{
    private String sampleText;
    private  Label label;
    public TextInfo(String sampleText,int x, int y,int sx, int sy,int sf){
        setUp(sampleText,x,y,sx,sy,sf);
        label.setTextFill(Color.web("#000000"));
    }
    public TextInfo(String sampleText,int x, int y,int sx, int sy,int sf, String textCol){
        setUp(sampleText,x,y,sx,sy,sf);
        label.setTextFill(Color.web(textCol));
    }
    private void setUp(String sampleText,int x, int y,int sx, int sy,int sf){
        this.sampleText = sampleText;
        label = new Label(sampleText);
        label.setLayoutX(x);
        label.setLayoutY(y);
        label.setPrefSize(sx,sy);
        label.setWrapText(true);
        label.setFont(Font.loadFont("file:src/main/resources/com/example/orlog/norse.bold.otf", sf));}

    public void restore(){label.setText(sampleText);}
    public void setText(String s){
        label.setText(s);
    }
    public void load(List<Node> group){
        group.add(label);
    }
}
