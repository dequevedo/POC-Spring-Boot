package com.pocspringboot.model.response;

import com.pocspringboot.configuration.MessageConfig;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ErrorResponse {
    private final String code;
    private final String message;

    public ErrorResponse(String code, Object... args) {
        this.code = code;
        this.message = new MessageConfig().getMessage(code, args);
    }
}