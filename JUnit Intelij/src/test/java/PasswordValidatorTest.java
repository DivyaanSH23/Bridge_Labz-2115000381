
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class PasswordValidatorTest {
    PasswordValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PasswordValidator();
    }

    @Test
    public void testValidPassword() {
        assertTrue(validator.validate("Password1"));
    }

    @Test
    public void testInvalidPasswordLength() {
        assertFalse(validator.validate("Pass1"));
    }

    @Test
    public void testInvalidPasswordUpperCase() {
        assertFalse(validator.validate("password1"));
    }

    @Test
    public void testInvalidPasswordDigit() {
        assertFalse(validator.validate("Password"));
    }
}
