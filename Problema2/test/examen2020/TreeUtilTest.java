package examen2020;

import java.util.Iterator;
import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;
import material.Position;
import material.tree.binarytree.BinaryTree;
import material.tree.binarytree.LinkedBinaryTree;
import material.tree.narytree.NAryTree;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author jvelez
 */
public class TreeUtilTest {
    
    /**
     * Test of generate method, of class TreeUtil.
     */
    @Test
    public void testGenerate() {
        System.out.println("generate");

        LinkedBinaryTree<String> btree = new LinkedBinaryTree<>();
        Position<String> p = btree.addRoot("+");
        btree.insertLeft(p, "2");
        Position<String> h = btree.insertRight(p, "*");
        btree.insertLeft(h, "3");
        Position<String> n5 = btree.insertRight(h, "5");
        assertFalse(btree.isLeaf(h));
        assertTrue(btree.isLeaf(n5));
                
        NAryTree <String> ntree = TreeUtil.generate(btree);
        
        assertEquals("+", ntree.root().getElement());
        
        Iterator<? extends Position<String>> children = ntree.children(ntree.root()).iterator();
        assertEquals("2", children.next().getElement());
        
        Position<String> child = children.next();
        assertEquals("*", child.getElement());
        
        Iterator<? extends Position<String>> children2 = ntree.children(child).iterator();
        assertEquals("3", children2.next().getElement());
        assertEquals("5", children2.next().getElement());
    }
    
}
