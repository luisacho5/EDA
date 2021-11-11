
package itinerary;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import material.Pair;

/**
 *
 * @author mayte
 */
public class Organize {
    
    Map<String,String> vuelos = new HashMap<String, String>();
    Map<String,String> vuelosvuelta = new HashMap<String, String>();
    String startPoint=null;
    
    public Organize(List<Pair<String, String>> lista) {

        for(Pair<String, String> vuelo : lista) {
            vuelos.put(vuelo.getFirst(), vuelo.getSecond());      
        }
        for(Map.Entry<String, String> vuelo : vuelos.entrySet()) {
            vuelosvuelta.put(vuelo.getValue(), vuelo.getKey());
        }
        
        startPoint = null;
        for (Map.Entry<String, String> vuelo : vuelos.entrySet()) {
            if (!vuelosvuelta.containsKey(vuelo.getKey())) {
                startPoint = vuelo.getKey();
                break;
            }
        }
        if(startPoint==null){
            throw new RuntimeException("Entrada de vuelos no valida.");
        }
    }
    
    /**
     * Returns the itinerary to travel or thrown an exception
     * @return 
     */
    public List<String> itineratio(){
        List<String> itinerario= new LinkedList<>();
        String stop=vuelos.get(startPoint);
        while(stop!=null){
            itinerario.add(startPoint);
            startPoint=stop;
            stop=vuelos.get(stop);
        }
        itinerario.add(startPoint);
        return itinerario;
    }
}
