package lesson15;

public class ProductResponse {

    private boolean success;
    private String errorMessage;

    public ProductResponse(boolean success,
                           String errorMessage) {
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
