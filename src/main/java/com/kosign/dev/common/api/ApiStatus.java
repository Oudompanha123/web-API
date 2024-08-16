package com.kosign.dev.common.api;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class ApiStatus {
    private int code;
    private String message;

    public ApiStatus(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ApiStatus(StatusCode statusCode) {
        this.code = statusCode.getCode();
        this.message = statusCode.getMessage();
    }
}
