package pma.dataimporter.csvDTO;

import com.opencsv.bean.CsvBindByName;
import pma.dataimporter.constants.CSVConstants;

public class AddressCSV {

    @CsvBindByName(column = CSVConstants.STREET)
    private String strasse;

    @CsvBindByName(column = CSVConstants.HOUSE_NUMBER)
    private String hausnummer;

    private String postleitzahl;

    private String stadt;


    public String getStrasse() {
        return strasse;
    }


    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }


    public String getHausnummer() {
        return hausnummer;
    }


    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }


    public String getPostleitzahl() {
        return postleitzahl;
    }


    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }


    public String getStadt() {
        return stadt;
    }


    public void setStadt(String stadt) {
        this.stadt = stadt;
    }
}
