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
    private HashSet<HashSet<Integer>> card;

    public Card() {

        this.card = new HashSet<>();
        HashSet<Integer> aux = new HashSet<>();

        for (int i = 0; i < 3; i++) {
            card.add(new HashSet<Integer>());
        }

        for (HashSet<Integer> line: card) {
            for (int j = 0; j < 5; j++) {
                int valorDado = 0;
                while (!aux.add(valorDado) || valorDado == 0) {
                    Random r = new Random();
                    valorDado = r.nextInt(91);
                }
                line.add(valorDado);
            }
        }
    }

    public boolean hasLine() {
        for (HashSet<Integer> line: card) {
            if (line.isEmpty()) {
                return true;
            }
        }
        return false;
    }

    public boolean hasBingo() {
        boolean bingo = true;
        for(HashSet<Integer> line: card){
            bingo &= line.size()==0;
        }
        return bingo;
    }

    public void removeNumber(int number) {
        for (HashSet<Integer> line: card) {
            line.remove(number);
        }
    }

}
