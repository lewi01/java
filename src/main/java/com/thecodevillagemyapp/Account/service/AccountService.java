package com.thecodevillagemyapp.Account.service;

import com.thecodevillagemyapp.Account.model.Account;

import java.util.List;

public interface AccountService {
    List<Account> getAccounts();

    List<Account> getCustomerAccountsByCustomerId(String customerId);

    Account saveAccount(Account account);

}
