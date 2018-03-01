package org.helenka;

import java.awt.*;

public class Oshape extends Shape implements Tetromino{

    public Oshape(Color color, GameBoard gameBoard){
        this.color = color;
        this.gameBoard = gameBoard;

        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(6, 1);
        fieldcoord[1] = new Field(5, 1);
        fieldcoord[2] = new Field(5, 0);
        fieldcoord[3] = new Field(6, 0);

    }


    public void transformShape(){//šipka top
        fieldcoord[0].x = fieldcoord[0].x;
}

}
