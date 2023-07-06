package com.complaintsmanagement.crm.services;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.complaintsmanagement.crm.dao.business.ComplaintRepository;
import com.complaintsmanagement.crm.models.entities.Complaint;
import com.complaintsmanagement.crm.models.entities.Status;

import lombok.AllArgsConstructor;


@Service
@AllArgsConstructor
public class ComplaintService {

    private final ComplaintRepository complaintRepository;
    private final CustomerService customerService;

    public void saveAll(List<Complaint> complaints) {
        complaintRepository.saveAll(complaints);
    }

    public void deleteById(Integer complaintId) {
        complaintRepository.deleteById(complaintId);
    }

    public List<Complaint> getCustomerComplaints(Integer customerId) {
        return complaintRepository.getComplaintsMadeBy(customerId);
    }
    
    public List<Complaint> getComplaintById(Integer compliantID) {
    	return complaintRepository.getComplaintById(compliantID);
    }

    public Complaint changeComplaintStatus(Complaint complaint, Status status) {
        complaint.setStatus(status);
        return complaintRepository.save(complaint);
    }
    
    
    public Complaint saveNewComplaint(Complaint newComplaint) {
        newComplaint.setComplaintId(0);
        newComplaint.setCustomer(newComplaint.getCustomer());
        newComplaint.setDate(LocalDateTime.now(ZoneId.of("Asia/Kolkata")));
        newComplaint.setStatus(newComplaint.getStatus());
        return complaintRepository.save(newComplaint);
    }
    

}
