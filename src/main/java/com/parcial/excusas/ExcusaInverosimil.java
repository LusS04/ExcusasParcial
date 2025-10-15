package com.parcial.excusas;
import com.parcial.model.Empleado;
import com.parcial.model.Excusa;

public class ExcusaInverosimil extends Excusa {

    public ExcusaInverosimil(Empleado empleado, String descripcion) {
        super(empleado, descripcion);
    }

    @Override
    public boolean esInverosimil() {
        return true;
    }

}
