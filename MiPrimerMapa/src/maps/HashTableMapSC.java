package maps;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * Separate chaining table implementation of hash tables. Note that all
 * "matching" is based on the equals method.
 *
 * @author A. Duarte, J. Vélez, J. Sánchez-Oro
 * @param <K> The key
 * @param <V> The stored value
 */
public class HashTableMapSC<K, V> implements Map<K, V> {

    private class HashEntry<T, U> implements Entry<T, U> {
        
        private final T key;
        private U value;

        public HashEntry(T k, U v) {
            this.key=k;
            this.value=v;
        }

        @Override
        public U getValue() {
            return value;
        }

        @Override
        public T getKey() {
            return key;
        }

        public U setValue(U val) {
            U aux=this.value;
            this.value=val;
            return aux;
        }

        @Override
        public boolean equals(Object o) {
            if(o == null) return false;
            if(o.getClass() != this.getClass()) return false;
            HashEntry<T,U> entry = (HashEntry<T,U>) o;
            return key.equals(entry.getKey()) && value.equals(entry.getValue());
        }

        /**
         * Entry visualization.
         */
        @Override
        public String toString() {
            return "("+getKey().toString()+", "+getValue().toString()+")";
        }
    }

    private class HashTableMapIterator<T, U> implements Iterator<Entry<T, U>> {

        //Ejercicio 2.2
        public HashTableMapIterator(ArrayList<HashEntry<T, U>>[] map, int numElems) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        private void goToNextElement() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public Entry<T, U> next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapKeyIterator<T, U> implements Iterator<T> {

        public HashTableMapKeyIterator(HashTableMapIterator<T, U> it) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public T next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            // NO HAY QUE IMPLEMENTARLO
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private class HashTableMapValueIterator<T, U> implements Iterator<U> {

        public HashTableMapValueIterator(HashTableMapIterator<T, U> it) {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public U next() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not yet implemented");
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("Not implemented.");
        }
    }

    private int prime=109345121;
    private int capacity;
    private int size;
    private ArrayList<HashEntry<K,V>> bucket[];
    private int shift;//no puede ser 0
    private int scale;
    
    /**
     * Creates a hash table
     */
    public HashTableMapSC() {
        this(109345121,100);
    }

    /**
     * Creates a hash table.
     *
     * @param cap initial capacity
     */
    public HashTableMapSC(int cap) {
        this(109345121,cap);
    }

    /**
     * Creates a hash table with the given prime factor and capacity.
     *
     * @param p prime number
     * @param cap initial capacity
     */
    public HashTableMapSC(int p, int cap) {
        prime=p;
        capacity=cap;
        size=0;
        bucket= new ArrayList[capacity];
        Random random= new Random();
        p= generatePrimeNumber(random.nextInt(capacity));
        shift=13;
        scale=2020;
    }
     private int generatePrimeNumber(int nextInt){
        int aux = nextInt;
        while(!isPrime(aux)){
            aux++;
        }
        return aux;
    }

    private boolean isPrime(int n){
        int aux = (int)Math.sqrt(n);
        for(int i = 2; i < aux; i++) {
            if(n % i == 0) return false;
        }
        return true;
    }

    /**
     * Hash function applying MAD method to default hash code.
     *
     * @param key Key
     * @return
     */
    protected int hashValue(K key) {
        return ((key.hashCode()*shift+scale)% prime) % capacity;
    }

    /**
     * Returns the number of entries in the hash table.
     *
     * @return the size
     */
    @Override
    public int size() {
        return size;
    }

    /**
     * Returns whether or not the table is empty.
     *
     * @return true if the size is 0
     */
    @Override
    public boolean isEmpty() {
        return this.size()==0;
    }

    /**
     * Returns the value associated with a key.
     *
     * @param key
     * @return value
     */
    @Override
    public V get(K key) throws IllegalStateException {
        checkKey(key);
        int hashvalue=hashValue(key);
        if(bucket[hashvalue]==null)
            return null;
        for(HashEntry<K,V> entrada : bucket[hashvalue]){
            if(entrada.getKey().equals(key)) return entrada.getValue();
        }
        return null;
    }

    /**
     * Put a key-value pair in the map, replacing previous one if it exists.
     *
     * @param key
     * @param value
     * @return value
     */
    @Override
    public V put(K key, V value) throws IllegalStateException {
        checkKey(key);
        V val= get(key);
        int hashvalue=hashValue(key);
        if(val == null){
            if(bucket[hashvalue]==null){
                bucket[hashvalue]=new ArrayList();
            }
            bucket[hashvalue].add(new HashEntry<K,V>(key,value));
            size++;
        }
        else{
           for(HashEntry<K,V> entrada : bucket[hashvalue]){
            if(entrada.getKey().equals(key)){
                    entrada.setValue(value);
            }
          }      
        }
        return val;
    }

    /**
     * Removes the key-value pair with a specified key.
     *
     * @param key
     * @return
     */
    @Override
    public V remove(K key) throws IllegalStateException {
        checkKey(key);
        V val= get(key);
        int hashvalue=hashValue(key);
        if(val != null){
            bucket[hashvalue].remove(new HashEntry<K,V>(key,val));
            size--;
            return val;
        }
        return null;
        
    }

    @Override
    public Iterator<Entry<K, V>> iterator() {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    /**
     * Returns an iterable object containing all of the keys.
     *
     * @return
     */
    @Override
    public Iterable<K> keys() {
        List<K> keys = new LinkedList<>();
        for(List<HashEntry<K,V>> elements: bucket){
                if(elements != null){
                    for(HashEntry<K,V> entry: elements){
                        if(entry != null){
                            keys.add(entry.getKey());
                        }
                    }
                }
            }
        return keys;
    }

    /**
     * Returns an iterable object containing all of the values.
     *
     * @return
     */
    @Override
    public Iterable<V> values() {
        List<V> values = new LinkedList<>();
        for(List<HashEntry<K,V>> elements: bucket){
                if(elements != null){
                    for(HashEntry<K,V> entry: elements){
                        if(entry != null){
                            values.add(entry.getValue());
                        }
                    }
                }
            }
        return values;
    }

    /**
     * Returns an iterable object containing all of the entries.
     *
     * @return
     */
    @Override
    public Iterable<Entry<K, V>> entries() {
        List<Entry<K, V>> entries = new LinkedList<>();
        for(List<HashEntry<K,V>> elements: bucket){
                if(elements != null){
                    for(HashEntry<K,V> entry: elements){
                        if(entry != null){
                            entries.add(entry);
                        }
                    }
                }
            }
        return entries;
    }

    /**
     * Determines whether a key is valid.
     *
     * @param k Key
     */
    protected void checkKey(K k) {
        if(k == null) throw new IllegalStateException("Invalid key.");
    }

    /**
     * Increase/reduce the size of the hash table and rehashes all the entries.
     * @param newCap
     */
    protected void rehash(int newCap) {
        ArrayList<HashEntry<K,V>>[] newBucket = new ArrayList[newCap];
        Iterable<Entry<K,V>> entries = entries();
        bucket = newBucket;
        capacity = newCap;
        size = 0;
        
        for(Entry<K,V> entry : entries){
            put(entry.getKey(),entry.getValue());
        }
    }
}
