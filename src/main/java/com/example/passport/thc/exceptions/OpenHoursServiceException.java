package com.example.passport.thc.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class OpenHoursServiceException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public OpenHoursServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public OpenHoursServiceException(String message) {
        super(message);
    }
}
