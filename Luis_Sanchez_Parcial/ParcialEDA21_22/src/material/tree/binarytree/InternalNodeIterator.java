package material.tree.binarytree;

import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import material.Position;

/**
 *
 * @author mayte
 * @param <T>
 */
public class InternalNodeIterator<T> implements Iterator<Position<T>> {

    private List<Position<T>> nodes = new LinkedList<>();
    private final BinaryTree<T> tree;
    
    public InternalNodeIterator (BinaryTree<T> tree){
       this.tree=tree;
       if(!tree.isEmpty()){
       Position<T> node;
        Iterator<Position<T>> it= tree.iterator();   
        while(it.hasNext()){
            node=it.next();
            if(tree.isInternal(node)){
                nodes.add(node);
            }
        }
       }      
    }
    
    
    @Override
    public boolean hasNext() {
       return(!nodes.isEmpty());
    }

    @Override
    public Position<T> next() {
       return nodes.remove(0);      
    }
    
}
