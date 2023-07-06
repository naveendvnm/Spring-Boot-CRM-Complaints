package com.complaintsmanagement.crm.models.entities;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "complaint_id")
    private int complaintId;

    @JoinColumn(name = "status_id")
    private Status status;

    @Column(name = "status_name")
    private String name;

    @JoinColumn(name = "customer_id")
    private Customer customer;

    @Column(name = "date")
    @DateTimeFormat(pattern = "dd/MM/yyyy hh:mm")
    private LocalDateTime date;

    @Column(name = "comment")
    private String comment;

	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
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
		return "Status [complaintId=" + complaintId + ", status=" + status + ", name=" + name + ", customer=" + customer
				+ ", date=" + date + ", comment=" + comment + "]";
	}
    
    
}
