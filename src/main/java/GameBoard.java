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

    public void generateBoard() {
        boardOfField = new Field[10][20];
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 20; j++) {
                boardOfField[i][j] = new Field(i,j);
            }
        }
    }

    public void generateTetromino(){
        tetromino = new Tetromino() {
            @Override
            public int move() {
                return 0;
            }

            @Override
            public boolean isFirstMove() {
                return false;
            }

            @Override
            public int moveRight() {
                return 0;
            }

            @Override
            public int moveLeft() {
                return 0;
            }

            @Override
            public int moveDown() {
                return 0;
            }

          //  @Override
          //  public void moveDownDown() {

          //  }

            @Override
            public int transformShape() {
                return 0;
            }

        //    @Override
        //    public boolean canIMove() {
        //        return false;
        //    }

            @Override
            public void die() {

            }

            @Override
            public int getX() {
                return 5;
            }

            @Override
            public int getY() {
                return 0;
            }

            @Override
            public Color getColorOfTetromino() {
                return Color.MAGENTA;
            }
        };
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
