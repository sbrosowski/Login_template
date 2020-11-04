package pma.dataimporter.factories;

import pma.dataimporter.interfaces.PersonDataImport;

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

    public PersonDataImport getPersonDataImport(){
        return null;
    }


}
