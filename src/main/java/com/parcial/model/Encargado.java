// src/main/java/com/parcial/handler/Encargado.java
package com.parcial.model;

import com.parcial.animo.Animo;

abstract public class Encargado {
    private Encargado suceror;
    private String nombre;
    private String email;
    private String numeroLegajo;
    private Animo animo;

    public Encargado(String nombre, String email, String numeroLegajo, Animo animo) {
        this.nombre = nombre;
        this.email = email;
        this.numeroLegajo = numeroLegajo;
        this.animo = animo;
    }

    public void manejarExcusa(Excusa excusa) {
        if (this.puedeManejar(excusa)) {
            this.manejar(excusa);
        } else {
            this.suceror.manejarExcusa(excusa);
        }
    }

    public void setSucesor(Encargado sucesor) {
        this.suceror = sucesor;
    }

    public Encargado getSucesor() {
        return suceror;
    }

    public String getNombre() {
        return nombre;
    }

    protected abstract boolean puedeManejar(Excusa excusa);

    public void manejar(Excusa excusa) {
        System.out.println("Encargado: " + this.nombre + " maneja la excusa.");
        animo.procesar(excusa, this);
    }
}