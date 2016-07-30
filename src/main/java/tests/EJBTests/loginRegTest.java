package tests.EJBTests;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.bean.DriverB;
import server.ejb.LoginRegImpl;
import server.entity.DriverE;
import server.service.TotalService;
import tests.DBUnitConfig;

import java.util.List;

/**
 * Created by ����� on 30.07.2016.
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
        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "driver", ignore);
        Assert.assertEquals(expectedData.getTable("driver").getRowCount(),drivers.size());
    }

    @Test
    public void testSave() throws Exception {
        DriverB driver = new DriverB();
        driver.setFullName("Pasha Plug");
        driver.setId(1);

        service.addDriver(driver);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("config for tests/person-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

//        actualData.getTable("driver");
        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "driver", ignore);
    }

}
