package examen2020;

import java.util.Iterator;
import material.tree.PosOrderTreeIterator;
import material.tree.PreOrderTreeIterator;
import material.tree.binarytree.BinaryTree;
import material.tree.binarytree.InorderBinaryTreeIterator;
import material.tree.narytree.LinkedTree;
import material.tree.narytree.NAryTree;
import material.Position;
/**
 *
 * @author jvelez
 */
public class TreeUtil {
    
    
    /**
     * 
     * @param <T> The type of the elements in the binary tree
     * @param btree The tree to be copied
     * @return a copy of the BinaryTree btree in an NAryTree
     */
    public static <T> NAryTree <T> generate(BinaryTree <T> btree) {
        NAryTree<T> aux= new LinkedTree();
        Position<T> node=aux.addRoot(btree.root().getElement());
        copiarArbol(aux,btree.root(),btree,node);
        return aux;
    }

    private static <T> void copiarArbol(NAryTree<T> aux, Position<T> root, BinaryTree<T> btree, Position<T> node) {
       for(Position<T> hijo: btree.children(root)){
           Position<T> nhijo= aux.add(hijo.getElement(),node);
           copiarArbol(aux, hijo, btree, nhijo);
       }
    }
}
