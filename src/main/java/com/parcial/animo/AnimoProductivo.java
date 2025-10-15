// src/main/java/com/parcial/animo/AnimoProductivo.java
package com.parcial.animo;

import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class AnimoProductivo implements Animo {
    @Override
    public void procesar(Excusa excusa, Encargado encargado) {
        System.out.println("El encargado " + encargado.getNombre() + " es productivo y maneja la excusa.");
    }
}