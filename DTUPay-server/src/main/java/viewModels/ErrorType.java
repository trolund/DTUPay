package dto;

import java.io.Serializable;

public class ErrorType implements Serializable {


    private String errorMessage;

    public ErrorType(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }
}
