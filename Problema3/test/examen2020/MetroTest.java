package examen2020;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayte
 */
public class MetroTest {
    
    public MetroTest() {
    }
    
    private Metro inicializa(){
        
        Metro instance = new Metro();
        
        int lineauno = instance.addLine();
        int lineados = instance.addLine();
        int lineatres = instance.addLine();
        
        instance.addStationToLine(lineauno, "Chamartin");
        instance.addStationToLine(lineauno, "Plaza Castilla");
        instance.addStationToLine(lineauno, "Tetuan");
        instance.addStationToLine(lineauno, "Cuatro Caminos");
        instance.addStationToLine(lineauno, "Bilbao");
        instance.addStationToLine(lineauno, "Tribunal");
        instance.addStationToLine(lineauno, "Gran Via");
        instance.addStationToLine(lineauno, "Sol");
        instance.addStationToLine(lineauno, "Atocha");
        instance.addStationToLine(lineauno, "Pacifico");
        
        instance.addStationToLine(lineados, "Cuatro Caminos");
        instance.addStationToLine(lineados, "San Bernardo");
        instance.addStationToLine(lineados, "Opera");
        instance.addStationToLine(lineados, "Sol");
        instance.addStationToLine(lineados, "Principe de Vergara");
        instance.addStationToLine(lineados, "Goya");
        instance.addStationToLine(lineados, "Manuel Becerra");
        instance.addStationToLine(lineados, "Ventas");
        
        instance.addStationToLine(lineatres, "Moncloa");
        instance.addStationToLine(lineatres, "Argüelles");
        instance.addStationToLine(lineatres, "Callao");
        instance.addStationToLine(lineatres, "Sol");
        instance.addStationToLine(lineatres, "Embajadores");
        instance.addStationToLine(lineatres, "Legazpi");
        
        
        return instance;
    }

    /**
     * Test of obtenerLinea method, of class Metro.
     */
    @Test
    public void testObtenerLinea() {
        System.out.println("obtenerLinea");
        
        Metro instance = inicializa();
        
        Line result = instance.getLine(2);
        
        assertEquals("[Cuatro Caminos, San Bernardo, Opera, Sol, Principe de Vergara, Goya, Manuel Becerra, Ventas]", result.toString());
       
       
    }

    /**
     * Test of aniadirLinea method, of class Metro.
     */
    @Test
    public void testAniadirLinea() {
        System.out.println("aniadirLinea");
        Metro instance = inicializa();
        int expResult = 4;
        int result = instance.addLine();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of aniadeEstacion method, of class Metro.
     */
    @Test
    public void testAniadeEstacion() {
        System.out.println("aniadeEstacion");
        int l = 2;
        String estacion = "Pacifico";
        Metro instance = inicializa();
        instance.addStationToLine(l, estacion);
        Line result = instance.getLine(2);
        
        assertEquals("[Cuatro Caminos, San Bernardo, Opera, Sol, Principe de Vergara, Goya, Manuel Becerra, Ventas, Pacifico]", result.toString());
        
    }

    /**
     * Test of caminoEntreEstaciones method, of class Metro.
     */
    @Test
    public void testCaminoEntreEstaciones() {
        System.out.println("caminoEntreEstaciones");
        String inicio = "Bilbao";
        String ultimo = "Legazpi";
        Metro instance = inicializa();
        
        List<String> result = instance.pathBetweenStations(inicio, ultimo);
        assertEquals(Arrays.asList("Bilbao","Tribunal","Gran Via", "Sol", "Embajadores", "Legazpi"), result);
       
    }
    
    @Test
    public void testCaminoEntreEstaciones2() {
        System.out.println("caminoEntreEstaciones");
        String inicio = "Opera";
        String ultimo = "Plaza Castilla";
        Metro instance = inicializa();
        
        List<String> result = instance.pathBetweenStations(inicio, ultimo);
        assertEquals(Arrays.asList("Opera", "San Bernardo", "Cuatro Caminos", "Tetuan", "Plaza Castilla"), result);
       
    }
    
}
