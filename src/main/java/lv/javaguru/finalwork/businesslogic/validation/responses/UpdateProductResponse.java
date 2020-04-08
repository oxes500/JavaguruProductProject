package lv.javaguru.finalwork.businesslogic.validation.responses;

import org.springframework.stereotype.Component;

@Component
public class UpdateProductResponse {

    private boolean success;
    private String errorMessage;

    public UpdateProductResponse(boolean success, String errorMessage) {
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