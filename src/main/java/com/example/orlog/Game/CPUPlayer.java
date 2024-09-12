package com.example.orlog.Game;

import com.example.orlog.Buttons.NullImage;
import com.example.orlog.Powers.Power;
import javafx.application.Platform;

import java.util.ArrayList;
import java.util.Random;
import java.util.TimerTask;

import static com.example.orlog.Game.Clock.clock;
import static com.example.orlog.Game.DiceVal.*;

public class CPUPlayer extends Player{
    public CPUPlayer(int offensew, int defencew, int goldw, int theifw, int borderw, int savagew, int opportunew, int cowardw, int flawlessw, int thor, int freyja, int odin, int vidar, int loki, int frigg, int adapt) {
        super(Playnum.PLAYER2);
        this.offensew = offensew;
        this.defencew = defencew;
        this.goldw = goldw;
        this.theifw = theifw;
        this.borderw = borderw;
        this.savagew = savagew;
        this.opportunew = opportunew;
        this.cowardw = cowardw;
        this.flawlessw = flawlessw;
        this.thorw = thor;
        this.friggw = frigg;
        this.adaptw = adapt;
        this.freyjaw = freyja;
        this.odinw = odin;
        this.vidarw = vidar;
        this.lokiw = loki;

        rand = new Random();
         }
    private static NullImage thinking;
    private Random rand;
    //uses sum weighting as a probability of making choices
    //there is a lot of factors lmao
    private int offensew; //AXE or BOW
    private int defencew; //SHIELD or WARRIOR
    private int goldw; //GOLD border
    private int theifw; //THIEF
    private int borderw; //border other than GOLD
    private int thorw;
    private int friggw;
    private int adaptw;

    private int freyjaw;
    private int odinw;
    private int vidarw;
    private int lokiw;
    private int savagew; // additional offensew for each health below starting (opponent)
    private int opportunew; //additional offensew if equal / above that defence

    private int cowardw; // additional defensew for each health below starting
    private int flawlessw; //additional defensew if opponent has more offence


    private void shaveDice(){
        for (Dice d: dice){d.noClick();}
    }
    @Override
    public void setDice(ArrayList<Dice> dice) {
        super.setDice(dice);
        shaveDice();
    }
    @Override
    public void pickDice(GameController gameController){

        gameController.think();
        Player p1 = gameController.getPlayer1();
        pickTheDice(gameController,p1);
        pickPowers(gameController,p1);
        gameController.disableSpace();
        clock.getTimer().schedule(new TimerTask() {public void run() {
            Platform.runLater(() ->
            {System.out.printf("AAAAA\n");
                endTurn(gameController);
                gameController.think();
            });
        }},3000l); //wait about 3 seconds for dramatic effect, then end turn

        //endTurn
    }
    public void pickTheDice(GameController gameController, Player p1){
        for (Dice d: dice){
            int p =0;
            switch (d.getSymb()){
                case THIEF: {
                    if (!(gameController.getTurn() == 0 && p1.getFavour()==0)){p += theifw;break;}}
                case WARRIOR:{
                    p+= defencew;
                    p+= cowardw*(sHP-health);
                    p += flawlessw * (p1.getChosenSymbs(AXE) - getChosenSymbs(WARRIOR));
                    break;}
                case SHIELD: {
                    p+= defencew;
                    p+= cowardw*(sHP-health);
                    p+= flawlessw*(p1.getChosenSymbs(BOW)- getChosenSymbs(SHIELD));
                    break;}
                case AXE:{
                    p += offensew;
                    p+= (sHP-p1.getHealth())*savagew; //ASSUMES SAME START HEALTH
                    p+= opportunew*(1+getChosenSymbs(AXE)-p1.getChosenSymbs(WARRIOR));
                    break;}
                case BOW:{
                    p += offensew;
                    p+= (sHP-p1.getHealth())*savagew; //ASSUMES SAMER START HEALTH
                    p+= opportunew*(1+getChosenSymbs(BOW)-p1.getChosenSymbs(SHIELD));
                    break;}
                default :
            }
            switch (d.getBorder()){
                case GOLD: {
                    if (! (d.getType() == GOLD)) {p+= goldw;break;}}
                case LOKI:
                case FRIGG:
                case VIDAR: {p+= borderw;break;}
                default :
            }
            if (rand.nextInt(1,100) < p){d.setChosen(true);}
        }


    }
    private void pickPowers(GameController gameController,Player p1){
        int predictedPower = (favour + getChosenSymbs(GOLD));
        for (Power p: powers){ //first pass -if activating thor or freyja to saves / ends the game
            if (predictedPower>=p.getCost()) {
                switch (p.getName()) {
                    case "Thor": {
                        if ((p1.getHealth() < 9)) //If Thors power wipes out opponent,
                            {p.activate();break;}//kill them
                    }
                    case "Freyja": {
                        if (health <4 && (predictedPower>=p.getCost())) //If I am on the verge of death
                        {p.activate();break;} //heal
                    }
                default:{}
            }
        }}
        for (Power p: powers) { //first pass -if activating thor or freyja to saves / ends the game
            int prob = rand.nextInt(1,100);
            if (predictedPower >= p.getCost()) {
                switch (p.getName()) {
                    case "Thor": {if (prob<thorw){p.activate();}break;}
                    case "Freyja": {if (prob<freyjaw){p.activate();}break;}
                    case "Odin": {if (prob<odinw){p.activate();}break;}
                    case "Frigg": {if (prob<friggw){p.activate();}break;}
                    case "Vidar": {if (prob<vidarw){p.activate();}break;}
                    case "Loki": {if (prob<lokiw){p.activate();}break;}
                    default: {if (prob<adaptw){p.activate();}break;}
                    }
                }
            }
    }
    private void endTurn(GameController gameController){
        gameController.activateSpace();
        gameController.endTurn();
    }
}
