package com.example.orlog.Game;



public enum Playnum {
    PLAYER1 (0),
    PLAYER2 (1);
    private final int number;
    Playnum(int n){
        number = n;
    }
    public static Playnum getPlayer(int n){
        for (Playnum p : Playnum.values()) {
            if (p.getNumber() == n) return p;
        }
        return null;
    }
    public int getNumber() {
        return number;
    }
}
