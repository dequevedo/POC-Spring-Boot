package com.pocspringboot.controller;//package com.dequevedo.POCSpringBoot.controller;
//
//import com.dequevedo.POCSpringBoot.exception.NotFoundException;
//import com.dequevedo.POCSpringBoot.exception.UnprocessableEntityException;
//import com.dequevedo.POCSpringBoot.model.response.ErrorResponse;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.MessageSource;
//import org.springframework.context.i18n.LocaleContextHolder;
//import org.springframework.http.HttpStatus;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//@RestControllerAdvice
//@RequiredArgsConstructor
//public class ControllerExceptionHandler {
//
//    private final MessageSource messageSource;
//
//    @ExceptionHandler(NotFoundException.class)
//    public ErrorResponse notFoundExceptionHandler(Exception ex) {
//        return ErrorResponse.builder()
//                .code(String.valueOf(HttpStatus.NOT_FOUND.value()))
//                .message(getMessage("404.000"))
//                .build();
//    }
//
//    @ExceptionHandler(UnprocessableEntityException.class)
//    public ErrorResponse unprocessableEntityExceptionHandler(Exception ex) {
//        return ErrorResponse.builder()
//                .code(String.valueOf(HttpStatus.UNPROCESSABLE_ENTITY.value()))
//                .message(getMessage("422.000"))
//                .build();
//    }
//
//    @ExceptionHandler(Exception.class)
//    public ErrorResponse globalExceptionHandler(Exception ex) {
//        return ErrorResponse.builder()
//                .code(String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()))
//                .message(getMessage("500.000"))
//                .build();
//    }
//
//    private String getMessage(String code, Object... args) {
//        return this.messageSource.getMessage(code, args, LocaleContextHolder.getLocale());
//    }
//}
