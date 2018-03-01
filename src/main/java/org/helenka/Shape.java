package org.helenka;

import java.awt.*;

public abstract class Shape {

    protected Field fieldcoord[];
    protected Color color;
    protected GameBoard gameBoard;
    protected boolean firstMove = true;
    protected boolean stav = true;

    public Shape() {
        fieldcoord = new Field[4];
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
            if (!gameBoard.boardOfField[getFieldCoord()[j].x][getFieldCoord()[j].y+1].isAvaiable()){
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