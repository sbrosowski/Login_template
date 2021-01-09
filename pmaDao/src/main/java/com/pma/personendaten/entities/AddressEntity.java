package com.pma.personendaten.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "address", schema = "pma")
public class AddressEntity {
    private int id;
    private String street;
    private int streetNumber;
    private int zipcode;
    private String city;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name = "streetNumber")
    public int getStreetNumber() {
        return streetNumber;
    }

    public void setStreetNumber(int streetNumber) {
        this.streetNumber = streetNumber;
    }

    @Basic
    @Column(name = "zipcode")
    public int getZipcode() {
        return zipcode;
    }

    public void setZipcode(int zipcode) {
        this.zipcode = zipcode;
    }

    @Basic
    @Column(name = "city")
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

        AddressEntity that = (AddressEntity) o;

        if (id != that.id) return false;
        if (streetNumber != that.streetNumber) return false;
        if (zipcode != that.zipcode) return false;
        if (!Objects.equals(street, that.street)) return false;
        return Objects.equals(city, that.city);
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (street != null ? street.hashCode() : 0);
        result = 31 * result + streetNumber;
        result = 31 * result + zipcode;
        result = 31 * result + (city != null ? city.hashCode() : 0);
        return result;
    }
}
