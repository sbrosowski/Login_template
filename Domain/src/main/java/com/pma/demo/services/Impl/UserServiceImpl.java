package com.pma.demo.services.Impl;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pma.demo.services.Impl.DTO.LoginDTO;
import com.pma.demo.services.Impl.DTO.UserRegistrationDTO;
import com.pma.demo.services.Interfaces.UserService;
import com.pma.demo.services.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;


@Service
class UserServiceImpl implements UserService {

    @Override
    public String doLogin(String loginDTO) {
        Gson request = new Gson();
        Gson gsonResult = new Gson();

        LoginDTO loginData = request.fromJson(getJsonContent(loginDTO, "login"), LoginDTO.class);

        LoginDTO loginDTOResult = containsCredentials(loginData);

        if (!loginDTOResult.isSuccessful() && loginDTOResult.getResultMessage().equals(CREDENTIALS_WRONG)) {
            return gsonResult.toJson(loginDTOResult);
        }

        return gsonResult.toJson(new LoginDTO(CREDENTIALS_CORRECT, true));
    }

    @Override
    public String doRegistration(String registrationInformation) {
        Gson request = new Gson();
        Gson gsonResult = new Gson();

        //TODO Inputvalidierung fehlt.
        UserRegistrationDTO userRegistration = request.fromJson(getJsonContent(registrationInformation,
                "registration"), UserRegistrationDTO.class);

        String encodedPassword = PasswordEncoder.encode(userRegistration.getPassword());


        return gsonResult.toJson(new LoginDTO(CREDENTIALS_CORRECT, true));
    }


    private LoginDTO containsCredentials(LoginDTO loginDTO) {

        if (!StringUtils.hasText(loginDTO.getUser()) || !StringUtils.hasText(loginDTO.getPassword())) {
            return new LoginDTO(CREDENTIALS_WRONG, false);
        }

        return loginDTO;
    }

    private String getJsonContent(String loginJson, String wrappingJsonKey) {
        JsonElement elements = JsonParser.parseString(loginJson);
        JsonObject object = elements.getAsJsonObject();
        JsonElement loginElement = object.get(wrappingJsonKey);
        return loginElement.toString();
    }


}
