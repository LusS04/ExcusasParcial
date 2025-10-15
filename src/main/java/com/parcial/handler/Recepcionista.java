// src/main/java/com/parcial/handler/Recepcionista.java
package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class Recepcionista extends Encargado {
    public Recepcionista(String nombre, String email, String numeroLegajo, Animo animo) {
        super(nombre, email, numeroLegajo, animo);
    }

    @Override
    protected boolean puedeManejar(Excusa excusa) {
        return excusa.esTrivial();
    }


    
}