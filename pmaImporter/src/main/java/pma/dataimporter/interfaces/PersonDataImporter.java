package pma.dataimporter.interfaces;

import pma.personendaten.beans.PersonCSV;

import java.util.List;

public interface PersonDataImporter {

    List<PersonCSV> importData();

}
