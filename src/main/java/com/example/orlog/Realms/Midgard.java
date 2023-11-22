package com.example.orlog.Realms;

import com.example.orlog.Powers.Power;

public class Midgard {
    protected Power power = null;
    private final String name;
    protected String sname;
    private final String tint;
    private final String path;
    public Midgard(String name,String path,String tint){
        this.name = name;
        this.sname = name;
        this.path = path;
        this.tint = tint;
    }

    public Midgard(String name,String tint) {
        this.name = name;
        this.sname = name;
        this.path = name;
        this.tint = tint;
    }

    public Power getPower(){return power;}

    public String getName() {return name;}
    public String getSName() {return sname;}

    public String getIcon() {
        return this.path+"Icon.png";
    }

    public String getPath(){return this.path;}


    public String getTint() {
        return tint;
    }
}
