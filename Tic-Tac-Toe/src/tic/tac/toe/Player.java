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
public class Player {

    boolean[] check = new boolean[9];

    public Player() {
        for (int i = 0; i < 9; i++) {
            check[i] = false;
        }

    }

    public void place(int place) {
        check[place] = true;
    }

    public boolean check() {
        boolean vertCheck = check[0] && check[3] && check[6] || check[1] && check[4] && check[7] || check[2] && check[5] && check[8];
        boolean horzCheck = check[0] && check[1] && check[2] || check[3] && check[4] && check[5] || check[6] && check[7] && check[8];
        boolean diagCheck = check[6] && check[4] && check[2] || check[0] && check[4] && check[8];
        return !(vertCheck || horzCheck || diagCheck);
    }

    public void restart() {
        for (int i = 0; i < 9; i++) {
            check[i] = false;
        }
    }
}
