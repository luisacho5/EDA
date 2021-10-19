/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3_ejercicio;

import java.util.HashMap;

/**
 *
 * @author luiss
 */
public class Tema3_ejercicio {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        HashMap<Alumno,Float> mapa= new HashMap<Alumno,Float>();
        Alumno a1= new Alumno("Luis","Sanchez Rebollo","50327811N");
        Alumno a2= new Alumno("Paco","Sanz García","50235260J");
        Alumno a3= new Alumno("Antonio","Gomez Redruello","50263470T");
        Alumno a4= new Alumno("Lucia","Varadé Bohueles","50244220H");
        Alumno a5= new Alumno("Luis","Sanchez Rebollo","50327811N");
        mapa.put(a1, new Float(10.0));
        mapa.put(a2, new Float(7.3));
        mapa.put(a3, new Float(6.8));
        mapa.put(a4, new Float(3.4));
        mapa.put(a5, new Float(1.4));//metemos el mismo alumno a pesar de ser otro objeto en consecuencia se cambia la nota.
        
    }
    
}
