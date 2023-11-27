package com.example.orlog.Buttons;



import com.example.orlog.Menu.PowerMenu;
import com.example.orlog.Realms.Midgard;
import javafx.scene.Group;

public class GamePicker extends MenuButton{
    public GamePicker(PowerMenu menu, Group group, String name, String tint,int n,int x, int y){
        super(menu,group,"Buttons/Realms/",name,"Mid_"+n,x,y,200,125);
        setClick( menu, group,new Midgard(name,"Midgard/",tint));


    }
    public GamePicker(Midgard pack, PowerMenu menu, Group group, int x, int y){
        super(menu,group,"Buttons/Realms/",pack.getSName()+"_Front", pack.getSName()+"_Back", x, y,200,125);
        setClick(menu,group,pack);
    }
    private void setClick(PowerMenu menu,Group group,Midgard pack){
        bg.setOnMouseClicked(mouseEvent -> menu.set(group,pack));
        fg.setOnMouseClicked(mouseEvent -> menu.set(group,pack));
    }
}
