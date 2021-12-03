
package material.graphs;

import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 *
 * @author mayte
 * @param <V>
 * @param <E>
 */
public class ELGraph<V,E> implements Graph<V,E> {

    private ELVertex<V> checkVertex(Vertex<V> v1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    private ELEdge<E> checkEdge(Edge<E> edge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    private class ELVertex<T> implements Vertex<T>{
        
        private T value;
        private Set<ELEdge<E>> misAristas= new HashSet<>();
        
        public void setValue(T aux){
            this.value=aux;
        }

        @Override
        public T getElement() {
           return value;
        }

        @Override
        public int hashCode() {
            int hash = 7;
            hash = 53 * hash + Objects.hashCode(this.value);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ELVertex<?> other = (ELVertex<?>) obj;
            if (this.value.equals(other.value)) {
                return false;
            }
            return true;
        }
    
        
    
    }
    private class ELEdge<E> implements Edge<E>{
        
        private E value;
        private ELVertex<V> start;
        private ELVertex<V> end;

        public ELEdge(ELVertex<V> start, ELVertex<V> end, E value) {
            this.value = value;
            this.start = start;
            this.end = end;
        }
        
        public void setValue(E aux){
            this.value=aux;
        }

        @Override
        public int hashCode() {
            int hash = 3;
            hash = 97 * hash + Objects.hashCode(this.value);
            hash = 97 * hash + Objects.hashCode(this.start);
            hash = 97 * hash + Objects.hashCode(this.end);
            return hash;
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null) {
                return false;
            }
            if (getClass() != obj.getClass()) {
                return false;
            }
            final ELEdge<?> other = (ELEdge<?>) obj;
            if (!this.start.equals(other.start)||!this.start.equals(other.end)) {
                return false;
            }
            if (!this.end.equals(other.end)||!this.end.equals(other.start)) {
                return false;
            }
            return true;
        }

        @Override
        public E getElement() {
            return value;
        }

        
        
    
    }

    private Set<ELEdge<E>> aristas;
    private Set<ELVertex<V>> nodos;

    public ELGraph() {
        this.aristas = new HashSet<>();
        this.nodos = new HashSet<>();
    }

    public ELGraph(Set<ELEdge<E>> aristas, Set<ELVertex<V>> nodos) {
        this.aristas = aristas;
        this.nodos = nodos;
    }
    
    @Override
    public Collection<? extends Vertex<V>> vertices() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<? extends Edge<E>> edges() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Collection<? extends Edge<E>> incidentEdges(Vertex<V> v) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> opposite(Vertex<V> v, Edge<E> e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Vertex<V>> endVertices(Edge<E> edge) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Edge<E> areAdjacent(Vertex<V> v1, Vertex<V> v2) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public V replace(Vertex<V> vertex, V vertexValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public E replace(Edge<E> edge, E edgeValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Vertex<V> insertVertex(V value) {
        ELVertex<V> nodo= new ELVertex<>();
        nodo.setValue(value);
        nodos.add(nodo);
        return nodo;
    }

    @Override
    public Edge<E> insertEdge(Vertex<V> v1, Vertex<V> v2, E edgeValue) {
        ELVertex<V> nodo1 = checkVertex(v1);
        ELVertex<V> nodo2 = checkVertex(v2);
        if(!nodos.contains(nodo1)||!nodos.contains(nodo2))
            throw new RuntimeException("No puedes crear una arista si no tienes los nodos");
        ELEdge<E> arista = new ELEdge<>(nodo1,nodo2,edgeValue);
        if(aristas.contains(arista))
            aristas.remove(arista);
        aristas.add(arista);
        return arista;
        
    }

    @Override
    public V removeVertex(Vertex<V> vertex) {
        ELVertex<V> nodo = checkVertex(vertex);
        for(ELEdge<E>arista:aristas){
            if(arista)
        }
    }

    @Override
    public E removeEdge(Edge<E> edge) {
        ELEdge<E> arista= checkEdge(edge);
        aristas.remove(arista);
        return arista.getElement();
    }
    
}
