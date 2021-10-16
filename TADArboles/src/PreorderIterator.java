
import java.util.Iterator;
import java.util.Stack;
import material.Position;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luiss
 */
public class PreorderIterator<T> implements Iterator<Position<T>>  {

    private Tree<T> tree;
    private Stack<Position<T>> stack= new Stack<>();
    
    public PreorderIterator(Tree<T> t) {
        tree=t;
        if(!tree.isEmpty())
         stack.push(tree.root());
        
    }
    
    public PreorderIterator(Tree<T> t, Position<T> p) {
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
        Iterable<? extends Position<T>> children = tree.children(node);
        for (Position<T> position:children) {
            stack.push(position);
        }
       return node; 
    }
    
}
