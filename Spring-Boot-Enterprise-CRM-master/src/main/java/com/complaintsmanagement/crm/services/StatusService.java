package com.complaintsmanagement.crm.services;

import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.complaintsmanagement.crm.dao.business.StatusRepository;
import com.complaintsmanagement.crm.models.entities.Status;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class StatusService {

    private final StatusRepository statusRepository;

    public List<Status> getAllStatuses() {
        return statusRepository.findAll(Sort.by(Sort.Direction.ASC, "id"));
    }
}
