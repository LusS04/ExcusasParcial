package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.model.Prontuario;
import com.parcial.observer.ProntuarioObserver;

public class CEO extends Encargado implements ProntuarioObserver {

    public CEO(String nombre, String email, String numeroLegajo, Animo animo) {
        super(nombre, email, numeroLegajo, animo);
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        // Lógica para enviar email a todos los CEOs
    }

        @Override
    protected boolean puedeManejar(Excusa excusa) {
        return excusa.esInverosimil();
    }

    
}