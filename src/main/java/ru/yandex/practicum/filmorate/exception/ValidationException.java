package ru.yandex.practicum.filmorate.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;


    public static class ValidationException extends ResponseStatusException {
        public ValidationException(final HttpStatus httpStatus) {
            super(httpStatus);
        }
    }
}
