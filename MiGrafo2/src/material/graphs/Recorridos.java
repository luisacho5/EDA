package material.graphs;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Stack;
import material.Position;
import material.tree.Tree;
import material.tree.narytree.LinkedTree;
import material.utils.Pair;

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
        //Variables necesarios para el funcionamiento.
        Set<Vertex<V>> visitados = new HashSet<>();
        Set<Edge<E>> descubrimiento= new HashSet<>();
        Set<Edge<E>> back= new HashSet<>();
        Stack<Pair<Vertex<V>,Iterator<Edge<E>>>> pila = new Stack<>();
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Map<Vertex<V>,Position<Vertex<V>>> mapa= new HashMap<>();
        
        return depthaux(visitados, source, pila, graph, mapa, tree, descubrimiento, back);
    }

    private Tree<Vertex<V>> depthaux(Set<Vertex<V>> visitados, Vertex<V> source, Stack<Pair<Vertex<V>, Iterator<Edge<E>>>> pila, Graph<V, E> graph, Map<Vertex<V>, Position<Vertex<V>>> mapa, LinkedTree<Vertex<V>> tree, Set<Edge<E>> descubrimiento, Set<Edge<E>> back) {
        //incializacion de las variables
        visitados.add(source);
        pila.push(new Pair(source,graph.incidentEdges(source).iterator()));
        mapa.put(source, tree.addRoot(source));
        
        while(!pila.isEmpty()){
            Pair<Vertex<V>, Iterator<Edge<E>>> par= pila.peek();
            Iterator<Edge<E>> ite = par.getSecond();
            Vertex<V> nodo= par.getFirst();
            Boolean salir=true;
            while(ite.hasNext()&&!salir){
                Edge<E> arista= ite.next();
                if((!descubrimiento.contains(arista))&&(!back.contains(arista))){
                    Vertex<V> otro= graph.opposite(nodo, arista);
                    salir=!visitados.contains(otro);
                    if(salir){
                        visitados.add(otro);
                        pila.push(new Pair(otro,graph.incidentEdges(otro).iterator()));
                        descubrimiento.add(arista);
                        mapa.put(otro,tree.add(otro, mapa.get(nodo)));
                    }    
                    else{
                        back.add(arista);
                    }
                }
            }
            if(!salir) pila.pop();
        }
        return tree;
    }
    
    /**
     * Devuelve el árbol que se genera al realizar el recorrido en anchura
     * 
     * @param graph
     * @param source
     * @return 
     */
    
    public Tree<Vertex<V>> widthTravel(Graph<V,E> graph, Vertex<V> source){
        //Variables necesarios para el funcionamiento.
        Set<Vertex<V>> visitados = new HashSet<>();
        Set<Edge<E>> descubrimiento= new HashSet<>();
        Set<Edge<E>> cross= new HashSet<>();
        LinkedList<Pair<Vertex<V>,Iterator<Edge<E>>>> cola = new LinkedList<>();
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Map<Vertex<V>,Position<Vertex<V>>> mapa= new HashMap<>();
        
        visitados.add(source);
        cola.addLast(new Pair(source, graph.incidentEdges(source).iterator()));
        mapa.put(source,tree.addRoot(source));
        
        while(!cola.isEmpty()){
            Pair<Vertex<V>, Iterator<Edge<E>>> par= cola.getFirst();
            Iterator<Edge<E>> ite= par.getSecond();
            Vertex<V> nodo= par.getFirst();
            while(ite.hasNext()){
                Edge<E> arista= ite.next();
                if((!descubrimiento.contains(arista))&&(!cross.contains(arista))){
                    Vertex<V> otro = graph.opposite(nodo, arista);
                    if(visitados.contains(otro))
                        cross.add(arista);
                    else{
                        visitados.add(otro);
                        cola.addLast(new Pair(otro,graph.incidentEdges(otro).iterator()));
                        descubrimiento.add(arista);
                        mapa.put(otro, tree.add(otro, mapa.get(nodo)));
                    }
                }
            }
        
        
        }
        return tree;
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
        //Variables necesarios para el funcionamiento.
        Set<Vertex<V>> visitados = new HashSet<>();
        Set<Edge<E>> descubrimiento= new HashSet<>();
        Set<Edge<E>> back= new HashSet<>();
        Stack<Pair<Vertex<V>,Iterator<Edge<E>>>> pila = new Stack<>();
        LinkedTree<Vertex<V>> tree = new LinkedTree<>();
        Map<Vertex<V>,Position<Vertex<V>>> mapa= new HashMap<>();
        
        depthaux(visitados, root, pila, g, mapa, tree, descubrimiento, back);
        return visitados;
    
    }
    
    
}
