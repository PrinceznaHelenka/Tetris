package org.helenka;


import org.junit.Assert;
import org.junit.Test;

import java.awt.*;

public class LshapeTest {
    @Test
    public void transformShape() {
        GameBoard gameBoard;
        Tetromino tetromino;

        gameBoard = new GameBoard();
        gameBoard.generateTetromino();
        tetromino = new Lshape(Color.orange, gameBoard);

        Assert.assertEquals( 1, tetromino.getFieldCoord()[0].y);

        tetromino.move();
        Assert.assertEquals( 2, tetromino.getFieldCoord()[0].y);

    }

}