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
public class Stage {

    private static final Player PLAYER_1 = new Player();
    private static final Player PLAYER_2 = new Player();
    private static final String[] PLACE = new String[9];

    public static void StartGame() {
        for (int i = 0; i < 9; i++) {
            PLACE[i] = Integer.toString(i + 1);

        }
    }

    public static void MakeStage() {
        System.out.println(PLACE[6] + "|" + PLACE[7] + "|" + PLACE[8]);
        System.out.println("-----");
        System.out.println(PLACE[3] + "|" + PLACE[4] + "|" + PLACE[5]);
        System.out.println("-----");
        System.out.println(PLACE[0] + "|" + PLACE[1] + "|" + PLACE[2]);
    }

    public static void MarkStage(String choice, boolean firstTurn) {
        for (int i = 0; i < 9; i++) {
            if (choice.equals(PLACE[i])) {
                if (firstTurn) {
                    PLACE[i] = "X";
                    PLAYER_1.place(i);
                } else {
                    PLACE[i] = "O";
                    PLAYER_2.place(i);
                }
            }
        }
    }

    public static void RestartStage() {
        PLAYER_1.restart();
        PLAYER_2.restart();
    }

    public static boolean CheckWin(boolean firstTurn) {
        boolean condition;
        if (firstTurn) {
            condition = PLAYER_1.check();
        } else {
            condition = PLAYER_2.check();
        }
        return condition;
    }
    public static boolean playAgain(){
        java.util.Scanner keyboard = new java.util.Scanner(System.in);
        boolean playAgain = false, choosing;
                do {
                    
                System.out.println(" play Again? Y/N");
                String choice = keyboard.next();
                if (choice.equalsIgnoreCase("y")) {
                    playAgain = true;
                    choosing = false;

                } else if (choice.equalsIgnoreCase("n")) {
                    playAgain = false;
                    choosing = false;
                } else {
                    System.out.println("That's not a valid answer");
                    choosing = true;
                }
            } while (choosing);
                return playAgain;
    }
}
