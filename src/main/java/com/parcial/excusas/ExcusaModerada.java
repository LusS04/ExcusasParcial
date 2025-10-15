package com.parcial.excusas;
import com.parcial.model.Empleado;
import com.parcial.model.Excusa;

public class ExcusaModerada extends Excusa {

    public ExcusaModerada(Empleado empleado, String descripcion) {
        super(empleado, descripcion);
    }

    @Override
    public boolean esModerada() {
        return true;
    }

}
