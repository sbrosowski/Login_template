package com.pma.demo.LoginControllerTest;

import com.google.gson.Gson;
import com.pma.demo.Controller.LoginController;
import com.pma.demo.Services.Impl.DTO.LoginDTO;
import com.pma.demo.Services.Impl.DTO.UserRegistrationDTO;
import com.pma.demo.Services.Interfaces.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LoginController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginControllerTests {

    @Autowired
    private MockMvc mockMvc;
    @MockBean
    private UserService service;

    private LoginDTO loginSuccessful;
    private LoginDTO loginSuccessfulResult;
    private UserRegistrationDTO userRegistrationSuccessful;


    @BeforeAll
    public void setUp() {
        loginSuccessful = setupLoginSuccessful();
        loginSuccessfulResult = setupLoginSuccessfulResult();
        userRegistrationSuccessful = setupLoginRegistrationDTO();
    }

    private LoginDTO setupLoginSuccessful() {
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("admin");
        loginDTO.setUser("admin");
        return loginDTO;
    }

    private LoginDTO setupLoginSuccessfulResult() {
        return new LoginDTO(UserService.CREDENTIALS_CORRECT, true);
    }

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
    public void shouldReturnMessageOnLogin() throws Exception {
        Gson g = new Gson();

        when(this.service.doLogin(g.toJson(loginSuccessful))).
                thenReturn(g.toJson(loginSuccessfulResult));

        this.mockMvc.perform(post("/login").
                header(CONTENT_TYPE, APPLICATION_JSON_VALUE).
                content(g.toJson(loginSuccessful)).
                accept(APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().json(g.toJson(loginSuccessfulResult))).
                andReturn();
    }


    @Test
    public void shouldReturnMessageOnRegistration() throws Exception {
        Gson g = new Gson();

        when(this.service.doRegistration(g.toJson(userRegistrationSuccessful))).
                thenReturn(g.toJson(loginSuccessfulResult));

        this.mockMvc.perform(post("/login/register").
                header(CONTENT_TYPE, APPLICATION_JSON_VALUE).
                content(g.toJson(userRegistrationSuccessful)).
                accept(APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().json(g.toJson(loginSuccessfulResult))).
                andReturn();
    }
}
