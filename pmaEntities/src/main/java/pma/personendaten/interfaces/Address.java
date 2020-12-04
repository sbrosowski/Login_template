package pma.personendaten.interfaces;

public interface Address extends BusinessObject {
    String getStreet();

    void setStreet(String street);

    String getStreetNumber();

    void setStreetNumber(String streetNumber);

    String getZipCode();

    void setZipCode(String zipCode);

    String getCity();

    void setCity(String city);
}
