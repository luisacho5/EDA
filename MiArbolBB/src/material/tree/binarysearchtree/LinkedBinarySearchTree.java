/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package material.tree.binarysearchtree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import material.Position;
import material.tree.binarytree.InorderBinaryTreeIterator;
import material.tree.binarytree.LinkedBinaryTree;

/**
 *
 * @author mayte
 * @param <E>
 */
public class LinkedBinarySearchTree<E> implements BinarySearchTree<E> {

    private LinkedBinaryTree<E> tree;
    private DefaultComparator  comparator;
    private int size;
    
     public LinkedBinarySearchTree(){
        tree = new LinkedBinaryTree<>();
        comparator = new DefaultComparator();
        size = 0;
    }
    public LinkedBinarySearchTree(E value){
        this();
        checkComparable(value);
        tree.addRoot(value);
        size++;
    }
    
    @Override
    public Position<E> find(E value) {
        checkComparable(value);
        Position<E> aux=tree.root();
        int i=0;
        while(aux!=null){
            int cmp = comparator.compare(value, aux.getElement());
            if(cmp==0)
                return aux;
            else if(cmp<0 && tree.hasLeft(aux)){
                aux=tree.left(aux);
            }
            else if(cmp>0 && tree.hasRight(aux)){
                aux=tree.right(aux);
            }
            else{
                aux=null;
            }
        }
        return null;
    }

    @Override
    public Iterable<? extends Position<E>> findAll(E value) {
        List<Position<E>> lista= new ArrayList<>();
        checkComparable(value);
        Position<E> aux=tree.root();
        int i=0;
        while(aux!=null){
            int cmp = comparator.compare(value, aux.getElement());
            if(cmp==0){
                lista.add(aux);
            }
            else if(cmp<0 && tree.hasLeft(aux)){
                aux=tree.left(aux);
            }
            else if(cmp>0 && tree.hasRight(aux)){
                aux=tree.right(aux);
            }
            else{
                aux=null;
            }
        }
        return lista;
    }

    @Override
    public Position<E> insert(E value) {
        checkComparable(value);
        Position<E> aux=tree.root();
        Position<E> auxParent= null;
        Position<E> newElement = null;
        
        if (tree.isEmpty()){
            newElement = tree.addRoot(value);
            return newElement;
        }
        
        while (aux != null) {
            int cmp = comparator.compare(value, aux.getElement());
            auxParent = aux;
            if (cmp < 0 && tree.hasLeft(aux)) {
                aux = tree.left(aux);
            } else if (cmp > 0 && tree.hasRight(aux)) {
                aux = tree.right(aux);
            }
        }

       int cmp = comparator.compare(value, auxParent.getElement());
            if(cmp < 0){
                newElement = tree.insertLeft(auxParent, value);
            }
            else{
                newElement = tree.insertRight(auxParent, value);
            }
        this.size++;
        return newElement;
    }

    @Override
    public boolean isEmpty() {
        return tree.isEmpty();
    }

    @Override
    public void remove(Position<E> pos) {
        checkPosition(pos);
        if(tree.isLeaf(pos)){
            tree.remove(pos);
        }
        else{
            tree.swap(pos, successor(pos));
            tree.remove(pos);
        }
        size--;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterable<? extends Position<E>> rangeIterator(E m, E n) {
        checkComparable(m);
        checkComparable(n);
        List<Position<E>> lista= new ArrayList<>();
        InorderBinaryTreeIterator it = new InorderBinaryTreeIterator(tree);
        
        if(tree.isEmpty()){
            throw new RuntimeException("Tree is empty");
        }
        
        Position<E> current = null;       
        while(it.hasNext()){
            current = it.next();
            int cmp = comparator.compare(m, current.getElement());   
            if(cmp >= 0){
                cmp = comparator.compare(n, current.getElement());
                if(cmp <= 0){
                    lista.add(current);
                }else{
                    // recorrido inorden, si el valor actual es mayor que n --> no hay mas valores posibles
                    return lista;
                }
            }
        }     
        return lista;
}

    @Override
    public Iterator<Position<E>> iterator() {
        return tree.iterator();
    }
    
    private void checkComparable(E value){
        if(!(value instanceof Comparable)) {
            throw new RuntimeException("Element is no comparable");
        }
    }

    private void checkPosition(Position<E> pos) {
        if(pos == null) {
            throw new RuntimeException("Position is not valid");
        }
        checkComparable(pos.getElement());
    }

    private Position<E> successor(Position<E> pos) {
        if(tree.hasRight(pos)){
            return minimum(pos);
        } 
        
        Position<E> parent = null;
        Position<E> current = pos;
        
        while(!tree.isRoot(current)){
            parent = tree.parent(pos);
            int cmp = comparator.compare(parent.getElement(), current.getElement());
            
            if(cmp < 0){// parent < current
                current = parent;
            }
            else { // parent >= 0
                return parent;
            }
        }
        return null; 
    }

    private Position<E> minimum(Position<E> pos) {
        Position<E> current = pos;
        while(current != null){
            if(tree.hasLeft(current)){
                current = tree.left(current);
            }
            else{
                return current;
            }
        }
        return null;
    }
    
}
