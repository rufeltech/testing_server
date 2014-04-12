package ru.eltech.csa.siths.bean.configuration;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ru.eltech.csa.siths.repository.AccountRepository;
import ru.eltech.csa.siths.service.implementation.AccountServiceImpl;

@Configuration
public class AccountServiceBeanConfiguration {

    @Autowired
    AccountRepository accountRepository;

    @Bean
    public AccountServiceImpl accountService() {
        AccountServiceImpl accountService = new AccountServiceImpl(accountRepository);

        return accountService;
    }

}