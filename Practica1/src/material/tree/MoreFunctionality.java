
package material.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import material.Position;
import material.tree.binarytree.BinaryTree;
import material.tree.narytree.NAryTree;

/**
 *
 * @author mayte
 * @param <T>
 */
public class MoreFunctionality<T> {
  
        
    /**
     * This method recives a NArytree and returns a List with the elements of the 
     * tree that can be seen if the tree is viewed from the left side.
     * @param tree
     * @return 
     */
    public List<T> leftView(NAryTree<T> tree){
       List<T> listfinal= new ArrayList<>();
       List<Integer> max= new ArrayList<>();
       max.add(0);
       leftaux(tree, listfinal, max, 1);
       return listfinal;
    }
    
    private void leftaux(NAryTree<T> root, List<T> lista,List<Integer> max, int nivel){
        if(root.isEmpty())return;
        
        if(max.get(0)<nivel)
        {
            lista.add(root.root().getElement());
            max.set(0,nivel);
        }
        
        Iterator<Position<T>> it =new BreadthFirstTreeIterator<>(root);
        Position<T> pos=it.next();
        while(it.hasNext()){
            pos=it.next();
            leftaux(root.subTree(pos), lista, max, nivel+1);
        }
    }

    
   /**
     * This method recives a NArytree and returns a List with the elements of the 
     * tree that can be seen if the tree is viewed from the right side.
     * @param tree
     * @return 
     */
    public List<T> rightView(NAryTree<T> tree){
       List<T> listfinal= new ArrayList<>();
       List<Integer> max= new ArrayList<>();
       max.add(0);
       rightaux(tree, listfinal, max, 1);
       return listfinal;
    
    }

    private void rightaux(NAryTree<T> root, List<T> lista, List<Integer> max, int nivel) {
       if(root.isEmpty())return;
       
       if(max.get(0)<nivel)
        {
            lista.add(root.root().getElement());
            max.set(0,nivel);
        }
       
       Stack<Position<T>> pila= new Stack();
       pila.add(root.root());
       Position<T> pos= pila.pop();
       for(Position<T> node: root.children(pos)){
           pila.add(node);
       }
       while(pila.size()!=0){
           pos=pila.pop();
           rightaux(root.subTree(pos), lista, max, nivel+1);
       }
    }
}
