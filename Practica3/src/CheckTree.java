

import material.Position;
import material.tree.binarytree.BinaryTree;


/**
 *
 * @author mayte
 * @param <E>
 */

public class CheckTree<E extends Comparable> {
   
    /**
     * Receives a BinaryTree and returns true if the tree is a BinarySearchTree
     * @param tree     
     * @return      
    */
    public boolean isBinarySearchTree(BinaryTree<E> tree){
       
        if(!tree.isEmpty()){
            Position<E> p=tree.root();
            return comparaArbol(p,tree);
        }
        return true;
    }
    private boolean comparaArbol(Position<E> p, BinaryTree<E> tree) {
        boolean izq=true;
        boolean der=true;

        if(tree.hasLeft(p)){
            Position<E> left=tree.left(p);
            izq=(p.getElement().compareTo(left.getElement())>0) && comparaArbol(left,tree);
        }
        if(tree.hasRight(p)){
            Position<E> right=tree.right(p);
            der=(p.getElement().compareTo(right.getElement())<=0) && comparaArbol(right,tree);
        }
        return izq && der;
    }

}


