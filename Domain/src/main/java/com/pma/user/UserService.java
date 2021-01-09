package com.pma.user;

public interface UserService {
    String CREDENTIALS_WRONG = "The User or Password is Wrong";
    String CREDENTIALS_CORRECT = "Success";

    String doLogin(String loginRequestJson);

    String doRegistration(String registrationInformation);

}
