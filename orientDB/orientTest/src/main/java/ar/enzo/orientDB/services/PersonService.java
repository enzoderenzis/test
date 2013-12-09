package ar.enzo.orientDB.services;

import java.util.List;

import javax.jws.WebService;

import ar.enzo.orientDB.entity.Person;

@WebService(name = "personServiceJAXWS")
public interface PersonService {

    void addPerson(Person person);

    List<Person> findAll();

    void delete(Person person);

}
