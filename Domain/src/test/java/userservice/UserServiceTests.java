package userservice;


import com.google.gson.Gson;
import com.pma.demo.services.Impl.DTO.LoginDTO;
import com.pma.demo.services.Impl.DTO.UserRegistrationDTO;
import com.pma.demo.services.Interfaces.UserService;
import com.pma.demo.services.ServicesConfig;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.*;


@ExtendWith(SpringExtension.class)
@ContextConfiguration(classes = ServicesConfig.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {

    @Autowired
    private UserService userService;

    private UserRegistrationDTO setupLoginRegistrationDTO() {
        UserRegistrationDTO userRegistrationDTO = new UserRegistrationDTO();
        userRegistrationDTO.setEmail("test@test.com");
        userRegistrationDTO.setFirstName("Max");
        userRegistrationDTO.setLastName("Mustermann");
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
