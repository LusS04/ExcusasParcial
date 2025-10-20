package com.parcial;

import com.parcial.animo.Animo;
import com.parcial.animo.AnimoNormal;
import com.parcial.animo.AnimoProductivo;
import com.parcial.animo.AnimoVago;
import com.parcial.builder.CadenaDeMandoBuilder;
import com.parcial.excusas.ExcusaCompleja;
import com.parcial.excusas.ExcusaInverosimil;
import com.parcial.excusas.ExcusaModerada;
import com.parcial.excusas.ExcusaTrivial;
import com.parcial.handler.CEO;
import com.parcial.handler.GerenteRRHH;
import com.parcial.handler.Recepcionista;
import com.parcial.handler.Supervisor;
import com.parcial.model.Empleado;
import com.parcial.model.Encargado;
import com.parcial.model.Excusa;
import com.parcial.service.AdministradorDeProntuarios;
import com.parcial.service.EmailSender;
import com.parcial.service.EmailSenderImpl;

public class Main {

    public static void main(String[] args) {

        EmailSender sender = new EmailSenderImpl();
        AdministradorDeProntuarios admin = AdministradorDeProntuarios.getInstancia();

        Animo normal = new AnimoNormal();
        Animo vago = new AnimoVago();
        Animo productivo = new AnimoProductivo();

        Empleado empleado = new Empleado("Juan Perez", "juan.perez@mail.com", "JP-5544");

        Excusa excusaTrivial = new ExcusaTrivial(empleado, "Me quedé dormido.");
        Excusa excusaModerada = new ExcusaModerada(empleado, "Corte de luz en el barrio.");
        Excusa excusaCompleja = new ExcusaCompleja(empleado, "Una paloma robó las llaves de mi auto.");
        Excusa excusaInverosimil = new ExcusaInverosimil(empleado, "Fui abducido por aliens.");

        Recepcionista recepcionista = new Recepcionista("Ana (Recepcionista)", "ana@excusas.sa", "123", normal, sender);
        Supervisor supervisor = new Supervisor("Bruno (Supervisor)", "bruno@excusas.sa", "456", productivo, sender);
        GerenteRRHH gerente = new GerenteRRHH("Carla (Gerente)", "carla@excusas.sa", "789", vago, sender);
        CEO ceoDiana = new CEO("Diana (CEO)", "diana@excusas.sa", "001", normal, sender);
        CEO ceoDavid = new CEO("David (CEO Observador)", "david@excusas.sa", "002", normal, sender);

        admin.agregarObservador(ceoDiana);
        admin.agregarObservador(ceoDavid);

        CadenaDeMandoBuilder builder = new CadenaDeMandoBuilder(sender);
        Encargado cadenaDeMando = builder
                .agregar(recepcionista)
                .agregar(supervisor)
                .agregar(gerente)
                .agregar(ceoDiana)
                .construir();

        
        System.out.println("--- INICIO DE PRUEBAS ---");

        System.out.println("\n==============================================");
        System.out.println("CASO 1: EXCUSA TRIVIAL (Manejada por Recepcionista)");
        System.out.println("==============================================");
        cadenaDeMando.manejarExcusa(excusaTrivial);

        System.out.println("\n==============================================");
        System.out.println("CASO 2: EXCUSA MODERADA (Manejada por Supervisor Productivo)");
        System.out.println("==============================================");
        cadenaDeMando.manejarExcusa(excusaModerada);

        System.out.println("\n==============================================");
        System.out.println("CASO 3: EXCUSA COMPLEJA (Pasa por Supervisor Productivo y Gerente Vago)");
        System.out.println("==============================================");
        cadenaDeMando.manejarExcusa(excusaCompleja);

        System.out.println("\n==============================================");
        System.out.println("CASO 4: EXCUSA INVEROSIMIL (Prueba CEO y Observer)");
        System.out.println("==============================================");
        cadenaDeMando.manejarExcusa(excusaInverosimil);

        
        System.out.println("\n--- FIN DE PRUEBAS ---");
    }
}