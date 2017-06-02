package org.nc.edu.internet_store.mvc.validator;

import org.nc.edu.internet_store.mvc.domain.Category;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CategoryValidator implements Validator{

    @Override
    public boolean supports(Class<?> clazz) {
        return Category.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object targets, Errors errors) {
        Category category = (Category) targets;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"category","NotEmpty.category","Required category");

        if (category.getCategory().length() > 80){
            errors.rejectValue("category","Too long category name");
        }
    }
}
