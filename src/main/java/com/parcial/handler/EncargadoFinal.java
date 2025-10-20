package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.service.EmailSender;

public class EncargadoFinal extends Encargado {

    public EncargadoFinal(String nombre, String email, String numeroLegajo, Animo animo, EmailSender emailSender) {
        super(nombre, email, numeroLegajo, animo, emailSender);
    }
    
    @Override
    public boolean puedeManejar(Excusa excusa) {
        return true;
    }

    @Override
    public void procesarSolicitud(Excusa excusa) {
        System.out.println("Encargado Final: Excusa rechazada para " + excusa.getEmpleado().getNombre() + ": necesitamos pruebas contundentes.");
    }
}