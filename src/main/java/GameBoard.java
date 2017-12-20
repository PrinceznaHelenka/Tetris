package main.java;

import java.awt.*;

public class GameBoard {

    public GameBoard(){ //konstruktor

        generateBoard();
       // boardOfField[2][6].color = Color.red;
        generateTetromino();

    }

    public Field boardOfField[][];
    public Tetromino tetromino;

    int i, j;

    public void generateBoard() {
        boardOfField = new Field[10][20];
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 20; j++) {
                boardOfField[i][j] = new Field(i,j);
            }
        }
    }

    public void generateTetromino(){
        tetromino = new Tetromino(5,0, Color.red, this);
    }

    public Field[][] getBoardOfField() {
        return boardOfField;
    }

    public Tetromino getTetromino(){
        return tetromino;
    }

    public void killTetromino(){
        tetromino = null;
    }

}
