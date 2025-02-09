package com.kosign.dev.exception;

import com.kosign.dev.common.api.ApiResponse;
import com.kosign.dev.common.api.ApiStatus;
import com.kosign.dev.common.api.EmptyJsonResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@Order(Ordered.HIGHEST_PRECEDENCE)
@RestControllerAdvice
@Component
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(CusNotFoundException.class)
    protected ResponseEntity<Object> handleEntityNotFound(
            CusNotFoundException ex
    ) {

        return buildResponseEntity(new ApiStatus(NOT_FOUND.value(), ex.getMessage()));
    }

    public ResponseEntity<Object> buildResponseEntity(ApiStatus apiStatus) {
        ApiResponse<Object> apiResponse = new ApiResponse<>(apiStatus, new EmptyJsonResponse());
        return new ResponseEntity<>(apiResponse, BAD_REQUEST);
    }

}
