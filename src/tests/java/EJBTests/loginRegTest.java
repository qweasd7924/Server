package EJBTests;

import configDB.DBUnitConfig;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.ejb.LoginRegImpl;
import server.entity.CarE;
import server.entity.ClientE;
import server.entity.DriverE;
import server.entity.Enum.StateOfDriverEnum;
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


    public void testAdd() throws Exception {
        logService.addNewObj(StateOfLogin.ClIENT, "login cl1", "123", "123");
        logService.addNewObj(StateOfLogin.DRIVER, "login dr1", "234", "234");
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        testAdd();

    }


    @Test
    public void testAddInfo() {
        ClientE client = logService.addClientInfo("login cl1", "vasya", 880055535, "a far,far away)");
        Assert.assertEquals("vasya", client.getFullName());
        DriverE driver = logService.addDriverInfo("login dr1", 100, 3, "ashot", "dagistan)", 12345, StateOfDriverEnum.FREE);
        Assert.assertEquals(driver.getFullName(),"ashot");
        CarE car = logService.addCarInfo("login dr1","sk177-bk","vaz",15,180);
        Assert.assertEquals(car.getCapacity(),180);
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

//    @Test
//    public void testGetByLogin() throws Exception {
//        String logDr = "login dr1";
//        String logCl = "login cl1";
//        DriverE d = logService.getDriverByLogin(logDr);
//        ClientE c = logService.getClientByLogin(logCl);
////        Assert.assertEquals(d.getId(),logService.getDriverByLogin(logDr).getId());
////        Assert.assertEquals(c.getId(),logService.getClientByLogin(logCl).getId());
//    }
}


















