package main.java;

import java.awt.*;

public class Lshape extends main.java.Shape implements Tetromino{

private int stav = 1;


public Lshape(Color color, GameBoard gameBoard){
        this.color = color;
        this.gameBoard = gameBoard;

        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(4, 1);
        fieldcoord[1] = new Field(5, 1);
        fieldcoord[2] = new Field(6, 1);
        fieldcoord[3] = new Field(6, 0);

        }


public void transformShape() {//šipka top

    if (stav == 1) {
        fieldcoord[0].x++;
        fieldcoord[0].y--;
        fieldcoord[2].x--;
        fieldcoord[2].y++;
        fieldcoord[3].y = fieldcoord[3].y + 2;

        stav = 2;
    }
    else if (stav == 2){
        fieldcoord[0].x++;
        fieldcoord[0].y++;
        fieldcoord[2].x--;
        fieldcoord[2].y--;
        fieldcoord[3].x = fieldcoord[3].x - 2;

        stav = 3;
    }
    else if (stav == 3){
        fieldcoord[0].x--;
        fieldcoord[0].y++;
        fieldcoord[2].x++;
        fieldcoord[2].y--;
        fieldcoord[3].y = fieldcoord[3].y - 2;

        stav = 4;
    }
    else if (stav == 4){
        fieldcoord[0].x--;
        fieldcoord[0].y--;
        fieldcoord[2].x++;
        fieldcoord[2].y++;
        fieldcoord[3].x = fieldcoord[3].x + 2;

        stav = 1;
    }


}
}
