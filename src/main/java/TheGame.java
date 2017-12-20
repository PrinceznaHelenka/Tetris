package main.java;

import java.awt.*;
import java.util.Timer;

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

            if (tetromino.move()!=1){ //tetromino se ještě ani jednou nepohlo
                //endOfGame
                //Frame.getFrames()
                System.out.println("gameover");
            }
            else{

                tetromino.die();
                deleteRow();
                gameBoard.generateTetromino();
                tetromino = gameBoard.getTetromino();

                //kontroluju, jestli není delete row
            }



        }

        gui.repaint();

    }

    private void deleteRow(){
        int i = 0;
        int pocetPlnychPoli = 0;
        for (i = 0; i <= 9; i++){
           if(gameBoard.boardOfField[i][tetromino.getY()].isAvaiable() == false){ //pokud je plny
               System.out.println("plny");
               pocetPlnychPoli++;
           }
           else{
               System.out.println("dira");
           }

        }

        if (pocetPlnychPoli == 10) {
            System.out.println("DELETE ROW");

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
