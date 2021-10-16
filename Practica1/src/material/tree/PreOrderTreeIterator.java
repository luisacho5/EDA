
package material.tree;

import java.util.Collections;
import material.Position;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

/**
 *
 * @author jvelez
 * @param <T>
 */
public class PreOrderTreeIterator<T> implements Iterator<Position<T>> {

    

    private Tree<T> tree;
    private Stack<Position<T>> stack= new Stack<>();
    
    public PreOrderTreeIterator(Tree<T> t) {
        tree=t;
        if(!tree.isEmpty())
         stack.push(tree.root());
        
    }
    
    public PreOrderTreeIterator(Tree<T> t, Position<T> p) {
        tree=t;
        stack.push(p);
    }
    
    

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Position<T> next() {
        Position<T> node = stack.pop();      
        List<Position<T>> aux = new LinkedList<>();
        for (Position<T> child : tree.children(node)) {
            aux.add(child);
        }
        Collections.reverse(aux);
        // añadir
        for (Position<T> child : aux) {
            stack.push(child);
        }
         return node; 
    }

}
