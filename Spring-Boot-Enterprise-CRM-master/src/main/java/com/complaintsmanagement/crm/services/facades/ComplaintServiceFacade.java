package com.complaintsmanagement.crm.services.facades;

import org.springframework.stereotype.Service;

import com.complaintsmanagement.crm.exceptions.CustomerNotFoundException;
import com.complaintsmanagement.crm.models.entities.Complaint;
import com.complaintsmanagement.crm.services.ComplaintService;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ComplaintServiceFacade {

    private final ComplaintService complaintService;

    public Complaint addComplaint(Complaint newComplaint) throws CustomerNotFoundException {
        return complaintService.saveNewComplaint(newComplaint);
    }

    public void deleteComplaint(Complaint complaint) {
        complaintService.deleteById(complaint.getComplaintId());
    }
}
