package examen2020;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import material.graphs.BreadthSearch;
import material.graphs.ELGraph;
import material.graphs.Edge;
import material.graphs.Vertex;



/**
 *
 * @author mayte
 */
public class Metro {
    
    private ELGraph<Line,String> grafo= new ELGraph<>();
    private Map<Line,Vertex<Line>> mapa= new HashMap<>();
    private Map<Integer,Line> mapaNL= new HashMap<>();
    
    /**
    * Return the number of lines in the Metro.
    * @return the number of lines. 
    */
    public int numberOfLines(){
        return mapa.size();
    }
    
    /**
    * Get one line.
    * @param i The identifier of the line.
    * @return the Line which is corresponding with the identifier. 
    */
    public Line getLine(int lineNumber){
        for(Line linea:mapa.keySet()){
            if(linea.getNumber()==lineNumber)
                return linea;
        }
        return null;
    }
    
    /**
    * Add a new line to the Metro.
    * @return the identifier of the new line. 
    */
    public int addLine(){
        Line aux=new Line(mapa.size()+1);
        Vertex<Line> vertice= grafo.insertVertex(aux);
        mapa.put(aux, vertice);
        return mapa.size();
    }
    
    /**
    * Add a new station to the line. Is possible that 
    * one station belongs to two lines or more.
    * @param l The identifier of the line.
    * @param station The name of the station.  
    */
    //Añade una nueva estacion a una línea de metro
    public void addStationToLine(int lineNUmber, String stationName){
        Line aux= this.getLine(lineNUmber);
        aux.anadirEstacion(stationName);
    }
    
    /**
    * Get the minimum path between two stations.
    * @param startStationName The name of station at the beginning of the way.
    * @param endStationName The name of the final station.
    * @return A list with the sequence of the stations between the first and
    * the last station. 
    */
    public List<String> pathBetweenStations(String startStationName, String endStationName){
        Line l1=null,l2=null;
        for(Line linea:mapa.keySet()){
             if(linea.contiene(startStationName)){
                l1=linea;
             }
             else if(linea.contiene(endStationName)){
                l2=linea;
             }
        }
        BreadthSearch<Line,String> bd= new BreadthSearch<Line,String>();
        List<Edge<String>> path = bd.getPath(grafo, mapa.get(l1), mapa.get(l2));
        
        List<String> aux= new ArrayList<>();
        if(path!=null){
            
            for(Edge<String> edge:path){
               aux.add(edge.getElement());
            }
        }
        return aux;
    }
}
