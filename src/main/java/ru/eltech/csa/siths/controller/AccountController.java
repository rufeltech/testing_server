package ru.eltech.csa.siths.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.beans.factory.annotation.Autowired;

import ru.eltech.csa.siths.form.entity.FeaturedAccount;
import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.service.behaviour.AccountService;

@Controller
public class AccountController {

    @Autowired
    private AccountService accountService;

	@RequestMapping(value="/account/create", method=RequestMethod.GET)
    public String getAccountCreationFormAction(Model model) {
        model.addAttribute("featuredAccount", new FeaturedAccount());
        return "registrationView";
    }

    @RequestMapping(value="/account/create", method=RequestMethod.POST)
    public String createAccountAction(@Valid FeaturedAccount featuredAccount, BindingResult bindingResult) {
        // ToDo:
        // 1. Put password form entity to another class for reuse
        // 2. Find a good way to validate two fields equal each other
        if ( bindingResult.hasErrors() ) {
            return "registrationView";
        }
        if ( !featuredAccount.getPassword().equals(featuredAccount.getPasswordConfirmation()) ) {
            bindingResult.rejectValue("password", "error.password", "Passwords should match");
        }
        if ( this.accountService.isNameInUse( featuredAccount.getName() ) ) {
            bindingResult.rejectValue("name", "error.name", "Account with the same name already exists");
        }
        if ( this.accountService.isEmailInUse( featuredAccount.getEmail() ) ) {
            bindingResult.rejectValue("email", "error.email", "Account with the same email already exists");
        }
        if ( bindingResult.hasErrors() ) {
            return "registrationView";
        }

        Account registeredAccount = this.accountService.createAccount(featuredAccount);
        if (registeredAccount == null) {
            // ToDo:
            // 1. Assign error to object, not to field 
            bindingResult.rejectValue("name", "error.name", "An error occured while registering account");
            return "registrationView";
        }

        return "redirect:/";
    }

    @RequestMapping(value="/account/success", method=RequestMethod.GET)
    public String registrationSuccessAction( Model model ) {
        model.addAttribute("account", new String("123") );
        return "authenticationView";
    }

    @RequestMapping(value="/account/login", method=RequestMethod.GET)
    public String loginAction(Model model) {
        return "loginFormView";
    }

    @RequestMapping(value="/account/logout", method=RequestMethod.POST)
    public String logoutAction(Model model) {
        return "loginFormView";
    }

    @RequestMapping(value="/account/delete", method=RequestMethod.POST)
    public String deleteAccountAction(Model model) {
        model.addAttribute("greeting", new String("Account deleted"));
        return "helloTmpl";
    }

    @RequestMapping(value="/account/validate/{validationCode:[a-fA-F0-9]{32}}", method=RequestMethod.GET)
    public String validateAccountAction( Model model, 
    	                                 @PathVariable("validationCode") String validationCode) {
        model.addAttribute("greeting", new String("Account validated with key #" + validationCode));
        return "helloTmpl";
    }

    @RequestMapping(value="/account/view/{name}", method=RequestMethod.GET)
    public String viewAccountAction( Model model, 
                                     @PathVariable("name") String name) {
        // ToDo:
        // 1. Make a pattern check for name in url
        model.addAttribute("account", this.accountService.getAccountByName(name) );
        return "accountView";
    }

}
