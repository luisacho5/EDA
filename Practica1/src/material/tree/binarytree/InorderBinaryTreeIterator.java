
package material.tree.binarytree;

import java.util.Iterator;
import java.util.Stack;
import material.Position;

/**
 *
 * @author jvelez
 * @param <T>
 */
public class InorderBinaryTreeIterator<T> implements Iterator<Position<T>> {

    private BinaryTree<T> t;   
    private Position<T> current;
    
    public InorderBinaryTreeIterator(BinaryTree <T> tree) {
        this(tree,tree.root());
    }

    public InorderBinaryTreeIterator(BinaryTree <T> tree, Position<T> node) {
        t=tree;
        Position<T> aux = null;
        if(node!=null)
            aux=node;
        else
           aux=t.root();
        
        while(t.hasLeft(aux)){
            aux=t.left(aux);
        }
        current=aux;
    }

         
    @Override
    public boolean hasNext() {
        return current!=null;
    }

    /**
     * This method visits the nodes of a binary tree first left-child, then the node and at last right-child
     */
    @Override
    public Position<T> next() {
        Position<T> aux = current;
        Position<T> next = null;
        if(t.hasRight(aux)){
            next=t.right(aux);
            while(t.hasLeft(next)){
                next=t.left(next);
            }
            current=next;
        }else if(t.isRoot(aux)){
            current=null;
        }
        else{
            Position<T> parent = t.parent(aux);
            if(t.left(parent)==aux)
                current=parent;
            else{
                next=parent;
                current=null;
                while(!t.isRoot(next)){
                    Position<T> ancestor = t.parent(next);
                    if(t.left(ancestor)==next){
                        current= ancestor;
                        break;
                    }
                    next=ancestor;
                }
            }
        }
        return aux;
    }

    
}
