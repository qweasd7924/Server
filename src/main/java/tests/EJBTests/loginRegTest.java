package tests.EJBTests;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.ejb.LoginRegImpl;
import server.entity.DriverE;
import server.service.TotalService;
import tests.DBUnitConfig;

import java.util.List;

/**
 * Created by Павел on 30.07.2016.
 */
public class loginRegTest extends DBUnitConfig {

    LoginRegImpl loginReg = new LoginRegImpl();
    TotalService service = new TotalService();

    public loginRegTest(String name) {
        super(name);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("config for tests/person-data.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    @Test
    public void testGetAllDrivers() throws Exception {
        List<DriverE> drivers = service.getAllDrivers();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("config for tests/person-data.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
//        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("driver").getRowCount(),drivers.size());
    }
}
