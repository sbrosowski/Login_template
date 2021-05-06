package com.pma.user;

import com.pma.controller.AuthenticationController;
import com.pma.controller.LoginController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SmokeTest {

    @Autowired
    private LoginController loginController;

    @Autowired
    private AuthenticationController authenticationController;


    @Test
    void contextLoads() {
        Assertions.assertNotNull(loginController);
        Assertions.assertNotNull(authenticationController);
    }

}
