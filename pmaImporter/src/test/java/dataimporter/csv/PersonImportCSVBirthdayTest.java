package dataimporter.csv;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import pma.dataimporter.PersonDataImporterCSVImpl;
import pma.dataimporter.factories.PersonDataImportFactory;
import pma.dataimporter.interfaces.PersonDataImporter;
import pma.personendaten.interfaces.Person;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.List;




public class PersonImportCSVBirthdayTest extends PersonImportCSVBase {


    @Test
    public void PersonWithoutBirthdayTest() throws FileNotFoundException {
        String pathToFile="src\\test\\java\\dataimporter\\testdaten\\birthday\\PersonWithBirthday.csv";
        PersonDataImporter csvImporter = getPersonDataImporter(pathToFile);
        List<Person> personList= csvImporter.importData();

    }

    @Test
    public void PersonWithBirthdayTest() throws FileNotFoundException {
        String pathToFile="src\\test\\java\\dataimporter\\testdaten\\birthday\\PersonWithoutBirthday.csv";
        PersonDataImporter csvImporter = getPersonDataImporter(pathToFile);
        List<Person> personList= csvImporter.importData();

    }

    private PersonDataImporter getPersonDataImporter(String pathToFile) throws FileNotFoundException {
        PersonDataImportFactory factory = PersonDataImportFactory.getInstance();
        return factory.getPersonDataImporterCSV(new FileReader(pathToFile));
    }

}
