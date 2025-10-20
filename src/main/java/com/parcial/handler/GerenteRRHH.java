package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.service.EmailSender;

public class GerenteRRHH extends Encargado {
    public GerenteRRHH(String nombre, String email, String numeroLegajo, Animo animo, EmailSender emailSender) {
        super(nombre, email, numeroLegajo, animo, emailSender);
    }
    
    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.esCompleja();
    }

    @Override
    public void procesarSolicitud(Excusa excusa) {
        System.out.println("Gerente RRHH: Procesando excusa compleja para " + excusa.getEmpleado().getNombre());
    }
}