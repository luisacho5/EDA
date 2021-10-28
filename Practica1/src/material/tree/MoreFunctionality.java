
package material.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
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
       Deque<Position<T>> aux = new LinkedList<>();
        aux.push(tree.root());
        listfinal.add(tree.root().getElement());
        while(!aux.isEmpty()){
        Position<T> nodoaux = aux.pop();
            List<Position<T>> childrenList = new LinkedList<>();
            List<Position<T>> childrenList2 = new LinkedList<>();
            for (Position<T> child: tree.children(nodoaux)) {
                childrenList.add(child);
                for (Position<T> child2: childrenList) {
                    childrenList2.add(child2);
                }
                listfinal.add(childrenList2.get(0).getElement());
            }
            
            Collections.reverse(childrenList);
            for(Position<T> child: childrenList){
                aux.push(child);
            }
            
        }
        return listfinal;
    }
   /**
     * This method recives a NArytree and returns a List with the elements of the 
     * tree that can be seen if the tree is viewed from the right side.
     * @param tree
     * @return 
     */
    public List<T> rightView(NAryTree<T> tree){
        
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    }
}
