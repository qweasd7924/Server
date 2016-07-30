package tests;

import org.dbunit.Assertion;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.entity.Person;
import server.service.PersonService;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;
import java.util.List;

/**
 * Created by ����� on 30.07.2016.
 */
public class PersonTest extends DBUnitConfig{

    private PersonService service = new PersonService();
    private EntityManager em = Persistence.createEntityManagerFactory("NCEDU").createEntityManager();

    @Before
    public void setUp() throws Exception {
        super.setUp();
        beforeData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("config for tests/person-data.xml"));

        tester.setDataSet(beforeData);
        tester.onSetup();
    }

    public PersonTest(String name) {
        super(name);
    }

    @Test
    public void testGetAll() throws Exception {
        List<Person> persons = service.getAll();

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("config for tests/person-data.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();
        Assertion.assertEquals(expectedData, actualData);
        Assert.assertEquals(expectedData.getTable("person").getRowCount(),persons.size());
    }

    @Test
    public void testSave() throws Exception {
        Person person = new Person();
        person.setName("Pasha");
        person.setSurname("Plug");

        service.save(person);

        IDataSet expectedData = new FlatXmlDataSetBuilder().build(
                Thread.currentThread().getContextClassLoader()
                        .getResourceAsStream("config for tests/person-data-save.xml"));

        IDataSet actualData = tester.getConnection().createDataSet();

        String[] ignore = {"id"};
        Assertion.assertEqualsIgnoreCols(expectedData, actualData, "person", ignore);
    }

    //others tests

}