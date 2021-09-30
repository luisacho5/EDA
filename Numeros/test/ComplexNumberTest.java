/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author l.sanchezr.2018
 */
public class ComplexNumberTest {
    
    

    /**
     * Test of realPart method, of class ComplexNumber.
     */
    @Test
    public void testRealPart() {
        System.out.println("realPart");
        ComplexNumber instance = new ComplexNumber(2.3,5);
        double expResult = 2.3;
        double result = instance.realPart();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of imaginaryPart method, of class ComplexNumber.
     */
    @Test
    public void testImaginaryPart() {
        System.out.println("imaginaryPart");
        ComplexNumber instance = new ComplexNumber(4.2,9.1);
        double expResult = 9.1;
        double result = instance.imaginaryPart();
        assertEquals(expResult, result, 0.01);
    }

    /**
     * Test of add method, of class ComplexNumber.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        ComplexNumber c = new ComplexNumber(3,-4);
        ComplexNumber instance = new ComplexNumber(2,7);
        ComplexNumber expResult = new ComplexNumber(3+2,-4+7);
        ComplexNumber result = instance.add(c);
        assertEquals(expResult.imaginaryPart(), result.imaginaryPart(),0.01);
        assertEquals(expResult.realPart(), result.realPart(),0.01);
    }

    /**
     * Test of subtract method, of class ComplexNumber.
     */
    @Test
    public void testSubtract() {
        System.out.println("subtract");
        ComplexNumber c = new ComplexNumber(3,-4);
        ComplexNumber instance = new ComplexNumber(2,7);
        ComplexNumber expResult = new ComplexNumber(2-3,7+4);
        ComplexNumber result = instance.subtract(c);
        assertEquals(expResult.imaginaryPart(), result.imaginaryPart(),0.01);
        assertEquals(expResult.realPart(), result.realPart(),0.01);
    }

    /**
     * Test of multiply method, of class ComplexNumber.
     */
    @Test
    public void testMultiply() {
        System.out.println("multiply");
        ComplexNumber c = new ComplexNumber(3,-4);
        ComplexNumber instance = new ComplexNumber(2,7);
        ComplexNumber expResult = new ComplexNumber((2*3)-(-4*7),(-4*2)+(3*7));
        ComplexNumber result = instance.multiply(c);
        assertEquals(expResult.imaginaryPart(), result.imaginaryPart(),0.01);
        assertEquals(expResult.realPart(), result.realPart(),0.01);
    }

    /**
     * Test of division method, of class ComplexNumber.
     */
    @Test
    public void testDivision() {
        System.out.println("divide");
        ComplexNumber c = new ComplexNumber(13,1);
        ComplexNumber instance = new ComplexNumber(1,-3);
        ComplexNumber expResult = new ComplexNumber(1,4);
        ComplexNumber result = c.division(instance);
        assertEquals(expResult.imaginaryPart(), result.imaginaryPart(),0.01);
        assertEquals(expResult.realPart(), result.realPart(),0.01);
    }

    /**
     * Test of conjugate method, of class ComplexNumber.
     */
    @Test
    public void testConjugate() {
        System.out.println("conjugate");
        ComplexNumber c = new ComplexNumber(8,-2);
        ComplexNumber expResult = new ComplexNumber(8,2);
        ComplexNumber result = c.conjugate();
        assertEquals(expResult.imaginaryPart(), result.imaginaryPart(),0.01);
        assertEquals(expResult.realPart(), result.realPart(),0.01);
    }

    /**
     * Test of module method, of class ComplexNumber.
     */
    @Test
    public void testModule() {
        System.out.println("module");
        ComplexNumber instance = new ComplexNumber(4,-3);
        double expResult = 5.0;
        double result = instance.module();
        assertEquals(expResult, result, 0.0);
    }
    
}
