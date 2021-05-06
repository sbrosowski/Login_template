package com.pma.Interfaces.entities;

import java.util.Date;

public interface ILoginEntity {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    void increaseLoginTry();

    void resetLoginTry();

    boolean isLimitReached();

    boolean isDeleted();

    Date getDeleteTimeStamp();

    Date getLastModifiedTimeStamp();

    Date setDeleteTimeStamp(Date deletedTimeStamp);

    Date setLastModifiedTimeStamp(Date lastModifiedTimeStamp);


}
