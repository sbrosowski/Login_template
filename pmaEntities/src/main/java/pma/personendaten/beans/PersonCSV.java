package pma.personendaten.beans;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvDate;
import com.opencsv.bean.CsvRecurse;
import pma.personendaten.CSVConstants;

import java.util.Date;

/**
 * Created by siegf on 03.11.2020.
 */
public class PersonCSV {

    @CsvBindByName(column = CSVConstants.FIRST_NAME)
    private String firstName;

    @CsvBindByName(column = CSVConstants.LAST_NAME)
    private String lastName;

    @CsvBindByName(column = CSVConstants.SALUTATION)
    private String salutation;

    @CsvRecurse
    private AddressCSV address;

    @CsvBindByName(column = CSVConstants.TITLE)
    private String title;

    @CsvDate("dd.mm.yyyy")
    private Date dateOfBirth;

    @CsvDate("dd.mm.yyyy")
    private Date entryDate;

    @CsvBindByName
    private String phoneNumber;

    @CsvBindByName
    private String mobile;

    @CsvBindByName
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

    public AddressCSV getAddress() {
        return address;
    }

    public void setAddress(AddressCSV address) {
        this.address = address;
    }
}
