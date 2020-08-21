package com.thecodevillagemyapp.Customer.model;

import com.thecodevillagemyapp.Customer.model.Customer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import java.util.List;

public class MyBankApp {
    private JdbcTemplate jdbcTemplate;


    @Autowired
    public void MyBankAppRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }



    public
    List<Customer> findAllCustomers(){
        String sql = "select * from customer";
        return jdbcTemplate.query(sql,(rs, rowNum) ->
                new Customer(
                        rs.getLong("id"),
                        rs.getString("id_number"),
                        rs.getString("full_name"))
        );
    }
}
