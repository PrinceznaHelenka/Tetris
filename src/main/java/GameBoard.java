package main.java;

import java.awt.*;

public class GameBoard {

    public GameBoard(){ //konstruktor

        generateBoard();
        generateTetromino();

    }

    public Field boardOfField[][];
    public Tetromino tetromino;

    int i, j;

    int stav = 1;

    public void generateBoard() {
        boardOfField = new Field[10][20];
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 20; j++) {
                boardOfField[i][j] = new Field(i,j);
            }
        }
    }

    public void generateTetromino(){

        if (stav == 1){
            tetromino = new Sshape(Color.magenta, this);
            stav = 2;
        }
        if(stav == 2){
            tetromino = new Tshape(Color.green, this);
            stav = 1;
        }

        //sem prijsou dlasi Lshape, necoShape a pak se náhodně zvolí
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
