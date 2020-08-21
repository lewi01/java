package com.thecodevillagemyapp.Customer.service;

import com.thecodevillagemyapp.Account.model.Account;
import com.thecodevillagemyapp.Customer.model.Customer;
//import com.thecodevillagemyapp.Customer.repository.CurrencyRepository;
import com.thecodevillagemyapp.Customer.service.BankService;
import com.thecodevillagemyapp.pojo.CustomerUploadReq;
import com.thecodevillagemyapp.Customer.repository.CustomerRepository;
import com.thecodevillagemyapp.pojo.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BankServiceImpl implements BankService {
    private CustomerRepository customerRepository;



    @Autowired
    public BankServiceImpl(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;


    }

    @Override
    public GenericResponse getCustomers() {
        List<Customer> customers=customerRepository.findAllCustomers();
        if (customers.size() > 0){
            return new GenericResponse(200,"Success",customers);
        }
        return new GenericResponse(200,"No Data Found");
    }

    @Override
    public Customer getCustomerByIdNumber(String idNumber) {
        return null;
    }

    @Override
    public GenericResponse saveCustomer(Customer customer) {
        Customer customer1=customerRepository.save(customer);
        if (customer1.getId() > 0){
            return new GenericResponse(200,"Success",customer1.getId());
        }

        return new GenericResponse(201,"Not Saved");
    }

    @Override
    public GenericResponse updateCustomer(Customer customer) {
        Customer customer1=customerRepository.save(customer);
        if (customer1.getId() > 0){
            return new GenericResponse(200,"Success",customer1.getId());
        }
        return new GenericResponse(201,"Not Updated");
    }

    @Override
    public GenericResponse updateCustomerBulk(CustomerUploadReq customerUploadReq) {

        try {
            for (Customer customer: customerUploadReq.getCustomers()){
                saveCustomer(customer);
            }
            return new GenericResponse(200,"Success");
        } catch (Exception exception){
            exception.printStackTrace();
        }
        return new GenericResponse(201,"Failed to create");
    }

    @Override
    public GenericResponse getCustomersManual() {
        return null;
    }


}
