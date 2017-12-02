package com.hello.api;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;
import javax.jws.soap.SOAPBinding.Style;

@WebService
@SOAPBinding(style = Style.RPC)
public interface GestionPersonne {

    @WebMethod
    void addPerson(Person p);

    @WebMethod
    void removePersonById(int id);

    @WebMethod
    Person getPersonById(int id);

    @WebMethod
    ListPerson getListPerson();

}
