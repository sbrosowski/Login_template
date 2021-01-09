package com.pma.userservice;


import com.google.gson.Gson;
import com.pma.DTO.LoginDTO;
import com.pma.DTO.UserRegistrationDTO;
import com.pma.user.UserService;
import lombok.AllArgsConstructor;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@AllArgsConstructor
public class UserServiceTests {

    private final UserService userService;

    private UserRegistrationDTO setupLoginRegistrationDTO() {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setEmail("test@test.com");
        userRegistrationDTO.setFirstName("Max");
        userRegistrationDTO.setSurname("Mustermann");
        userRegistrationDTO.setUsername("admin");
        userRegistrationDTO.setPassword("admin123");
        return new UserRegistrationDTO();
    }


    @Test
    public void shouldFailLoginByUsername() {
        LoginDTO incoming = new LoginDTO(null, "password123");

        String resultJson = userService.doLogin(new Gson().toJson(incoming));

        LoginDTO parsedDTO = new Gson().fromJson(resultJson, LoginDTO.class);
        assertEquals(UserService.CREDENTIALS_WRONG, parsedDTO.getResultMessage());
        assertFalse(parsedDTO.isSuccessful());
        assertNull(parsedDTO.getUser());
        assertNull(parsedDTO.getPassword());
    }

    @Test
    public void shouldFailLoginByPassword() {

        LoginDTO incoming = new LoginDTO("admin", null);
        String resultJson = userService.doLogin(new Gson().toJson(incoming));

        LoginDTO parsedDTO = new Gson().fromJson(resultJson, LoginDTO.class);
        assertEquals(UserService.CREDENTIALS_WRONG, parsedDTO.getResultMessage());
        assertFalse(parsedDTO.isSuccessful());
        assertNull(parsedDTO.getUser());
        assertNull(parsedDTO.getPassword());
    }

    @Test
    public void shouldFailLoginByEmptyPassword() {

        LoginDTO incoming = new LoginDTO("admin", "");
        String resultJson = userService.doLogin(new Gson().toJson(incoming));

        LoginDTO parsedDTO = new Gson().fromJson(resultJson, LoginDTO.class);
        assertEquals(UserService.CREDENTIALS_WRONG, parsedDTO.getResultMessage());
        assertFalse(parsedDTO.isSuccessful());
        assertNull(parsedDTO.getUser());
        assertNull(parsedDTO.getPassword());
    }

    @Test
    public void shouldFailLoginByEmptyLogin() {

        LoginDTO incoming = new LoginDTO("", "123455");
        String resultJson = userService.doLogin(new Gson().toJson(incoming));

        LoginDTO parsedDTO = new Gson().fromJson(resultJson, LoginDTO.class);
        assertEquals(UserService.CREDENTIALS_WRONG, parsedDTO.getResultMessage());
        assertFalse(parsedDTO.isSuccessful());
        assertNull(parsedDTO.getUser());
        assertNull(parsedDTO.getPassword());
    }

    @Test
    public void shouldSucceedLogin() {
        LoginDTO incoming = new LoginDTO("admin", "admin");

        String resultJson = userService.doLogin(new Gson().toJson(incoming));
        LoginDTO parsedDTO = new Gson().fromJson(resultJson, LoginDTO.class);
        assertEquals(UserService.CREDENTIALS_CORRECT, parsedDTO.getResultMessage());
        assertTrue(parsedDTO.isSuccessful());
        assertNull(parsedDTO.getUser());
        assertNull(parsedDTO.getPassword());
    }

    @Test
    public void shouldSucceedRegistration() {

        UserRegistrationDTO userRegistrationSuccessful = setupLoginRegistrationDTO();

        String resultJson = userService.doRegistration(new Gson().toJson(userRegistrationSuccessful));
        LoginDTO parsedDTO = new Gson().fromJson(resultJson, LoginDTO.class);
        assertEquals(UserService.CREDENTIALS_CORRECT, parsedDTO.getResultMessage());
        assertTrue(parsedDTO.isSuccessful());
        assertNull(parsedDTO.getUser());
        assertNull(parsedDTO.getPassword());
    }

}
