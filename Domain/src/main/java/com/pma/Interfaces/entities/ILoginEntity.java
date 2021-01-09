package com.pma.Interfaces.entities;

public interface ILoginEntity {

    String getUsername();

    void setUsername(String username);

    String getPassword();

    void setPassword(String password);

    void increaseLoginTry();

    void resetLoginTry();

    boolean isLimitReached();


}
