package com.example.orlog.Game;

public enum DiceVal{
    WARRIOR, BOW, SHIELD,THIEF,AXE,
    BASIC, FRIGG, LOKI, VIDAR, ODIN,
    GOLD, NONE;

    public static DiceVal getBorder(int n, DiceVal back) {
        if (back== ODIN){return GOLD;}
        switch (n){
            case 1:
            case 2:
                return GOLD;
            case 3:
            case 4:
                if (back == FRIGG ||back == LOKI || back == VIDAR){return back;}
            default:return NONE;
        }
    }

}
