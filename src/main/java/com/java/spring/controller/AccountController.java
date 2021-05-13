package com.java.spring.controller;

import com.java.spring.controller.dto.AccountRequestDTO;
import com.java.spring.controller.dto.AccountResponseDTO;
import com.java.spring.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class AccountController {

    private final AccountService accountService;

    @Autowired
    public AccountController(AccountService accountService){
        this.accountService= accountService;
    }

    @GetMapping("/hello")
    public String helloSpring(){
        return "Hello from Sptring";
    }

    @PostMapping("/accounts")
    public Long createAccount(@RequestBody AccountRequestDTO accountRequestDTO){
        return accountService.createAccount(accountRequestDTO.getName(),
                accountRequestDTO.getEmail(), accountRequestDTO.getBill());
    }

    @GetMapping("/accounts/{id}")
    public AccountResponseDTO getAccount(@PathVariable Long id){
        return new AccountResponseDTO(accountService.getAccountById(id));
    }
    @GetMapping("/accounts")
    public List<AccountResponseDTO> getAll(){
        return accountService.getAll().stream().map(AccountResponseDTO::new)
                .collect(Collectors.toList());
    }
    @DeleteMapping("/accounts/{id}")
    public AccountResponseDTO delete(@PathVariable Long id){
        return new AccountResponseDTO(accountService.deleteById(id));
    }
}
