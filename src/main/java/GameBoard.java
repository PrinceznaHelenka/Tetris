package main.java;

import java.awt.*;

public class GameBoard {

    private Field boardOfField[][];
    Tetromino tetromino;

    int i, j;

    public void generateBoard() {
        for (i = 0; i < 10; i++) {
            for (j = 0; j < 20; j++) {
                boardOfField[i][j] = new Field(i,j, getColorOfTheField(i, j));
            }
        }
    }

    public Color getColorOfTheField(int i, int j) {
        return Color.getHSBColor(216, 30, 117); //random
    }

    public Field[][] getBoardOfField() {
        return boardOfField;
    }

    public void Tetromino getTetromino(){
        return
    }


}
