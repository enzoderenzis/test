package ar.enzo.orientDB.DAO;

import java.lang.reflect.InvocationTargetException;

import com.orientechnologies.orient.core.db.document.ODatabaseDocumentPool;
import com.orientechnologies.orient.core.db.document.ODatabaseDocumentTx;
import com.orientechnologies.orient.server.OServer;
import com.orientechnologies.orient.server.OServerMain;

public abstract class OrientDBAbstractDAO {
    private static OServer SERVER;

    static {
        try {
            System.setProperty("ORIENTDB_HOME", "/tmp/databases/");
            SERVER = OServerMain.create();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        try {
            SERVER.startup();// (OrientDBAbstractDAO.class.getClass().getResourceAsStream("db.config"));
            SERVER.activate();
        } catch (IllegalArgumentException | SecurityException | InstantiationException | IllegalAccessException | ClassNotFoundException
                | InvocationTargetException | NoSuchMethodException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void createConexion() {
        ODatabaseDocumentTx oDatabaseDocumentTx = new ODatabaseDocumentTx("local:/tmp/databases/test");
        if (!oDatabaseDocumentTx.exists()) {
            oDatabaseDocumentTx.create();
        }
    }

    protected void closeConexion() {

    }

    protected ODatabaseDocumentTx getTxMgr() {
        ODatabaseDocumentTx db = ODatabaseDocumentPool.global().acquire("remote:localhost/test", "admin", "admin");
        return db;
    }

    public void shutdownServer() {
        SERVER.shutdown();
    }

}
