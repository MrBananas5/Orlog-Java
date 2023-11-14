package com.example.orlog.Buttons;

import com.example.orlog.Buttons.ImageButton;
import com.example.orlog.Buttons.TextInfo;
import javafx.event.EventHandler;
import javafx.scene.input.MouseEvent;

public class InfoButton extends ImageButton {
    public InfoButton(String path, String foreground, String background, String text, TextInfo tx, int x, int y, int sx, int sy) {
        super(path, foreground, background, x, y, sx, sy);
        fg.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onClick(tx,text);
            }
        });
        bg.setOnMousePressed(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onClick(tx,text);
            }
        });

    }
    public InfoButton(String path, String background, String text, TextInfo tx, int x, int y, int sx, int sy) {
        super(path , background, x, y, sx, sy);
        bg.setOnMousePressed(new EventHandler<MouseEvent> () {
            @Override
            public void handle(MouseEvent mouseEvent) {
                onClick(tx,text);
            }
        });

    }
    protected void onClick(TextInfo tx, String text){
        tx.setText(text);
    }
}
