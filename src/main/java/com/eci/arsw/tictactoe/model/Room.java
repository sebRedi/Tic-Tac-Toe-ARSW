package com.eci.arsw.tictactoe.model;

import java.util.HashMap;

public class Room {
    private boolean player1;
    private boolean player2;
    private String password;
    private int roomId;
    private GameState state;

    private HashMap<Integer, GameState> localHistory = new HashMap<Integer, GameState>();

    public Room(String password, int roomId) {
        this.player1 = true;
        this.password = password;
    }
    public boolean playerTwoJoins(){ return player2 = true; }
    public boolean isComplete(){ return player1 && player2; }
}
