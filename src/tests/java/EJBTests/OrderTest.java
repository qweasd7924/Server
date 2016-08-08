package EJBTests;

import configDB.DBUnitConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.ejb.LoginRegImpl;
import server.ejb.OrderEJB;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfDriverEnum;
import server.entity.Enum.StateOfLogin;
import server.entity.Enum.StateOfOrder;
import server.entity.OrderE;
import server.entity.OrderInfoE;
import server.service.OrderService;
import server.service.TotalService;

import javax.inject.Inject;

/**
 * Created by ����� on 06.08.2016.
 */
public class OrderTest extends DBUnitConfig {
    LoginRegImpl logService = new LoginRegImpl();
    OrderService orderService = new OrderService();

    OrderEJB orderEJB = new OrderEJB();

    public OrderTest(String name) {
        super(name);
    }

    public void add() throws Exception {
        logService.addNewObj(StateOfLogin.ClIENT, "login cl1", "123", "123");
        logService.addNewObj(StateOfLogin.DRIVER, "login dr1", "234", "234");
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        add();
        ClientE client = logService.addClientInfo("login cl1", "vasya", 880055535, "a far,far away)");
        DriverE driver = logService.addDriverInfo("login dr1", 100, 3, "ashot", "dagistan)", 12345, StateOfDriverEnum.FREE);
    }

    @Test
    public OrderE testAddOrder() {
        ClientE client = logService.getClientByLogin("login cl1");
//        OrderE order = orderService.addNewOrder(client);
        OrderE order = orderEJB.addOrder(client);
        DriverE driver = logService.getDriverByLogin("login dr1");
        orderService.setDriverForOrder(driver,order);
        OrderE order1 = orderService.addNewOrder(client);
        orderService.setDriverForOrder(driver,order1);

        OrderInfoE info1 = new OrderInfoE(StateOfOrder.CANCELED,"from home","to market","210x21x10",
                "it is comments","now here",100);
        OrderInfoE info2 = new OrderInfoE(StateOfOrder.PROCESSING,"from USA","to Kemerovo","20x90x250",
                "it is comments 2 ","now not here",333);
        orderService.addOrderInfo(order,info1);
        orderService.addOrderInfo(order1,info2);
        return order;
    }

    @Test
    public void testOrderState(){
        OrderE order = testAddOrder();
        orderService.changeStateOfOrder(order,StateOfOrder.FREE);//was canceled
        Assert.assertEquals(order.getOrderInfo().getStateOfOrder().toString(),"FREE");
    }
}
