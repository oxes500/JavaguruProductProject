package lv.javaguru.finalwork.businesslogic.validation.user;

public class UserLoginValidationResponse {

    private boolean success;
    private String errorMessage;

    public UserLoginValidationResponse(boolean success, String errorMessage) {
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
