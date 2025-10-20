package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.service.EmailSender;

public class Recepcionista extends Encargado {

    public Recepcionista(String nombre, String email, String numeroLegajo, Animo animo, EmailSender emailSender) {
        super(nombre, email, numeroLegajo, animo, emailSender);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.esTrivial();
    }

    @Override
    public void procesarSolicitud(Excusa excusa) {
        emailSender.enviarEmail(
            excusa.getEmpleado().getEmail(),
            this.email,
            "motivo demora",
            "la licencia fue aceptada"
        );
    }
}