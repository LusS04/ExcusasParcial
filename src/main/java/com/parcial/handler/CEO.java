package com.parcial.handler;

import com.parcial.animo.Animo;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.model.Prontuario;
import com.parcial.observer.ProntuarioObserver;
import com.parcial.service.AdministradorDeProntuarios;
import com.parcial.service.EmailSender;

public class CEO extends Encargado implements ProntuarioObserver {

    public CEO(String nombre, String email, String numeroLegajo, Animo animo, EmailSender emailSender) {
        super(nombre, email, numeroLegajo, animo, emailSender);
    }

    @Override
    public boolean puedeManejar(Excusa excusa) {
        return excusa.esInverosimil();
    }

    @Override
    public void procesarSolicitud(Excusa excusa) {
        emailSender.enviarEmail(
            excusa.getEmpleado().getEmail(),
            this.email,
            "Respuesta a su solicitud de excusa",
            "Aprobado por creatividad"
        );

        Prontuario prontuario = new Prontuario(excusa.getEmpleado(), excusa);
        AdministradorDeProntuarios admin = AdministradorDeProntuarios.getInstancia();
        System.out.println("CEO " + this.nombre + ": Registrando nuevo prontuario...");
        admin.agregarProntuario(prontuario);
    }

    @Override
    public void actualizar(Prontuario prontuario) {
        System.out.println("CEO " + this.nombre + ": Recibí notificación de nuevo prontuario.");
        emailSender.enviarEmail(
            this.email,
            "sistema@excusas.sa",
            "Notificación: Nuevo Prontuario Registrado",
            "Se ha registrado un nuevo prontuario para el empleado: " + prontuario.getEmpleado().getNombre()
        );
    }
}