
package material.tree.binarytree;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import material.Position;

/**
 *
 * @author mayte
 * @param <T>
 */
public class LinkedBinaryTree<E> implements BinaryTree<E>{

    private BTNode<E> checkPosition(Position<E> p){
        if(p != null && p instanceof BTNode){
            return (BTNode<E>)p;
        }
        throw new RuntimeException("Position is not valid");
    }

     private class LinkedBinaryTreeIterator<T> implements Iterator<Position<T>>{
        private BTNode<T> current;
        private LinkedBinaryTree<T> tree;
        
        public LinkedBinaryTreeIterator(LinkedBinaryTree<T> lt){
            this(lt, null);
        }
        
        public LinkedBinaryTreeIterator(LinkedBinaryTree<T> lt, BTNode<T> node){
            if(lt == null)
                throw new RuntimeException("Invalid tree. Tree is null");
            tree = lt;
            BTNode<T> aux;
            if(node == null){
                aux = (BTNode<T>) lt.root();
            }
            else{
                aux = node;
            }
            while(tree.hasLeft(aux)){
                aux = aux.getLeft();
            }
            
            current = aux;
        }
        
        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Position<T> next() {
            BTNode<T> aux = current;
            if(tree.hasRight(current)){
                current = aux.getRight();
            }
            else if(tree.isRoot(current)){
                current = null;
            }
            else{
                BTNode<T> parent = (BTNode) tree.parent(current);
                if(parent.isLeftChild(aux)) current = parent;
                else{
                    if(!tree.isRoot(parent)){
                        current = parent.getParent();
                    }
                    else{
                        current = null;
                    }
                }
            }
            return aux;
        }
    }

    private class BTNode<V> implements Position<V>{
    
        private V element;
        private BTNode<V> parent;
        private BTNode<V> left;
        private BTNode<V> right;

        public BTNode(V element, BTNode<V> parent, BTNode<V> left, BTNode<V> right) {
            this.element = element;
            this.parent = parent;
            this.left = left;
            this.right = right;
        }

        @Override
        public V getElement() {
            return element;
        }

        public void setElement(V element) {
            this.element = element;
        }

        public BTNode<V> getParent() {
            return parent;
        }

        public void setParent(BTNode<V> parent) {
            this.parent = parent;
        }

        public BTNode<V> getLeft() {
            return left;
        }

        public void setLeft(BTNode<V> left) {
            this.left = left;
        }

        public BTNode<V> getRight() {
            return right;
        }

        public void setRight(BTNode<V> right) {
            this.right = right;
        }
        
        private boolean isLeftChild(BTNode<V> child){
            return left == child;
        }
    }
    
    private BTNode<E> root;
    
    @Override
    public Position<E> left(Position<E> v) {
        BTNode<E> node =checkPosition(v);
        if(node.getLeft()== null)
            throw new RuntimeException("No Left child of this node");
        return node.getLeft();
    }

    @Override
    public Position<E> right(Position<E> v) {
        BTNode<E> node =checkPosition(v);
        if(node.getRight()== null)
            throw new RuntimeException("No Right child of this node");
        return node.getRight();
    }

    @Override
    public boolean hasLeft(Position<E> v) {
        BTNode<E> node =checkPosition(v);
        return node.getLeft()!= null;
    }

    @Override
    public boolean hasRight(Position<E> v) {
        BTNode<E> node =checkPosition(v);
        return node.getRight()!= null;
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return (this.hasLeft(v) || this.hasRight(v));
    }

    @Override
    public boolean isLeaf(Position<E> p) {
        return !isInternal(p);
    }

    @Override
    public boolean isRoot(Position<E> p) {
        BTNode<E> node =checkPosition(p);
        return node.getParent()== null;
    }

    @Override
    public Position<E> root() {
        return this.root;
    }

    @Override
    public E replace(Position<E> p, E e) {
        BTNode<E> node =checkPosition(p);
        E old=node.getElement();
        node.setElement(e);
        return old;
    }
    
    private boolean isRightSon(BTNode<E> parent,BTNode<E> child){
        return parent.getRight() == child;
    }
    
    private boolean isLeftSon(BTNode<E> parent,BTNode<E> child){
        return parent.getLeft() == child;
    }
    
    @Override
    public Position<E> sibling(Position<E> p) {
        BTNode<E> node =checkPosition(p);
        if(isRoot(p))
            throw new RuntimeException("This node has no siblings");
        if (hasLeft(node.getParent()) && hasRight(node.getParent()))
           if(left(node.getParent())==node)
               return right(node.getParent());
           else
               return left(node.getParent());
        else
            throw new RuntimeException("This node has no siblings");
    }

    @Override
    public Position<E> addRoot(E e) {
        if(this.root!=null)
            throw new RuntimeException("The tree has already a root");
        root= new BTNode<>(e,null,null,null);
        return root;
    }

    @Override
    public Position<E> insertLeft(Position<E> p, E e) {
       BTNode<E> node =checkPosition(p);
       if(hasLeft(p))
           throw new RuntimeException("The tree has already a Left children");
       BTNode<E> newNode = new BTNode<>(e,node,null,null);
       node.setLeft(newNode);
       return newNode;
    }

    @Override
    public Position<E> insertRight(Position<E> p, E e) {
        BTNode<E> node =checkPosition(p);
       if(hasRight(p))
           throw new RuntimeException("The tree has already a Right children");
       BTNode<E> newNode = new BTNode<>(e,node,null,null);
       node.setRight(newNode);
       return newNode;
        
    }

    @Override
    public E remove(Position<E> p) {
        BTNode<E> node =checkPosition(p);
        if(isRoot(p))
            root=null;
        else{
            if(isRightSon(node.getParent(), node))
                node.getParent().setRight(null);
            else 
                node.getParent().setLeft(null);
        }
        return node.getElement();
    }

    @Override
    public void swap(Position<E> p1, Position<E> p2) {
       BTNode<E> node =checkPosition(p1);
       BTNode<E> node2 =checkPosition(p2);
       E element= node.getElement();
       node.setElement(node2.getElement());
       node2.setElement(element);
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        BTNode<E> node =checkPosition(v);
        if(isRoot(v)) 
            throw new RuntimeException("Is a root");
        return node.getParent();
    
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        BTNode<E> node = checkPosition(v);
        List<Position<E>> children = new LinkedList<>();
        if(hasLeft(node)) children.add(node.getLeft());
        if(hasRight(node)) children.add(node.getRight());
        return children;
    }

    @Override
    public Iterator<Position<E>> iterator() {
        return new LinkedBinaryTreeIterator(this);
    }

    public LinkedBinaryTree<E> subTree(Position<E> h) {
         BTNode<E> node = checkPosition(h);
        if(isRoot(node)) return this;
        
        LinkedBinaryTree<E> subTree = new LinkedBinaryTree<>();
        BTNode<E> parent = (BTNode<E>)parent(node);
        if(isLeftSon(parent, node)) parent.setLeft(null);
        else parent.setRight(null);
        
        node.setParent(null);
        subTree.root = node;
        return subTree; 
    }
   
    
    @Override
    public void attachLeft(Position<E> h, BinaryTree<E> t1) {
        BTNode<E> node =checkPosition(h);
        BTNode<E> root2 =(BTNode<E>) t1.root();
        if(hasLeft(h))
            throw new RuntimeException();
        if(!t1.isEmpty()){
            node.setLeft(root2);
            root2.setParent(node);
            t1.remove(t1.root());
        }
    
    }

    @Override
    public void attachRight(Position<E> h,BinaryTree<E> t1) {
         BTNode<E> node =checkPosition(h);
         BTNode<E> root2 =(BTNode<E>) t1.root();
        if(hasRight(h))
            throw new RuntimeException();
        if(!t1.isEmpty()){
            node.setRight(root2);
            root2.setParent(node);
            t1.remove(t1.root());
        }
    }
}
