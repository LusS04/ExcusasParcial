package com.parcial.handler;

import com.parcial.animo.AnimoNormal;
import com.parcial.builder.CadenaDeMandoBuilder;
import com.parcial.excusas.ExcusaModerada;
import com.parcial.excusas.ExcusaTrivial;
import com.parcial.model.Empleado;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.service.MockEmailSender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ChainTest {

    private MockEmailSender mockSender;
    private Encargado cadenaDeMando;
    private Empleado empleado;

    @BeforeEach
    void setUp() {
        mockSender = new MockEmailSender();
        empleado = new Empleado("Juan Perez", "juan.perez@mail.com", "JP-5544");
        
    
        cadenaDeMando = new CadenaDeMandoBuilder(mockSender)
                .agregar(new Recepcionista("Ana", "ana@excusas.sa", "123", new AnimoNormal(), mockSender))
                .agregar(new Supervisor("Bruno", "bruno@excusas.sa", "456", new AnimoNormal(), mockSender))
                .construir(); 
    }

    @Test
    @DisplayName("Recepcionista debe procesar ExcusaTrivial y enviar email")
    void testRecepcionistaManejaTrivial() {
        Excusa excusa = new ExcusaTrivial(empleado, "Me quedé dormido");
        cadenaDeMando.manejarExcusa(excusa);

        assertEquals(1, mockSender.getTotalEmailsEnviados());
        assertEquals("juan.perez@mail.com", mockSender.getUltimoEmailEnviado().destino);
        assertEquals("la licencia fue aceptada", mockSender.getUltimoEmailEnviado().cuerpo);
    }

    @Test
    @DisplayName("Recepcionista debe pasar ExcusaModerada a Supervisor")
    void testRecepcionistaPasaModerada() {
        Excusa excusa = new ExcusaModerada(empleado, "Corte de luz");
        cadenaDeMando.manejarExcusa(excusa);

        assertEquals(1, mockSender.getTotalEmailsEnviados());
        assertNotEquals("la licencia fue aceptada", mockSender.getUltimoEmailEnviado().cuerpo);
        assertEquals("juan.perez@mail.com", mockSender.getUltimoEmailEnviado().destino);
    }
    
}