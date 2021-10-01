/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bingo;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Luis.Sanchez
 */
class Hype {
    
    private final static int NUMBERS = 90;
    private final List<Integer> bombo= new LinkedList();

    public Hype() {
        for(int i=1;i<=NUMBERS; i++)
            bombo.add(i);
        Collections.shuffle(bombo);
    }

    boolean hasNumbers() {
        return !bombo.isEmpty();
    }

    int getNumber() {
        return bombo.remove(0);
    }
    
}
