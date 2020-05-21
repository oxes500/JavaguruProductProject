package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.user.UserLoginValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.user.UserValidator;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.User;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import static org.junit.Assert.*;

public class LoginUserServiceTest {

    @Mock
    private JPAUserRepository jpaUserRepository;

    @Mock
    private UserValidator userValidator;

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void loginUserServiceSuccess() {
        User user = new User("username", "password");
        LoginUserService victim = new LoginUserService(jpaUserRepository, userValidator);
        Mockito.when(jpaUserRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(true);
        UserLoginValidationResponse actual = victim.loginUser(user);
        assertTrue(actual.isSuccess());
        assertNull(actual.getErrorMessage());
    }

    @Test
    public void loginUserServiceNotSuccess() {
        User user = new User("username", "password");
        LoginUserService victim = new LoginUserService(jpaUserRepository, userValidator);
        Mockito.when(jpaUserRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword())).thenReturn(false);
        UserLoginValidationResponse actual = victim.loginUser(user);
        assertFalse(actual.isSuccess());
        assertEquals("User not found, please check provided data!", actual.getErrorMessage());
    }
}