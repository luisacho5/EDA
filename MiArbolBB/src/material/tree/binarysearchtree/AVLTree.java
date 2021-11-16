package material.tree.binarysearchtree;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author mayte
 */
public class AVLTree<E> implements BinarySearchTree<E> {
    
    private BinarySearchTree<E> tree= new LinkedBinarySearchTree<>();
    
    //Esta clase es necesaria para guardar el valor de la altura AVL en los nodos BTNodes
    private class AVLInfo<T> implements Comparable<AVLInfo<T>>, Position<T> {

        public void setTreePosition(Position<AVLInfo<T>> pos) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public Position<AVLInfo<T>> getTreePosition() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public void setHeight(int height) {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        public int getHeight() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public T getElement() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public int compareTo(AVLInfo<T> o) {
          throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public String toString() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public boolean equals(Object obj) {
           throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

    }

    @Override
    public Position<E> find(E value) {
        return tree.find(value);
    }

    @Override
    public Iterable<? extends Position<E>> findAll(E value) {
        return this.findAll(value);
    }

    @Override
    public Position<E> insert(E value) {
       Position<E> p= this.insert(value);
       return null;
    }
    
    private Position<E> desequilibrio(Position<E> p){
        if(!tree.isRoot(p)){
            Position<E> parent=tree.parent(p);      
        }
        
    }

    @Override
    public boolean isEmpty() {
       return tree.isEmpty();
    }

    @Override
    public void remove(Position<E> pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int size() {
       return tree.size();
    }

    @Override
    public Iterable<? extends Position<E>> rangeIterator(E m, E M) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
