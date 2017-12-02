package com.hello.ws;

import javax.xml.ws.Endpoint;

public class Seveur {
    public static void main(String[] args) {
        System.out.println("Démarrage du Serveur Soap ...");
        GestionPersonneImpl gestionPersonne = new GestionPersonneImpl();
        Endpoint.publish("http://localhost:8080/ws/hello", gestionPersonne);
    }
}
