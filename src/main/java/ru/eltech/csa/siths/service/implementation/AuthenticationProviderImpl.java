package ru.eltech.csa.siths.service.implementation;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ru.eltech.csa.siths.service.behaviour.AccountService;
import ru.eltech.csa.siths.entity.node.Account;

@Service
public class AuthenticationProviderImpl implements AuthenticationProvider {

    @Autowired
    AccountService accountService;

    public AuthenticationProviderImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    public AuthenticationProviderImpl() {

    }

    public void setAccountService(AccountService accountService) {
        this.accountService = accountService;
    }

    public AccountService getAccountService() {
        return this.accountService;
    }
            
    public boolean supports(Class<?> authentication) {
        return true;
    }
    
    public Authentication authenticate(Authentication authentication) throws AuthenticationException {
        Object principal = authentication.getPrincipal();
        String username = String.valueOf(principal);
        Account account = accountService.getAccountByName(username);

        if ( account == null ) {
            throw new UsernameNotFoundException("No account for principal " + principal);
        }
        if ( !authentication.getCredentials().equals( account.getPasswordHash() ) ) {
            throw new BadCredentialsException("Invalid password");
        }
        return new UsernamePasswordAuthenticationToken(principal, 
            account.getPasswordHash(), 
            accountService.getAccountRoles(account)  );
    }
}