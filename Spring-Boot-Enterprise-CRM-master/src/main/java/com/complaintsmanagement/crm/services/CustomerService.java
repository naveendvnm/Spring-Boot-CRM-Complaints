package com.complaintsmanagement.crm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.complaintsmanagement.crm.dao.business.CustomerRepository;
import com.complaintsmanagement.crm.models.entities.Customer;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class CustomerService {

    private final CustomerRepository customerRepository;

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getById(Integer customerId) {
        return customerRepository.findById(customerId);
    }

    public Customer saveCustomer(Customer newCustomer) {
        return customerRepository.save(newCustomer);
    }

}
