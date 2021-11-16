
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import material.Position;
import material.tree.Tree;
import material.tree.binarytree.BinaryTree;
import material.tree.binarytree.LinkedBinaryTree;
import material.tree.narytree.LinkedTree;
import material.tree.narytree.NAryTree;
import org.junit.Test;
import static org.junit.Assert.*;
import parcial1.Parcial1;
import static parcial1.Parcial1.antecesors;
import static parcial1.Parcial1.degree;
import static parcial1.Parcial1.isIsogram;

/**
 *
 * @author mayte
 */
public class Parcial1Test {
    
    public Parcial1Test() {
    }
    private Position<String> prueba;
    private Position<String> p2;
    
    private NAryTree<String> iniciaTree(){
        NAryTree<String> t = new LinkedTree<>();
        Position<String> r = t.addRoot("Caos");
        Position<String> h1 = t.add("Nix", r);
        t.add("Gea", r);
        Position<String> h2 = t.add("Eter", r);
        Position<String> h1h = t.add("Cronos", h1);
        Position<String> h2h = t.add("Afrodita", h2);
        t.add("Eros", h2h);
        t.add("Poseidon", h1h);
        Position<String> h1hh = t.add("Zeus", h1h);
        t.add("Era", h1h);
        t.add("Hades", h1h);
        t.add("Atenea", h1hh);
        t.add("Apolo", h1hh);
        prueba = t.add("Ares", h1hh);
        return t;
    }
    private BinaryTree<String> iniciaBinaryTree(){
        BinaryTree<String> t = new LinkedBinaryTree<>();
        Position<String> r = t.addRoot("Caos");
        Position<String> hiz = t.insertLeft(r, "Nix");
        Position<String> hder = t.insertRight(r, "Eter");
        Position<String> hizhiz = t.insertLeft(hiz,"Cronos");
        t.insertRight(hder, "Afrodita");
        Position<String> p = t.insertRight(hizhiz, "Zeus");
        Position<String> piz = t.insertLeft(p, "Atenea");
        p2 = t.insertRight(p, "Ares");
        return t;
    }

    /**
     * Test of antecesors method, of class Parcial1.
     */
    @Test
    public void testAntecesors() {
        System.out.println("antecesors");
       System.out.println("antecesors");
        List<String> expResult = new ArrayList<>();
        expResult.addAll(Arrays.asList("Zeus", "Cronos", "Nix", "Caos")) ;
        Tree<String> tree = iniciaTree();
        List<String> result = antecesors(tree,prueba);
        
        
        assertEquals(expResult.toString(), result.toString());
    }

    /**
     * Test of degree method, of class Parcial1.
     */
    @Test
    public void testDegree() {
        System.out.println("degree");
        
        Tree<String> tree = iniciaTree();
        int expResult = 4;
        int result = degree(tree);
        assertEquals(expResult, result);
    }

    
    /**
     * Test of isIsogram method, of class Parcial1.
     */
    @Test
    public void testIsIsogram() {
        System.out.println("isIsogram");
        String word = "caracter";
        boolean result = isIsogram(word);
        assertFalse(result);
        word = "otra";
        assertTrue(isIsogram(word));
    }
    
}
