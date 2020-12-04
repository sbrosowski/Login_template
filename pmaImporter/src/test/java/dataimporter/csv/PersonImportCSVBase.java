package dataimporter.csv;

import org.junit.jupiter.api.Test;
import pma.dataimporter.factories.PersonDataImportFactory;
import pma.dataimporter.interfaces.PersonDataImporter;
import pma.personendaten.beans.PersonCSV;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PersonImportCSVBase {

    protected PersonDataImporter getPersonDataImporter(String pathToFile) throws FileNotFoundException {
        PersonDataImportFactory factory = PersonDataImportFactory.getInstance();
        return factory.getPersonDataImporterCSV(new FileReader(pathToFile));

    }

    public Date createDateObjet(int year, int month, int day) {
        Calendar instance = Calendar.getInstance();
        instance.set(Calendar.YEAR,year);
        instance.set(Calendar.MONTH,month);
        instance.set(Calendar.DATE,day);

       return instance.getTime();
    }


    @Test
    public void readCSVDateTest() throws FileNotFoundException {
        String pathToFile="src\\test\\java\\dataimporter\\testdaten\\birthday\\PersonWithBirthday.csv";
        PersonDataImporter csvImporter = getPersonDataImporter(pathToFile);
        List<PersonCSV> personList= csvImporter.importData();

        assertEquals(personList.size(),1);
    }
}
