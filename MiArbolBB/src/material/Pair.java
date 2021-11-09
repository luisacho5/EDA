/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material;

/**
 *
 * @author luiss
 */
public class Pair<E,F> {
    private E first;
    private F second;

    public Pair(E first, F second) {
        this.first = first;
        this.second = second;
    }
    
    public E getFirst() {
        return first;
    }

    public F getSecond() {
        return second;
    }

   
}
