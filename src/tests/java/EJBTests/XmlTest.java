package EJBTests;

import configDB.DBUnitConfig;
import org.junit.Before;
import org.junit.Test;
import server.ejb.LoginRegImpl;
import server.ejb.OrderEJB;
import server.ejb.ParseXMLImpl;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfDriverEnum;
import server.entity.Enum.StateOfLogin;
import server.entity.Enum.StateOfOrder;
import server.entity.OrderE;
import server.entity.OrderInfoE;
import server.service.OrderService;

/**
 * Created by Павел on 03.09.2016.
 */
public class XmlTest extends DBUnitConfig {
    ParseXMLImpl parser = new ParseXMLImpl("super name string ept");

    public XmlTest(String name) {
        super(name);
    }

    LoginRegImpl logService = new LoginRegImpl();
    OrderService orderService = new OrderService();

    OrderEJB orderEJB = new OrderEJB();

    public void add() throws Exception {
//        logService.a
        logService.addNewObj(StateOfLogin.ClIENT, "login cl1", "123", "123");
        logService.addNewObj(StateOfLogin.DRIVER, "login dr1", "234", "234");
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        add();
        ClientE client = logService.addClientInfo("login cl1", "vasya", 880055535, "a far,far away)");
        DriverE driver = logService.addDriverInfo("login dr1", 100, 3, "ashot", "dagistan)", 12345, StateOfDriverEnum.FREE);

        OrderE order = orderEJB.addOrder(client);
        OrderE order1 = orderEJB.addOrder(client);

        DriverE driver1 = logService.getDriverByLogin("login dr1");
        orderService.setDriverForOrder(driver,order);
        orderService.setDriverForOrder(driver,order1);

        OrderInfoE info1 = new OrderInfoE(StateOfOrder.CANCELED,"from home","to market","210x21x10",
                "it is comments","now here",100);
        OrderInfoE info2 = new OrderInfoE(StateOfOrder.PROCESSING,"from USA","to Kemerovo","20x90x250",
                "it is comments 2 ","now not here",333);
        orderService.addOrderInfo(order,info1);
        orderService.addOrderInfo(order1,info2);

    }

    @Test
    public void testClientParsing(){
        try {
            parser.parseJson(logService.getDriverByLogin("login dr1"));
//            parser.parseJson(logService.getClientByLogin("login cl1"));
//            parser.parseJson(orderService.getOrderById(6));

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
