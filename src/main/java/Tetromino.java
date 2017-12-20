package main.java;

import java.awt.*;

public class Tetromino{

    private int x;
    private int y;
    private Color color;
    private GameBoard gameBoard;


    public Tetromino(int x, int y, Color color, GameBoard gameBoard){
        this.x = x;
        this.y = y;
        this.color = color;
        this.gameBoard = gameBoard;
    }

    public int move(){
       y = y + 1;
       return 1;
    }

    public boolean canIMove(){ //domyslet

       if (gameBoard.boardOfField[getX()][(getY()+1)].isAvaiable()){
           return true;
       }
       else {
           return false;
       }
        //return !((y+1)==19);

    }

    public void die(){
        //souřadnice z ttmna se propíše do fieldu, a to bude navždy plné - ukládání na dno
        gameBoard.boardOfField[x][y] = gameBoard.boardOfField[getX()][getY()];

        gameBoard.boardOfField[x][y].color = this.color; //chci, aby to getovalo color ttmna a ne fieldu
        //   gameBoard.boardOfField[getX()][getY()].isAvaiable() = false;
        //"vyresetuje se a
        gameBoard.killTetromino();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public Color getColorOfTetromino(){
        return color;
    }

}
