package pma.dataimporter;

import com.opencsv.bean.CsvToBeanBuilder;
import pma.dataimporter.csvDTO.PersonCSV;

import java.io.FileReader;
import java.util.List;

public class PersonDataImporterCSVImpl extends AbstractPersonDataImporter {

    private final CsvToBeanBuilder<PersonCSV> readToBean;


    public PersonDataImporterCSVImpl(FileReader reader){
        readToBean=new CsvToBeanBuilder<>(reader);
        readToBean.withType(PersonCSV.class);
        readToBean.withSeparator(';');

    }

    @Override
    public List<PersonCSV> importData() {
        return readToBean.build().parse();
    }
}
