package server.ejb;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.boot.model.relational.Database;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.LoginE;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.awt.print.Book;
import java.io.File;
import java.io.FileOutputStream;

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
//        String xmlString = setupXMLBuffer(
//                new StringBuffer("<firstName>")
//                        .append(customer.firstName)
//                        .append("</firstName>")
//                        .append("<lastName>")
//                        .append(customer.lastName)
//                        .append("</lastName>")
//                        // etc...
//                        .toString()
//        );
//
//создаем выходной поток
        File of = new File("C:\\book.xml");
            try(FileOutputStream os = new FileOutputStream(of)){

                JAXBContext context = JAXBContext.newInstance(XmlClient.class);
                Marshaller m = context.createMarshaller();
                m.marshal(new XmlClient(client), os);
        }
        ;

//        IDataSet assertData = tester.getConnection().createDataSet();
//        IDataSet a1 = new FlatXmlDataSetBuilder().
//        DatabaseOperation.CLEAN_INSERT.execute();
        return null;
    }
}
