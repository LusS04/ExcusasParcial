package com.parcial.service;

import java.util.ArrayList;
import java.util.List;

public class MockEmailSender implements EmailSender {

    private List<Email> emailsEnviados = new ArrayList<>();

    @Override
    public void enviarEmail(String unEmailDestino, String unEmailOrigen, String unAsunto, String unCuerpo) {
        System.out.println("MOCK SENDER: Email simulado para " + unEmailDestino);
        emailsEnviados.add(new Email(unEmailDestino, unEmailOrigen, unAsunto, unCuerpo));
    }

    // --- Métodos de Test ---
    public int getTotalEmailsEnviados() {
        return emailsEnviados.size();
    }

    public Email getUltimoEmailEnviado() {
        if (emailsEnviados.isEmpty()) {
            return null;
        }
        return emailsEnviados.get(emailsEnviados.size() - 1);
    }
    
    public boolean seEnvioEmailA(String destino) {
        return emailsEnviados.stream().anyMatch(email -> email.destino.equals(destino));
    }

    public void limpiar() {
        emailsEnviados.clear();
    }

    // Clase interna para guardar los datos
    public static class Email {
        public String destino, origen, asunto, cuerpo;
        public Email(String d, String o, String a, String c) {
            this.destino = d; this.origen = o; this.asunto = a; this.cuerpo = c;
        }
    }
}