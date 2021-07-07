package com.example.passport.thc.exceptions;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class LocationServiceException extends RuntimeException {
    public static final long serialVersionUID = 1L;

    public LocationServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public LocationServiceException(String message) {
        super(message);
    }
}
