
package problemas;

import material.graphs.ELGraph;
import problemas.GraphUtils;
import material.graphs.Graph;
import material.graphs.Vertex;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayte
 */
public class GraphUtilsTest {
    
    public GraphUtilsTest() {
    }

     /**
     * Test of esGrafoConexo method, of class GraphUtils.
     */
    @Test
    public void testIsConnected() {
        System.out.println("isConnected");
        GraphUtils instance = new GraphUtils();
        
        try{
            Graph <String,Integer> graph = null;
            instance.isConnected(graph);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Graph <String,Integer> graph= new ELGraph <> ();
        
        Vertex<String> madrid = graph.insertVertex("Madrid");
        Vertex<String> sevilla = graph.insertVertex("Sevilla");
        Vertex<String> acoruna = graph.insertVertex("A Coruña");
        Vertex<String> santander = graph.insertVertex("Santander");
        Vertex<String> barcelona = graph.insertVertex("Barcelona");
        Vertex<String> zaragoza = graph.insertVertex("Zaragoza");
        Vertex<String> leon = graph.insertVertex("Leon");
        Vertex<String> salamanca = graph.insertVertex("Salamanca");
        Vertex<String> caceres = graph.insertVertex("Caceres");
        Vertex<String> ciudad_r = graph.insertVertex("Ciudad Real");
        Vertex<String> malaga = graph.insertVertex("Malaga");
        Vertex<String> valencia = graph.insertVertex("Valencia");
        
        
        boolean expResult = false;
        boolean result = instance.isConnected(graph);
        assertEquals(expResult, result);
        
        graph.insertEdge(madrid,leon,337);
        graph.insertEdge(leon, acoruna, 318);
        graph.insertEdge(leon, salamanca, 206);
        graph.insertEdge(salamanca, madrid, 214);
        graph.insertEdge(salamanca, caceres,201);
        graph.insertEdge(madrid,caceres, 296);
        graph.insertEdge(madrid, ciudad_r, 186);
        graph.insertEdge(caceres, ciudad_r, 271);
        graph.insertEdge(ciudad_r,malaga, 346);
        graph.insertEdge(ciudad_r, sevilla, 328);
        graph.insertEdge(sevilla, malaga, 205);
        graph.insertEdge(sevilla,valencia,654);
        graph.insertEdge(valencia,madrid, 360);
        graph.insertEdge(valencia, barcelona, 350);
        graph.insertEdge(barcelona, zaragoza,310);
        graph.insertEdge(zaragoza, madrid, 322);
        assertFalse(instance.isConnected(graph));
        graph.insertEdge(zaragoza, santander, 405);
        graph.insertEdge(madrid,santander, 456);
        assertTrue(instance.isConnected(graph));
    }

    /**
     * Test of esGrafoEuleriano method, of class GraphUtils.
     */
    @Test
    public void testIsEulerian() {
        System.out.println("isEulerian");
        GraphUtils instance = new GraphUtils();
        try{
            Graph <String,Integer> graph = null;
            instance.isEulerian(graph);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Graph <String,Integer> graph= new ELGraph <> ();
        
        
        boolean expResult = false;
        boolean result = instance.isEulerian(graph);
        assertEquals(expResult, result);
        
        Vertex<String> madrid = graph.insertVertex("Madrid");
        Vertex<String> sevilla = graph.insertVertex("Sevilla");
        Vertex<String> acoruna = graph.insertVertex("A Coruña");
        Vertex<String> santander = graph.insertVertex("Santander");
        Vertex<String> barcelona = graph.insertVertex("Barcelona");
        Vertex<String> zaragoza = graph.insertVertex("Zaragoza");
        Vertex<String> leon = graph.insertVertex("Leon");
        Vertex<String> salamanca = graph.insertVertex("Salamanca");
        Vertex<String> caceres = graph.insertVertex("Caceres");
        Vertex<String> ciudad_r = graph.insertVertex("Ciudad Real");
        Vertex<String> malaga = graph.insertVertex("Malaga");
        Vertex<String> valencia = graph.insertVertex("Valencia");
        
        assertFalse(instance.isEulerian(graph));
        
        graph.insertEdge(madrid,leon,337);
        graph.insertEdge(leon, acoruna, 318);
        graph.insertEdge(salamanca, madrid, 214);
        graph.insertEdge(salamanca, caceres,201);
        graph.insertEdge(madrid,caceres, 296);
        graph.insertEdge(madrid, ciudad_r, 186);
        graph.insertEdge(caceres, ciudad_r, 271);
        graph.insertEdge(ciudad_r,malaga, 346);
        graph.insertEdge(ciudad_r, sevilla, 328);
        assertFalse(instance.isEulerian(graph));
        graph.insertEdge(sevilla, malaga, 205);
        graph.insertEdge(sevilla,valencia,654);
        graph.insertEdge(valencia,madrid, 360);
        graph.insertEdge(valencia, barcelona, 350);
        graph.insertEdge(zaragoza, madrid, 322);
        graph.insertEdge(zaragoza, santander, 405);
        graph.insertEdge(madrid,santander, 456);
        graph.insertEdge(acoruna, santander, 454);
        graph.insertEdge(caceres, valencia, 629);
        graph.insertEdge(sevilla, madrid, 532);
        
        assertTrue(instance.isEulerian(graph));
        
        
    }

    /**
     * Test of esArbolLibre method, of class GraphUtils.
     */
    @Test
    public void testIsFreeTree() {
        System.out.println("isFreeTree");
        GraphUtils instance = new GraphUtils();
        try{
            Graph <String,Integer> graph = null;
            instance.isFreeTree(graph);
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        Graph <String,Integer> graph= new ELGraph <> ();
        
        
        boolean expResult = false;
        boolean result = instance.isFreeTree(graph);
        assertEquals(expResult, result);
        
        Vertex<String> madrid = graph.insertVertex("Madrid");
        Vertex<String> sevilla = graph.insertVertex("Sevilla");
        Vertex<String> acoruna = graph.insertVertex("A Coruña");
        Vertex<String> santander = graph.insertVertex("Santander");
        Vertex<String> barcelona = graph.insertVertex("Barcelona");
        Vertex<String> zaragoza = graph.insertVertex("Zaragoza");
        Vertex<String> leon = graph.insertVertex("Leon");
        Vertex<String> salamanca = graph.insertVertex("Salamanca");
        Vertex<String> caceres = graph.insertVertex("Caceres");
        Vertex<String> ciudad_r = graph.insertVertex("Ciudad Real");
        Vertex<String> malaga = graph.insertVertex("Malaga");
        Vertex<String> valencia = graph.insertVertex("Valencia");
        
        assertFalse(instance.isFreeTree(graph));
        
        graph.insertEdge(madrid,leon,337);
        graph.insertEdge(leon, acoruna, 318);
        graph.insertEdge(salamanca, madrid, 214);        
        graph.insertEdge(madrid,caceres, 296);
        graph.insertEdge(madrid, ciudad_r, 186);
        graph.insertEdge(ciudad_r,malaga, 346);
        graph.insertEdge(ciudad_r, sevilla, 328);
        graph.insertEdge(sevilla,valencia,654);
        graph.insertEdge(valencia, barcelona, 350);
        graph.insertEdge(zaragoza, madrid, 322); 
        graph.insertEdge(zaragoza, santander, 405);
        assertTrue(instance.isFreeTree(graph));
        graph.insertEdge(valencia,madrid, 360);
        graph.insertEdge(madrid,santander, 456);
        graph.insertEdge(acoruna, santander, 454);
        graph.insertEdge(caceres, valencia, 629);
        graph.insertEdge(sevilla, madrid, 532);
        graph.insertEdge(salamanca, caceres,201);
        graph.insertEdge(caceres, ciudad_r, 271);
        graph.insertEdge(sevilla, malaga, 205);
        assertFalse(instance.isFreeTree(graph));
    }
    
}
