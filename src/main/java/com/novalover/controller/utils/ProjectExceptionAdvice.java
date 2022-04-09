package com.novalover.controller.utils;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ProjectExceptionAdvice {

    @ExceptionHandler
    public R doExceptionAdvice(Exception ex){
        ex.getStackTrace();
        return new R("Server is too busy!");
    }

}
