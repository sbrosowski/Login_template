package dataimporter.csv;

import org.junit.Before;
import org.junit.Test;
import pma.dataimporter.PersonDataImporterCSVImpl;
import pma.dataimporter.factories.PersonDataImportFactory;
import pma.dataimporter.interfaces.PersonDataImporter;
import pma.personendaten.interfaces.Person;

import java.util.List;

import static org.mockito.Mockito.mock;


public class PersonDataImporterCSVTest {

    private PersonDataImporter personDataImporter;
    private List<Person> personList;

    @Before
    public void setup(){
        PersonDataImportFactory factory = PersonDataImportFactory.getInstance();
        personDataImporter=factory.getPersonDataImporterCSV();



    }

    @Test
    public void test(){
        Person person= mock(Person.class);

    }

}
