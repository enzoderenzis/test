package ar.enzo.orientDB;

import ar.enzo.orientDB.entity.Person;

import com.orientechnologies.orient.core.entity.OEntityManager;

public class LibraryService {

    private OrientDatabaseConnection odc;

    public void registerEntityClasses() {
        OEntityManager em = odc.object().getEntityManager();
        em.registerEntityClass(Person.class);
    }

    public void createEntities() {
        Person person = odc.object().newInstance(Person.class);
        odc.object().save(person);
    }
}
