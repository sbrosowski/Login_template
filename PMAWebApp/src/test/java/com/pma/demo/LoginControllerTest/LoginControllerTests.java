package com.pma.demo.LoginControllerTest;

import com.google.gson.Gson;
import com.pma.demo.Login.LoginController;
import com.pma.demo.Login.LoginDTO;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;

import static org.springframework.http.HttpHeaders.CONTENT_TYPE;
import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@WebMvcTest(LoginController.class)
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class LoginControllerTests {

    @Autowired
    private MockMvc mockMvc;

    private String loginDtoString;
    private String loginDtoResult;

    @BeforeAll
    public void setUp() {
        loginDtoString = setupLoginDto();
        loginDtoResult = setupLoginFailedResult();
    }

    private String setupLoginDto() {
        Gson g = new Gson();
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setPassword("passwort123");
        loginDTO.setUser("admin");
        return g.toJson(loginDTO);
    }

    private String setupLoginFailedResult() {
        Gson g = new Gson();
        LoginDTO loginDTO = new LoginDTO();
        loginDTO.setResultMessage("Login Failed");
        return g.toJson(loginDTO);
    }


    @Test
    public void doLogin() throws Exception {

        MvcResult mvcResult = this.mockMvc.perform(post("/login").
                header(CONTENT_TYPE, APPLICATION_JSON_VALUE).
                content(loginDtoString).
                secure(false).
                accept(MediaType.APPLICATION_JSON)).
                andExpect(status().isOk()).
                andExpect(content().json(loginDtoResult)).
                andReturn();

        mvcResult.toString();
//       this.mockMvc.perform(asyncDispatch(mvcResult)).
//               andExpect(status().isOk()).
//               andExpect(header().string(CONTENT_TYPE, APPLICATION_JSON_VALUE)).
//               andExpect(jsonPath("message").value("hello"));

    }

}
