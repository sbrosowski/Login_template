package pma.personendaten.entities;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "person", schema = "pma")
public class PersonEntity {
    private int id;
    private String firstName;
    private String lastName;
    private String salutation;
    private String title;
    private Date dateOfBirth;
    private Date entryDate;
    private String phoneNumber;
    private String mobile;
    private String email;

    @Id
    @Column(name = "ID")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "firstName")
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Basic
    @Column(name = "lastName")
    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Basic
    @Column(name = "salutation")
    public String getSalutation() {
        return salutation;
    }

    public void setSalutation(String salutation) {
        this.salutation = salutation;
    }

    @Basic
    @Column(name = "title")
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "dateOfBirth")
    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    @Basic
    @Column(name = "entryDate")
    public Date getEntryDate() {
        return entryDate;
    }

    public void setEntryDate(Date entryDate) {
        this.entryDate = entryDate;
    }

    @Basic
    @Column(name = "phoneNumber")
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Basic
    @Column(name = "mobile")
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "email")
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PersonEntity that = (PersonEntity) o;

        if (id != that.id) return false;
        if (firstName != null ? !firstName.equals(that.firstName) : that.firstName != null) return false;
        if (lastName != null ? !lastName.equals(that.lastName) : that.lastName != null) return false;
        if (salutation != null ? !salutation.equals(that.salutation) : that.salutation != null) return false;
        if (title != null ? !title.equals(that.title) : that.title != null) return false;
        if (dateOfBirth != null ? !dateOfBirth.equals(that.dateOfBirth) : that.dateOfBirth != null) return false;
        if (entryDate != null ? !entryDate.equals(that.entryDate) : that.entryDate != null) return false;
        if (phoneNumber != null ? !phoneNumber.equals(that.phoneNumber) : that.phoneNumber != null) return false;
        if (mobile != null ? !mobile.equals(that.mobile) : that.mobile != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (firstName != null ? firstName.hashCode() : 0);
        result = 31 * result + (lastName != null ? lastName.hashCode() : 0);
        result = 31 * result + (salutation != null ? salutation.hashCode() : 0);
        result = 31 * result + (title != null ? title.hashCode() : 0);
        result = 31 * result + (dateOfBirth != null ? dateOfBirth.hashCode() : 0);
        result = 31 * result + (entryDate != null ? entryDate.hashCode() : 0);
        result = 31 * result + (phoneNumber != null ? phoneNumber.hashCode() : 0);
        result = 31 * result + (mobile != null ? mobile.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
