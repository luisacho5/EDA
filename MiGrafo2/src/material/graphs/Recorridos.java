package material.graphs;

import java.util.List;
import java.util.Set;
import material.tree.Tree;

/**
 *
 * @author jvelez
 * @param <V>
 * @param <E>
 */
public class Recorridos<V, E> {

    /**
     * Devuelve el árbol que se genera al realizar el recorrido en profundidad
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> depthTravel(Graph<V,E> graph, Vertex<V> source){
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Devuelve el árbol que se genera al realizar el recorrido en anchura
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> widthTravel(Graph<V,E> graph, Vertex<V> source){
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get the path between two vertex with minimun number of nodes.
     *
     * @param graph
     * @param startVertex
     * @param endVertex
     * @return The edge list
     */
    public List<Edge<E>> getPath(Graph<V, E> graph, Vertex<V> startVertex, Vertex<V> endVertex) {
       throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Devuelve el conjunto de vértices visitados al hacer un recorrido en profundidad partiendo de root
     * @param g
     * @param root
     * @return 
     */
    public Set<Vertex<V>> traverse(Graph<V, E> g, Vertex<V> root) {
        throw new UnsupportedOperationException ("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
