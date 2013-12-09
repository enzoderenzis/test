package ar.enzo.orientDB.DAO;

import java.util.List;

import ar.enzo.orientDB.entity.Person;

public interface PersonDAO {

    List<Person> findAll();

    void save(Person person);

    void delete(int id);

}
