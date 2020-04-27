
package lv.javaguru.finalwork.ui;

import lv.javaguru.finalwork.businesslogic.services.LoginUserService;
import lv.javaguru.finalwork.businesslogic.services.RegisterUserService;
import lv.javaguru.finalwork.businesslogic.validation.user.UserLoginValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.user.UserValidationResponse;
import lv.javaguru.finalwork.businesslogic.validation.user.UserValidator;
import lv.javaguru.finalwork.domain.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Scanner;

@Component
public class ProductLoginUI {

    @Autowired private RegisterUserService registerUserService;
    @Autowired private LoginUserService loginUserService;
    @Autowired private ProductMainUI productMainUI;
    static User logedInUser = new User();

    public void execute() {

        label:
        while (true) {
            System.out.println("");
            System.out.println("Welcome to Product application");
            System.out.println("If you want to register please enter - 1");
            System.out.println("If you want to login please enter - 2");
            System.out.println("If you want to exit please enter - 3");
            Scanner sc = new Scanner(System.in);
            String userChoice = sc.nextLine();

            switch (userChoice) {
                case "1": {
                    System.out.println("Please enter your credentials to register new profile,");
                    System.out.println("Please enter new username:");
                    String username = sc.nextLine();

                    System.out.println("Please enter new password:");
                    String password = sc.nextLine();

                    User newUser = new User(username, password);
                    UserValidationResponse userValidationResponse = registerUserService.registerUser(newUser);
                    if (userValidationResponse.isSuccess()) {
                        System.out.println("User successfully registered, you can login now, using your username and password");
                    }
                    break;
                }
                case "2": {
                    System.out.println("Please enter your credentials to login,");
                    System.out.println("Please enter your username:");
                    String username = sc.nextLine();

                    System.out.println("Please enter your password:");
                    String password = sc.nextLine();

                    User newUser = new User(username, password);

                    logedInUser.setUsername(newUser.getUsername());
                    logedInUser.setPassword(newUser.getPassword());


                    UserValidator userValidator = new UserValidator();
                    UserValidationResponse userValidationResponse = userValidator.validate(newUser);

                    if (userValidationResponse.isSuccess()) {
                        UserLoginValidationResponse userLoginValidationResponse = loginUserService.loginUser(logedInUser);
                        if (userLoginValidationResponse.isSuccess()) {
                            System.out.println("LOGIN SUCCESSFUL!");
                            System.out.println("");
                            productMainUI.executeMainUI();
                        } else {
                            System.out.println("User not found, please check provided data!");
                        }
                    } else {
                        System.out.println("Please check your credentials. Length should be more than 3 digits");
                    }
                    break;
                }
                case "3":
                    break label;
                default:
                    System.out.println("Please enter valid choice");
                    break;
            }
        }
    }
}