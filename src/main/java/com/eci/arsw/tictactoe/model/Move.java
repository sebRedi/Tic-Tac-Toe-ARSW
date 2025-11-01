package com.eci.arsw.tictactoe.model;

public class Move {
    private int index; // 0..8
    private char player; // 'X' o 'O'

    public Move() {}
    public Move(int index, char player) { this.index = index; this.player = player; }

    public int getIndex() { return index; }
    public void setIndex(int index) { this.index = index; }
    public char getPlayer() { return player; }
    public void setPlayer(char player) { this.player = player; }
}