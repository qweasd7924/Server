package EJBTests;

import configDB.DBUnitConfig;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.AfterClass;
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
//        beforeData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("client-data.xml"));
//
//        tester.setDataSet(beforeData);
//        tester.onSetup();
    }
//
//    @Test
//    public void testGetAll() throws Exception {
//        List<DriverE> drivers = service.getAllDrivers();
//        List<ClientE> clients = service.getAllClients();
//
//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("client-data.xml"));
//
//        IDataSet actualData = tester.getConnection().createDataSet();
////        Assertion.assertEquals(expectedData, actualData);
////        actualData.getTable("driver");
//
//        String[] arr = actualData.getTableNames();
//
//        String[] ignore = {"id"};
//
//
////        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "driver", ignore);
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "client", ignore);
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "driver", ignore);
//        Assert.assertEquals(expectedData.getTable("client").getRowCount(), clients.size());
//        Assert.assertEquals(expectedData.getTable("driver").getRowCount(), drivers.size());
//    }
//
//    @Test
//    public void testAddInfo() throws Exception {
//        //for driver and client
//        DriverB driver = new DriverB();
//        driver.setFullName("driver 7");
//        driver.setId(7);
//        driver.setPhone(111);
//        driver.setBalance(100);
//        driver.setExperience(10);
//        driver.setLocation("not here");
//        driver.setStatus(StateOfDriverEnum.BYSE);
//        service.addDriverInfo(driver);
//
//        ClientB clientB = new ClientB();
//        clientB.setId(12);
//        clientB.setFullName("client 12");
//        clientB.setAdress("not here");
//        clientB.setPhone(111);
//        service.addClientInfo(clientB);
//
//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("client-data-save.xml"));
//
//        IDataSet actualData = tester.getConnection().createDataSet();
//
//        String[] ignore = {"id"};
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "client", ignore);
//        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "driver", ignore);
//    }

    @Test
    public void testAdd() throws Exception {
//        Connection con = tester.getConnection().getConnection();
//
//        // выполняем запрос на поиск некоторой записи
//        ResultSet rs = con.createStatement().executeQuery("select * from users where id_user = 1");
//
//        // проверяем, что запись была найдена
//        Assert.assertTrue(rs.next());
//        Assert.assertEquals(rs.getString("fio"), "Not-a-Jim");

//        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
//                Thread.currentThread().getContextClassLoader()
//                        .getResourceAsStream("login-add.xml"));

        logService.addNewObj(StateOfLogin.ClIENT, "login cl1", "123", "123");
        logService.addNewObj(StateOfLogin.DRIVER, "login dr1", "234", "234");

//-----------------------------

        // TODO: 02.08.2016  разобраться с рез сэт 
//        IDataSet actualData = tester.getConnection().createDataSet();
//
//        ResultSet rs = tester.getConnection().getConnection().createStatement().
//                executeQuery("select * from login where password = '123'");
//
//        ResultSet rs1 = tester.getConnection().getConnection().
//                createStatement().executeQuery("SELECT * FROM driver WHERE phone = 0 ");
//        int  aaa = rs1.findColumn("LOCATION");
//        int ph = rs1.getInt(5);
//        byte[] a1 = rs1.getBytes("login");
//        String a = rs1.getString("LOCATION");
//        Assert.assertEquals(rs.getString("password"),"123");
    }

//    @Test
//    public void addInfo(){
//
//    }

    @Test
    public void testGetAll() {
// TODO: 03.08.2016 test get all driver 
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

}


















