// src/main/java/com/parcial/animo/AnimoNormal.java
package com.parcial.animo;

import com.parcial.model.Encargado;
import com.parcial.model.Excusa;

public class AnimoNormal implements Animo {
    @Override
    public void procesar(Excusa excusa, Encargado encargado) {
        System.out.println("El encargado " + encargado.getNombre() + " maneja la excusa normalmente.");
    }
}