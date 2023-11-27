package com.example.orlog.Game;

import com.example.orlog.Buttons.NullImage;

import com.example.orlog.Buttons.TextInfo;

import com.example.orlog.Realms.Midgard;

import javafx.scene.Group;

import javafx.scene.Scene;
import javafx.scene.image.Image;

import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class GameController {
    private final Midgard gamePack;
    private final Player[] players;
    private final TextInfo[][] stats;
    private Playnum player;
    private final Group root;
    private int turnN;
    private TextInfo turnLabel;
    private TextInfo rollLabel;
    private NullImage coin;
    public GameController(Midgard gamePack, Player p2, DicePack pack, Stage stage, Scene scene) {
        this.gamePack = gamePack;
        players = new Player[]{new Player(Playnum.PLAYER1), p2};
        root = new Group();
        stage.setTitle("Orlog - " + gamePack.getName());
        stage.getIcons().add(new Image("file:C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/" + gamePack.getIcon()));
        new NullImage(gamePack.getPath(), gamePack.getName(), 0, 0, 900, 750).load(root.getChildren());
        scene.setRoot(root);
        scene.addEventFilter(KeyEvent.KEY_PRESSED, (KeyEvent event) -> {
            endTurn();
            event.consume();
        });
        stats = new TextInfo[][]{null, null};
        begin(root, pack, 900, 750);

    }

    private void begin(Group root, DicePack dicePack, int x, int y) {
        player = players[1].getNum();
        turnLabel = new TextInfo(player.name()+"'s Turn",x/2-36,y/2 - 30,300,32,48);
        turnLabel.load(root.getChildren());
        rollLabel = new TextInfo("ROLL: "+ (turnN/2 +1),x/2-36,(y - 48) / 2 + 48 -5,300,32,48);
        rollLabel.load(root.getChildren());
        coin = new NullImage(gamePack.getPath(), "Coin_"+player.name(),x/2-106,y/2-32,64,64);
        coin.load(root.getChildren());
        for (Player p : players) {
            p.setFavour(dicePack.getStartFavour());
            p.setHealth(dicePack.getStartHealth());
            p.setDice(dicePack.getDice(p.getP()));
            p.setPowers(dicePack.getPowers(p.getP()));
            new NullImage(gamePack.getPath(), "Favour", x / 2 + 160, (y - 48) / 2 + 48 * p.getPN(), 48, 48).load(root.getChildren());
            new NullImage(gamePack.getPath(), "HP", x / 2 + 150, (y - 48) / 2 + 96 * p.getPN(), 48, 48).load(root.getChildren());

            stats[p.getP().getNumber()] = new TextInfo[]{new TextInfo(p.getHealth() + "X ", x / 2 + 100, (y - 48) / 2 + 96 * p.getPN() - 5, 96, 48, 48),
                    new TextInfo(p.getFavour() + "X ", x / 2 + 100, (y - 48) / 2 + 48 * p.getPN() - 5, 96, 48, 48)};
            for (TextInfo t : stats[p.getP().getNumber()]) {
                t.load(root.getChildren());
            }
            for (int i = 0; i < p.getPowers().size(); i++) {
                p.getPowers().get(i).getPower(gamePack.getPath(), (x / 2) + 100 - (64 * p.getPowers().size()) + 64 * i, ((y - 32) / 2 + 100 * p.getPN()), gamePack.getTint()).load(root.getChildren());
            }
            for (Dice dice : p.getDice()) {
                dice.print();
            }
        }
        play();
    }

    private void play() {
        turn(players[player.getNumber()]);

    ///resolve();
    /////update health, energy
    ///player = players[1- player.getNumber()].getP();
    }
    private void turn(Player p){
        //roll Dice
        turnLabel.setText(player.name()+"'s turn");
        gamePack.rollDice(p.getDice());
        gamePack.displayDice(root,p.getDice(),p.getP().getInv()*495,p.getP().getInv()*495 + (750-495),p.getP().getNumber()*700,(750-48)/2);


        //pick dice/powers
    }
    private void endPlayerTurn(Player p){
        gamePack.hideDice(root,p.getDice());
        if ((turnN++) == 5){turnN= 0;resolve();}
        else{player = players[p.getP().getInv()].getP();}
        rollLabel.setText("ROLL: " +(turnN/2 +1));
        turn(players[player.getNumber()]);

    }
    private void endTurn(){endPlayerTurn(players[player.getNumber()]);
    }
    private void playerResolve(Player p){
        gamePack.resolve(p,players[p.getP().getInv()],root);
    }
    private void resolve(){
        playerResolve(players[player.getInv()]);
        playerResolve(players[player.getNumber()]);
        for (int i = 0; i<2; i++){
            stats[i][0].setText(players[i].getHealth() + "X ");
            stats[i][1].setText(players[i].getFavour() + "X ");}
        coin.setImage(gamePack.getPath()+"Coin_"+player.name());
    }
}

