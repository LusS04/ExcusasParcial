package com.parcial.model;

public class Excusa {
    protected Empleado empleado;
    protected String descripcion; 

    protected Excusa(Empleado empleado, String descripcion) {
        this.empleado = empleado;
        this.descripcion = descripcion;
    }

    public String getDescripcion() {
        return descripcion;
    }
    
    //TIPOS DE EXCUSAS
    public boolean esTrivial() {
        return false;
    }

    public boolean esModerada() {
        return false;
    }

    public boolean esCompleja() {
        return false;
    }

    public boolean esInverosimil() {
        return false;
    }
}