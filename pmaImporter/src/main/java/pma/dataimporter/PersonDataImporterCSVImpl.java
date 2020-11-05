package pma.dataimporter;

import com.opencsv.CSVReader;
import com.opencsv.bean.CsvToBean;
import pma.personendaten.interfaces.Person;

import java.io.FileReader;
import java.util.List;

public class PersonDataImporterCSVImpl extends AbstractPersonDataImporter {

    private final CSVReader csvReader;


    public PersonDataImporterCSVImpl(FileReader reader){
        csvReader=new CSVReader(reader);

    }

    @Override
    public List<Person> importData() {
        CsvToBean<Person> readToBean =new CsvToBean<>();
        readToBean.setCsvReader(csvReader);
        return readToBean.parse();
    }
}
