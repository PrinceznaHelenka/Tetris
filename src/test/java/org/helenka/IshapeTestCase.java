package org.helenka;

import org.junit.Assert;
import org.junit.Test;

import java.awt.*;


public class IshapeTestCase {

    /*

    Test zda je nově vygenerované tetromino vygenerované na očekávaném místě
    a po pohnutí dolů, jestli spadlo kam mělo

    */
    @Test
    public void movetest() {
        GameBoard gameBoard;
        Tetromino tetromino;

        gameBoard = new GameBoard();
        gameBoard.generateTetromino();
        tetromino = new Ishape(Color.orange, gameBoard);

        Assert.assertEquals( 0, tetromino.getFieldCoord()[0].y);

        tetromino.move();
        Assert.assertEquals( 1, tetromino.getFieldCoord()[0].y);

    }

}