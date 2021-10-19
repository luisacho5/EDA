/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tema3_ejercicio;

import java.util.Objects;

/**
 *
 * @author luiss
 */
public class Alumno {
    private final String name;
    private final String apellidos;
    private final String dni;

    public Alumno(String name, String apellidos, String dni) {
        this.name = name;
        this.apellidos = apellidos;
        this.dni = dni;
    }

    public String getApellidos() {
        return apellidos;
    }
    
    public String getName() {
        return name;
    }

    public String getDni() {
        return dni;
    }   

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(this.name);
        hash = 37 * hash + Objects.hashCode(this.apellidos);
        hash = 37 * hash + Objects.hashCode(this.dni);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Alumno other = (Alumno) obj;
        if (!Objects.equals(this.name, other.name)) {
            return false;
        }
        if (!Objects.equals(this.apellidos, other.apellidos)) {
            return false;
        }
        if (!Objects.equals(this.dni, other.dni)) {
            return false;
        }
        return true;
    }
    
    
}
