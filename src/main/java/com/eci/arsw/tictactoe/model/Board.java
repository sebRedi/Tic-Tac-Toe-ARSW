package com.eci.arsw.tictactoe.model;

import java.util.Arrays;

public class Board {
    private final char[] cells = new char[9]; // 'X', 'O' o '\0'

    public Board() { Arrays.fill(cells, '\0'); }

    public char[] getCells() { return cells; }

    public boolean isEmptyAt(int idx) { return cells[idx] == '\0'; }

    public void place(int idx, char symbol) { cells[idx] = symbol; }
}