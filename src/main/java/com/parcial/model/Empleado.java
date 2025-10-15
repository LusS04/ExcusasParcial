package com.parcial.model;

public class Empleado {
    protected String nombre;
    protected String email;
    protected String numeroLegajo;
    

    public Empleado(String nombre, String email, String numeroLegajo) {
        this.nombre = nombre;
        this.email = email;
        this.numeroLegajo = numeroLegajo;
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public String getNumeroLegajo() {
        return numeroLegajo;
    }
}