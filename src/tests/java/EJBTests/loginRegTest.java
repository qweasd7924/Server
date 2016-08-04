package EJBTests;

import configDB.DBUnitConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.ejb.LoginRegImpl;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfLogin;
import server.service.TotalService;

import java.util.List;

/**
 * Created by ����� on 30.07.2016.
 */

public class loginRegTest extends DBUnitConfig {

    LoginRegImpl logService = new LoginRegImpl();
    TotalService service = new TotalService();

    public loginRegTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        testAdd();

    }

    public void testAdd() throws Exception {

        logService.addNewObj(StateOfLogin.ClIENT, "login cl1", "123", "123");
        logService.addNewObj(StateOfLogin.DRIVER, "login dr1", "234", "234");

    }

    @Test
    public void testAddInfo() {

    }

    @Test
    public void testGetAll() {
        List<ClientE> clList = service.getAllClients();
        Assert.assertEquals(clList.size(), 1);
        for (ClientE o : clList) {
            Assert.assertEquals(o.getLogin().getLogin(), "login cl1");
        }
        List<DriverE> drList = service.getAllDrivers();
        Assert.assertEquals(drList.size(), 1);
        for (DriverE o : drList) {
            Assert.assertEquals(o.getLogin().getLogin(), "login dr1");
        }
    }

    @Test
//    @Test(timeout = 100)
    public void testGetByLogin() throws Exception {
        DriverE d = logService.getDriverByLogin("login dr1");
        ClientE c = logService.getClientByLogin("login cl1");
        ClientE c1 = logService.getClientByLogin("login cl");
        int b = 1;
    }
}


















