package com.thecodevillagemyapp.pojo;

import com.thecodevillagemyapp.Customer.model.Customer;

import java.io.Serializable;
import java.util.List;

public class CustomerUploadReq  implements Serializable {
    private List<Customer> customers;

    private int totalCustomer;


    public List<Customer> getCustomers() {
        return customers;
    }

    public void setCustomers(List<Customer> customers) {
        this.customers = customers;
    }

}
