package main.java;

import java.awt.*;

public class Shape {

    private Field fieldcoord[];
    private Color color;
    private GameBoard gameBoard;
    private boolean firstMove = true;
    private boolean stav = true;

    public Shape() {
        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(4, 1);
        fieldcoord[1] = new Field(5, 1);        //WTF
        fieldcoord[2] = new Field(5, 0);
        fieldcoord[3] = new Field(6, 0);
    }


    public int move(){
        for (int j = 0; j < 4; j++) {
            fieldcoord[j].y++;
        }
        firstMove = false;
        return 1;
    }

    public boolean isFirstMove(){
        return firstMove;
    }

    public void moveRight(){
        for (int j=0; j < 4; j++){
            if (fieldcoord[j].x<9){
                fieldcoord[j].x++;
            }
        }
    }
    public void moveLeft(){

        if (!(fieldcoord[0].x>0 && gameBoard.boardOfField[fieldcoord[0].x-1][fieldcoord[0].y].isAvaiable())){
            stav = false;}
        if (!(fieldcoord[1].x>0 && gameBoard.boardOfField[fieldcoord[1].x-1][fieldcoord[1].y].isAvaiable())){
            stav = false;}
        if (!(fieldcoord[2].x>0 && gameBoard.boardOfField[fieldcoord[2].x-1][fieldcoord[2].y].isAvaiable())){
            stav = false;}
        if (!(fieldcoord[3].x>0 && gameBoard.boardOfField[fieldcoord[3].x-1][fieldcoord[3].y].isAvaiable())){
            stav = false;}

        if ( stav == true){
            for (int j=0; j < 4; j++){
                fieldcoord[j].x--;}
        }
    }


    public void moveDownDown(){
        while (canIMove()){
            move();
        }

    }

    public boolean canIMove(){
        for (int j=0; j < 4; j++){
            if (fieldcoord[j].y == 19){
                return false;
            }}

        for (int j=0; j < 4; j++){
            if (!gameBoard.boardOfField[fieldcoord[j].x][fieldcoord[j].y+1].isAvaiable()){
                return false;
            }}

        return true;
    }

    public void die(){

        //souřadnice z ttmna se propíše do fieldu, a to bude navždy plné - ukládání na dno
        for (int j=0; j < 4; j++){
            gameBoard.boardOfField[fieldcoord[j].x][fieldcoord[j].y].color = this.getColorOfTetromino();}

        //chci, aby to getovalo color ttmna a ne fieldu
        //gameBoard.boardOfField[getX()][getY()].isAvaiable() = false;
        //"vyresetuje se a
        gameBoard.killTetromino();

    }

    public Color getColorOfTetromino(){
        return color;
    }


    public Field[] getFieldCoord(){
        return fieldcoord;
    }
}