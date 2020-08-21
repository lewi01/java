package com.thecodevillagemyapp.Account.api;

import com.thecodevillagemyapp.Account.model.Account;
import com.thecodevillagemyapp.Account.service.AccountService;
import com.thecodevillagemyapp.Customer.model.Customer;
import com.thecodevillagemyapp.Customer.service.BankService;
import com.thecodevillagemyapp.pojo.CustomerUploadReq;
import com.thecodevillagemyapp.pojo.GenericResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/account" )
public class AccountApi {
    private BankService bankService;
    private AccountService accountService;

    @Autowired
    public AccountApi( BankService bankService,AccountService accountService) {
        this.bankService = bankService;
        this.accountService = accountService;
    }
    @RequestMapping(value = "/all/db",method = RequestMethod.GET)
    public ResponseEntity getAllCustomersFromDb(){
        System.out.println("Customer API FROM DB Called# ");

        GenericResponse genericResponse=bankService.getCustomers();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }

    @RequestMapping(value = "/all/db/manual",method = RequestMethod.GET)
    public ResponseEntity getAllCustomersFromDbManual(){
        System.out.println("Customer API FROM DB Manual Called# ");
        GenericResponse genericResponse=bankService.getCustomersManual();
        return new ResponseEntity<>(genericResponse, HttpStatus.OK);
    }


    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public ResponseEntity createAccount(@RequestBody Account account){
        System.out.println("Customer Save Account in DB Called# ");

        System.out.println("Name: "+account.getAccountNumber());
        return new ResponseEntity<>(accountService.saveAccount(account), HttpStatus.OK);
    }


    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ResponseEntity updateCustomer(@RequestBody Customer customer){
        System.out.println("Update Customer in DB Called# ");
        return new ResponseEntity<>(bankService.updateCustomer(customer), HttpStatus.OK);
    }

    @RequestMapping(value = "/update/bulk",method = RequestMethod.POST)
    public ResponseEntity updateCustomerBulk(@RequestBody CustomerUploadReq customerUploadReq){
        System.out.println("Update Customer in DB Called# ");
        return new ResponseEntity<>(bankService.updateCustomerBulk(customerUploadReq), HttpStatus.OK);
    }
}
