package lv.javaguru.finalwork.businesslogic.validation;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductValidationResponse {

    private boolean success;
    private List<String> errorMessages;

    public ProductValidationResponse(boolean success, List<String> errorMessages) {
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
