/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.HashSet;
import java.util.Random;

/**
 *
 * @author Luis.Sanchez
 */
class Card {
    private HashSet<Integer>[] card;

    public Card() {

        this.card = new HashSet[3];
        HashSet<Integer> aux = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            card[i] = new HashSet<>();
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 5; j++) {
                int valorDado = 0;
                while (!aux.add(valorDado) || valorDado == 0) {
                    Random r = new Random();
                    valorDado = r.nextInt(91);
                }
                card[i].add(valorDado);
            }
        }
    }

    public boolean hasLine() {
        for (int i = 0; i < 3; i++) {
            if (card[i].isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBingo() {
        boolean bingo = true;
        int aux = 0;
        while (bingo && aux < 3) {
            bingo = card[aux].isEmpty();
            aux++;
        }
        return bingo;
    }

    public void removeNumber(int number) {
        for (int i = 0; i < 3; i++) {
            card[i].remove(number);
        }
    }

}
