package com.custom;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

/**
 * @author lzn
 */

public class NotRegisterValidator
        implements ConstraintValidator<NotRegister,String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if(value.length()==11){
            return true;
        }else {
            return false;
        }
    }
}
