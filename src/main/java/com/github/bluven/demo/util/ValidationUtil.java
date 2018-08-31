package com.github.bluven.demo.util;

import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by bluven on 3/31/18
 */

public class ValidationUtil {

    public static Map<String, String> fromBindingErrors(Errors errors) {

        Map<String, String> validErrors = new HashMap<>();

        for (ObjectError error : errors.getGlobalErrors()) {
            System.out.println(error);
            validErrors.put(error.getObjectName(), error.getDefaultMessage());
        }

        for (FieldError error : errors.getFieldErrors()) {
            System.out.println(error);
            validErrors.put(error.getField(), error.getDefaultMessage());
        }
        return validErrors;
    }
}
