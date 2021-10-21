
package material.tree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;
import material.Position;

/**
 *
 * @author mayte
 * @param <T>
 */
public class LeafIterator<T> implements Iterator<Position<T>>  {
    
    private Tree<T> tree;
    private Deque<Position<T>> queue= new LinkedList<>();

    public LeafIterator(Tree<T> tree, Position<T> root){
        this.tree=tree;
        Deque<Position<T>> aux = new LinkedList<>();
        aux.push(root);
        
        while(!aux.isEmpty()){
        Position<T> nodoaux = aux.pop();
        List<Position<T>> childrenList = new LinkedList<>();
            for (Position<T> child: tree.children(nodoaux)) {
                childrenList.add(child);
            }
            Collections.reverse(childrenList);
            for(Position<T> child: childrenList){
                aux.push(child);
            }
            
            if(tree.isLeaf(nodoaux)){
            queue.add(nodoaux);
            }
        }
    }
    
    public LeafIterator(Tree<T> tree){
        this(tree,tree.root());
    }
    
    @Override
    public boolean hasNext() {
       return !queue.isEmpty();
    }

    /**
     * This method only visits the leaf nodes 
     */
    @Override
    public Position<T> next() {
        return queue.pollFirst();
    }

    
    
}
