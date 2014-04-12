package ru.eltech.csa.siths.service.implementation;

import java.util.Set;
import java.util.HashSet;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ru.eltech.csa.siths.form.entity.FeaturedAccount;
import ru.eltech.csa.siths.entity.node.Account;
import ru.eltech.csa.siths.entity.node.Role;
import ru.eltech.csa.siths.entity.relationship.Permission;
import ru.eltech.csa.siths.service.base.AbstractEntityService;
import ru.eltech.csa.siths.service.behaviour.AccountService;
import ru.eltech.csa.siths.repository.AccountRepository;

@Service
public class AccountServiceImpl extends AbstractEntityService<AccountRepository> implements AccountService  {
 
    public AccountServiceImpl(AccountRepository accountRepository) {
        super(accountRepository);
    }

    public AccountServiceImpl() {

    }

    public boolean isNameInUse(String name) {
    	if ( this.getAccountByName(name) != null )
    		return true;
    	else
    		return false;
    }
    
    public boolean isEmailInUse(String email) {
    	if ( this.getAccountByEmail(email) != null )
    		return true;
    	else
    		return false;
    }

    @Transactional
    public Account createAccount(FeaturedAccount featuredAccount, boolean emailConfirmationRequired) {
        if ( this.isNameInUse( featuredAccount.getName() )
             || this.isEmailInUse( featuredAccount.getEmail() ) )
            return null;
        try {
            Account account = new Account(featuredAccount);
            return this.entityRepository.save(account);
        } catch (Exception e) {
            return null;
        }    	
    }

    public Account createAccount(FeaturedAccount featuredAccount) {
    	return this.createAccount(featuredAccount, true);
    }

    @Transactional
    public Account createAccount(Account account, boolean emailConfirmationRequired) {
        if ( this.isNameInUse( account.getName() )
             || this.isEmailInUse( account.getEmail() ) )
            return null;
        try {
            return this.entityRepository.save(account);
        } catch (Exception e) {
            return null;
        }    
    }

    public Account createAccount(Account account) {
        return this.createAccount(account, true);
    }

    public Account getAccountByName(String name) {
        return this.entityRepository.findByName(name);
    }

    public Account getAccountByEmail(String email) {
        return this.entityRepository.findByEmail(email);
    }

    @Transactional
    public Set<Role> getAccountRoles(Account account) {
        Set<Role> accountRoles = new HashSet<Role>();
        Set<Permission> grantedPermissions = this.template.fetch( account.getPermissions() );
        for ( Permission permission : grantedPermissions ) {
            accountRoles.add( this.template.fetch( permission.getRole() ) );
        }
        return accountRoles;
    }

    public Set<Role> getAccountRoles(String accountName) {
        return this.getAccountRoles( this.getAccountByName(accountName) );
    }

}