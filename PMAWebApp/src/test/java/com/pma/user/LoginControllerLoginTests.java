package com.pma.user;

import com.google.gson.Gson;
import com.pma.DTO.LoginDTO;
import com.pma.DTO.UserRegistrationDTO;
import com.pma.controller.LoginController;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LoginController.class)
@ContextConfiguration
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginControllerLoginTests {


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
        userRegistrationDTO.setSurname("Mustermann");
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
}
