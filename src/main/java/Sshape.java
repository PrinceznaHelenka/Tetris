package main.java;

import java.awt.*;

public class Sshape implements Tetromino{

    int x;
    private int y;
    private Color color;
    private GameBoard gameBoard;
    private boolean firstMove = true;


    public Sshape(int x, int y, Color color, GameBoard gameBoard){
        this.x = x;
        this.y = y;
        this.color = color;
        this.gameBoard = gameBoard;
    }
    private boolean[][] Sshape1= {
            { false, true, true},
            { true,  true, false},
    };

    private boolean[][] Sshape2= {
            { true, false},
            { true, true},
            { false, true},

    };
    public int move(){
        y = y+1;
        firstMove = false;
        return 1;
    }

    public boolean isFirstMove(){
        return firstMove;
    }

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
    public int transformShape(){ //šipka top
        if (Shape == 1){
            return 2;
        }
        else {
            return 1;
        }
    }

    public int moveDown(){
        if (gameBoard.boardOfField[getX()][getY() + 2].isAvaiable() == true){
            y = y+1;
        }
        return y;
    }

  /*  public void moveDownDown(){
        while (canIMove()){
            move();
        }

    }

    public boolean canIMove(){ //domyslet
        if (getY()==19){
            return false;
        }
        if (gameBoard.boardOfField[getX()][(getY() + 1)].isAvaiable()){
            return true;
        }
        else {
            return false;
        }

    }*/

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
