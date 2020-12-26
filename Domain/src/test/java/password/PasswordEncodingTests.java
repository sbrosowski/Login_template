package password;

import com.pma.demo.services.password.PasswordEncoder;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import static org.junit.jupiter.api.Assertions.*;

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
        String actualEncodedPassword = PasswordEncoder.encode(rawPassword);
        assertNotNull(actualEncodedPassword);
    }

    @Test
    public void shouldMatchPasswordTest() {
        CharSequence rawPassword = "12345678910#.!";
        boolean isActualEqualPassword = PasswordEncoder.matches(rawPassword, expectedEncodedPassword);
        assertTrue(isActualEqualPassword);
    }

    @Test
    public void shouldFailMatchPasswordTest() {
        CharSequence rawPassword = "128910#.!";
        boolean isActualEqualPassword = PasswordEncoder.matches(rawPassword, expectedEncodedPassword);
        assertFalse(isActualEqualPassword);
    }
}
