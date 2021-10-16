package material.tree;

import java.util.Deque;
import material.Position;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

/**
 *
 * @author jvelez
 * @param <T>
 */
public class PosOrderTreeIterator<T> implements Iterator<Position<T>> {

    private Stack<Position<T>> stack= new Stack<>();
    private Tree<T> tree;
       
   

    public PosOrderTreeIterator(Tree<T> t, Position<T> root) {
        tree=t;
        Deque<Position<T>> aux = new LinkedList();
        
        if(root==null){
            aux.add(root);
        }else{
            aux.add(tree.root());
        }
        
        while(!aux.isEmpty()){
            Position<T> current=aux.pop();
            for(Position<T> child: tree.children(current))
                aux.push(child);
            stack.push(current);
        }
    }
    
    public PosOrderTreeIterator(Tree<T> t) {
        this(t,t.root());
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    /**
     * This method visits the nodes of a tree by following a pos-order
     */
    @Override
    public Position<T> next() {
       return stack.pop();
    }

}
