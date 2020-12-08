package com.pma.demo;

import com.pma.demo.Controller.LoginController;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
public class SmokeTest {

    @Autowired
    private LoginController loginController;


    @Test
    void contextLoads() {
        Assertions.assertNotNull(loginController);
    }

}
