// src/main/java/com/parcial/service/AdministradorDeProntuarios.java
package com.parcial.service;

import com.parcial.model.Prontuario;
import com.parcial.observer.ProntuarioObserver;

import java.util.ArrayList;
import java.util.List;

public class AdministradorDeProntuarios {
    // Singleton
    private static AdministradorDeProntuarios instancia;
    
    // Atributos
    private List<Prontuario> prontuarios;
    private List<ProntuarioObserver> observadores; // Subject (Observer)

    private AdministradorDeProntuarios() {
        this.prontuarios = new ArrayList<>();
        this.observadores = new ArrayList<>();
    }

    public static synchronized AdministradorDeProntuarios getInstancia() {
        if (instancia == null) {
            instancia = new AdministradorDeProntuarios();
        }
        return instancia;
    }

    // Métodos del Subject
    public void agregarObservador(ProntuarioObserver observador) {
        this.observadores.add(observador);
    }

    public void notificarObservadores(Prontuario prontuario) {
        for (ProntuarioObserver observador : observadores) {
            observador.actualizar(prontuario);
        }
    }

    // Lógica del administrador
    public void agregarProntuario(Prontuario prontuario) {
        this.prontuarios.add(prontuario);
        notificarObservadores(prontuario);
    }
}