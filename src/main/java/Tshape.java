package main.java;

import java.awt.*;

public class Tshape extends Shape implements Tetromino{
    private Color color;
    private GameBoard gameBoard;

    Field fieldcoord[];


    private int stav = 1;

    public Tshape(Color color, GameBoard gameBoard){

        this.color = color;
        this.gameBoard = gameBoard;

        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(4, 1);
        fieldcoord[1] = new Field(5, 1);
        fieldcoord[2] = new Field(6, 1);
        fieldcoord[3] = new Field(5, 0);

    }

    public void transformShape(){//šipka top

        if (stav == 4){
            fieldcoord[0].x--;
            fieldcoord[0].y--;
            fieldcoord[2].x++;
            fieldcoord[2].y++;
            fieldcoord[3].x++;
            fieldcoord[3].y--;

            stav = 1;
        }if (stav == 1){
            fieldcoord[0].x++;
            fieldcoord[0].y++;


            stav = 2;
        }if (stav == 3){
            fieldcoord[3].x--;
            fieldcoord[3].y++;

            stav = 3;
        }if (stav == 3){
            fieldcoord[2].x--;
            fieldcoord[2].y--;

            stav = 4;
        }



    }

}
