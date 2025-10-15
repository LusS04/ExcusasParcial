package com.parcial.excusas;
import com.parcial.model.Empleado;
import com.parcial.model.Excusa;

public class ExcusaCompleja extends Excusa {

    public ExcusaCompleja(Empleado empleado, String descripcion) {
        super(empleado, descripcion);
    }

    @Override
    public boolean esCompleja() {
        return true;
    }

}
