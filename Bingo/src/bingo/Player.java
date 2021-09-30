/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import utils.NumberGetter;

/**
 *
 * @author Luis.Sanchez
 */
class Player {

    private Card [] cards;
    public Player() {
        NumberGetter n = new NumberGetter();
        int numCards = n.getNumber("Number of cards:");
        cards = new Card[numCards];
        for (int i = 0; i < numCards; i++) {
            cards[i] = new Card();
            
        }
    }

    void removeNumber(int number) {
        for(Card carton:cards){
            carton.removeNumber(number);
        }
    }

    boolean hasLine() {
        boolean hasLine= false;
        for(Card carton:cards){
            hasLine= carton.hasLine() || hasLine;
        }
        return hasLine;
    }

    boolean hasBingo() {
        boolean hasBingo= false;
        for(Card carton:cards){
            hasBingo= carton.hasBingo() || hasBingo;
        }
        return hasBingo;
    }
    
}
