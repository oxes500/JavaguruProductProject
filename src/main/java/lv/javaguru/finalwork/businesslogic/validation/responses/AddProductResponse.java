package lv.javaguru.finalwork.businesslogic.validation.responses;

import java.util.List;

public class AddProductResponse {

    private boolean success;
    private List<String> errorMessages;

    public AddProductResponse(boolean success, List<String> errorMessages) {
        this.success = success;
        this.errorMessages = errorMessages;
    }

    public boolean isSuccess() {
        return success;
    }

    public List<String> getErrorMessages() {
        return errorMessages;
    }
}
