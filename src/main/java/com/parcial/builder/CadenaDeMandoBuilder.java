package com.parcial.builder;

import com.parcial.animo.AnimoNormal;
import com.parcial.model.Encargado;
import com.parcial.handler.EncargadoFinal;

import java.util.ArrayList;
import java.util.List;

public class CadenaDeMandoBuilder {
    private List<Encargado> encargados = new ArrayList<>();

    public CadenaDeMandoBuilder agregar(Encargado encargado) {
        this.encargados.add(encargado);
        return this;
    }

    public Encargado construir() {
        this.encargados.add(new EncargadoFinal("Auditor Final", "audit@excusas.sa", "9999", new AnimoNormal()));

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