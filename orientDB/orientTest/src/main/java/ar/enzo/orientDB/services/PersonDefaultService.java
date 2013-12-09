package ar.enzo.orientDB.services;

import java.util.List;

import ar.enzo.orientDB.DAO.PersonDAO;
import ar.enzo.orientDB.entity.Person;

public class PersonDefaultService implements PersonService {

    private PersonDAO personDAO;

    @Override
    public void addPerson(Person person) {
        this.personDAO.save(person);
    }

    @Override
    public List<Person> findAll() {
        return this.personDAO.findAll();
    }

    @Override
    public void delete(Person person) {
        this.personDAO.delete(person.getId());
    }

    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }

}
