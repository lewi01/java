package com.thecodevillagemyapp.Account.service;

//import com.sun.el.stream.Optional;
import com.thecodevillagemyapp.Account.model.Account;
import com.thecodevillagemyapp.Account.repository.AccountRepository;
import com.thecodevillagemyapp.Customer.model.Customer;
import com.thecodevillagemyapp.Customer.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class AccountServiceImpl implements AccountService{
    private AccountRepository accountRepository;
    private CustomerRepository customerRepository;


    @Autowired
    public AccountServiceImpl(AccountRepository accountRepository,CustomerRepository customerRepository) {
        this.accountRepository = accountRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public List<Account> getAccounts() {
        return null;
    }

    @Override
    public List<Account> getCustomerAccountsByCustomerId(String customerId) {
        return null;
    }

    @Override
    public Account saveAccount(Account account) {
        return accountRepository.save(account);
    }

}
