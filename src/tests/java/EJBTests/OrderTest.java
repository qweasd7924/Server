package EJBTests;

import configDB.DBUnitConfig;
import org.junit.Before;
import org.junit.Test;
import server.ejb.LoginRegImpl;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfDriverEnum;
import server.entity.Enum.StateOfLogin;
import server.entity.OrderE;
import server.service.OrderService;
import server.service.TotalService;

/**
 * Created by Павел on 06.08.2016.
 */
public class OrderTest extends DBUnitConfig {
    LoginRegImpl logService = new LoginRegImpl();
    OrderService orderService = new OrderService();

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
    public void testAddOrder() {
        ClientE client = logService.getClientByLogin("login cl1");
        OrderE order = orderService.addNewOrder(client);
        DriverE driver = logService.getDriverByLogin("login dr1");
        orderService.setDriverForOrder(driver,order);
        OrderE order1 = orderService.addNewOrder(client);
        orderService.setDriverForOrder(driver,order1);


    }
}
