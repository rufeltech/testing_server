package ru.eltech.csa.siths.service.behaviour;

import java.util.Set;
import java.util.HashSet;

import ru.eltech.csa.siths.form.entity.FeaturedAccount;
import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.Role;

public interface AccountService {
 
    public boolean isNameInUse(String name);
    
    public boolean isEmailInUse(String email);

    public Account createAccount(FeaturedAccount featuredAccount, boolean emailConfirmationRequired);

    public Account createAccount(FeaturedAccount featuredAccount);

    public Account createAccount(Account account, boolean emailConfirmationRequired);

    public Account createAccount(Account account);

    public Account getAccountByEmail(String name);

    public Account getAccountByName(String email);

    public Set<Role> getAccountRoles(Account account);

    public Set<Role> getAccountRoles(String accountName);

}