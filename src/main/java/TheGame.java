package main.java;
import com.sun.rowset.internal.Row;

import java.awt.*;

public class TheGame implements Runnable {
    private GameBoard gameBoard;
    private Tetromino tetromino;
    private GUI gui;

    public static void main(String[] args) {
        (new Thread(new TheGame())).start();
    }

    public TheGame(){

        gameBoard = new GameBoard();
        gui = new GUI(gameBoard);
        gameBoard.generateTetromino();
        tetromino = gameBoard.getTetromino();
    }

    public void play(){

        if (tetromino.canIMove() == true){
            tetromino.move();
        }
        else{
            //kontroluju jestli je první kolo -- zvládl move
            //jestli ano -> endOfGame();
            if (tetromino.getY()>0){

            if (tetromino.move()!=1){ //tetromino se ještě ani jednou nepohlo
                //endOfGame
                //Frame.getFrames()
                System.out.println("gameover");
            }
            else{

                tetromino.die();
                CheckIfCantBedeletedRow();
                gameBoard.generateTetromino();
                tetromino = gameBoard.getTetromino();

                //kontroluju, jestli není delete row
            }}
        }
        gui.repaint();
    }

    private void CheckIfCantBedeletedRow(){
        int i;
        int occupied = 0;
        for (i = 0; i <= 9; i++){
           if(gameBoard.boardOfField[i][tetromino.getY()].isAvaiable() == false){ //pokud je plny
               occupied++;
           }
        }

        if (occupied == 10) {
            System.out.println("DELETE ROW");

            // deleteRow();

            for (int j = tetromino.getY(); j > 0; j--)
            {
                for (i = 0; i < 9; i++)
                {
                    gameBoard.boardOfField[i][j] = gameBoard.boardOfField[i][j - 1];

                }
            }

        }
    }




    @Override
    public void run() {
        while (true){
             play();
            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
