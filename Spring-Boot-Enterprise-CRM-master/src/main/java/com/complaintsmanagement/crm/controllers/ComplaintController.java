package com.complaintsmanagement.crm.controllers;

import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complaintsmanagement.crm.exceptions.CustomerNotFoundException;
import com.complaintsmanagement.crm.models.entities.Complaint;
import com.complaintsmanagement.crm.services.ComplaintService;
import com.complaintsmanagement.crm.services.facades.ComplaintServiceFacade;
import com.complaintsmanagement.crm.utils.LoggerUtils;

import lombok.RequiredArgsConstructor;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/complaint")
public class ComplaintController {

    private final Logger logger = LoggerFactory.getLogger("[Complaint Controller]");

    private final ComplaintService complaintService;
    private final ComplaintServiceFacade complaintServiceFacade;

    
    /*
     * Register a complaint if the customer is registered
     */
    @PostMapping("/")
    public ResponseEntity<?> addNewComplaint(@Valid @RequestBody Complaint newComplaint) {
        try {
            Complaint savedComplaint = complaintServiceFacade.addComplaint(newComplaint);
            return new ResponseEntity<>(savedComplaint, HttpStatus.CREATED);
        } catch (CustomerNotFoundException e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    /*
     * Register a complaint if the customer is registered
     */
    @PostMapping("/register")
    public ResponseEntity<?> addNewComplaintWithoutCustomerId(@Valid @RequestBody Complaint newComplaint) {
        try {
            Complaint savedComplaint = complaintServiceFacade.addComplaint(newComplaint);
            return new ResponseEntity<>(savedComplaint, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }
    
    /*
     * Get a customer details, with all its complaints
     */
    @GetMapping("/{customer_id}")
    public ResponseEntity<List<Complaint>> getCustomerComplaints(@PathVariable("customer_id") Integer customerId) {
        List<Complaint> customerComplaints = complaintService.getCustomerComplaints(customerId);
        return new ResponseEntity<>(customerComplaints, HttpStatus.OK);
    }
    
    /*
     * Get current status of a complaint, with out history
     */
    @GetMapping("/complaintId/{complaint_id}")
    public ResponseEntity<List<Complaint>> getComplaintById(@PathVariable("complaint_id") Integer complaintId){
    	List<Complaint> complaintStatus = complaintService.getComplaintById(complaintId);
    	return new ResponseEntity<>(complaintStatus, HttpStatus.OK);
    	
    }

    
    /*
     *  Manage the status of a complaint - mark it as resolved or cancelled or escalated
     */
    @PutMapping("/")
    public ResponseEntity<?> updateComplaint(@Valid @RequestBody Complaint changedComplaint) {
        LoggerUtils.logUserAction(logger, "changes " + changedComplaint.getComplaintId() + " to:\n" + changedComplaint);
        try {
            Complaint updatedComplaint = complaintService.changeComplaintStatus(changedComplaint, changedComplaint.getStatus());
            return new ResponseEntity<>(updatedComplaint, HttpStatus.ACCEPTED);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

}
