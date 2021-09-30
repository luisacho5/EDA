/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author mayte
 */

public class ComplexNumber {
    
    
    /**
     * Constructor of the ComplexNumber
     * @param a real part
     * @param b imaginary part
     */
    
    private double a;
    private double b;
    
    ComplexNumber(double a, double b){
        this.a=a;
        this.b=b;
    }
    
    /**
     * 
     * @return the real part of the ComplexNumber
     */
    public double realPart(){
       return a;
    }
    
    /**
     * 
     * @return the imaginary part of the ComplexNumber
     */
    public double imaginaryPart(){
       return b;
    }
    
    /**
     * Adds c to the ComplexNumber
     * 
     * @param c
     *        number to add
     * @return 
     *        this + c
     */
    public ComplexNumber add (ComplexNumber c){
        return new ComplexNumber(this.realPart()+c.realPart(),this.imaginaryPart()+c.imaginaryPart());
    }
    
    /**
     * Returns the result of subtracting c from the ComplexNumber
     * 
     * @param c
     *        subtracting
     * @return 
     *        this - c
     */
    public ComplexNumber subtract (ComplexNumber c){
        return new ComplexNumber(this.realPart()-c.realPart(),this.imaginaryPart()-c.imaginaryPart());
    }
    
    /**
     * Returns multiplication of c and the ComplexNumber
     * 
     * @param c
     *        multiplying
     * @return 
     *          this * c2
     */
    public ComplexNumber multiply (ComplexNumber c){
        double preal=this.a*c.realPart()-this.b*c.imaginaryPart();
        double pimaginaria=this.b*c.realPart()+this.a*c.imaginaryPart();
        ComplexNumber aux= new ComplexNumber(preal,pimaginaria);
        return aux;

    }
    
   /**
     * Returns the division of the ComplexNumber by c 
     *
     * @param c
     *        divider
     * @return 
     *        this / c
     */
    public ComplexNumber division (ComplexNumber c){
        double preal=(this.a*c.realPart()+this.b*c.imaginaryPart())/(c.realPart()*c.realPart()+c.imaginaryPart()*c.imaginaryPart());
        double pimaginaria=(this.b*c.realPart()-this.a*c.imaginaryPart())/(c.realPart()*c.realPart()+c.imaginaryPart()*c.imaginaryPart());
        ComplexNumber aux= new ComplexNumber(preal,pimaginaria);
        return aux;
    } 
    
    /**
     * Returns the conjugate of the ComplexNumber
     * 
     * @return 
     *        a - ib
     */
    public ComplexNumber conjugate (){
        return new ComplexNumber(this.a,-this.b);

    } 
    
    /**
     * Returns the module of the ComplexNumber
     * 
     * @return 
     *      sqrt (a² + b²)
     */
    public double module (){
        return Math.sqrt(Math.pow(this.a,2)+Math.pow(this.b,2));

    } 
}
