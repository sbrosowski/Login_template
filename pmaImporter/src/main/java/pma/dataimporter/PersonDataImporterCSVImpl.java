package pma.dataimporter;

import com.opencsv.CSVReader;
import pma.personendaten.interfaces.Person;

import java.io.FileReader;
import java.util.List;

public class PersonDataImporterCSVImpl extends AbstractPersonDataImporter {

    private CSVReader csvReader;


    public PersonDataImporterCSVImpl(FileReader reader){
        csvReader=new CSVReader(reader);
    }

    @Override
    public List<Person> importData() {
        return null;
    }
}
