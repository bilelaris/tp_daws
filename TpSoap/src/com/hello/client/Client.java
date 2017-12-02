package com.hello.client;

import com.hello.api.GestionPersonne;
import com.hello.api.ListPerson;
import com.hello.api.Person;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.URL;
import java.util.Scanner;

public class Client {
    private static final String ENDPOINT = "http://localhost:8080/ws/hello?wsdl";
    private static final QName QNAME = new QName("http://ws.hello.com/", "GestionPersonneImplService");

    public static void main(String[] args) throws Exception {

        Service service = Service.create(new URL(ENDPOINT), QNAME);
        GestionPersonne gestionPersonne = service.getPort(GestionPersonne.class);

        Scanner scan = new Scanner(System.in);

        boolean loop = true;
        while (loop) {
            showUsage();
            switch (scan.nextInt()) {
                case 1:
                    addPerson(gestionPersonne, scan);
                    break;
                case 2:
                    removePerson(gestionPersonne, scan);
                    break;
                case 3:
                    showPerson(gestionPersonne, scan);
                    break;
                case 4:
                    listPersons(gestionPersonne);
                    break;
                case 5:
                    loop = false;
            }
        }
        System.out.println("Bye !");
    }

    private static void removePerson(GestionPersonne gestionPersonne, Scanner scan) {
        System.out.println("Id ?: ");
        gestionPersonne.removePersonById(scan.nextInt());
    }

    private static void listPersons(GestionPersonne gestionPersonne) {
        ListPerson personnes = gestionPersonne.getListPerson();
        System.out.println(personnes.getPersonnes());
    }

    private static void showPerson(GestionPersonne gestionPersonne, Scanner scan) {
        System.out.println("Id ?: ");
        Person personne = gestionPersonne.getPersonById(scan.nextInt());
        System.out.println(personne);
    }

    private static void addPerson(GestionPersonne gestionPersonne, Scanner scan) {
        System.out.println("Id ?: ");
        Integer id = scan.nextInt();
        System.out.println("Nom ?: ");
        String nom = scan.next();
        System.out.println("Prénom ?: ");
        String prenom = scan.next();
        gestionPersonne.addPerson(new Person(id, nom, prenom));
    }

    private static void showUsage() {
        System.out.println("1- Ajouter une personne");
        System.out.println("2- Supprimer personne");
        System.out.println("3- Afficher personne");
        System.out.println("4- Afficher la liste des personnes");
        System.out.println("5- Quitter");
    }
}
