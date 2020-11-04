package pma.personendaten;

import pma.personendaten.interfaces.Address;

public class AddressImpl implements Address {

    private String strasse;

    private String hausnummer;

    private String postleitzahl;

    private String stadt;

    @Override
    public String getStrasse() {
        return strasse;
    }

    @Override
    public void setStrasse(String strasse) {
        this.strasse = strasse;
    }

    @Override
    public String getHausnummer() {
        return hausnummer;
    }

    @Override
    public void setHausnummer(String hausnummer) {
        this.hausnummer = hausnummer;
    }

    @Override
    public String getPostleitzahl() {
        return postleitzahl;
    }

    @Override
    public void setPostleitzahl(String postleitzahl) {
        this.postleitzahl = postleitzahl;
    }

    @Override
    public String getStadt() {
        return stadt;
    }

    @Override
    public void setStadt(String stadt) {
        this.stadt = stadt;
    }
}
