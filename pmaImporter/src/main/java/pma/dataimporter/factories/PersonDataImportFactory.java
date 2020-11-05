package pma.dataimporter.factories;

import pma.dataimporter.PersonDataImporterCSVImpl;
import pma.dataimporter.interfaces.PersonDataImporter;

import java.io.FileReader;

public class PersonDataImportFactory {

    private static PersonDataImportFactory _Instance;

    private PersonDataImportFactory(){

    }

    public static PersonDataImportFactory getInstance(){
        if(_Instance ==null){
            _Instance=new PersonDataImportFactory();
        }
        return _Instance;
    }

    public PersonDataImporter getPersonDataImporterCSV(FileReader reader){
        return new PersonDataImporterCSVImpl(reader);
    }


}
