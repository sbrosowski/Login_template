package com.pma.demo.Services.Impl;

import com.google.gson.Gson;
import com.pma.demo.Services.Impl.DTO.LoginDTO;
import com.pma.demo.Services.Impl.DTO.UserRegistrationDTO;
import com.pma.demo.Services.Interfaces.UserService;
import org.springframework.stereotype.Service;


@Service
class UserServiceImpl implements UserService {

    @Override
    public String doLogin(String loginDTO) {
        Gson request = new Gson();
        Gson gsonResult = new Gson();
        LoginDTO loginDTORequest = request.fromJson(loginDTO, LoginDTO.class);

        LoginDTO loginDTOResult = containsCredentials(loginDTORequest);

        if (!loginDTOResult.isSuccessful() && loginDTOResult.getResultMessage().equals(CREDENTIALS_WRONG)) {
            return gsonResult.toJson(loginDTOResult);
        }

        return gsonResult.toJson(new LoginDTO(CREDENTIALS_CORRECT, true));
    }

    @Override
    public String doRegistration(String registrationInformation) {
        Gson request = new Gson();
        Gson gsonResult = new Gson();

        UserRegistrationDTO userRegistration = request.fromJson(registrationInformation, UserRegistrationDTO.class);
        return gsonResult.toJson(new LoginDTO(CREDENTIALS_CORRECT, true));
    }


    private LoginDTO containsCredentials(LoginDTO loginDTO) {

        if (loginDTO.getUser() == null || loginDTO.getPassword() == null) {
            return new LoginDTO(CREDENTIALS_WRONG, false);
        }

        return loginDTO;
    }
}
