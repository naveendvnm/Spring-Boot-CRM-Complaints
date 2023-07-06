# Spring-Boot-CRM-Complaints
Spring Boot Customer CRM Complaints assignment

⚠️ Still under development ⚠️

Oracle Customer CRM Complaints - Spring Boot Application

Problem Statement:

Create a CRM webapp with RESTful APIs using Springboot. We should below functionalities/ features in the webapp.

-          Register a customer
-          Register a complaint if the customer is registered
-          if not registered, register internally and register the complaint
-          Get current status of a complaint, with history and without history (history means - what all statuses it has been through)
-          Manage the status of a complaint - mark it as resolved or cancelled or escalated
-          Get a customer details, with all its complaints
-          Have filters to show complaints which are cancelled, resolved, escalated. Include all by default

All the features should be consumed through end points. It is not mandatory to have a DB integration and do the data operations. Instead they can be stored using collections and appropriate class relationships. However, if you find it fine, you can use H2 integrated DB and JPA to have the complete integrated app. That would be up to you.

Keys to look out for: Project structure, Class Level relationships, end point conventions, Springboot auto configurations, Java 8 features where ever applicable, Design patterns if anything appropriate, Exception handling.
