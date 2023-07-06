package com.complaintsmanagement.crm.dao.business;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complaintsmanagement.crm.models.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {
    boolean existsByCustomerName(String name);
}
