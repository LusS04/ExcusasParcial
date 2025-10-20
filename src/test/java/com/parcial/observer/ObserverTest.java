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
    private CEO ceoDiana; 
    private CEO ceoDavid; 
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
     
        
        admin.agregarObservador(ceoDiana);
        admin.agregarObservador(ceoDavid);
    }

    @Test
    @DisplayName("CEO procesa excusa, crea prontuario y notifica a TODOS los CEOs")
    void testCEOProcesaYNotificaObservadores() {
        ceoDiana.manejarExcusa(excusa);

        assertTrue(mockSenderDiana.seEnvioEmailA("juan.perez@mail.com"));
        
        assertTrue(mockSenderDiana.seEnvioEmailA("diana@excusas.sa"));
        assertEquals(2, mockSenderDiana.getTotalEmailsEnviados());
        
        assertEquals(1, mockSenderDavid.getTotalEmailsEnviados());
        assertEquals("david@excusas.sa", mockSenderDavid.getUltimoEmailEnviado().destino);
        assertEquals("Notificación: Nuevo Prontuario Registrado", mockSenderDavid.getUltimoEmailEnviado().asunto);
    }
}