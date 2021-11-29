
import java.util.Iterator;

import material.Position;
import material.tree.binarysearchtree.BinarySearchTree;

/**
 *
 * @author mayte
 */
public class ClosestInteger {

    /**
     * Recives a BinarySearchTree and an integer i and returns the Position that
     * contains the closest integer to i
     * 
     * @param tree
     * @param i
     * @return
     */
    public Position<Integer> closest(BinarySearchTree<Integer> tree, int i) {

        if ((tree == null) || (tree.isEmpty())) {
            throw new RuntimeException("ARBOL VACIO");
        }
        Position<Integer> encontrado = tree.find(i);
        if (encontrado != null) {
            return encontrado;
        }
        Iterator<Position<Integer>> it = tree.iterator();
        int dif= Integer.MAX_VALUE;
        while(it.hasNext()){
            Position<Integer> actual= it.next();
            int dif_aux= Math.abs(i-actual.getElement());
            if(dif_aux<dif){
                dif=dif_aux;
                encontrado=actual;
            }
        }
        return encontrado;
    }

}
