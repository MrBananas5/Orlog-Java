package com.example.orlog.Menu;

import com.example.orlog.Buttons.*;

import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;


public class MenuController {
   public MenuController(Stage stage){
      Group root = new Group();
      int x = 900; int y = 750;
      Scene scene = new Scene(root, x, y);
      scene.setFill(new RadialGradient(
              0, 0, 0, 0, 1, true,                  //sizing
              CycleMethod.NO_CYCLE,                 //cycling
              new Stop(0, Color.web("#3d1b08")),    //colors
              new Stop(1, Color.web("#58270c")))
      );
      stage.setTitle("Orlog - Menu");
      stage.setScene(scene);
      stage.show();

      Menu p2Select = new Menu();
      Menu mainMenu = new Menu();
      Menu rulesMain = new Menu();
      Menu settings = new Menu();
      Menu diceRules = new Menu();
      Menu powerRules = new Menu();
      Menu basicRules = new Menu();
      Menu realmRules = new Menu();
      Menu envSelect = new Menu();
      Menu aISelect = new Menu();
      Menu hostMenu = new Menu();
      Menu joinMenu = new Menu();
      Menu realmSelect = new Menu();

      MinButton home = new MinButton(mainMenu,root,"Symb_home",10,y-135);
      MinButton sMin = new MinButton(settings,root,"Symb_settings",x-135,10);
      MinButton retu = new MinButton(mainMenu,root,"Symb_return",x-135,y-135);

      ImageButton logo = new ImageButton("","Newlogo",(x-256)/2,40,256,171);

      HTButton midSelect = new HTButton(envSelect,root,"Midgard",128,90);
      HTButton reaSelect = new HTButton(envSelect,root,"Yggdrasil",x-403,90);
      mainMenu.setItems(new Rec[]{
              new LTButton(p2Select,root,"play",(x-450)/2,y-405),
              new LTButton(rulesMain,root,"rules",(x-450)/2,y-270),
              new LTButton(settings,root,"settings",(x-450)/2,y-135),
              logo
      });

      rulesMain.setItems(new Rec[]{
              new LTButton(basicRules,root,"Basic",(x-450)/2,y-540),
              new LTButton(powerRules,root,"Powers",(x-450)/2,y-405),
              new LTButton(diceRules,root,"Dice",(x-450)/2,y-270),
              new LTButton(realmRules,root,"Realms",(x-450)/2,y-135),
              home,sMin,retu
      });

      p2Select.setItems(new Rec[]{
              new LTButton(aISelect, root,"Computer",(x-450)/2,y-270),
              new LTButton(envSelect, root,"Local",(x-450)/2,y-405),
              new HTButton(hostMenu,root,"Host",(x-1350/2),y-135),
              new HTButton(joinMenu,root,"Join",(x-900/2),y-135),
              home,sMin,retu,logo});

      envSelect.setItems(new Rec[]{reaSelect,midSelect,sMin,retu});
      realmSelect.setItems(new Rec[]{reaSelect,midSelect,sMin,retu});

      aISelect.setItems(new Rec[]{home,sMin,retu,logo});
      settings.setItems(new Rec[]{home,sMin,retu,logo});

      TextInfo diceInfo = new TextInfo("Select an option!",135,425+64,x-270,150,36);
      diceRules.setItems(new Rec[]{
              new DiceInfo("Gold_Front","A Gold Border - grants 1 FAVOR",diceInfo,135,54),

              new DiceInfo("Frigg_Front","Frigg_Back","A Prophecy Border - Heals 1 health",diceInfo,135,160),
              new DiceInfo("Vidar_Front","Vidar_Back","A Vengeance Border - deals 1 Damage to your opponent!",diceInfo,135,266),
              new DiceInfo("Loki_Front","Loki_Back","A Mischief Border - destroys 1 of your opponents FAVOR",diceInfo,135,372),

              new DiceInfo("Basic_Back","A Basic Dice - two sides have a GOLD BORDER",diceInfo,29,54),
              new DiceInfo("Frigg_Back","A Frigg Dice - two sides have a GOLD BORDER, and two more have a PROPHECY BORDER - those sides give 1 Health",diceInfo,29,160),
              new DiceInfo("Vidar_Back","A Vidar Dice - two sides have a GOLD BORDER, and two more have a VENGEANCE BORDER - those sides deal 1 Damage to your opponent!",diceInfo,29,266),
              new DiceInfo("Loki_Back","A Loki Dice - two sides have a GOLD BORDER, and two more have a MISCHIEF BORDER - those sides destroy your opponents FAVOR ",diceInfo,29,372),
              new DiceInfo("Odin_Back","An Odin Dice - every side has a GOLD BORDER!",diceInfo,29,478),

              new DiceInfo("Axe","Axe - deals 1 damage to your opponent. Blocked by WARRIOR",diceInfo,241,54),
              new DiceInfo("Bow","Bow - deals 1 damage to your opponent. Blocked by SHIELD",diceInfo,347,54),
              new DiceInfo("Warrior","Warrior - Blocks 1 AXE",diceInfo,453,54),
              new DiceInfo("Shield","Shield - Blocks 1 BOW",diceInfo,559,54),
              new DiceInfo("Thief","Thief - Steals 1 FAVOR from your opponent!",diceInfo,665,54),

              diceInfo, home,sMin,retu});

      TextInfo powerInfo = new TextInfo("Select an god to learn their power!",145,y-210,x-290,250,24);
      powerRules.setItems(new Rec[]{
              new TextInfo("Basic:",10,175,100,50,50),
              new TextInfo("Dice:",10,315,100,50,50),
              new TextInfo("Special:",10,455,200,50,50),

              new PowerInfo("Thor","MIGHT",12,"Deals 8 Damage to your opponent!",powerInfo,(x-600)/2+20,135),
              new PowerInfo("Odin","WISDOM", 8,"Grants an extra dice (two theifs), each side grants energy! (Can only be used once)",powerInfo,(x-64)/2,135),
              new PowerInfo("Freyja","BEAUTY",12,"Gives you 10 Health",powerInfo,(x+472)/2-20,135),

              new PowerInfo("Loki","TRICKERY",6,"Replaces a random ordinary die (If you have one) with a LOKI die - 2 sides destroy your opponent's energy",powerInfo,(x-600)/2+20,275),
              new PowerInfo("Frigg","CLAIRVOYANCE",6,"Replaces a random ordinary die (If you have one) with a FRIGG die - 2 sides gives you an extra health",powerInfo,(x-64)/2,275),
              new PowerInfo("Vidar","ANGER",6,"Replaces a random ordinary die (If you have one) with a VIDAR die - 2 sides deal extra damage",powerInfo,(x+472)/2-20,275),


              new PowerInfo("Heimdall","VISION",8,"You can see through the mists of NIFLHEIM",powerInfo,(x-600)/2+20,415),
              new PowerInfo("Surtur","FLAME",7,"You no longer take damage from the fires of MUSPELHEIM",powerInfo,(x-64)/2,415),
              new PowerInfo("Idun","APPLE",6,"One of your die gets upgraded with the Power of Asgard- each side is doubled in power!",powerInfo,(x+472)/2-20,415),

              powerInfo,home,sMin,retu});

      TextInfo rulesInfo = new TextInfo("Select an option!",145,y-260,x-290,250,24);
      basicRules.setItems(new Rec[]{rulesInfo,home,sMin,retu});

      TextInfo realmInfo = new TextInfo("Select a realm to learn its rules!",145,y-210,x-290,250,24);
      realmRules.setItems(new Rec[]{
              new InfoButton("Buttons/","Midgard","HT_Back","All locations in Midgard use basic rules",realmInfo,(x-225)/2,90,225,125),

              new RealmInfo("Asgard","In Asgard, Players gain 1 Energy every turn, and also can use IDUN'S APPLE blessing to upgrade their dice",realmInfo,(x-200)/2,275),
              new RealmInfo("Vana","Vanaheim!",realmInfo,(x-600)/2+20,275),
              new RealmInfo("Alf","In Alfheim, each side of each dice uses 4 symbols instead of 1",realmInfo,(x+200)/2-20,275),

              new RealmInfo("Nifl","In Niflheim, you cannot see what your opponent has rolled or chosen, nor can you see what you picked in previous rolls. use HEIMDALL'S VISION blessing to restore sight!",realmInfo,(x-200)/2,450),
              new RealmInfo("Muspel","In Muspelheim, players take 1 damage every turn.  Gain SURTUR'S FLAME blessing to prevent this",realmInfo,(x-600)/2+20,450),
              new RealmInfo("Jotun","In Jotunheim, the choices you take on each turn are frozen out from their dice for the next turn!",realmInfo,(x+200)/2-20,450),


              realmInfo,home,sMin,retu});

      hostMenu.setItems(new Rec[]{home,sMin,retu});
      joinMenu.setItems(new Rec[]{home,sMin,retu});

      mainMenu.set(root);
   }

}
