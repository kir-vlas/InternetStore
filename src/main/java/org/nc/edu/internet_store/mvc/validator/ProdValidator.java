package org.nc.edu.internet_store.mvc.validator;

import org.nc.edu.internet_store.mvc.domain.Good;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ProdValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Good.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object targets, Errors errors) {
        Good good = (Good) targets;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"title","NotEmpty.good.title","Title is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"price","NotEmpty.good.price","Price is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"description","NotEmpty.good.description","Description is required");

        if (good.getDescription() != null)
            if(good.getDescription().length() > 7000){
                errors.rejectValue("description", "Too long description");
            }
    }
}
