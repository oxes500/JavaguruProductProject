package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.user.UserLoginValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.user.UserValidator;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class LoginUserService {

    @Autowired private JPAUserRepository jpaUserRepository;
    @Autowired private UserValidator userValidator;

    public LoginUserService(JPAUserRepository jpaUserRepository, UserValidator userValidator) {
        this.jpaUserRepository = jpaUserRepository;
        this.userValidator = userValidator;
    }

    public UserLoginValidationResponse loginUser(User user) {
        if (jpaUserRepository.existsByUsernameAndPassword(user.getUsername(), user.getPassword())) {
            return new UserLoginValidationResponse(true, null);
        } else {
            return new UserLoginValidationResponse(false, "User not found, please check provided data!");
        }
    }
}