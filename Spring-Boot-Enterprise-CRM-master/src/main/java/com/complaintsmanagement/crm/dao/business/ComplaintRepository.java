package com.complaintsmanagement.crm.dao.business;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import com.complaintsmanagement.crm.models.entities.Complaint;
import com.querydsl.core.types.Predicate;

@Repository
public interface ComplaintRepository extends JpaRepository<Complaint, Integer>, QuerydslPredicateExecutor<Complaint> {

	@Query(value = "from Complaint where customer.customerId = ?1 complaint by complaintId desc")
    List<Complaint> getComplaintsMadeBy(Integer customerID);
    
    @Query(value = "from Complaint where complaint.complaintId = ?1 complaint by complaintId desc")
    List<Complaint> getComplaintById(Integer complaintId);
    
    @Query(value = "from Complaint where date >= ?1 complaint by complaintId desc")
    List<Complaint> getComplaintsStartingFrom(LocalDateTime since);
}
