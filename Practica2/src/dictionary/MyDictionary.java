
package dictionary;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import maps.AbstractHashTableMap;

/**
 *
 * @author mayte
 * @param <K>
 * @param <V>
 */
public class MyDictionary<K,V> implements Dictionary<K,V> {
    
    /**
     * @param <T> Key type
     * @param <U> Value type
     *
     */
    private class HashEntry<T, U> implements Entry<T, U> {

        protected T key;
        protected U value;

        public HashEntry(T k, U v) {
            key = k;
            value = v;
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
            U oldValue = value;
            value = val;
            return oldValue;
        }

        @Override
        public boolean equals(Object o) {

            if (o.getClass() != this.getClass()) {
                return false;
            }

            HashEntry<T, U> ent;
            try {
                ent = (HashEntry<T, U>) o;
            } catch (ClassCastException ex) {
                return false;
            }
            return (ent.getKey().equals(this.key))
                    && (ent.getValue().equals(this.value));
        }

        /**
         * Entry visualization.
         */
        @Override
        public String toString() {
            return "(" + key + "," + value + ")";
        }
    }
    
    private class HashDictionaryIterator<T, U> implements Iterator<Entry<T, U>> {

        @Override
        public boolean hasNext() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        @Override
        public Entry<T, U> next() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }

        
        
    }
    private List<HashEntry<K,V>>[] bucket;
    private int capacity;
    private int prime;
    private int n;
    private int p;
    private int a;
    private int b;

    public MyDictionary() {
        this(109345121, 100);
    }
    
    public MyDictionary(int cap) {
        this(109345121, cap);
    }
    
    public MyDictionary(int p, int cap) {
        prime = p;
        capacity = cap;
        bucket = new ArrayList[cap];
        
        Random r = new Random();
        this.p = generatePrimeNumber(r.nextInt(capacity));
        a = 13;
        b = 2020;
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
    private int hashValue(K key) {
         return ((Math.abs(a * key.hashCode()) + b) % p) % capacity;
    }
    
    @Override
    public int size() {
        return n;
    }

    @Override
    public boolean isEmpty() {
        return n==0;
    }

    @Override
    public Entry<K, V> insert(K key, V value) throws IllegalStateException {
        int pos = hashValue(key);
        HashEntry<K, V> entry = new HashEntry<>(key,value);
        if (bucket[pos] == null) {
            bucket[pos] = new ArrayList<>();
        }
        bucket[pos].add(entry);
        n++;

        return entry;
    }

    @Override
    public Entry<K, V> find(K key) throws IllegalStateException {
        HashEntry<K,V> entry = null;
        int pos = hashValue(key);
        List<HashEntry<K,V>> elements = bucket[pos];
        if(elements == null || elements.isEmpty()) return null;
        
        Iterator it = elements.iterator();
        while(it.hasNext()){
            HashEntry<K,V> e = (HashEntry<K,V>) it.next();
            if(e.getKey().equals(key)){
                entry = e;
                break;
            }
        }
        
        return entry;
    }

    @Override
    public Iterable<Entry<K, V>> findAll(K key) throws IllegalStateException {
        List<Entry<K,V>> entries = new LinkedList<>();
        int pos = hashValue(key);
        List<HashEntry<K,V>> elements = bucket[pos];
        if(elements == null || elements.isEmpty()) return null;
        
        Iterator it = elements.iterator();
        while(it.hasNext()){
            HashEntry<K,V> e = (HashEntry<K,V>) it.next();
            if(e.getKey().equals(key)){
                entries.add(e);
            }
        }
        
        return entries;
    }

    @Override
    public Entry<K, V> remove(Entry<K, V> e) throws IllegalStateException {
        HashEntry<K,V> entry = (HashEntry<K,V>) find(e.getKey());
        int pos = hashValue(e.getKey());
        if(entry != null) {
            bucket[pos].remove(entry);
            n--;
            return entry;
        }
        return null;
    }

    @Override
    public Iterable<Entry<K, V>> entries() {
       List<Entry<K, V>> entries= new ArrayList<>();
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
    
    @Override
    public Iterator<Entry<K, V>> iterator() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * Doubles the size of the hash table and rehashes all the entries.
     */
    private void rehash() {
        List<HashEntry<K,V>>[] newBucket = new List[capacity*2];
        Iterable<Entry<K,V>> entries = entries();
        bucket = newBucket;
        capacity = capacity*2;
        n = 0;
        
        for(Entry<K,V> entry : entries){
            insert(entry.getKey(),entry.getValue());
        }
    }
}
