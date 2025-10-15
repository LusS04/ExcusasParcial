// src/main/java/com/parcial/handler/Supervisor.java
package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class Supervisor extends Encargado {
    public Supervisor(String nombre, String email, String numeroLegajo, Animo animo) {
        super(nombre, email, numeroLegajo, animo);
    }
    
    @Override
    protected boolean puedeManejar(Excusa excusa) {
        return excusa.esModerada();
    }


}