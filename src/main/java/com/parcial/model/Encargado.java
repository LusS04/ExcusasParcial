package com.parcial.model;

import com.parcial.animo.Animo;
import com.parcial.service.EmailSender;

public abstract class Encargado {
    protected Encargado sucesor;
    protected String nombre;
    protected String email;
    protected String numeroLegajo;
    protected Animo animo;
    protected EmailSender emailSender;

    public Encargado(String nombre, String email, String numeroLegajo, Animo animo, EmailSender emailSender) {
        this.nombre = nombre;
        this.email = email;
        this.numeroLegajo = numeroLegajo;
        this.animo = animo;
        this.emailSender = emailSender;
    }

    public void manejarExcusa(Excusa excusa) {
        animo.procesar(excusa, this);
    }

    public abstract boolean puedeManejar(Excusa excusa);

    public abstract void procesarSolicitud(Excusa excusa);

    public void setSucesor(Encargado sucesor) {
        this.sucesor = sucesor;
    }

    public void pasarAlSiguiente(Excusa excusa) {
        if (this.sucesor != null) {
            this.sucesor.manejarExcusa(excusa);
        }
    }

    public String getNombre() {
        return nombre;
    }

    public String getEmail() {
        return email;
    }

    public EmailSender getEmailSender() {
        return emailSender;
    }
}