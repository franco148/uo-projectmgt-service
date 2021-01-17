package com.umssonline.projmgt.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.PRECONDITION_FAILED)
public class InvalidPreConditionException extends RuntimeException {

    public InvalidPreConditionException(String message) {
        super(message);
    }
}
