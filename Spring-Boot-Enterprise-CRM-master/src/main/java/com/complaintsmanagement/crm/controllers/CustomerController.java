package com.complaintsmanagement.crm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complaintsmanagement.crm.models.entities.Customer;
import com.complaintsmanagement.crm.services.CustomerService;
import com.complaintsmanagement.crm.utils.LoggerUtils;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/customers")
public class CustomerController {

    private final Logger logger = LoggerFactory.getLogger("[Customer Controller]");

    private final CustomerService customerService;

    /* 
     * Register a customer
     */
    @PostMapping("/")
    public ResponseEntity<Customer> saveCustomer(@Valid @RequestBody Customer newCustomer) {
        LoggerUtils.logUserAction(logger, "creates:\n" + newCustomer);
        Customer savedCustomer = customerService.saveCustomer(newCustomer);
        return new ResponseEntity<>(savedCustomer, HttpStatus.CREATED);
    }
    
    /*
     * Get all customer details
     */
    @GetMapping("/")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = customerService.getAllCustomers();
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

}

