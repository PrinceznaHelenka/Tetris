package org.helenka;

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

    public boolean play(){

        if (tetromino.canIMove()){
            tetromino.move();
       }
       else{
            //kontroluju jestli je první kolo -- zvládl move
            //jestli ano -> endOfGame();

            if (tetromino.isFirstMove()){ //tetromino se ještě ani jednou nepohlo
                System.out.println("gameover");
                gui.paintGO();

                return false;
            }
            else{

                tetromino.die();
                checkIfCantBedeletedRow();
                gameBoard.generateTetromino();
                tetromino = gameBoard.getTetromino();

                //kontroluju, jestli není delete row
            }
        }
        gui.repaint();
        return true;
    }

    private void checkIfCantBedeletedRow() {
        int i;
      for (i = 0; i<20; i++){
          if (gameBoard.isRowFull(i)){
              gameBoard.deleteRow(i);
          }
      }

    }





    @Override
    public void run() {
        while (true){
            if (play()==false){break;}

            try {
                Thread.sleep(400);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
