// src/main/java/com/parcial/handler/GerenteRRHH.java
package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class GerenteRRHH extends Encargado {
    public GerenteRRHH(String nombre, String email, String numeroLegajo, Animo animo) {
        super(nombre, email, numeroLegajo, animo);
    }
    
        @Override
    protected boolean puedeManejar(Excusa excusa) {
        return excusa.esCompleja();
    }

   
}