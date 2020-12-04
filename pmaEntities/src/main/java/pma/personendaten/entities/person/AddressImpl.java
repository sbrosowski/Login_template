package pma.personendaten.entities.person;

import org.hibernate.annotations.Table;
import pma.personendaten.interfaces.Address;

import javax.persistence.Column;
import javax.persistence.Id;


@Table(appliesTo = "")
public class AddressImpl implements Address {

    @Id
    private int id;

    @Column(name = "street")
    private String street;

    @Column(name = "streetNumber")
    private String streetNumber;

    @Column(name = "zipcode")
    private String zipCode;

    @Column(name = "city")
    private String city;

    @Override
    public String getStreet() {
        return street;
    }

    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    @Override
    public String getStreetNumber() {
        return streetNumber;
    }

    @Override
    public void setStreetNumber(String streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Override
    public String getZipCode() {
        return zipCode;
    }

    @Override
    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public void setCity(String city) {
        this.city = city;
    }
}
