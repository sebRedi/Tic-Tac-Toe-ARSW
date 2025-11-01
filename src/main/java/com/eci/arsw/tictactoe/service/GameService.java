package com.eci.arsw.tictactoe.service;

import com.eci.arsw.tictactoe.model.Board;
import com.eci.arsw.tictactoe.model.GameState;
import com.eci.arsw.tictactoe.model.Move;
import org.springframework.stereotype.Service;

@Service
public class GameService {
    private final Board board = new Board();
    private char next = 'X';
    private Character winner = null;
    private boolean draw = false;

    private static final int[][] WINS = {
            {0,1,2},{3,4,5},{6,7,8},
            {0,3,6},{1,4,7},{2,5,8},
            {0,4,8},{2,4,6}
    };

    public synchronized GameState state(){
        return new GameState(board.getCells().clone(), next, winner, draw);
    }

    public synchronized GameState reset(){
        for (int i=0;i<9;i++) board.getCells()[i] = '\0';
        next = 'X'; winner = null; draw = false;
        return state();
    }

    public synchronized GameState move(Move move){
        if (winner != null || draw) return state();
        if (move.getPlayer() != next) return state();
        int idx = move.getIndex();
        if (idx < 0 || idx > 8 || !board.isEmptyAt(idx)) return state();

        board.place(idx, move.getPlayer());
        checkWinnerOrDraw();
        if (winner == null && !draw) next = (next=='X') ? 'O' : 'X';
        return state();
    }

    private void checkWinnerOrDraw(){
        for (int[] w : WINS){
            char a = board.getCells()[w[0]];
            char b = board.getCells()[w[1]];
            char c = board.getCells()[w[2]];
            if (a!='\0' && a==b && b==c){
                winner = a; return;
            }
        }
        boolean anyEmpty=false;
        for (char cell : board.getCells()) if (cell=='\0') { anyEmpty=true; break; }
        draw = !anyEmpty && winner==null;
    }
}