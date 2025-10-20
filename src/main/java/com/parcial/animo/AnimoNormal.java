package com.parcial.animo;

import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class AnimoNormal implements Animo {
    @Override
    public void procesar(Excusa excusa, Encargado encargado) {
        if (encargado.puedeManejar(excusa)) {
            encargado.procesarSolicitud(excusa);
        } else {
            encargado.pasarAlSiguiente(excusa);
        }
    }
}