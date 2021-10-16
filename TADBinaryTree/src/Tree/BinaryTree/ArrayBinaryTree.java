
package Tree.BinaryTree;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import material.Position;

/**
 *
 * @author mayte
 */
public class ArrayBinaryTree<E> implements BinaryTree<E> {

    private class ArrayBinaryTreeIterator<T> implements Iterator<Position<T>>{
        private Queue<Position<T>> elements;
        private ArrayBinaryTree<T> tree;
        
        public ArrayBinaryTreeIterator(ArrayBinaryTree<T> tree){
            this(tree, null);
        }
        
        public ArrayBinaryTreeIterator(ArrayBinaryTree<T> tree, BTPos<T> pos){
            this.tree = tree;
            elements = new LinkedList<>();
            if(pos == null){
                elements.add(tree.root());
            }else{
                elements.add(pos);
            }
        }
        
        @Override
        public boolean hasNext() {
            return !elements.isEmpty();
        }

        @Override
        public Position<T> next() {
            BTPos<T> current = (BTPos<T>) elements.poll();
            if(tree.hasRight(current)){
                elements.add(tree.right(current));
            }
            elements.add(current);
            if(tree.hasLeft(current)){
               elements.add(tree.left(current));
            }
            return elements.remove();
        }
    }

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

    private BTPos<E>[] resizeTree(int newsize) {
        BTPos<E>[] newTree = new BTPos[newsize];
        for(int i = 0; i < newsize; i++){
            if(i < maxsize) newTree[i] = tree[i];
            else newTree[i] = null;
        }
        maxsize = newsize;
        return newTree;
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
        BTPos<E> pos = checkPosition(p);
        if(isRoot(pos)){
            throw new RuntimeException("Invalid operation. There is no sibling");
        }
        BTPos<E> par = (BTPos<E>)parent(p);
        if(isLeft(par,pos)){
            return left(par);
        }
        else{
            return right(par);
        }
        
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
        BTPos<E> pos = checkPosition(p);
        if(hasLeft(p)) throw new RuntimeException("Invalid Operation. There is a left child");
        int rankChild = calculateLeft(pos);
        if(rankChild >= maxsize) resizeTree(rankChild+10);
        BTPos<E> newChild = new BTPos(e,rankChild);
        tree[rankChild] = newChild;
        return newChild;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTPos<E> pos = checkPosition(p);
        if(hasRight(p)) throw new RuntimeException("Invalid Operation. There is a left child");
        int rankChild = calculateRight(pos);
        if(rankChild >= maxsize) resizeTree(rankChild+10);
        BTPos<E> newChild = new BTPos(e,rankChild);
        tree[rankChild] = newChild;
        return newChild;
    }

    @Override
    public E remove(Position<E> p) {
        BTPos<E> pos = checkPosition(p);
        if(hasLeft(pos) && hasRight(pos)){
            throw new RuntimeException("Invalid Operation. Cannot remove node, there are 2 childs");
        }
        E oldValue = pos.getElement();
        if(isRoot(pos)){
            for(int i=0; i<maxsize;i++){
                tree[i]=null;
            }
        }
        else{
            for(Position<E> c: children(p)){
                BTPos<E> child = (BTPos<E>)c;
                remove(child);
            }
            tree[pos.getPos()] = null;
        }
        return oldValue;
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
        BTPos<E> pos1 = checkPosition(p1);
        BTPos<E> pos2 = checkPosition(p2);
        E aux = pos1.getElement();
        pos1.setElement(pos2.getElement());
        pos2.setElement(aux);
    }

    @Override
    public boolean isEmpty() {
        return root() == null;    
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTPos<E> pos = checkPosition(v);
        if(isRoot(v)) throw new RuntimeException("Invalid Operation. Root has no parent");
        BTPos<E> parent = null;
        for(BTPos<E> aux : tree){
            int rankL = calculateLeft(aux);
            int rankR = calculateRight(aux);
            if(rankL == pos.getPos() || rankR == pos.getPos()){
                parent = aux;
                break;
            }
        }
        return parent;    
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        BTPos<E> pos = checkPosition(v);
        List<Position<E>> children = new LinkedList<>();
        if(hasLeft(pos)) children.add(left(pos));
        if(hasRight(pos)) children.add(right(pos));
        return children;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new ArrayBinaryTreeIterator(this);    
    }

    @Override
    public void attachLeft(Position<E> h, BinaryTree<E> t1) {
        if(t1 == null || !(t1 instanceof ArrayBinaryTree)){
            throw new RuntimeException("Tree is not valid");
        }
        BTPos<E> pos = checkPosition(h);
        BTPos<E> newChild = checkPosition(t1.root());
        if(t1 == null) throw new RuntimeException("Invalid Operation. Tree is not valid.");
        if(hasLeft(pos)) throw new RuntimeException("Invalid Operation. There is a left child");
        int leftChildPos = calculateLeft(pos);
        tree[leftChildPos] = newChild;    
    }

    @Override
    public void attachRight(Position<E> h, BinaryTree<E> t1) {
        if(t1 == null || !(t1 instanceof ArrayBinaryTree)){
            throw new RuntimeException("Tree is not valid");
        }
        BTPos<E> pos = checkPosition(h);
        BTPos<E> newChild = checkPosition(t1.root());
        if(t1 == null) throw new RuntimeException("Invalid Operation. Tree is not valid.");
        if(hasRight(pos)) throw new RuntimeException("Invalid Operation. There is a left child");
        int rightChildPos = calculateRight(pos);
        tree[rightChildPos] = newChild;    
    }

    @Override
    public BinaryTree<E> subTree(Position<E> h) {
        BTPos<E> pos = checkPosition(h);
        if(isRoot(pos)) return this;
        ArrayBinaryTree<E> subTree = new ArrayBinaryTree<>(20);
        subTree.tree[0] = pos;
        subTree.tree[0].setPos(0);
        tree[pos.getPos()] = null;
        return subTree;
    }
    
    private boolean isLeft(Position<E> parent, Position<E> p){
        BTPos<E> parentPos = checkPosition(parent);
        BTPos<E> child = checkPosition(p);
        int rankChild = child.getPos();
        return (rankChild == calculateLeft(parentPos));
    }
    
    private boolean isRight(Position<E> parent, Position<E> p){
        BTPos<E> parentPos = checkPosition(parent);
        BTPos<E> child = checkPosition(p);
        int rankChild = child.getPos();
        return (rankChild == calculateRight(parentPos));
    }
    
}
