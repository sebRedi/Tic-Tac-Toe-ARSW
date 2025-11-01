package com.eci.arsw.tictactoe.model;

public class GameState {
    private char[] cells; // tamaño 9
    private char nextPlayer; // 'X' o 'O'
    private Character winner; // 'X'/'O' o null si nadie
    private boolean draw;

    public GameState() {}
    public GameState(char[] cells, char nextPlayer, Character winner, boolean draw) {
        this.cells = cells; this.nextPlayer = nextPlayer; this.winner = winner; this.draw = draw;
    }
    public char[] getCells(){ return cells; }
    public void setCells(char[] c){ this.cells = c; }
    public char getNextPlayer(){ return nextPlayer; }
    public void setNextPlayer(char p){ this.nextPlayer = p; }
    public Character getWinner(){ return winner; }
    public void setWinner(Character w){ this.winner = w; }
    public boolean isDraw(){ return draw; }
    public void setDraw(boolean d){ this.draw = d; }
}