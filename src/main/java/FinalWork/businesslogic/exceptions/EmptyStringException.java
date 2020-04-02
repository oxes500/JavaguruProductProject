package FinalWork.businesslogic.exceptions;

public class EmptyStringException extends RuntimeException {

    private String errorMessage;

    public EmptyStringException(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return "Please enter value and press ENTER";
    }
}
