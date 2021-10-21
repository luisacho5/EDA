
package material.tree;

import java.util.Collections;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import material.Position;

/**
 *
 * @author jvelez
 * @param <T>
 */
public class BreadthFirstTreeIterator<T> implements Iterator<Position<T>> {

    private Tree<T> tree;
    private List<Position<T>> list= new LinkedList<>();
        
    public BreadthFirstTreeIterator(Tree<T> tree, Position<T> root) {
        
        this.tree=tree;
        Deque<Position<T>> aux = new LinkedList<>();
        list.add(root);
    }
    public BreadthFirstTreeIterator(Tree<T> tree) {
       this(tree,tree.root());
    }
    
    @Override
    public boolean hasNext() {
        return ! list.isEmpty();
    }

    /**
     * This method visits the nodes of a tree by following a breath-first order
     */
    @Override
    public Position<T> next() {
        Position<T> current=list.remove(0);
        for(Position<T> children:tree.children(current)){
            list.add(children);
        }
        return current;
    }

   
}
