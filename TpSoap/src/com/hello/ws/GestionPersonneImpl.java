package com.hello.ws;

import com.hello.api.GestionPersonne;
import com.hello.api.ListPerson;
import com.hello.api.Person;

import java.util.*;
import javax.jws.WebService;

@WebService(endpointInterface = "com.hello.api.GestionPersonne")
public class GestionPersonneImpl implements GestionPersonne {

    private ArrayList<Person> personnes = new ArrayList<>();

    @Override
    public void addPerson(Person p) {
        removePersonById(p.getId());
        personnes.add(p);
    }

    @Override
    public void removePersonById(int id) {
        int idx = -1;
        for (Person peronne : personnes) {
            if (peronne.getId() == id) {
                idx = personnes.indexOf(peronne);
            }
        }
        if (idx > -1) {
            personnes.remove(idx);
        }
    }

    @Override
    public Person getPersonById(int id) {
        for (Person peronne : personnes) {
            if (peronne.getId() == id) {
                return peronne;
            }
        }
        return null;
    }

    @Override
    public ListPerson getListPerson() {
        // ListPerson est un warpper
        ListPerson listPerson = new ListPerson();
        listPerson.setPersonnes(personnes);
        return listPerson;
    }
}
