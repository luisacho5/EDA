package material.tree.binarytree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author mayte
 * @param <T>
 */
public class MoreFunctionality<T> {

    /**
     * Check if a BinaryTree is perfect. 
     * A BinaryTree is perfect if all its internal nodes have left chlid and right child.
     * @param t
     * @return 
     */
    public boolean isPerfect(BinaryTree<T> t){
        if(t.isEmpty()){return true;}
        Position<T> node;
        boolean aux=true;
        Iterator<Position<T>> it= t.iterator();   
        
        while(aux==true & it.hasNext()){
            node=it.next();
            if(t.isInternal(node)||t.isRoot(node)){
                aux=t.hasLeft(node)&&t.hasRight(node);
            }
        }
        return aux;
    }
    
    
}
