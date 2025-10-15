package com.parcial.excusas;
import com.parcial.model.Empleado;
import com.parcial.model.Excusa;

public class ExcusaTrivial extends Excusa {

    public ExcusaTrivial(Empleado empleado, String descripcion) {
        super(empleado, descripcion);
    }

    @Override
    public boolean esTrivial() {
        return true;
    }

}
