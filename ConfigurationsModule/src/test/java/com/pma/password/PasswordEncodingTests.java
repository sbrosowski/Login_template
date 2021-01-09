package com.pma.password;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;


@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class PasswordEncodingTests {

    String expectedEncodedPassword;

    @BeforeAll
    public void setupTest() {
        expectedEncodedPassword = "$2a$10$Lps9OuVVurWL60DjJ73OH.mRlUfyOkFm/Dw/5yknrXWCpNqkP/ol2";
    }

    @Test
    public void shouldEncodePasswordTest() {
        CharSequence rawPassword = "12345678910#.!";
        String actualEncodedPassword = PasswordEncoderImpl.getInstance().encode(rawPassword);
        Assertions.assertNotNull(actualEncodedPassword);
    }

    @Test
    public void shouldMatchPasswordTest() {
        CharSequence rawPassword = "12345678910#.!";
        boolean isActualEqualPassword = PasswordEncoderImpl.getInstance().matches(rawPassword, expectedEncodedPassword);
        Assertions.assertTrue(isActualEqualPassword);
    }

    @Test
    public void shouldFailMatchPasswordTest() {
        CharSequence rawPassword = "128910#.!";
        boolean isActualEqualPassword = PasswordEncoderImpl.getInstance().matches(rawPassword, expectedEncodedPassword);
        Assertions.assertFalse(isActualEqualPassword);
    }
}
