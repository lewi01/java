package com.thecodevillagemyapp.Customer.service;

import com.thecodevillagemyapp.Account.model.Account;
import com.thecodevillagemyapp.Customer.model.Customer;
import com.thecodevillagemyapp.pojo.CustomerUploadReq;
import com.thecodevillagemyapp.pojo.GenericResponse;

import java.util.List;

public interface BankService {
    GenericResponse getCustomers();

    Customer getCustomerByIdNumber(String idNumber);

    GenericResponse saveCustomer(Customer customer);
    GenericResponse updateCustomer(Customer customer);

    GenericResponse updateCustomerBulk(CustomerUploadReq customerUploadReq);

    GenericResponse getCustomersManual();
}
