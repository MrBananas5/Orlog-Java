package com.example.orlog.Buttons;

public class InfoButton extends ImageButton {
    public InfoButton(String path, String foreground, String background, String text, TextInfo tx, int x, int y, int sx, int sy) {
        super(path, foreground, background, x, y, sx, sy);
        fg.setOnMousePressed(mouseEvent -> onClick(tx,text));
        bg.setOnMousePressed(mouseEvent -> onClick(tx,text));

    }
    public InfoButton(String path, String background, String text, TextInfo tx, int x, int y, int sx, int sy) {
        super(path , background, x, y, sx, sy);
        bg.setOnMousePressed(mouseEvent -> onClick(tx,text));

    }
    protected void onClick(TextInfo tx, String text){
        tx.setText(text);
    }
}
