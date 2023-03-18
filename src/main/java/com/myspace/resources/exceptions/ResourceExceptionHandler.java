package com.myspace.resources.exceptions;

import com.myspace.services.exceptions.ObjectNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.Instant;

@ControllerAdvice
public class ResourceExceptionHandler {

    private final Logger LOG = LoggerFactory.getLogger(getClass());

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<StandardError> objectNotFound(ObjectNotFoundException e, HttpServletRequest request) {
        var error = "Resource Not Found";
        var status = HttpStatus.NOT_FOUND;
        var err = new StandardError(Instant.now(), status.value(), error, e.getMessage(), request.getRequestURI());

        LOG.error(String.format("%d %s %s", status, error, err));
        return ResponseEntity.status(status).body(err);
    }
}