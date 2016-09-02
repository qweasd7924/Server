package server.ejb;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.boot.model.relational.Database;
import server.entity.ClientE;
import server.entity.DriverE;

import java.io.File;

/**
 * Created by Павел on 30.07.2016.
 */
public class ParseXMLImpl extends DBUnitConfigForXML implements ParseXML {

    public ParseXMLImpl(String name) {
        super(name);
    }

    @Override
    public File parseDriverXML(DriverE driver) {
        return null;
    }

    @Override
    public File parseClientXML(ClientE client) throws Exception {
        IDataSet assertData = tester.getConnection().createDataSet();
//        IDataSet a1 = new FlatXmlDataSetBuilder().
//        DatabaseOperation.CLEAN_INSERT.execute();
        return null;
    }
}
