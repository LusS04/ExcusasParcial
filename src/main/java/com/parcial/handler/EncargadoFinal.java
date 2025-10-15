package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class EncargadoFinal extends Encargado {

    public EncargadoFinal(String nombre, String email, String numeroLegajo, Animo animo) {
        super(nombre, email, numeroLegajo, animo);
    }
    
    @Override
    protected boolean puedeManejar(Excusa excusa) {
        return true;
    }

    @Override
    public void manejar(Excusa excusa) {
        System.out.println("Nadie más puede manejar la excusa. Se da por rechazada.");
    }

    
}