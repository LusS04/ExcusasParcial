package com.parcial.animo;

import com.parcial.excusas.ExcusaCompleja;
import com.parcial.handler.CEO;
import com.parcial.handler.GerenteRRHH;
import com.parcial.handler.Supervisor;
import com.parcial.model.Empleado;
import com.parcial.service.MockEmailSender;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StrategyTest {

    private MockEmailSender mockSender;
    private Empleado empleado;
    private ExcusaCompleja excusaCompleja; 

    @BeforeEach
    void setUp() {
        mockSender = new MockEmailSender();
        empleado = new Empleado("Juan Perez", "juan.perez@mail.com", "JP-5544");
        excusaCompleja = new ExcusaCompleja(empleado, "Una paloma robó mi bicicleta");
    }

    @Test
    @DisplayName("AnimoVago debe saltar el procesamiento y pasar al siguiente")
    void testAnimoVagoSeSalteaLogica() {

        GerenteRRHH gerenteVago = new GerenteRRHH("Carla", "carla@excusas.sa", "789", new AnimoVago(), mockSender);
        CEO ceo = new CEO("Diana", "diana@excusas.sa", "001", new AnimoNormal(), mockSender);
        gerenteVago.setSucesor(ceo);
        
        gerenteVago.manejarExcusa(excusaCompleja);

 
        assertEquals(0, mockSender.getTotalEmailsEnviados());
    }

    @Test
    @DisplayName("AnimoProductivo debe enviar email al CTO al derivar")
    void testAnimoProductivoEnviaEmailCTO() {

        Supervisor supervisorProd = new Supervisor("Bruno", "bruno@excusas.sa", "456", new AnimoProductivo(), mockSender);
        GerenteRRHH gerente = new GerenteRRHH("Carla", "carla@excusas.sa", "789", new AnimoNormal(), mockSender);
        supervisorProd.setSucesor(gerente);

        supervisorProd.manejarExcusa(excusaCompleja);

 
        assertEquals(1, mockSender.getTotalEmailsEnviados());
        assertEquals("cto@excusas.sa", mockSender.getUltimoEmailEnviado().destino);
        assertEquals("EXCUSA DERIVADA", mockSender.getUltimoEmailEnviado().asunto);
    }
}