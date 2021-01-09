package com.pma.user;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.pma.DTO.LoginDTO;
import com.pma.DTO.UserRegistrationDTO;
import org.apache.commons.lang3.StringUtils;


class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


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

        //String encodedPassword = PasswordEncoder.encode(userRegistration.getPassword());

        return gsonResult.toJson(new LoginDTO(CREDENTIALS_CORRECT, true));
    }


    private LoginDTO containsCredentials(LoginDTO loginDTO) {

        if (StringUtils.isNotEmpty(loginDTO.getUser()) || StringUtils.isNotEmpty(loginDTO.getPassword())) {
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
