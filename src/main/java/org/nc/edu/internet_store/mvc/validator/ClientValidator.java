package org.nc.edu.internet_store.mvc.validator;

import org.apache.commons.validator.routines.EmailValidator;
import org.nc.edu.internet_store.mvc.dao.AccountDAO;
import org.nc.edu.internet_store.mvc.domain.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class ClientValidator implements Validator {

    private EmailValidator emailValidator = EmailValidator.getInstance();

    @Autowired
    private AccountDAO accountDAO;

    @Override
    public boolean supports(Class<?> clazz){
        return Account.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object targets, Errors errors){
        Account account = (Account) targets;

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"firstName","NotEmpty.clientR.firstName","First Name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"lastName","NotEmpty.clientR.lastName","Last Name is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"address","NotEmpty.clientR.address","Address is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"login","NotEmpty.clientR.login","Login is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phone","NotEmpty.clientR.phone","Phone is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password","NotEmpty.clientR.password","Password is required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"passwordConfirm","NotEmpty.clientR.passwordConfirm","Wrong password");

        Account acc = accountDAO.findAccount(account.getLogin());

        if (acc != null)
            if (acc.getLogin().equals(account.getLogin())){
                errors.rejectValue("login", "","This login is already taken");
            }

        if (!account.getPassword().equals(account.getPasswordConfirm())){
            errors.rejectValue("password", "notMatch.clientR.passwordC","Passwords is not match");
        }

        if(!emailValidator.isValid(account.getEmail())){
            errors.rejectValue("email", "Pattern.clientR.email","E-mail is not valid");
        }
    }
}
