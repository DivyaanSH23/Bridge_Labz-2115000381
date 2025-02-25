import static org.junit.jupiter.api.Assertions.*;
        import org.junit.jupiter.api.Test;

public class StringUtilsTest {
    StringUtils stringUtils = new StringUtils();

    @Test
    public void testReverse() {
        assertEquals("cba", stringUtils.reverse("abc"));
    }

    @Test
    public void testIsPalindrome() {
        assertTrue(stringUtils.isPalindrome("madam"));
        assertFalse(stringUtils.isPalindrome("hello"));
    }

    @Test
    public void testToUpperCase() {
        assertEquals("HELLO", stringUtils.toUpperCase("hello"));
    }
}
