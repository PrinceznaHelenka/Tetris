package main.java;

import java.awt.*;

public interface Tetromino {

        Field[] getFieldCoord();
        int move();
        boolean isFirstMove();
        void moveRight();
        void moveLeft();
        void moveDownDown();
        void transformShape();
        boolean canIMove();
        void die();
        Color getColorOfTetromino();
}
