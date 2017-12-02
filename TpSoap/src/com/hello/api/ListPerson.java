package com.hello.api;

import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;

@XmlRootElement
public class ListPerson {

    private ArrayList<Person> personnes;

    public ArrayList<Person> getPersonnes() {
        return personnes;
    }

    public void setPersonnes(ArrayList<Person> personnes) {
        this.personnes = personnes;
    }
}
