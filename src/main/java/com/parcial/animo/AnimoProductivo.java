package com.parcial.animo;

import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class AnimoProductivo implements Animo {
    @Override
    public void procesar(Excusa excusa, Encargado encargado) {
        if (encargado.puedeManejar(excusa)) {
            encargado.procesarSolicitud(excusa);
        } else {
            encargado.getEmailSender().enviarEmail(
                "cto@excusas.sa",
                encargado.getEmail(),
                "EXCUSA DERIVADA",
                "El encargado " + encargado.getNombre() + " derivó una excusa."
            );
            encargado.pasarAlSiguiente(excusa);
        }
    }
}