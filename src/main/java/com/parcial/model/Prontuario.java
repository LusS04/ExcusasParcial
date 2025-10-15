package com.parcial.model;

public class Prontuario {
    private Empleado empleado;
    private Excusa excusa;
    private String numeroLegajo;

    public Prontuario(Empleado empleado, Excusa excusa) {
        this.empleado = empleado;
        this.excusa = excusa;
        this.numeroLegajo = empleado.getNumeroLegajo();
    }
}