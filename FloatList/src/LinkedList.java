/**
 *
 * @author mayte
 */
public class LinkedList<E> implements List<E>{

    private class Node<E>{
       
        private E elem;
        private Node<E> next;

        public E getElem() {
            return elem;
        }

        public void setElem(E elem) {
            this.elem = elem;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> next) {
            this.next = next;
        }
        
        public Node(E e, Node sig){
            this.elem = e;
            this.next = sig;
        }        
             
    }
    
    private Node<E> forward(int index){
        if ((index < 1) || (index > (size + 1)))
            throw new RuntimeException("The index is out of limits.");
        Node<E> ant = null;
        Node<E> act = head;
        for (int i = 1; i < index; i++){
            ant = act;
            act = act.getNext();
        }
        return ant;
    }
    
    private int size;
    private Node<E> head;
    
    public LinkedList(){
        this.size = 0;
        this.head = null;
    }
    
    @Override
    public int size() {
        return this.size;
    }

    @Override
    public boolean isempty() {
        return (this.size == 0);
    }

    @Override
    public void add(E value) {
        Node<E> aux = new Node<E>(value, head);
        this.head = aux;
        this.size++;
    }

     
    @Override
    public void add(int index, E value) {
        Node<E> ant = forward(index);
        if (ant == null)
            add(value);
        else{
            Node<E> aux = new Node<E>(value, ant.getNext());
            this.size++;
            ant.setNext(aux);
        }          
    }

    @Override
    public E remove() {
        if (this.isempty())
            throw new RuntimeException("It is not allowed remove elements from a empty list.");
        Node<E> aux = head;
        size--;
        head = head.getNext();
        return aux.getElem();
    }

    
    @Override
    public E remove(int index) {
        Node<E> ant = forward(index);
        if (ant == null)
            return remove();
        else{
            this.size--;
            Node<E> aux = ant.getNext();
            ant.setNext(aux.getNext()); 
            return aux.getElem();
        }
    }

    @Override
    public E get() {
        if (this.isempty())
             throw new RuntimeException("The index is out of limits.");
        return head.getElem();
    }

    @Override
    public E get(int index) {
        Node<E> ant = forward(index+1);
        return ant.getElem();        
    }

    @Override
    public int search(E value) {
        if (isempty())
            return 0;
        Node<E> aux = head;
        int i = 1;
        while ((i < size) && (!aux.getElem().equals(value))){
            aux = aux.getNext();
            i++;
        }
        if ((i < size)||(aux.getElem().equals(value)))
            return i;
        return 0;
    }

    @Override
    public boolean contains(E value) {
       return (search(value) != 0);
    }
    
}
