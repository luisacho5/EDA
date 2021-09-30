/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Iterator;
import material.Position;

/**
 *
 * @author luiss
 */
public class LinkedPositionList<E> implements MyListBetter<E>{

    private class DLinkedNode<E> implements Position{
        
        private E element;
        private DLinkedNode<E> next;
        private DLinkedNode<E> prev;

        public DLinkedNode(E element, DLinkedNode<E> prev, DLinkedNode<E> next) {
            this.element = element;
            this.next = next;
            this.prev = prev;
        }
        
        
        
        public void setElement(E element) {
            this.element=element;
        }
        public void setNext(DLinkedNode<E> next){
         this.next=next;
        }
        
        public void setPrev(DLinkedNode<E> prev){
         this.prev=prev;
        } 
        
        @Override
        public E getElement() {
            return element;
        }
        
        public DLinkedNode<E> getNext() {
            return next;
        }
        
        public DLinkedNode<E> getPrev() {
            return prev;
        }
    
    }  
    
    private DLinkedNode<E> head;
    private DLinkedNode<E> tail;
    private int size;
    
    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isempty() {
        return(size==0);
    }

    @Override
    public Position<E> add(E value) {
        DLinkedNode<E> node = new DLinkedNode<>(value,null,head);
        if(this.isempty()){
            tail= node;
        }
        else{
            head.setPrev(node);  
        }
        head = node;
        size++;
        return node;
    }
    private DLinkedNode<E> checkPosition(Position<E> p) {
        if (p == null || !(p instanceof DLinkedNode)) {
        throw new RuntimeException("The position is invalid");
        }
        return (DLinkedNode<E>) p;
    }

    @Override
    public Position<E> addBefore(Position<E> pos, E value) throws RuntimeException{
        
        DLinkedNode<E> nextNode= this.checkPosition(pos);
        DLinkedNode<E> newNode = new DLinkedNode<>(value,nextNode.getPrev(),nextNode);
        
        if(this.head==nextNode){
            this.head=newNode;
        }
        else{
            nextNode.getPrev().setNext(newNode);     
        }
        nextNode.setPrev(newNode);
        size++;
        return (Position<E>) newNode;
    }
    
    @Override
    public Position<E> addAfter(Position<E> pos, E value) throws RuntimeException{
        DLinkedNode<E> prevNode= this.checkPosition(pos);
        DLinkedNode<E> newNode = new DLinkedNode<>(value,prevNode,prevNode.getNext());
        
        if(this.tail==prevNode){
            this.tail=newNode;
        }
        else{
            prevNode.getNext().setPrev(newNode);        
        }
        prevNode.setNext(newNode);
        size++;
        return (Position<E>) newNode;
    }
 
    @Override
    public E remove(Position pos) throws RuntimeException{
        DLinkedNode<E> nodeDel = this.checkPosition(pos);
        DLinkedNode<E> nodePrev = nodeDel.getNext();
        DLinkedNode<E> nodeNext = nodeDel.getNext();
        if (isempty()==false){
            if(nodeDel == tail){
                tail=nodePrev;
            }
            else if(nodeDel ==head){
                head=nodeNext;
            }
            else if(size()==1){
                tail=nodePrev;
                head=nodeNext;
            }
            nodePrev.setNext(nodeNext);
            nodeNext.setPrev(nodePrev);
            size--;
            return nodeDel.getElement();
        }
        
        throw new RuntimeException("Lista vacía");
    }

    @Override
    public Position get() {
        return (Position<E>) this.head;
    }

    @Override
    public Position<E> set(Position<E> pos, E value) throws RuntimeException{
        DLinkedNode<E> node = this.checkPosition(pos); 
        node.setElement(value);
        return (Position<E>) node;    
    }

    @Override
    public Position<E> search(E value) {
       Iterator<Position<E>> it = this.iterator();
       while(it.hasNext()){
           Position<E> posicion= it.next();
           if(posicion.getElement().equals(value)){
               return posicion;
           }
       }
       return null;
    }

    @Override
    public boolean contains(E value) {
        return (search(value)!=null);
    }

    
    @Override
    public Iterator<Position<E>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
