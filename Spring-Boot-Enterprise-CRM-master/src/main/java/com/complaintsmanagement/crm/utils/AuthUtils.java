package com.complaintsmanagement.crm.utils;

import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import com.complaintsmanagement.crm.dao.business.CustomerRepository;
import com.complaintsmanagement.crm.models.entities.Customer;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;

@Component
@RequiredArgsConstructor
public final class AuthUtils implements ApplicationListener<AuthorizationEvent> {

    public static Customer LOGGED_CUSTOMER = null;

    private final CustomerRepository customerRepository;

    @SneakyThrows
    @Override
    public void onApplicationEvent(AuthorizationEvent authorizationEvent) {
        LOGGED_CUSTOMER = customerRepository.findById(LOGGED_USER.getCustomerID()).orElse(null);
    }
}
