package ar.enzo.orientDB;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.core.db.graph.OGraphDatabase;
import com.orientechnologies.orient.object.db.OObjectDatabaseTx;

public interface OrientDatabaseConnection {

    ODatabaseDocumentTx document();

    OObjectDatabaseTx object();

    OGraphDatabase graph();
}
