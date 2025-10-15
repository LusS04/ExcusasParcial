package com.parcial;

import com.parcial.animo.AnimoNormal;
import com.parcial.animo.AnimoProductivo;
import com.parcial.animo.AnimoVago;
import com.parcial.builder.CadenaDeMandoBuilder;
import com.parcial.excusas.ExcusaCompleja;
import com.parcial.excusas.ExcusaInverosimil;
import com.parcial.excusas.ExcusaModerada;
import com.parcial.excusas.ExcusaTrivial;
import com.parcial.handler.CEO;
import com.parcial.model.Encargado;
import com.parcial.handler.GerenteRRHH;
import com.parcial.handler.Recepcionista;
import com.parcial.handler.Supervisor;
import com.parcial.model.Empleado;
import com.parcial.model.Excusa;

public class Main {

    public static void main(String[] args) {

        // --- 1. Creación del Empleado y las Excusas ---
        System.out.println("Preparando el entorno de prueba...");
        Empleado empleadoTardio = new Empleado("Juan Perez", "juan.perez@mail.com", "JP-5544");

        Excusa excusaTrivial = new ExcusaTrivial(empleadoTardio, "Me quedé dormido, sonó tarde el despertador.");
        Excusa excusaModerada = new ExcusaModerada(empleadoTardio, "Hubo un corte de luz general en todo el barrio.");
        Excusa excusaCompleja = new ExcusaCompleja(empleadoTardio, "Una paloma mensajera robó las llaves de mi auto.");
        Excusa excusaInverosimil = new ExcusaInverosimil(empleadoTardio, "Fui abducido brevemente por una nave espacial.");
        
        // --- 2. Creación de los Encargados con Ánimos Variados ---
        Recepcionista recepcionista = new Recepcionista("Ana", "ana@excusas.sa", "123", new AnimoNormal());
        Supervisor supervisor = new Supervisor("Bruno", "bruno@excusas.sa", "456", new AnimoProductivo());
        GerenteRRHH gerente = new GerenteRRHH("Carla", "carla@excusas.sa", "789", new AnimoVago());
        CEO ceo = new CEO("Diana", "diana@excusas.sa", "001", new AnimoNormal());

        // --- 3. Construcción de la Cadena de Mando ---
        CadenaDeMandoBuilder builder = new CadenaDeMandoBuilder();

        Encargado cadenaDeMando = builder
            .agregar(recepcionista)
            .agregar(supervisor)
            .agregar(gerente)
            .agregar(ceo)
            .construir();
        
        System.out.println("Cadena de mando construida. Iniciando prueba...");
        System.out.println("==============================================");


        // --- 4. EJECUCIÓN DE LA PRUEBA ---
        //
        //       ↓↓↓ CAMBIA ESTA VARIABLE PARA PROBAR OTRA EXCUSA ↓↓↓
        Excusa excusaActual = excusaCompleja;
        //
        System.out.println("Procesando excusa: \"" + excusaActual.getDescripcion() + "\"");
        System.out.println("----------------------------------------------");
        
        cadenaDeMando.manejarExcusa(excusaActual);
        
        System.out.println("==============================================");
        System.out.println("Prueba finalizada.");
    }
}