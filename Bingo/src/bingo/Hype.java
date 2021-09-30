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
class Hype {

    private HashSet<Integer> bombo;
    private final int tope=90;

    public Hype() {
        this.bombo= new HashSet<>();
        bombo.add(0);//numeros del 1 al 90 metemos 0 para evitar que salga
    }

    boolean hasNumbers() {
            return bombo.size()-1<tope;
    }

    int getNumber() {
        int valorDado=0;//nunca va a entrar con el 0
        while (!bombo.add(valorDado) ) {
            Random r = new Random();
            valorDado = r.nextInt(91);
        }
        return valorDado;
    }
    
}
