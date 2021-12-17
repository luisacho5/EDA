package examen2020;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;



/**
 *
 * @author mayte
 */
public class Line {
   
    private ArrayList<String> estaciones;
    private final int number;

    public Line(int number) {
        this.number = number;
        estaciones= new ArrayList<>();
    }

    public ArrayList<String> getEstaciones() {
        return estaciones;
    }

    public void setEstaciones(ArrayList<String> estaciones) {
        this.estaciones = estaciones;
    }

    public int getNumber() {
        return number;
    }
    
    public void anadirEstacion(String estacion){
        estaciones.add(estacion);
    }
    
    public boolean contiene(String estacion){
        for(String estacion2:estaciones){
            if(estacion2.equals(estacion)){
                return true;
            }
        }
        return false;
    }
    /**
     * Return all the names of the stations in the line.
     * @return A string with the sequence of all stations in the line. 
     */
    @Override
    public String toString(){
        
        return estaciones.toString();
    }
   
    
}
