package com.thecodevillagemyapp.Account.repository;

import com.thecodevillagemyapp.Account.model.Account;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface AccountRepository extends PagingAndSortingRepository<Account,Long> {

    @Query("select a from Account a where a.accountNumber = :accountNumber")
    Optional<Account> findByAccountNumber(@Param("accountNumber") Long customerId);


}
