package com.complaintsmanagement.crm.dao.business;

import org.springframework.data.jpa.repository.JpaRepository;

import com.complaintsmanagement.crm.models.entities.Status;

public interface StatusRepository extends JpaRepository<Status, Integer> {
}
