
package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import material.Position;

/**
 *
 * @author mayte
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {

    private BTPos<E> checkPosition(Position<E> p){
        if(p != null && p instanceof BTPos){
            return (BTPos<E>)p;
        }
        throw new RuntimeException("Position is not valid");
    }

    private int calculateLeft(BTPos<E> pos) {
        return 2 * pos.getPos()+ 1;
    }
    
    private int calculateRight(BTPos<E> pos){
         return 2 * pos.getPos()+2;
    }
    
    private class BTPos<E> implements Position<E>{

        private E element;
        private int pos;

        public BTPos(E element, int pos) {
            this.element = element;
            this.pos = pos;
        }

        public void setPos(int pos) {
            this.pos = pos;
        }
        
        public void setElement(E e){
            this.element=e;
        }
        
        public int getPos() {
            return pos;
        }
        @Override
        public E getElement() {
            return element;
        }
        
    }
    
    private BTPos<E>[] tree;
    private int maxsize;

    public ArrayBinaryTree(int maxsize) {
        tree = new BTPos[maxsize];
        for(int i = 0; i < 20; i++){
            tree[i] = null;
        }
        this.maxsize = maxsize;
    }
     
    @Override
    public Position<E> left(Position<E> v) {
        BTPos<E> pos= checkPosition(v);
        if(!hasLeft(pos))throw new RuntimeException("Doesnt have left children");
        int position=calculateLeft(pos);
        return tree[position];
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTPos<E> pos= checkPosition(v);
        if(!hasRight(pos))throw new RuntimeException("Doesnt have right children");
        int position=calculateRight(pos);
        return tree[position];
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTPos<E> pos= checkPosition(v);
        int position=calculateLeft(pos);
        return tree[position]!=null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTPos<E> pos= checkPosition(v);
        int position=calculateRight(pos);
        return tree[position]!=null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return hasLeft(v) || hasRight(v);
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTPos<E> pos= checkPosition(p);
        return pos==tree[0];
    }

    @Override
    public Position<E> root() {
        if(isEmpty()) throw new RuntimeException("Invalid operation. Tree is empty.");
        return tree[0];
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTPos<E> pos= checkPosition(p);
        E aux=pos.getElement();
        pos.setElement(e);
        return aux;
    }

    @Override
    public Position<E> sibling(Position<E> p) {
        BTPos<E> pos= checkPosition(p);
        if(isRoot(pos)){
            throw new RuntimeException("Invalid operation. There is no sibling");
        }
        return null;
        
    }

    @Override
    public Position<E> addRoot(E e) {
        if(this.root()!=null)
            throw new RuntimeException("Already has a root");
        BTPos<E> root= new BTPos<>(e,0);
        tree[0]=root;
        return root;
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E remove(Position<E> p) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> parent(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachLeft(Position<E> h, BinaryTree<E> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void attachRight(Position<E> h, BinaryTree<E> t1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public BinaryTree<E> subTree(Position<E> h) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
