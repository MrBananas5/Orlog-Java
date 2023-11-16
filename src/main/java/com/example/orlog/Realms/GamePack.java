package com.example.orlog.Realms;

public class GamePack {
    private final String power = null;
    private final String name;
    String sname;
    public GamePack(String name){
        this.name = name;
        this.sname = name;
    }

    public String getPower(){return power;}

    public String getName() {return name;}

    public String getSName() {return sname;}
}
