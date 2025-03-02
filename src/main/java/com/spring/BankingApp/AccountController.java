package com.spring.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/accounts")
public class AccountController {

    @Autowired
    private AccountService accountService;


    @GetMapping
    public List<Account> getAllAccounts(){
        return accountService.getAllAccounts();
    }

    // The @PathVariable annotation is used to extract a value from the URI (Uniform Resource Identifier) of the request and bind it to a method parameter
    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id){
        return accountService.getAccountById(id);
    }

    @PostMapping
    public Account createAccount(@RequestBody Account account){
        return accountService.createAccount(account);
    }

    @PutMapping("/{id}/deposit")
    public Account deposit(@PathVariable Long id, @RequestBody double amount) {
        return accountService.deposit(id, amount);
    }

    @PutMapping("/{id}/withdraw")
    public Account withdraw(@PathVariable Long id, @RequestBody double amount){
        return accountService.withdraw(id, amount);
    }

    @PutMapping("/{fromId}/transfer/{toId}")
    public String transfer(@PathVariable Long fromId, @PathVariable Long toId, @RequestParam double amount){
        return accountService.transfer(fromId, toId, amount);
    }

    @GetMapping("/{accountId}/transactions")
    public List<Transaction> getTransactionsById(@PathVariable Long accountId){
        return accountService.getTransactionsById(accountId);
    }

    @PutMapping("/{id}/lock")
    public void lockAccount(@PathVariable Long id){
        accountService.lockAccount(id);
    }

    @PutMapping("/{id}/unlock")
    public void unlockAccount(@PathVariable Long id){
        accountService.unlockAccount(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable long id){
        accountService.deleteById(id);
    }



}
