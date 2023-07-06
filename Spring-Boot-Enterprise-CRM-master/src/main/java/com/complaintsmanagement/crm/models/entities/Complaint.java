package com.complaintsmanagement.crm.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "complaints")
public class Complaint {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @Column(name = "customer_id")
    private Customer customer;

    @Column(name = "status_id")
    private Status status;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime date;

    @Column(name = "comment")
    private String comment;

    public Integer getCustomerId() {
        return this.customer.getCustomerId();
    }

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public LocalDateTime getDate() {
		return date;
	}

	public void setDate(LocalDateTime date) {
		this.date = date;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	@Override
	public String toString() {
		return "Complaint [complaintId=" + complaintId + ", customer=" + customer + ", status=" + status + ", date="
				+ date + ", comment=" + comment + "]";
	}
    
    
    

}
