package com.example.orlog.Realms;

import com.example.orlog.Powers.Power;

public class Midgard {
    protected Power power = null;
    private final String name;
    protected String sname;
    public Midgard(String name){
        this.name = name;
        this.sname = name;
    }

    public Power getPower(){return power;}

    public String getName() {return name;}

    public String getSName() {return sname;}
}
