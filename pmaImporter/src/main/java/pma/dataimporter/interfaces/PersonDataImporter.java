package pma.dataimporter.interfaces;

import pma.dataimporter.csvDTO.PersonCSV;

import java.util.List;

public interface PersonDataImporter {

    List<PersonCSV> importData();

}
