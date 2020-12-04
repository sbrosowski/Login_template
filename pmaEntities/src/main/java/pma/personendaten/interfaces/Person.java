package pma.personendaten.interfaces;

import java.util.Date;

public interface Person extends BusinessObject {

    String getFirstName();

    void setFirstName(String firstName);

    String getLastName();

    void setLastName(String lastName);

    String getSalutation();

    void setSalutation(String salutation);

    String getTitle();

    void setTitle(String title);

    Date getDateOfBirth();

    void setDateOfBirth(Date dateOfBirth);

    Date getEntryDate();

    void setEntryDate(Date entryDate);

    String getPhoneNumber();

    void setPhoneNumber(String phoneNumber);

    String getMobile();

    void setMobile(String mobile);

    String getEmail();

    void setEmail(String email);

}
