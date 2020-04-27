package lv.javaguru.finalwork.businesslogic.validation.user;

import java.util.List;

public class UserValidationResponse {

    private boolean success;
    private String errorMessage;

    public UserValidationResponse(boolean success, String errorMessage) {
        this.success = success;
        this.errorMessage = errorMessage;
    }

    public boolean isSuccess() {
        return success;
    }

    public String getErrorMessage() {
        return errorMessage;
    }
}