package com.spring.BankingApp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    @Autowired
    private TransactionRepository transactionRepository;


    public List<Account> getAllAccounts(){
        return accountRepository.findAll();
    }

    public Account getAccountById(Long id){
        return accountRepository.findById(id).orElse(null);
    }

    public Account createAccount(Account account){
        return accountRepository.save(account);
    }

//    public Account deposit(Long id, double amount){
//        Account account = accountRepository.findById(id).orElse(null);
//        if(account != null){
//            account.setBalance(account.getBalance() + amount );
//            accountRepository.save(account);
//        }
//        return account;
//    }

    public Account deposit(Long id, double amount) {
        if (amount <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Deposit amount must be positive.");
        }

        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found."));

        account.setBalance(account.getBalance() + amount);
        accountRepository.save(account); // Within a transaction
        return account; // Return 200 OK with the updated account
    }

    public Account withdraw(Long id, double amount) {
        if (amount <= 0) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Withdrawal amount must be positive.");
        }

        Account account = accountRepository.findById(id).orElseThrow(() ->
                new ResponseStatusException(HttpStatus.NOT_FOUND, "Account not found."));

        if (account.getBalance() < amount) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Insufficient funds.");
        }

        account.setBalance(account.getBalance() - amount);
        accountRepository.save(account); // Within a transaction
        return account; // Return 200 OK
    }

    public String transfer(Long fromId, Long toId, double amount){

        Account fromAccount = accountRepository.findById(fromId).orElse(null);
        Account toAccount = accountRepository.findById(toId).orElse(null);

        if(fromAccount == null || toAccount == null || fromAccount.isLocked() || toAccount.isLocked()){
            return "Transfer failed: Invalid account or account is locked.";
        }
        if(fromAccount.getBalance() < amount){
            return "Insufficient Funds";
        }
        else {
            fromAccount.setBalance(fromAccount.getBalance() - amount);
            toAccount.setBalance(toAccount.getBalance() + amount);
            accountRepository.save(fromAccount);
            accountRepository.save(toAccount);
            transactionRepository.save(new Transaction(fromId, "Debited", amount));
            transactionRepository.save(new Transaction(toId, "Credited", amount));
            return "Transaction Successful";
        }
    }

    public void deleteById(Long id){
        accountRepository.deleteById(id);
    }

    public List<Transaction> getTransactionsById(Long accountId){
        return transactionRepository.findByAccountId(accountId);
    }

    public void lockAccount(Long id){
        Account account = accountRepository.findById(id).orElse(null);
        if(account != null) {
            account.setLocked(true);
            accountRepository.save(account);
        }
    }

    public void unlockAccount(Long id){
        Account account = accountRepository.findById(id).orElse(null);
        if(account != null) {
            account.setLocked(false);
            accountRepository.save(account);
        }
    }



}
