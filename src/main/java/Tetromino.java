package main.java;

import java.awt.*;

public class Tetromino{

    private int x;
    private int y;
    private Color color;
    private GameBoard gameBoard;
    private boolean firstMove = true;


    public Tetromino(int x, int y, Color color, GameBoard gameBoard){
        this.x = x;
        this.y = y;
        this.color = color;
        this.gameBoard = gameBoard;
    }

    public int move(){
        y = y+1;
        firstMove = false;
        return 1;
    }

    public boolean isFirstMove(){
        return firstMove;
    }

  /*  public int move(){
        if (gameBoard.boardOfField[getX()][getY() + 1].isAvaiable() == true){
            y = y+1;
            return 1;
        }
        else {
           if( gameBoard.boardOfField[getX()][getY()].isAvaiable() == true){
               y = y+1;
               return 1;
           }
           else{
               System.out.println("GAMEOVER");
           }

            return 2;}

    }*/

    public int moveRight(){
        if (x < 9 && gameBoard.boardOfField[getX()+1][getY()].isAvaiable() == true){
            x = x + 1;
        }
        return x;
    }
    public int moveLeft(){
        if (x>0 && gameBoard.boardOfField[getX()-1][getY()].isAvaiable() == true){
            x = x - 1;
        }
        return x;
    }
    /*public int transformToAnotherShape(){ //šipka top
    }*/

    public int moveDown(){
        if (gameBoard.boardOfField[getX()][getY() + 2].isAvaiable() == true){
            y = y+1;
        }
        return y;
    }

    public void moveDownDown(){
       /* int i = 1;
        int currentY = 0;

        while (gameBoard.boardOfField[getX()][getY() + i].isAvaiable()){
            i++;
            currentY = getY();
        }

        y = currentY + i - 2;
        System.out.println(currentY);
        System.out.println(y);

        return y;*/

        while (canIMove()){
            move();
        }


    }

    public boolean canIMove(){ //domyslet

       if (gameBoard.boardOfField[getX()][(getY() + 1)].isAvaiable()){
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

        gameBoard.boardOfField[x][y].color = this.getColorOfTetromino();

        //chci, aby to getovalo color ttmna a ne fieldu
        //gameBoard.boardOfField[getX()][getY()].isAvaiable() = false;
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