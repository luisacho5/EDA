import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

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
        TreeNode<E> node =checkPosition(p);
        if(node.getChildren()!=null)
            node.setChildren(new ArrayList<TreeNode<E>>());
        
        TreeNode<E> children =new TreeNode<>(element,node);
        node.getChildren().add(children);
        return children;
    }

    @Override
    public Position<E> add(E element, Position<E> p, int n) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            final TreeNode<E> parent = node.getParent();
            parent.getChildren().remove(node);
        }
    }

    @Override
    public NAryTree<E> subTree(Position<E> v) {
        TreeNode<E> node = checkPosition(v);
        this.remove(v);
        LinkedTree<E> subtree = new LinkedTree<>();
        subtree.root= node;
        return subtree;
    }

    @Override
    public void attach(Position<E> p, NAryTree<E> t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Position<E> root() {
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
    public boolean isInternal(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isLeaf(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isRoot(Position<E> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
 
    public int size(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates. 
    }
}
