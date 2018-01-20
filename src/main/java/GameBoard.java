package main.java;

import java.awt.*;

public class GameBoard {

    public GameBoard(){ //konstruktor

        generateBoard();
        generateTetromino();

    }

    public Field boardOfField[][];
    public Tetromino tetromino;
    private int score = 0;

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

        int selectedShape = (int) (Math.random() * 7); //cisla 0-6
        switch (selectedShape) {
            case 0:
                tetromino = new Sshape(Color.magenta, this);
                break;
            case 1:
                tetromino = new Tshape(Color.green, this);
                break;
            case 2:
                tetromino = new Oshape(Color.yellow, this);
                break;
            case 3:
                tetromino = new Lshape(Color.red, this);
                break;
            case 4:
                tetromino = new Ishape(Color.orange, this);
                break;
            case 5:
                tetromino = new Zshape(Color.cyan, this);
                break;

            case 6:
                tetromino = new Pshape(Color.pink, this);
                break;
        }

     /*   if (stav == 1){
            tetromino = new Sshape(Color.magenta, this);
            stav = 2;
        }
        else if (stav == 2){
            tetromino = new Tshape(Color.green, this);
            stav = 3;
        }

        else if (stav == 3){
            tetromino = new Oshape(Color.yellow, this);
            stav = 4;
        }
        else if (stav == 4){
            tetromino = new Lshape(Color.red, this);
            stav = 5;
        }
        else if (stav == 5){
            tetromino = new Ishape(Color.orange, this);
            stav = 6;
        }else if (stav == 6){
            tetromino = new Zshape(Color.cyan, this);
            stav = 1;
        }*/
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

    public boolean isRowFull(int i) {
        int occupied=0;
        for (int j = 0; j < 10; j++) {
           if (!boardOfField[j][i].isAvaiable()){
                occupied++;
            }
        }

        if (occupied == 10){
            return true;
        }
      return false;
    }

    public void deleteRow(int nRow) {

        System.out.println("DELETE ROW");

        // deleteRow();
        for (int j = nRow; j > 1; j--){
            for (int i = 0; i < 10; i++) {
                boardOfField[i][j] = boardOfField[i][j - 1];
            }
        }
        scorePlusPlus();
        System.out.println("Skore:" + score);
    }

    public void scorePlusPlus(){
        this.score++;
    }

    public int getScore(){
        return score;
    }

}
