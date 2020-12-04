package pma.personendaten.entities.person;


import pma.personendaten.interfaces.Address;
import pma.personendaten.interfaces.Person;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "Person", schema = "pma")
public class PersonImpl implements Person {

    @Id
    private int id;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "firstName")
    private String lastName;

    @Column(name = "firstName")
    private String salutation;

    @Column(name = "addressID")
    private Address address;

    @Column(name = "title")
    private String title;

    @Column(name = "dateOfBirth")
    private Date dateOfBirth;

    @Column(name = "entryDate")
    private Date entryDate;

    @Column(name = "phoneNumber")
    private String phoneNumber;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "email")
    private String email;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public int getId() {
        return id;
    }
}
