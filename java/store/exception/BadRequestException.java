package store.exception;

import store.exception.AppException;

public class BadRequestException extends AppException {
    public BadRequestException(String message) {
        super(message);
    }
}
