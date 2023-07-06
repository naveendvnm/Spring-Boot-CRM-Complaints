package com.complaintsmanagement.crm.controllers;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.complaintsmanagement.crm.models.entities.Complaint;
import com.complaintsmanagement.crm.models.entities.Status;
import com.complaintsmanagement.crm.services.ComplaintService;
import com.complaintsmanagement.crm.services.StatusService;
import com.complaintsmanagement.crm.utils.LoggerUtils;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping(path = "/api/statuses")
public class StatusController {

	private final Logger logger = LoggerFactory.getLogger("[Status Controller]");

	private final StatusService statusService;
	private final ComplaintService complaintService;


	/*
	 * Get current status by giving complaint id
	 */
	@GetMapping("/{complaint_id}/status")
	public ResponseEntity<Complaint> getStatus(@PathVariable(name = "complaint_id") Complaint complaint) {
		
		List<Complaint> currentComplaint = complaintService.getComplaintById(complaint.getComplaintId());
		
		LoggerUtils.logUserAction(logger, "Current status of " + complaint.getComplaintId() + " is " + currentComplaint.lastIndexOf(currentComplaint));
				
		return new ResponseEntity<>(currentComplaint, HttpStatus.ACCEPTED);		
	}
	
	/*
	 * Update current status of an complaint id
	 */
	@PutMapping("/{complaint_id}/{status_id}")
	public ResponseEntity<Complaint> changeStatusOnRequest(@PathVariable(name = "complaint_id") Complaint complaint,
			@PathVariable(name = "status_id") Status status) {
		
		if (complaint.getStatus().getComplaintId() == status.getComplaintId()) {
			return new ResponseEntity<>(complaint, HttpStatus.OK);
		}
		LoggerUtils.logUserAction(logger, "changes status of " + complaint.getComplaintId() + " to " + status.getName());
		Complaint updatedComplaint = complaintService.changeComplaintStatus(complaint, status);
		return new ResponseEntity<>(updatedComplaint, HttpStatus.OK);
	}
}
