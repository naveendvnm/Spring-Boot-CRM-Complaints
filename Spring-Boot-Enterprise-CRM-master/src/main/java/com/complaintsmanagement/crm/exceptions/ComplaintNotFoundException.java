package com.complaintsmanagement.crm.exceptions;

public class ComplaintNotFoundException extends Exception {
    public ComplaintNotFoundException() {
        super("Complaint with the specified ID does not exist.");
    }
}
