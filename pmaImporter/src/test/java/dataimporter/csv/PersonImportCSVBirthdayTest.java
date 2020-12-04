package dataimporter.csv;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import pma.dataimporter.interfaces.PersonDataImporter;
import pma.personendaten.beans.AddressCSV;
import pma.personendaten.beans.PersonCSV;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PersonImportCSVBirthdayTest extends PersonImportCSVBase {

    List<PersonCSV> personCSVList;

    @Test
    public void PersonWithoutBirthdayTest() throws FileNotFoundException {
        String pathToFile="src\\test\\java\\dataimporter\\testdaten\\birthday\\PersonWithBirthday.csv";
        PersonDataImporter csvImporter = getPersonDataImporter(pathToFile);
        List<PersonCSV> personList= csvImporter.importData();

    }

    @Test
    public void PersonWithBirthdayTest() throws FileNotFoundException {
        String pathToFile="src\\test\\java\\dataimporter\\testdaten\\birthday\\PersonWithoutBirthday.csv";
        PersonDataImporter csvImporter = getPersonDataImporter(pathToFile);
        List<PersonCSV> personList= csvImporter.importData();

    }

    @BeforeAll
    public void constructPersonData(){
        personCSVList=new ArrayList<>();
        Date birthdayDate=createDateObjet(1935,Calendar.MAY,9);
        Date dayOfEntry=createDateObjet(1995,Calendar.JANUARY,21);

        PersonCSV person= new PersonCSV();
        personCSVList.add(person);


        person.setSalutation("Frau");
        person.setFirstName("Rhiane");
        person.setLastName("Grund");

        person.setDateOfBirth(birthdayDate);
        person.setEntryDate(dayOfEntry);
        person.setPhoneNumber("04747/41787807");
        person.setMobile("0167/4981164");

        AddressCSV address=constructAddress();
        person.setAddress(address);


    }

    public AddressCSV constructAddress() {
        AddressCSV address= new AddressCSV();
        address.setHausnummer("27");
        address.setPostleitzahl("27616");
        address.setStrasse("Moerser Straße");
        address.setStadt("Lunestedt");
        return address;
    }


}
