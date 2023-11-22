package com.example.orlog.Game;

import com.example.orlog.Buttons.NullImage;

import com.example.orlog.Buttons.TextInfo;

import com.example.orlog.Realms.Midgard;

import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.stage.Stage;

public class GameController {
    private final Midgard gamePack;
    private final Player[] players;
    private final TextInfo[][] stats;
    private Playnum player;
    public GameController(Midgard gamePack, Player p2, DicePack pack, Stage stage, Scene scene){
        this.gamePack = gamePack;
        players = new Player[]{new Player(Playnum.PLAYER1),p2};
        Group root = new Group();
        stage.setTitle("Orlog - " + gamePack.getName());
        stage.getIcons().add(new Image("file:C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/"+gamePack.getIcon()));
        new NullImage(gamePack.getPath(),gamePack.getName(),0,0,900,750).load(root.getChildren());
        scene.setRoot(root);
        stats = new TextInfo[][]{null, null};
        begin(root,pack,900,750);

    }
    private void begin(Group root, DicePack dicePack,int x, int y) {
        player = players[1].getNum();
        for (Player p : players) {
            p.setFavour(dicePack.getStartFavour());
            p.setHealth(dicePack.getStartHealth());
            p.setDice(dicePack.getDice(p.getP()));
            p.setPowers(dicePack.getPowers(p.getP()));
            new NullImage(gamePack.getPath(), "Favour", x/2+ 150, (y-48) / 2 +48*p.getPN(), 48, 48).load(root.getChildren());
            new NullImage(gamePack.getPath(), "HP", x/2 +150, (y-48) / 2  +96*p.getPN(), 48, 48).load(root.getChildren());
            stats[p.getP().getNumber()] = new TextInfo[]{new TextInfo(p.getHealth()+ "X ",x/2+100,(y-48) / 2  +96*p.getPN()-5,96,48,48),
                    new TextInfo(p.getFavour() + "X ",x/2+100,(y-48) / 2  +48*p.getPN()-5,96,48,48)};
            for (TextInfo t: stats[p.getP().getNumber()]){t.load(root.getChildren());}
            for (int i = 0; i<p.getPowers().size();i++){
                p.getPowers().get(i).getPower(gamePack.getPath(),(x/2) + 100 - (64*p.getPowers().size()) + 64*i,((y-32)/2 + 100*p.getPN()),p,gamePack.getTint()).load(root.getChildren());
            }
            for (Dice dice : p.getDice()){
                dice.print();
            }
        }

    }

        ///Display health, energy, powers
}

