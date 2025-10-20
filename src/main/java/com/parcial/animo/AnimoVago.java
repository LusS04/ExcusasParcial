package com.parcial.animo;

import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class AnimoVago implements Animo {
    @Override
    public void procesar(Excusa excusa, Encargado encargado) {
        System.out.println("El encargado " + encargado.getNombre() + " es vago y no procesa la excusa.");
        encargado.pasarAlSiguiente(excusa);
    }
}