package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.user.UserValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.user.UserValidator;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class RegisterUserServiceTest {

    @Mock
    private JPAUserRepository jpaUserRepository;

    @Mock
    private UserValidator userValidator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void registerUserSuccess() {
        User user = new User("username", "password");
        RegisterUserService victim = new RegisterUserService(jpaUserRepository, userValidator);
        Mockito.when(userValidator.validate(user)).thenReturn(new UserValidationResponse(true, null));
        UserValidationResponse actual = victim.registerUser(user);
        assertTrue(actual.isSuccess());
        assertNull(actual.getErrorMessage());
    }

    @Test
    public void registerUserNotSuccess() {
        User user = new User("username", "password");
        RegisterUserService victim = new RegisterUserService(jpaUserRepository, userValidator);
        Mockito.when(userValidator.validate(user)).thenReturn(new UserValidationResponse(false, "User not registered"));
        UserValidationResponse actual = victim.registerUser(user);
        assertFalse(actual.isSuccess());
        assertEquals(actual.getErrorMessage(), "User not registered");
    }
}