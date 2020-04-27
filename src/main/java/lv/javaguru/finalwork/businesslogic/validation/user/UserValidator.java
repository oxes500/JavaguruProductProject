package lv.javaguru.finalwork.businesslogic.validation.user;

import lv.javaguru.finalwork.domain.User;
import org.springframework.stereotype.Component;

@Component
public class UserValidator {

    public UserValidationResponse validate(User user) {
        if (user.getUsername()!= null
                && !user.getUsername().equals("")
                && user.getUsername().length() > 3
                && user.getPassword()!= null
                && !user.getPassword().equals("")
                && user.getPassword().length() > 3) {
            return new UserValidationResponse(true, null);
        } else {
            return new UserValidationResponse(false, "Please check your credentials. Length should be more than 3 digits");
        }
    }
}