package com.parcial.observer;

import com.parcial.animo.AnimoNormal;
import com.parcial.excusas.ExcusaInverosimil;
import com.parcial.handler.CEO;
import com.parcial.model.Empleado;
import com.parcial.service.AdministradorDeProntuarios;
import com.parcial.service.MockEmailSender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ObserverTest {

    private MockEmailSender mockSenderDiana;
    private MockEmailSender mockSenderDavid;
    private CEO ceoDiana; // Estará en la cadena
    private CEO ceoDavid; // Solo será observador
    private AdministradorDeProntuarios admin;
    private Empleado empleado;
    private ExcusaInverosimil excusa;

    @BeforeEach
    void setUp() {
        mockSenderDiana = new MockEmailSender();
        mockSenderDavid = new MockEmailSender();
        empleado = new Empleado("Juan Perez", "juan.perez@mail.com", "JP-5544");
        excusa = new ExcusaInverosimil(empleado, "Fui abducido");

        ceoDiana = new CEO("Diana", "diana@excusas.sa", "001", new AnimoNormal(), mockSenderDiana);
        ceoDavid = new CEO("David", "david@excusas.sa", "002", new AnimoNormal(), mockSenderDavid);

        admin = AdministradorDeProntuarios.getInstancia();
        // Limpiamos observadores de tests anteriores (aunque el singleton es difícil de limpiar)
        // Idealmente, el admin tendría un método .clearObservadores() para tests.
        
        admin.agregarObservador(ceoDiana);
        admin.agregarObservador(ceoDavid);
    }

    @Test
    @DisplayName("CEO procesa excusa, crea prontuario y notifica a TODOS los CEOs")
    void testCEOProcesaYNotificaObservadores() {
        // El CEO procesa la excusa (no necesita la cadena, él es el handler)
        ceoDiana.manejarExcusa(excusa);

        // --- Verificamos a ceoDiana (la que procesó) ---
        // 1. Verificamos que envió el email de "Aprobado por creatividad" al empleado
        assertTrue(mockSenderDiana.seEnvioEmailA("juan.perez@mail.com"));
        // 2. Verificamos que se auto-notificó como observadora
        assertTrue(mockSenderDiana.seEnvioEmailA("diana@excusas.sa"));
        assertEquals(2, mockSenderDiana.getTotalEmailsEnviados());
        
        // --- Verificamos a ceoDavid (el que solo observaba) ---
        // 1. Verificamos que recibió la notificación
        assertEquals(1, mockSenderDavid.getTotalEmailsEnviados());
        assertEquals("david@excusas.sa", mockSenderDavid.getUltimoEmailEnviado().destino);
        assertEquals("Notificación: Nuevo Prontuario Registrado", mockSenderDavid.getUltimoEmailEnviado().asunto);
    }
}