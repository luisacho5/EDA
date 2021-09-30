

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author mayte
 */
public class LinkedListTest {
    
    public LinkedListTest() {
    }
    
    
    public LinkedList inicializa(){
       
        LinkedList instance = new LinkedList();
        
        instance.add(new Float(3));
        instance.add(new Float(8));
        instance.add(new Float(12));
        
        return instance; //[12, 8, 3]
    }
    /**
     * Test of size method, of class LinkedList.
     */
    @Test
    public void testSize() {
        System.out.println("size");
        LinkedList instance = inicializa();
              
        int expResult = 3;
        int result = instance.size();
        assertEquals(expResult, result);
    }

    /**
     * Test of isempty method, of class LinkedList.
     */
    @Test
    public void testIsempty1() {
        System.out.println("isempty");
        LinkedList instance = inicializa();
        boolean expResult = false;
        boolean result = instance.isempty();
        assertEquals(expResult, result);
       
    }

    /**
     * Test of isempty method, of class LinkedList.
     */
    @Test
    public void testIsempty2() {
        System.out.println("isempty");
        LinkedList instance = new LinkedList();
        boolean expResult = true;
        boolean result = instance.isempty();
        assertEquals(expResult, result);
       
    }
    
    /**
     * Test of add method, of class LinkedList.
     */
    @Test
    public void testAdd_Float() {
        System.out.println("add");
        Float value = null;
        LinkedList instance = new LinkedList();
        assertTrue(instance.isempty());
        instance.add(new Float(2));
        assertFalse(instance.isempty());
        assertEquals(instance.size(),1);
    }

    /**
     * Test of add and remove methods, of class LinkedList.
     */
    @Test
    public void testAdd_int_Remove() {
        System.out.println("add");
        int index = 3;
        Float value = new Float(5);
        LinkedList instance = inicializa(); // [12, 8, 3]
        instance.add(index, value); // [12, 8, 5, 3]
        assertEquals(instance.size(),4);
        Float remove = (Float) instance.remove();
        assertEquals(12.0,remove,0.01);
        remove = (Float) instance.remove();
        assertEquals(8.0,remove,0.01);
        remove = (Float) instance.remove();
        assertEquals(5.0,remove,0.01);
        remove = (Float) instance.remove();
        assertEquals(3.0,remove,0.01);
        assertTrue(instance.isempty());
    }

    /**
     * Test of remove method, of class LinkedList.
     */
    @Test
    public void testRemove_int() {
        System.out.println("remove");
        int index = 2;
        LinkedList instance = inicializa(); // [12, 8, 3]
        Float result = (Float) instance.remove(index);// 8
        assertEquals(8.0, result,0.01);
       
    }

    /**
     * Test of get method, of class LinkedList.
     */
    @Test
    public void testGet_0args() {
        System.out.println("get");
        LinkedList instance = inicializa(); // [12, 8, 3]
        Float result = (Float) instance.get();//12
        assertEquals(12.0, result,0.01);
        
    }

    /**
     * Test of get method, of class LinkedList.
     */
    @Test
    public void testGet_int() {
        System.out.println("get");
        int index = 2;
        LinkedList instance = inicializa(); // [12, 8, 3]
        Float result = (Float) instance.get(index);// 8
        assertEquals(8.0, result,0.01);
       
    }

    /**
     * Test of search method, of class LinkedList.
     */
    @Test
    public void testSearch() {
        System.out.println("search");
        Float value = new Float(5);
        LinkedList instance = inicializa();// [12, 8, 3]
        int expResult = 0;
        int result = instance.search(value);
        assertEquals(expResult, result);
        value = new Float(3);
        expResult = 3;
        result = instance.search(value);
        assertEquals(expResult, result);
    }

    /**
     * Test of contains method, of class LinkedList.
     */
    @Test
    public void testContains() {
        System.out.println("contains");
        Float value = new Float(5);
        LinkedList instance = inicializa();// [12, 8, 3]
        boolean result = instance.contains(value);
        assertFalse(result);
        value = new Float(12);
        result = instance.contains(value);
        assertTrue(result);
    }
    
}
