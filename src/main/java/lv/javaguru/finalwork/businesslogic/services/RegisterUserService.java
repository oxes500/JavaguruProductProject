
package lv.javaguru.finalwork.businesslogic.services;

import lv.javaguru.finalwork.businesslogic.validation.user.UserValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.user.UserValidator;
import lv.javaguru.finalwork.database.JPAUserRepository;
import lv.javaguru.finalwork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

@Component
public class RegisterUserService {

    @Autowired private JPAUserRepository jpaUserRepository;
    @Autowired private UserValidator userValidator;

    public RegisterUserService(JPAUserRepository jpaUserRepository, UserValidator userValidator) {
        this.jpaUserRepository = jpaUserRepository;
        this.userValidator = userValidator;
    }

    @Transactional
    public UserValidationResponse registerUser(User user) {
        UserValidationResponse userValidationResponse = userValidator.validate(user);
        if (userValidationResponse.isSuccess()) {
            jpaUserRepository.save(user);
            return new UserValidationResponse(true, null);
        } else {
            return new UserValidationResponse(false, userValidationResponse.getErrorMessage());
        }
    }
}