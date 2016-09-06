package server.ejb;

import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.hibernate.boot.model.relational.Database;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.LoginE;
import server.entity.OrderE;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import java.awt.print.Book;
import java.io.*;

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
        File of = new File("D:\\book.xml");
        try (BufferedOutputStream writer = new BufferedOutputStream(new FileOutputStream(of)))
        {
            writer.write(getClientXml(client).getBytes());
        }

//        try (FileOutputStream os = new FileOutputStream(of)) {
//
//            JAXBContext context = JAXBContext.newInstance(XmlClient.class);
//            Marshaller m = context.createMarshaller();
//            m.marshal(new XmlClient(client), os);
//        }

//        IDataSet assertData = tester.getConnection().createDataSet();
//        IDataSet a1 = new FlatXmlDataSetBuilder().
//        DatabaseOperation.CLEAN_INSERT.execute();
        return null;
    }

    public String getClientXml(ClientE client) {
        String ls = System.getProperty("line.separator");

        StringBuffer xmlOrders = new StringBuffer("");
        if (client.getOrders() != null) {
            for (OrderE order : client.getOrders()) {
                xmlOrders.append("<order>").append(order.getId()).append("</order>").append(ls);
            }
        }

        String xmlString = new StringBuffer("<client>").append(ls)
                .append("<fullName>").append(client.getFullName()).append("</fullName>").append(ls)
                .append("<phone>").append(client.getPhone()).append("</phone>").append(ls)
                .append("<address>").append(client.getAddress()).append("</address>").append(ls)
                .append("<login>").append(client.getLogin().getLogin()).append("</login>").append(ls)
                .append("<orders>").append(xmlOrders).append("</orders>").append(ls)
                .append("</client>").append(ls)
                .toString();

        return xmlString;
    }

    public String getOrderXml(OrderE order) {
        String xmlString = new StringBuffer("<order>")
                .append("<id>").append(order.getId()).append("</id>")
                .append("<driver>").append(order.getDriverE().getFullName()).append("</driver>")
                .append("<client>").append(order.getClientE().getFullName()).append("</client>")
                .append("<state>").append(order.getOrderInfo().getStateOfOrder()).append("</state>")
                .append("<loadingAddress>").append(order.getOrderInfo().getLoadingAddress()).append("</loadingAddress>")
                .append("<unloadingAddress>").append(order.getOrderInfo().getUnloadingAddress()).append("</unloadingAddress>")
                .append("<cargoParameters>").append(order.getOrderInfo().getCargoParams()).append("</cargoParameters>")
                .append("<comments>").append(order.getOrderInfo().getComments()).append("</comments>")
                .append("<cargoLocation>").append(order.getOrderInfo().getCargoLocation()).append("</cargoLocation>")
                .append("<price>").append(order.getOrderInfo().getPrice()).append("</price>")
                .append("<date>").append(order.getDateOfAdd()).append("</date>")
                .append("<number>").append(order.getNumberOfOrder()).append("</number>")
                .append("</order>")
                .toString();

        return xmlString;
    }
}
