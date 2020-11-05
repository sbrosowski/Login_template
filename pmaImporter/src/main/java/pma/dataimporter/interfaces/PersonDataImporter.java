package pma.dataimporter.interfaces;

import pma.personendaten.interfaces.Person;

import java.util.List;

public interface PersonDataImporter {

    List<Person> importData();

}
