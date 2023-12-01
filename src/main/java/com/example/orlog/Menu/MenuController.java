package com.example.orlog.Menu;

import com.example.orlog.Buttons.*;

import com.example.orlog.Game.*;
import com.example.orlog.Powers.*;

import com.example.orlog.Realms.Muspelheim;
import com.example.orlog.Realms.Niflheim;
import javafx.scene.Group;
import javafx.scene.Scene;

import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import javafx.scene.paint.CycleMethod;
import javafx.scene.paint.RadialGradient;
import javafx.scene.paint.Stop;
import javafx.stage.Stage;


public class MenuController {
   public static MenuController menucontroller;
   public void setMenuTitle(String title){stage.setTitle("Orlog - "+ title);}
   public static String tintCol = "#0e8eb5";
   private Menu menu;
   private Menu oldMenu;
   public DicePack getDicePack() {
      return dicePack;
   }
   private final DicePack dicePack;
   public Group getGroup() {
      return root;
   }
   private final Group root;
   public DiceMenu getDiceMenu() {
      return diceMenu;
   }
   private final Stage stage;
   private final DiceMenu diceMenu;
   public PowerMenu getPowerMenu() {
      return powerMenu;
   }
   private Player player;
   public Player getPlayer(){return player;}
   public void setPlayer(Player player){this.player = player;}

   private final PowerMenu powerMenu;
   public MenuController(Stage stage){
      menucontroller = this;
      this.stage =  stage;
      root = new Group();
      stage.setResizable(false);
      int x = 900; int y = 750;
      Scene scene = new Scene(root, x, y);
      scene.setFill(new RadialGradient(
              0, 0, 0, 0, 1, true,                  //sizing
              CycleMethod.NO_CYCLE,                 //cycling
              new Stop(0, Color.web("#3d1b08")),    //colors
              new Stop(1, Color.web("#58270c")))
      );
      stage.getIcons().add(new Image("file:C:/Users/pek14/Documents/JORLOG/Orlog/src/main/resources/com/example/orlog/Midgard/Icon.png"));
      stage.setScene(scene);
      stage.show();

      dicePack = new DicePack();

      Menu p2Select = new Menu("Select an opponent");
      Menu mainMenu = new Menu("Menu");
      Menu rulesMain = new Menu("Rules");
      Menu settings = new Menu("Settings");
      Menu diceRules = new Menu("Dice Information");
      Menu powerRules = new Menu("Power Information");
      Menu basicRules = new Menu("Rules");
      Menu realmRules = new Menu("Realm Information");
      Menu envSelect = new Menu("Select a location!");
      Menu aISelect = new Menu("Select a computer!");
      Menu hostMenu = new Menu("Host a game");
      Menu joinMenu = new Menu("Join a game");
      Menu realmSelect = new Menu("Select a location!");
      diceMenu = new DiceMenu("Customise dice");
      powerMenu = new PowerMenu("Choose your powers!");

      MinButton home = new MinButton(mainMenu,root,"Symb_home",10,y-135);
      MinButton sMin = new MinButton(settings,root,"Symb_settings",x-135,10);
      ReturnButton retu = new ReturnButton(root,x-135,y-135);

      NullImage logo = new NullImage("","Newlogo",(x-562)/2,0,562,342);

      HTButton midSelect = new HTButton(envSelect,root,"Midgard",128,90);
      HTButton reaSelect = new HTButton(realmSelect,root,"Yggdrasil",x-403,90);

      MinButton basInf = new MinButton(basicRules,root,"Symb_B",10,10);
      MinButton reaInf = new MinButton(realmRules,root,"Symb_Tree",145,10);
      MinButton dicInf = new MinButton(diceRules,root,"Symb_Dice",280,10);
      MinButton powInf = new MinButton(powerRules,root,"Symb_Favour",415,10);


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
              new PlayerButton(new Player(Playnum.PLAYER2),envSelect,root,"Buttons/","Local","LT_Back",(x-450)/2,y-405,450,125),
              new HTButton(hostMenu,root,"Host",(x-1350/2),y-135),
              new HTButton(joinMenu,root,"Join",(x-900/2),y-135),
              home,sMin,retu,logo});

      envSelect.setItems(new Rec[]{
              ///new GamePicker(powerMenu,root,"Anslo","#fceb35",1,(x-200)/2,275),
              ///new GamePicker(powerMenu,root,"Nidaros","#fceb35",2,(x-600)/2+20,275),
              ///new GamePicker(powerMenu,root,"Jomsborg","#fceb35",2,(x+200)/2-20,275),

              new GamePicker(powerMenu,root,"Jorvik","#fceb35",1,(x-200)/2,450),
              new GamePicker(powerMenu,root,"Grœnland","#00FFFF",2,(x-600)/2+20,450),
              new GamePicker(powerMenu,root,"Vinland","#00FF00",2,(x+200)/2-20,450),

              reaSelect,midSelect,sMin,retu});
      realmSelect.setItems(new Rec[]{
             /// new GamePicker(new Asgard(dicePack),powerMenu,root,(x-200)/2,275),
             /// new GamePicker(new Vanaheim(),powerMenu,root,(x-600)/2 +20,275),
             /// new GamePicker(new Alfheim(),powerMenu,root,(x+200)/2 -20,275),

              new GamePicker(new Niflheim(dicePack),powerMenu,root,(x-200)/2,450),
              new GamePicker(new Muspelheim(dicePack),powerMenu,root,(x-600)/2 + 20,450),
             /// new GamePicker(new Jotunheim(),powerMenu,root,(x+200)/2 - 20,450),

              reaSelect,midSelect,sMin,retu});
      Power[] powerItems = new Power[]{
              new Thor(25,148,dicePack),
              new Freyja(99,148,dicePack),
              new Odin(173,148,dicePack),
              new Loki(173,300,dicePack),
              new Vidar(25,300,dicePack),
              new Frigg(99,300,dicePack),
              };

      powerMenu.setItems(powerItems);
      powerMenu.addAll(new Rec[]{
              new MinButton(diceMenu,root,"Symb_Dice",10,10),
              new PlayButton(225,453),
              sMin});

      DiceBuilder[] diceItems = new DiceBuilder[]{
              new DiceBuilder("Midgard",138,10),
              new DiceBuilder("Midgard",138,116),
              new DiceBuilder("Midgard",138,222),
              new DiceBuilder("Midgard",138,328),
              new DiceBuilder("Midgard",138,434),
              new DiceMaster("Midgard","ALL",276,328),
              new DiceRandom("Midgard",276,222),
      };

      diceMenu.setItems(diceItems);
      diceMenu.add(sMin);
      diceMenu.add(retu);

      aISelect.setItems(new Rec[]{
              new AIButton(new AIPlayer(),envSelect,root,"Knud","TL",(x-445)/2 ,y-400),
              new AIButton(new AIPlayer(),envSelect,root,"Yrsa","TR",(x-5)/2,y-400),
              new AIButton(new AIPlayer(),envSelect,root,"Bjorn","M",(x-445)/2,y-280),
              new AIButton(new AIPlayer(),envSelect,root,"Liv","M",(x-5)/2,y-280),
              new AIButton(new AIPlayer(),envSelect,root,"Frode","BL",(x-445)/2,y-160),
              new AIButton(new AIPlayer(),envSelect,root,"Ragnar","BR",(x-5)/2,y-160),

              home,sMin,retu,logo});
      settings.setItems(new Rec[]{home,sMin,retu,logo});

      TextInfo diceInfo = new TextInfo("Select an option!",135,425+64,x-270,150,36);
      diceRules.setItems(new Rec[]{
              new DiceInfo("Gold_Front","A Gold Border - grants 1 FAVOR",diceInfo,559,266),

              new DiceInfo("Frigg_Front","Frigg_Back","A Prophecy Border - Heals 1 health",diceInfo,135,160),
              new DiceInfo("Vidar_Front","Vidar_Back","A Vengeance Border - deals 1 Damage to your opponent!",diceInfo,135,266),
              new DiceInfo("Loki_Front","Loki_Back","A Mischief Border - destroys 1 of your opponents FAVOR",diceInfo,135,372),

              new DiceInfo("Basic_Back","A Basic Dice - two sides have a GOLD BORDER",diceInfo,665,266),
              new DiceInfo("Frigg_Back","A Frigg Dice - two sides have a GOLD BORDER, and two more have a PROPHECY BORDER - those sides give 1 Health",diceInfo,29,160),
              new DiceInfo("Vidar_Back","A Vidar Dice - two sides have a GOLD BORDER, and two more have a VENGEANCE BORDER - those sides deal 1 Damage to your opponent!",diceInfo,29,266),
              new DiceInfo("Loki_Back","A Loki Dice - two sides have a GOLD BORDER, and two more have a MISCHIEF BORDER - those sides destroy your opponents FAVOR ",diceInfo,29,372),
              new DiceInfo("Odin_Back","An Odin Dice - every side has a GOLD BORDER!",diceInfo,29,478),

              new DiceInfo("Axe","Axe - deals 1 damage to your opponent. Blocked by WARRIOR",diceInfo,241,160),
              new DiceInfo("Bow","Bow - deals 1 damage to your opponent. Blocked by SHIELD",diceInfo,347,160),
              new DiceInfo("Warrior","Warrior - Blocks 1 AXE",diceInfo,453,160),
              new DiceInfo("Shield","Shield - Blocks 1 BOW",diceInfo,559,160),
              new DiceInfo("Thief","Thief - Steals 1 FAVOR from your opponent!",diceInfo,665,160),
              basInf, reaInf, dicInf, powInf,
              diceInfo, home,sMin,retu});

      TextInfo powerInfo = new TextInfo("Select an god to learn their power!",145,y-210,x-290,250,24);
      powerRules.setItems(new Rec[]{
              new TextInfo("Basic:",10,185,100,50,50),
              new TextInfo("Dice:",10,325,100,50,50),
              new TextInfo("Special:",10,465,200,50,50),

              new PowerInfo("Thor","MIGHT",12,"Deals 8 Damage to your opponent!",powerInfo,(x-600)/2+20,145),
              new PowerInfo("Odin","WISDOM", 8,"Grants an extra dice (two theifs), each side grants energy! (Can only be used once)",powerInfo,(x-64)/2,145),
              new PowerInfo("Freyja","BEAUTY",12,"Gives you 10 Health",powerInfo,(x+472)/2-20,145),

              new PowerInfo("Loki","TRICKERY",6,"Replaces a random ordinary die (If you have one) with a LOKI die - 2 sides destroy your opponent's energy",powerInfo,(x-600)/2+20,285),
              new PowerInfo("Frigg","CLAIRVOYANCE",6,"Replaces a random ordinary die (If you have one) with a FRIGG die - 2 sides gives you an extra health",powerInfo,(x-64)/2,285),
              new PowerInfo("Vidar","ANGER",6,"Replaces a random ordinary die (If you have one) with a VIDAR die - 2 sides deal extra damage",powerInfo,(x+472)/2-20,285),


              new PowerInfo("Heimdall","VISION",8,"You can see through the mists of NIFLHEIM",powerInfo,(x-600)/2+20,425),
              new PowerInfo("Surtur","FLAME",7,"You no longer take damage from the fires of MUSPELHEIM",powerInfo,(x-64)/2,425),
              new PowerInfo("Idun","APPLE",6,"One of your die gets upgraded with the Power of Asgard- each side is doubled in power!",powerInfo,(x+472)/2-20,425),
              basInf, reaInf, dicInf, powInf,
              powerInfo,home,sMin,retu});

      TextInfo rulesInfo = new TextInfo("Select an option!",145,y-260,x-290,250,24);
      basicRules.setItems(new Rec[]{basInf, reaInf, dicInf, powInf,rulesInfo,home,sMin,retu});

      TextInfo realmInfo = new TextInfo("Select a realm to learn its rules!",145,y-210,x-290,250,24);
      realmRules.setItems(new Rec[]{
              new InfoButton("Buttons/","Midgard","HT_Back","All locations in Midgard use basic rules",realmInfo,(x-225)/2,155,225,125),

              new RealmInfo("Asgard","In Asgard, Players gain 1 Energy every turn, and also can use IDUN'S APPLE blessing to upgrade their dice",realmInfo,(x-200)/2,300),
              new RealmInfo("Vana","Vanaheim!",realmInfo,(x-600)/2+20,300),
              new RealmInfo("Alf","In Alfheim, each side of each dice uses 4 symbols instead of 1",realmInfo,(x+200)/2-20,300),

              new RealmInfo("Nifl","In Niflheim, you cannot see what your opponent has rolled or chosen, nor can you see what you picked in previous rolls. use HEIMDALL'S VISION blessing to restore sight!",realmInfo,(x-200)/2,480),
              new RealmInfo("Muspel","In Muspelheim, players take 1 damage every turn.  Gain SURTUR'S FLAME blessing to prevent this",realmInfo,(x-600)/2+20,480),
              new RealmInfo("Jotun","In Jotunheim, the choices you take on each turn are frozen out from their dice for the next turn!",realmInfo,(x+200)/2-20,480),
              basInf, reaInf, dicInf, powInf,

              realmInfo,home,sMin,retu});

      hostMenu.setItems(new Rec[]{home,sMin,retu});
      joinMenu.setItems(new Rec[]{home,sMin,retu});
      setMenu(mainMenu);
      mainMenu.set(root);
   }
   public void begin(){
      diceMenu.setDice(dicePack,powerMenu.getRealm());
      new GameController(this.powerMenu.getRealm(),this.player,this.dicePack,stage,stage.getScene());
   }
   public Menu getMenu(){return menu;}
   public void setMenu(Menu menu ){
      this.oldMenu = this.menu;
      this.menu=menu;}
   public Menu getOldMenu(){return oldMenu;}
}
