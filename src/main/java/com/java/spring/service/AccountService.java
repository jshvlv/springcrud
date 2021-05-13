package com.java.spring.service;

import com.java.spring.entity.Account;
import com.java.spring.exception.AccountNotFoundException;
import com.java.spring.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {
    private final AccountRepository accountRepository;

    @Autowired
    public AccountService(AccountRepository accountRepository){
        this.accountRepository = accountRepository;
    }

    public long createAccount(String name, String email, Integer bill){
        Account account = new Account(name, email, bill);
        return accountRepository.save(account).getId();
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id)
                .orElseThrow(   () -> new AccountNotFoundException("Can't find account by id: " + id));
    }

    public List<Account> getAll(){
        return accountRepository.findAll();
    }

    public Account deleteById(Long id){
        Account account = getAccountById(id);
        accountRepository.deleteById(id);
        return account;
    }
}
