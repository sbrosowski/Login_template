package com.pma.persistence.model.entities;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "pma")
public class Address extends AbstractPersistable<Long> {

    @Basic
    @Column(name = "street")
    private String street;

    @Basic
    @Column(name = "streetNumber")
    private int streetNumber;

    @Basic
    @Column(name = "zipcode")
    private int zipcode;

    @Basic
    @Column(name = "city")
    private String city;


    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }


    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Address that = (Address) o;

        if (this.getId() != that.getId()) return false;
        if (streetNumber != that.streetNumber) return false;
        if (zipcode != that.zipcode) return false;
        if (!Objects.equals(street, that.street)) return false;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        int result = this.getId().intValue();
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + streetNumber;
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
