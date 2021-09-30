/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejercicio3;

import java.util.Iterator;
import material.Position;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author luiss
 */
public class LinkedPositionListTest {
    
    public LinkedPositionListTest() {
    }
    
    public LinkedPositionList inicializa(){
       
        LinkedPositionList<Float> instance = new  LinkedPositionList();
        instance.add(new Float(3));
        instance.add(new Float(8));
        instance.add(new Float(12));
        
        return instance; //[12, 8, 3]
    }

    /**
     * Test of size method, of class LinkedPositionList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedPositionList instance = inicializa();      
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isempty method, of class LinkedPositionList.
     */
    @Test
    public void testIsempty() {
        System.out.println("isempty");
        LinkedPositionList instance = inicializa();
        boolean expResult = false;
        boolean result = instance.isempty();
        assertEquals(expResult, result);
    }

    /**
     * Test of add method, of class LinkedPositionList.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        Float value = null;
        LinkedPositionList instance = new LinkedPositionList();
        assertTrue(instance.isempty());
        instance.add(new Float(2));
        assertFalse(instance.isempty());
        assertEquals(instance.size(),1);
    }

    /**
     * Test of addAfter method, of class LinkedPositionList.
     */
    @Test
    public void testAddAfter() {
        System.out.println("add Before");
        Float value = new Float(5.5);
        LinkedPositionList instance = inicializa();
        instance.addAfter(null,value);
        assertFalse(instance.isempty());
        assertEquals(instance.size(),1);
    }

    /**
     * Test of addBefore method, of class LinkedPositionList.
     */
    @Test
    public void testAddBefore() {
        System.out.println("addBefore");
        Position pos = null;
        Object value = null;
        LinkedPositionList instance = new LinkedPositionList();
        Position expResult = null;
        Position result = instance.addBefore(pos, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of remove method, of class LinkedPositionList.
     */
    @Test
    public void testRemove() {
        System.out.println("remove");
        Position pos = null;
        LinkedPositionList instance = new LinkedPositionList();
        Object expResult = null;
        Object result = instance.remove(pos);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of get method, of class LinkedPositionList.
     */
    @Test
    public void testGet() {
        System.out.println("get");
        LinkedPositionList instance = new LinkedPositionList();
        Position expResult = null;
        Position result = instance.get();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of set method, of class LinkedPositionList.
     */
    @Test
    public void testSet() {
        System.out.println("set");
        Position pos = null;
        Object value = null;
        LinkedPositionList instance = new LinkedPositionList();
        Position expResult = null;
        Position result = instance.set(pos, value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of search method, of class LinkedPositionList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Object value = null;
        LinkedPositionList instance = new LinkedPositionList();
        Position expResult = null;
        Position result = instance.search(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of contains method, of class LinkedPositionList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Object value = null;
        LinkedPositionList instance = new LinkedPositionList();
        boolean expResult = false;
        boolean result = instance.contains(value);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of iterator method, of class LinkedPositionList.
     */
    @Test
    public void testIterator() {
        System.out.println("iterator");
        LinkedPositionList instance = new LinkedPositionList();
        Iterator expResult = null;
        Iterator result = instance.iterator();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
