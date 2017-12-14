package main.java;

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
                gui = null;
                //gui.remove(gui);
            }

            tetromino.die();
            gameBoard.generateTetromino();
            tetromino = gameBoard.getTetromino();

            //kontroluju, jestli není delete row

        }

        System.out.println("Hraješ Helenčin Tetris ;)!");
        gui.repaint();

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
