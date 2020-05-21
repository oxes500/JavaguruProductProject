package lv.javaguru.finalwork.businesslogic.validation.user;

import lv.javaguru.finalwork.domain.User;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserValidatorTest {

    @Test
    public void validateSuccess() {
        UserValidator victim = new UserValidator();
        User user = new User("username", "password");
        assertTrue(victim.validate(user).isSuccess());
        assertNull(victim.validate(user).getErrorMessage());
    }

    @Test
    public void validateNotSuccessLengthUser() {
        UserValidator victim = new UserValidator();
        User user = new User("", "password");
        assertFalse(victim.validate(user).isSuccess());
        assertEquals(victim.validate(user).getErrorMessage(), "Please check your credentials. Length should be more than 3 digits");
    }

    @Test
    public void validateNotSuccessLengthPass() {
        UserValidator victim = new UserValidator();
        User user = new User("username", "");
        assertFalse(victim.validate(user).isSuccess());
        assertEquals(victim.validate(user).getErrorMessage(), "Please check your credentials. Length should be more than 3 digits");
    }

    @Test
    public void validateNotSuccessLengthUserMoreThan3() {
        UserValidator victim = new UserValidator();
        User user = new User("u", "password");
        assertFalse(victim.validate(user).isSuccess());
        assertEquals(victim.validate(user).getErrorMessage(), "Please check your credentials. Length should be more than 3 digits");
    }

    @Test
    public void validateNotSuccessLengthPassMoreThan3() {
        UserValidator victim = new UserValidator();
        User user = new User("username", "p");
        assertFalse(victim.validate(user).isSuccess());
        assertEquals(victim.validate(user).getErrorMessage(), "Please check your credentials. Length should be more than 3 digits");
    }

    @Test
    public void validateNotSuccessNull() {
        UserValidator victim = new UserValidator();
        User user = new User();
        assertFalse(victim.validate(user).isSuccess());
        assertEquals(victim.validate(user).getErrorMessage(), "Please check your credentials. Length should be more than 3 digits");
    }
}