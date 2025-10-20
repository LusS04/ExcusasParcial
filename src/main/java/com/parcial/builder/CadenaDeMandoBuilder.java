package com.parcial.builder;

import com.parcial.animo.AnimoNormal;
import com.parcial.handler.EncargadoFinal;
import com.parcial.model.Encargado;
import com.parcial.service.EmailSender;

import java.util.ArrayList;
import java.util.List;

public class CadenaDeMandoBuilder {
    private List<Encargado> encargados = new ArrayList<>();
    private final EmailSender emailSender;

    public CadenaDeMandoBuilder(EmailSender emailSender) {
        this.emailSender = emailSender;
    }

    public CadenaDeMandoBuilder agregar(Encargado encargado) {
        this.encargados.add(encargado);
        return this;
    }

    public Encargado construir() {
        this.encargados.add(new EncargadoFinal(
            "Auditor Final",
            "audit@excusas.sa",
            "9999",
            new AnimoNormal(),
            this.emailSender
        ));

        for (int i = 0; i < encargados.size() - 1; i++) {
            encargados.get(i).setSucesor(encargados.get(i + 1));
        }

        return encargados.get(0);
    }

    public CadenaDeMandoBuilder clear() {
        this.encargados.clear();
        return this;
    }
}