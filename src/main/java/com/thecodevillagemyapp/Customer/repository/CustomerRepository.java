package com.thecodevillagemyapp.Customer.repository;

import com.thecodevillagemyapp.Customer.model.Customer;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CustomerRepository extends PagingAndSortingRepository<Customer,Long> {
    List<Customer> findAllCustomers();

    Optional<Customer> findByIdNumber(@Param("idNumber") String idNumber);
}
