package main.java;
import java.awt.*;


public class Zshape extends main.java.Shape implements Tetromino{

private boolean stav = true;


public Zshape(Color color, GameBoard gameBoard){
        this.color = color;
        this.gameBoard = gameBoard;

        fieldcoord = new Field[4];

        fieldcoord[0] = new Field(5, 0);
        fieldcoord[1] = new Field(6, 0);
        fieldcoord[2] = new Field(6, 1);
        fieldcoord[3] = new Field(7, 1);

        }


public void transformShape(){//šipka top
    if (stav == true){
        fieldcoord[0].y = fieldcoord[0].y + 2;
        fieldcoord[3].x = fieldcoord[3].x - 2;

        stav = false;
    }

    else {

        fieldcoord[0].y = fieldcoord[0].y - 2;
        fieldcoord[3].x = fieldcoord[3].x + 2;
        stav = true;
    }

}

}
