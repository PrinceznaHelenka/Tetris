package org.helenka;

import java.awt.*;

public class Sshape extends Shape implements Tetromino{

    private boolean stav = true;


    public Sshape(Color color, GameBoard gameBoard){
        this.color = color;
        this.gameBoard = gameBoard;

        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(4, 1);
        fieldcoord[1] = new Field(5, 1);
        fieldcoord[2] = new Field(5, 0);
        fieldcoord[3] = new Field(6, 0);

    }


    public void transformShape(){//šipka top

        if (stav == true){
            fieldcoord[0].x++;
            fieldcoord[1].y--;
            fieldcoord[2].x--;
            fieldcoord[3].y--;
            fieldcoord[3].x = fieldcoord[3].x - 2;

            stav = false;
        }

        else {

            fieldcoord[0].x--;
            fieldcoord[1].y++;
            fieldcoord[2].x++;
            fieldcoord[3].y++;
            fieldcoord[3].x = fieldcoord[3].x + 2;
            stav = true;
        }

    }


}
