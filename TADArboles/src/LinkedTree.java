import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.management.RuntimeErrorException;

import material.Position;

/**
 *
 * @author Luis Sánchez
 * @param <E>
 */
public class LinkedTree<E> implements NAryTree<E> {

    private TreeNode<E> checkPosition(Position<E> p) {
        if(p!=null && p instanceof TreeNode)
            return (TreeNode<E>)p;
        else throw new RuntimeException("Nota valid node");
    }

    private class TreeNode<T> implements Position<T>{

        private T element;
        private TreeNode<T> parent;
        private List<TreeNode<T>> children;

        public TreeNode() {
        }

        public TreeNode(T element, TreeNode<T> parent) {
            this.element = element;
            this.parent = parent;
            this.children=null;
        }

        @Override
        public T getElement() {
            return element;
        }

        public void setElement(T element) {
            this.element = element;
        }

        public List<TreeNode<T>> getChildren() {
            return children;
        }

        public void setChildren(List<TreeNode<T>> children) {
            this.children = children;
        }

        public TreeNode<T> getParent() {
            return parent;
        }

        public void setParent(TreeNode<T> parent) {
            this.parent = parent;
        }
        
        
    }

    private TreeNode<E> root;

    @Override
    public Position<E> addRoot(E e) {
        if(!this.isEmpty())
            throw new RuntimeException("Tree not empty");
        this.root= new TreeNode<>(e,null);
        return root;
    }

    @Override
    public Position<E> add(E element, Position<E> p) {
       TreeNode<E> node = checkPosition(p);
        TreeNode<E> newNode = new TreeNode(element,null);
        newNode.setParent(node);
        node.getChildren().add(newNode);
        return newNode;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        TreeNode<E> node = checkPosition(p);
        List<TreeNode<E>> childrenList = node.getChildren();
        TreeNode<E> newNode = new TreeNode(element,null);
        if(childrenList.size() > n){
            childrenList.add(n, newNode);
            return newNode;
        }
        throw new RuntimeException("Index is not valid");
    }

    @Override
    public void swapElements(Position<E> p1, Position<E> p2) {
       TreeNode<E> node1 = checkPosition(p1);
       TreeNode<E> node2 = checkPosition(p2);
       E element=node1.getElement();
       node1.setElement(node2.getElement());
       node2.setElement(element);
    }

    @Override
    public E replace(Position<E> p, E e) {
        TreeNode<E> node = checkPosition(p);
        E element=node.getElement();
        node.setElement(e);
        return element;
    }

    @Override
    public void remove(Position<E> p) {
        TreeNode<E> node = checkPosition(p);
        if(isRoot(p))
            root=null;
        else{
            if(node.getParent()!=null){;
            node.getParent().getChildren().remove(node);
            node.setParent(null);
            }
        }
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        this.remove(v);
        node.setParent(null);      
        LinkedTree<E> subtree = new LinkedTree<>();
        subtree.root= node;
        return subtree;
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        TreeNode<E> newChild = checkPosition(t.root());
        TreeNode<E> parent = checkPosition(p);
        parent.getChildren().add(newChild);
        newChild.setParent(parent);
    }

    @Override
    public boolean isEmpty() {
        return root==null;
    }

    @Override
    public Position<E> root() {
        if(isEmpty()) throw new RuntimeException("Tree is empty");
        return root;
    }

    @Override
    public Position<E> parent(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        if(isRoot(node)) throw new RuntimeException("Invalid operation");
        return node.getParent();
    }

    @Override
    public Iterable<? extends Position<E>> children(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        return node.getChildren();
    }

    @Override
    public boolean isInternal(Position<E> v) {
        return !isLeaf(v);
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        return node.getChildren().isEmpty();
    }

    @Override
    public boolean isRoot(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        return root.equals(node);
    }

    
    private class LinkedTreeIterator<T> implements Iterator<Position<T>>{
        private Queue<Position<T>> it = new LinkedList<>();
        private LinkedTree<T> tree;
        
        public LinkedTreeIterator(LinkedTree<T> tree){
            this(tree, tree.root());
        }
        
        public LinkedTreeIterator(LinkedTree<T> tree, Position<T> pos){
            if(tree.isEmpty()) throw new RuntimeException("Tree is empty");
            if(pos == null) throw new RuntimeException("Position is not valid");
            this.tree = tree;
            it.add(tree.checkPosition(pos));
        }
        
        @Override
        public boolean hasNext() {
            return !it.isEmpty();
        }

        @Override
        public Position<T> next() {
            Position<T> element = it.poll();
            Iterable <? extends Position<T>> children = tree.children(element);
            for(Position<T> p: children){
                it.add(p);
            }
            return element;
        }
    } 
     
    @Override
    public Iterator<Position<E>> iterator() {
        return new LinkedTreeIterator(this);
    }
 
    public int size(){
        if (isEmpty())
            return 0;
        return countDescendents(root);              
    }
    
    private int countDescendents(TreeNode<E> node){
        int numDescendents = 0;
        LinkedTreeIterator<E> it = new LinkedTreeIterator(this,node);
        while(it.hasNext()){
            it.next();
            numDescendents++;
        }
        return numDescendents;
    }
}
