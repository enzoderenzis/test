package ar.enzo.orientDB.DAO;

import java.util.ArrayList;
import java.util.List;

import ar.enzo.orientDB.entity.Person;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.record.impl.ODocument;
import com.orientechnologies.orient.core.sql.OCommandSQL;
import com.orientechnologies.orient.core.sql.query.OSQLSynchQuery;

public class PersonOrientDBDAO extends OrientDBAbstractDAO implements PersonDAO {

    @Override
    public List<Person> findAll() {
        OSQLSynchQuery<ODocument> query = new OSQLSynchQuery<ODocument>("SELECT * FROM Person");
        List<ODocument> result = this.getTxMgr().query(query);
        List<Person> persons = new ArrayList<Person>(result.size());
        for (ODocument doc : result) {
            Person person = new Person();
            person.setId((Integer) doc.field("id"));
            person.setName((String) doc.field("name"));
            persons.add(person);
        }
        return persons;
    }

    @Override
    public void save(Person person) {
        this.getTxMgr();
        ODocument doc = new ODocument("Person");
        doc.field("id", person.getId());
        doc.field("name", person.getName());
        doc.save();
    }

    @Override
    public void delete(int id) {
        ODatabaseDocumentTx db = this.getTxMgr();
        db.command(new OCommandSQL(String.format("DELETE FROM Person WHERE id = %d", id))).execute();
    }

}
