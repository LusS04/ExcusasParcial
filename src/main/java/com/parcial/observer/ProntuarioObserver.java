// src/main/java/com/parcial/observer/ProntuarioObserver.java
package com.parcial.observer;

import com.parcial.model.Prontuario;

public interface ProntuarioObserver {
    void actualizar(Prontuario prontuario);
}