package ru.eltech.csa.siths.form.entity;

import java.lang.reflect.Method;

import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotEmpty;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.ScriptAssert;
import org.junit.Test;

public class FeaturedAccount {

    @NotEmpty(message = "Account name field should not be empty")
    @Size(min = 3, max = 32, message = "Account name should be between {min} and {max} characters long")
    public String name;

    @NotEmpty(message = "Email field should not be empty")
    @Email(message="Email address shold be valid")
    public String email;

    @NotEmpty(message = "Password field should not be empty")
    @Size(min = 6, max = 32, message = "Password should be between {min} and {max} characters long")
    private String password;

    @NotEmpty(message = "Password confirmation field should not be empty")
    @Size(min = 6, max = 32, message = "Password confirmation should be between {min} and {max} characters long")
    public String passwordConfirmation;

    public FeaturedAccount(String name, String email, String password, String passwordConfirmation) {
        this.name = name;
        this.email = email;
        this.password = password;
        this.passwordConfirmation = passwordConfirmation;
    }
  
    public FeaturedAccount() {

    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return this.email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPasswordConfirmation(String passwordConfirmation) {
        this.passwordConfirmation = passwordConfirmation;
    }

    public String getPasswordConfirmation() {
        return this.passwordConfirmation;
    }

}