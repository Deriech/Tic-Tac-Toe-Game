/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tic.tac.toe;

/**
 *
 * @author derie
 */
public class TicTacToe {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        int oneWins = 0;// number of player one wins
        int twoWins = 0;// number of player two wins
        int draws = 0;
        boolean whoseTurn = true;// determines whose turn it is
        boolean inProgress = true;// determines if the game continues
        boolean playAgain = true;// dedtermines if a second game is played
        boolean choosing = true;
        int drawTimer = 0;
        String choice;// the space the player chooses to put their piece
        int choiceInt;
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        while (playAgain) {
            Stage.StartGame();// makes placeholders for tic-tac-toe spaces
            Stage.MakeStage();//makes the tic-tac-toe board
            System.out.println("P1: " + oneWins + " | " + "P2: " + twoWins + " | " + "Draws: " + draws);// displays current score

            while (inProgress && drawTimer < 9) {
                if (whoseTurn) {
                    System.out.print("Player 1, ");
                } else {
                    System.out.print("Player 2, ");
                }
                System.out.print("Choose a spot > ");
                do {
                    choice = keyboard.next();

                    try {
                        choiceInt = Integer.parseInt(choice);
                        if (!(choiceInt >= 1 && choiceInt <= 9)) {
                            System.out.println("Not a valid input. Try Again");
                            choosing = true;
                        }
                        else{
                        choosing = false;
                        }
                    } catch (java.lang.NumberFormatException ex) {
                        System.out.println("Not a valid input. Try Again");
                        choosing = true;
                    }
                } while (choosing);
                Stage.MarkStage(choice, whoseTurn);
                Stage.MakeStage();
                inProgress = Stage.CheckWin(whoseTurn);
                whoseTurn = !(whoseTurn);
                drawTimer++;
            }
            if (drawTimer == 9) {
                System.out.println("It's a draw!");
                draws++;
            } else {
                if (whoseTurn) {
                    System.out.print("Player 2 ");
                    twoWins++;
                    whoseTurn = false;
                } else {
                    System.out.print("Player 1 ");
                    oneWins++;
                    whoseTurn = true;
                }
                System.out.println("wins!");
            }
            inProgress = true;
            Stage.RestartStage();
            drawTimer = 0;
               playAgain = Stage.playAgain();

        }

    }
}
