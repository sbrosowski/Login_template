package com.pma.demo.userservice;


import com.pma.demo.Services.Impl.DTO.LoginDTO;
import com.pma.demo.Services.Interfaces.UserService;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.assertEquals;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class UserServiceTests {


    private UserService userService;

    @BeforeAll
    public void setUp(){
        this.userService= new UserServiceImpl();
    }

    @Test
    public void shouldFailByUsername(){
        LoginDTO incoming = new LoginDTO(null, "password123");
        LoginDTO result= userService.doLogin(incoming);

        assertEquals(UserService.CREDENTIALS_WRONG,result.getResultMessage());
        assertEquals(false,result.isSuccessful());
        assertEquals(null,result.getUser());
        assertEquals(null,result.getPassword());
    }

    @Test
    public void shouldFailByPassword(){

        LoginDTO incoming = new LoginDTO("admin", null);
        LoginDTO result=userService.doLogin(incoming);

        assertEquals(UserService.CREDENTIALS_WRONG,result.getResultMessage());
        assertEquals(false,result.isSuccessful());
        assertEquals(null,result.getUser());
        assertEquals(null,result.getPassword());
    }

    @Test
    public void shouldSucceed(){

        LoginDTO incoming = new LoginDTO("admin", "admin");
        LoginDTO result=userService.doLogin(incoming);

        assertEquals(UserService.CREDENTIALS_CORRECT,result.getResultMessage());
        assertEquals(true,result.isSuccessful());
        assertEquals(null,result.getUser());
        assertEquals(null,result.getPassword());
    }

}
