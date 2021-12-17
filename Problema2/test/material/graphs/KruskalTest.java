package material.graphs;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 *
 * @author jvelez
 */
public class KruskalTest {
    
    public KruskalTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of print method, of class Kruskal.
     */
    @Test
    public void testPrint() {
		Graph<String, Integer> graph = new ELGraph<>();
		
		Vertex<String> a = graph.insertVertex("A");
		Vertex<String> b = graph.insertVertex("B");
		Vertex<String> c = graph.insertVertex("C");
		Vertex<String> d = graph.insertVertex("D");
		Vertex<String> e = graph.insertVertex("E");
		Vertex<String> f = graph.insertVertex("F");
		Vertex<String> g = graph.insertVertex("G");
		Vertex<String> h = graph.insertVertex("H");
		Vertex<String> i = graph.insertVertex("I");
		
		graph.insertEdge(a, b, 4);
		graph.insertEdge(a, h, 8);
		graph.insertEdge(b, c, 8);
		graph.insertEdge(b, h, 11);
		graph.insertEdge(c, d, 7);
		graph.insertEdge(c, f, 4);
		graph.insertEdge(c, i, 2);
		graph.insertEdge(d, e, 9);
		graph.insertEdge(d, f, 14);
		graph.insertEdge(e, f, 10);
		graph.insertEdge(f, g, 2);
		graph.insertEdge(g, h, 1);
		graph.insertEdge(g, i, 6);
		graph.insertEdge(h, i, 7);
		
		Kruskal kruskal = new Kruskal();
		kruskal.kruskal(graph);
		kruskal.print(graph);
    }

}
