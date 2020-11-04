package pma.personendaten.interfaces;

public interface Address {
    String getStrasse();

    void setStrasse(String strasse);

    String getHausnummer();

    void setHausnummer(String hausnummer);

    String getPostleitzahl();

    void setPostleitzahl(String postleitzahl);

    String getStadt();

    void setStadt(String stadt);
}
